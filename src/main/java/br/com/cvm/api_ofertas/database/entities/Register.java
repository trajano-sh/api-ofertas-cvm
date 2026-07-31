package br.com.cvm.api_ofertas.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "registers")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false,name = "id_requerimento")
    private String idRequerimento;

    @Column(unique = true, nullable = false)
    private String numeroProtocolo;

    @Column(unique = true, nullable = false)
    private String numeroProcesso;

    private String nomeValorMobiliario;

    private String tipoDeOferta;

    private String statusDaOferta;

    private String nomeEmissor;

    private String cnpjEmissor;

    private String nomeCoordenadorLider;

    private String cnpjCoordenadorLider;

    private String valorEmReais;

    private LocalDate data;

    private String nomeTipoRequerimento;

    private Boolean vasoComunicante;

    private Boolean possuiBook;

    private Boolean registroAutomatico;
}
