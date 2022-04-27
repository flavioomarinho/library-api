package com.flaviomarinho.library.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevolutionDTO {
    private Long book;
    private Long user;
}
