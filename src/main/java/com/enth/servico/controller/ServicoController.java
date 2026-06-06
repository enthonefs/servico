package com.enth.servico.controller;

import com.enth.servico.business.ServicoService;
import com.enth.servico.business.dto.in.ServicoRequestDTO;
import com.enth.servico.business.dto.out.ServicoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService service;

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criarServico(@RequestBody ServicoRequestDTO dto,
                                                           @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.criarServico(dto));
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> buscarServicos(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<ServicoResponseDTO> buscarServicoPorId(@RequestParam Long id,
                                                                 @RequestHeader("Auhorization") String token){
        return ResponseEntity.ok(service.buscarServicoPorId(id));
    }

    @PutMapping(params = "id")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@RequestParam Long id, @RequestBody ServicoRequestDTO dto,
                                                               @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.atualizarAgendamento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id, @RequestHeader("Authorization") String token){
        service.apagarServico(id);
        return ResponseEntity.ok().build();
    }

}
