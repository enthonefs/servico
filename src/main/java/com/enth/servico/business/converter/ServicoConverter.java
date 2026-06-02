package com.enth.servico.business.converter;

import com.enth.servico.business.dto.in.ServicoRequestDTO;
import com.enth.servico.business.dto.out.ServicoResponseDTO;
import com.enth.servico.infrastructure.entity.Servico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoConverter {

    public Servico paraServicoEntity(ServicoRequestDTO dto){
        return Servico.builder()
                .servico(dto.getServico())
                .valor(dto.getValor())
                .build();
    }

    public ServicoResponseDTO paraServicoResponseDTO(Servico entity){
        return ServicoResponseDTO.builder()
                .id(entity.getId())
                .servico(entity.getServico())
                .valor(entity.getValor())
                .build();
    }

    public List<ServicoResponseDTO> paraListaServicoResponseDTO(List<Servico> listaEntity){
        return listaEntity.stream()
                .map(this::paraServicoResponseDTO)
                .toList();
    }
}
