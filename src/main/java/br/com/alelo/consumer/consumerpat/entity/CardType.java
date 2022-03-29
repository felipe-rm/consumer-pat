package br.com.alelo.consumer.consumerpat.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
}
