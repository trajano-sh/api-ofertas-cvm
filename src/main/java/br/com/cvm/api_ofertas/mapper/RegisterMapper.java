package br.com.cvm.api_ofertas.mapper;

import br.com.cvm.api_ofertas.database.entities.Register;
import br.com.cvm.api_ofertas.dto.RegisterRequestDTO;
import br.com.cvm.api_ofertas.dto.RegisterResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterMapper {
    public List<Register> toEntity(List<RegisterRequestDTO> dtoList) {
        if (dtoList == null) return List.of();

        return dtoList.stream().map(dto -> {
            Register register = new Register();
            register.setIdRequerimento(dto.idRequerimento());
            register.setNumeroProtocolo(dto.numeroProtocolo());
            register.setNumeroProcesso(dto.numeroProcesso());
            register.setNomeValorMobiliario(dto.nomeValorMobiliario());
            register.setTipoDeOferta(dto.tipoDeOferta());
            register.setStatusDaOferta(dto.statusDaOferta());
            register.setNomeEmissor(dto.nomeEmissor());
            register.setCnpjEmissor(dto.cnpjEmissor());
            register.setNomeCoordenadorLider(dto.nomeCoordenadorLider());
            register.setCnpjCoordenadorLider(dto.cnpjCoordenadorLider());
            register.setValorEmReais(dto.valorEmReais());
            register.setData(dto.data());
            register.setNomeTipoRequerimento(dto.nomeTipoRequerimento());
            register.setVasoComunicante(dto.vasoComunicante());
            register.setPossuiBook(dto.possuiBook());
            register.setRegistroAutomatico(dto.registroAutomatico());
            return register;
        }).toList();
    }

    public Page<RegisterResponseDTO> toResponseAll(Page<Register> registerPage) {
        if (registerPage == null) {
            return Page.empty();
        }

        return registerPage.map(this::toResponse);
    }

    public RegisterResponseDTO toResponse(Register register) {
        return new RegisterResponseDTO(register.getId(), register.getIdRequerimento(), register.getNumeroProtocolo(), register.getNumeroProcesso(), register.getNomeValorMobiliario(), register.getTipoDeOferta(), register.getStatusDaOferta(), register.getNomeEmissor(), register.getCnpjEmissor(), register.getNomeCoordenadorLider(), register.getCnpjCoordenadorLider(), register.getValorEmReais(), register.getData(), register.getNomeTipoRequerimento(), register.getVasoComunicante(), register.getPossuiBook(), register.getRegistroAutomatico());
    }

    public void updateEntityFromDTO(Register register, RegisterRequestDTO dto) {
        register.setNumeroProtocolo(dto.numeroProtocolo());
        register.setNumeroProcesso(dto.numeroProcesso());
        register.setNomeValorMobiliario(dto.nomeValorMobiliario());
        register.setTipoDeOferta(dto.tipoDeOferta());
        register.setStatusDaOferta(dto.statusDaOferta());
        register.setNomeEmissor(dto.nomeEmissor());
        register.setCnpjEmissor(dto.cnpjEmissor());
        register.setNomeCoordenadorLider(dto.nomeCoordenadorLider());
        register.setCnpjCoordenadorLider(dto.cnpjCoordenadorLider());
        register.setValorEmReais(dto.valorEmReais());
        register.setData(dto.data());
        register.setNomeTipoRequerimento(dto.nomeTipoRequerimento());
        register.setVasoComunicante(dto.vasoComunicante());
        register.setPossuiBook(dto.possuiBook());
        register.setRegistroAutomatico(dto.registroAutomatico());
    }
}
