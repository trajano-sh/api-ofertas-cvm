package br.com.cvm.api_ofertas.service;

import br.com.cvm.api_ofertas.database.entities.Register;
import br.com.cvm.api_ofertas.database.repository.RegisterRepository;
import br.com.cvm.api_ofertas.dto.RegisterRequestDTO;
import br.com.cvm.api_ofertas.dto.RegisterResponseDTO;
import br.com.cvm.api_ofertas.exception.RegisterNotFoundException;
import br.com.cvm.api_ofertas.mapper.RegisterMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final RegisterMapper registerMapper;

    public void createOffers(List<RegisterRequestDTO> registers) {

        List<Register> registerEntity = registerMapper.toEntity(registers);
        registerRepository.saveAll(registerEntity);
    }


    public RegisterResponseDTO findById(String id) {
        Register register = registerRepository.findByIdRequerimento(id).orElseThrow(() -> new RegisterNotFoundException("Register not found"));
        return registerMapper.toResponse(register);
    }

    public Page<RegisterResponseDTO> searchByTerm(String term, Pageable pageable) {
        Page<Register> registers = registerRepository.searchByTerm(term, pageable);

        return registerMapper.toResponseAll(registers);
    }

    @Transactional
    public void refreshOffers(List<RegisterRequestDTO> dtoList) {
        if (dtoList == null || dtoList.isEmpty()) return;
        List<String> ids = dtoList.stream().map(RegisterRequestDTO::idRequerimento).toList();
        List<Register> existingRegisters = registerRepository.findAllByIdRequerimento(ids);

        Map<String, Register> registerMap = existingRegisters.stream().collect(Collectors.toMap(Register::getIdRequerimento, register -> register));

        for (RegisterRequestDTO dto : dtoList) {
            Register register = registerMap.get(dto.idRequerimento());

            if (register != null) {
                registerMapper.updateEntityFromDTO(register, dto);
            }
        }
    }

    public void deleteById(UUID id) {
        Register register = registerRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException("Register not found"));
        registerRepository.delete(register);
    }
}
