package br.com.cvm.api_ofertas.database.repository;

import br.com.cvm.api_ofertas.database.entities.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, UUID> {

    @Query(value = """
            SELECT * FROM tb_requerimento
            WHERE
                to_tsvector('portuguese', 
                    coalesce(id_requerimento, '') || ' ' ||
                    coalesce(numero_protocolo, '') || ' ' ||
                    coalesce(numero_processo, '') || ' ' ||
                    coalesce(nome_valor_mobiliario, '') || ' ' ||
                    coalesce(tipo_de_oferta, '') || ' ' ||
                    coalesce(status_da_oferta, '') || ' ' ||
                    coalesce(nome_emissor, '') || ' ' ||
                    coalesce(cnpj_emissor, '') || ' ' ||
                    coalesce(nome_coordenador_lider, '') || ' ' ||
                    coalesce(cnpj_coordenador_lider, '') || ' ' ||
                    coalesce(nome_tipo_requerimento, '')
                )
                @@
                plainto_tsquery('portuguese', :searchTerm)
            """, nativeQuery = true)
    Page<Register> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

    Optional<Register> findByIdRequerimento(String idRequerimento);

    List<Register> findAllByIdRequerimento(List<String> idRequerimento);
}