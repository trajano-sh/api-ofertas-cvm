package br.com.cvm.api_ofertas.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record CustomPageResponseDTO<T>(List<T> content, int page, int size, long totalElements, int totalPages) {
    public static <T> CustomPageResponseDTO<T> from(Page<T> page) {

        return new CustomPageResponseDTO<>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }

}
