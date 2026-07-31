package br.com.cvm.api_ofertas.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RegisterResponseDTO(UUID id, String idRequerimento, String numeroProtocolo, String numeroProcesso,
                                  String nomeValorMobiliario, String tipoDeOferta, String statusDaOferta,
                                  String nomeEmissor, String cnpjEmissor, String nomeCoordenadorLider,
                                  String cnpjCoordenadorLider, String valorEmReais, LocalDate data,
                                  String nomeTipoRequerimento, boolean vasoComunicante, boolean possuiBook,
                                  boolean registroAutomatico) {
}
