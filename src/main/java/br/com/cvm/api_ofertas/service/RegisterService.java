package br.com.cvm.api_ofertas.service;

import br.com.cvm.api_ofertas.database.entities.Register;
import br.com.cvm.api_ofertas.database.repository.RegisterRepository;
import br.com.cvm.api_ofertas.dto.RegisterRequestDTO;
import br.com.cvm.api_ofertas.dto.RegisterResponseDTO;
import br.com.cvm.api_ofertas.exception.RegisterNotFoundException;
import br.com.cvm.api_ofertas.mapper.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

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
}
