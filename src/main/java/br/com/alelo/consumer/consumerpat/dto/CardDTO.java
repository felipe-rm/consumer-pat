package br.com.alelo.consumer.consumerpat.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDTO {
    private Long number;

    private Double balance;

    private TypeDTO type;
}
