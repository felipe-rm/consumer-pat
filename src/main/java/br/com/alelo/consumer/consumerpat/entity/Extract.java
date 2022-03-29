package br.com.alelo.consumer.consumerpat.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Extract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer establishmentNameId;

    String establishmentName;

    String productDescription;

    LocalDateTime dateBuy;

    Integer cardNumber;

    Double value;
}
