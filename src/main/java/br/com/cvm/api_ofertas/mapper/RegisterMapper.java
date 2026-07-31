package br.com.cvm.api_ofertas.mapper;

import br.com.cvm.api_ofertas.database.entities.Register;
import br.com.cvm.api_ofertas.dto.RegisterRequestDTO;
import br.com.cvm.api_ofertas.dto.RegisterResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    public Register toEntity(RegisterRequestDTO dto) {
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
    }

    public RegisterResponseDTO toResponseDTO(Register register) {
        return new RegisterResponseDTO(
                register.getId(),
                register.getIdRequerimento(),
                register.getNumeroProtocolo(),
                register.getNumeroProcesso(),
                register.getNomeValorMobiliario(),
                register.getTipoDeOferta(),
                register.getStatusDaOferta(),
                register.getNomeEmissor(),
                register.getCnpjEmissor(),
                register.getNomeCoordenadorLider(),
                register.getCnpjCoordenadorLider(),
                register.getValorEmReais(),
                register.getData(),
                register.getNomeTipoRequerimento(),
                register.getVasoComunicante(),
                register.getPossuiBook(),
                register.getRegistroAutomatico()
        );
    }
}
