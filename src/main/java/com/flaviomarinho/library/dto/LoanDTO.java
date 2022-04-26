package com.flaviomarinho.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private Long user;
    private List<DetailLoanDTO> itens;
}
