package br.com.cvm.api_ofertas.controller;

import br.com.cvm.api_ofertas.dto.CustomPageResponseDTO;
import br.com.cvm.api_ofertas.dto.RegisterRequestDTO;
import br.com.cvm.api_ofertas.dto.RegisterResponseDTO;
import br.com.cvm.api_ofertas.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/ofertas")
    public ResponseEntity<Void> createOffer(@RequestBody List<RegisterRequestDTO> dto) {
        registerService.createOffers(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ofertas/{id}")
    public ResponseEntity<RegisterResponseDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(registerService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<CustomPageResponseDTO<RegisterResponseDTO>> search(@RequestParam("term") String term, Pageable pageable) {

        Page<RegisterResponseDTO> page = registerService.searchByTerm(term, pageable);

        return ResponseEntity.ok(CustomPageResponseDTO.from(page));
    }

    @PostMapping("/ofertas/update")
    public ResponseEntity<Void> updateOffer(@RequestBody List<RegisterRequestDTO> dto) {
        registerService.refreshOffers(dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ofertas/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        registerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
