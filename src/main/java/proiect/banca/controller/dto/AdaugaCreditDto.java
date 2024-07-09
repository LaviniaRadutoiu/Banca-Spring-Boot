package proiect.banca.controller.dto;

import lombok.Getter;
import lombok.Setter;
import proiect.banca.domain.Moneda;

import java.math.BigDecimal;

@Setter
@Getter
public class AdaugaCreditDto {
    BigDecimal sold;
    BigDecimal dobanda;
    Integer perioadaDeCreditare;
    Moneda moneda;


}
