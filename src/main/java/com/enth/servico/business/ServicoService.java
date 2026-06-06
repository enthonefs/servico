package com.enth.servico.business;

import com.enth.servico.business.converter.ServicoConverter;
import com.enth.servico.business.dto.in.ServicoRequestDTO;
import com.enth.servico.business.dto.out.ServicoResponseDTO;
import com.enth.servico.infrastructure.entity.Servico;
import com.enth.servico.infrastructure.exceptions.ResourceNotFoundException;
import com.enth.servico.infrastructure.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoConverter servicoConverter;

    public List<ServicoResponseDTO> buscarTodos(){
        return servicoConverter.paraListaServicoResponseDTO(servicoRepository.findAll());
    }

    public ServicoResponseDTO buscarServicoPorId(Long id){
        Servico servico = servicoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id de serviço não encontrado: " + id));
        return servicoConverter.paraServicoResponseDTO(servico);
    }

    public ServicoResponseDTO criarServico(ServicoRequestDTO dto){
        Servico servico = servicoConverter.paraServicoEntity(dto);

        return servicoConverter.paraServicoResponseDTO(servicoRepository.save(servico));
    }


    public ServicoResponseDTO atualizarAgendamento(Long id, ServicoRequestDTO dto){
        Servico servicoAtual = servicoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Agendamento não encontrado."));

        Servico servicoAtualizado = Servico.builder()
                .servico(dto.getServico() != null ? dto.getServico() : servicoAtual.getServico())
                .valor(dto.getValor() != 0 ? dto.getValor() : servicoAtual.getValor())
                .id(servicoAtual.getId())
                .build();

        return servicoConverter.paraServicoResponseDTO(servicoRepository.saveAndFlush(servicoAtualizado));

    }

    public void apagarServico(Long id){
        servicoRepository.deleteById(id);
    }
}