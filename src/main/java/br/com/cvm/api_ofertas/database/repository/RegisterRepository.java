package br.com.cvm.api_ofertas.database.repository;

import br.com.cvm.api_ofertas.database.entities.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RegisterRepository extends JpaRepository<Register, UUID> {

    @Query(value = """
            SELECT * FROM tb_registers
            WHERE
                to_tsvector('portuguese', 
                    coalesce(id_requerimento::text, '') || ' ' ||
                    coalesce(numero_protocolo::text, '') || ' ' ||
                    coalesce(numero_processo::text, '') || ' ' ||
                    coalesce(nome_valor_mobiliario::text, '') || ' ' ||
                    coalesce(tipo_de_oferta::text, '') || ' ' ||
                    coalesce(status_da_oferta::text, '') || ' ' ||
                    coalesce(nome_emissor::text, '') || ' ' ||
                    coalesce(cnpj_emissor::text, '') || ' ' ||
                    coalesce(nome_coordenador_lider::text, '') || ' ' ||
                    coalesce(cnpj_coordenador_lider::text, '') || ' ' ||
                    coalesce(nome_tipo_requerimento::text, '')
                )
                @@ plainto_tsquery('portuguese', :searchTerm)
            ORDER BY to_date(data, 'DD/MM/YYYY') DESC
            """, countQuery = """
            SELECT count(*) FROM tb_registers
            WHERE
                to_tsvector('portuguese', 
                    coalesce(id_requerimento::text, '') || ' ' ||
                    coalesce(numero_protocolo::text, '') || ' ' ||
                    coalesce(numero_processo::text, '') || ' ' ||
                    coalesce(nome_valor_mobiliario::text, '') || ' ' ||
                    coalesce(tipo_de_oferta::text, '') || ' ' ||
                    coalesce(status_da_oferta::text, '') || ' ' ||
                    coalesce(nome_emissor::text, '') || ' ' ||
                    coalesce(cnpj_emissor::text, '') || ' ' ||
                    coalesce(nome_coordenador_lider::text, '') || ' ' ||
                    coalesce(cnpj_coordenador_lider::text, '') || ' ' ||
                    coalesce(nome_tipo_requerimento::text, '')
                )
                @@ plainto_tsquery('portuguese', :searchTerm)
            """, nativeQuery = true)
    Page<Register> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

    Optional<Register> findByIdRequerimento(String idRequerimento);

    List<Register> findByIdRequerimentoIn(List<String> idRequerimentos);
}