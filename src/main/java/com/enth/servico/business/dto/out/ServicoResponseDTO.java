package com.enth.servico.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoResponseDTO {

    private Long id;
    private String servico;
    private double valor;
}
