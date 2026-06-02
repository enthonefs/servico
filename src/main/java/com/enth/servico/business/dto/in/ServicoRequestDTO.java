package com.enth.servico.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicoRequestDTO {

    private String servico;
    private double valor;
}
