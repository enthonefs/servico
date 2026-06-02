package com.enth.servico.controller;

import com.enth.servico.business.ServicoService;
import com.enth.servico.business.dto.in.ServicoRequestDTO;
import com.enth.servico.business.dto.out.ServicoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService service;

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criarServico(@RequestBody ServicoRequestDTO dto){
        return ResponseEntity.ok(service.criarServico(dto));
    }
}
