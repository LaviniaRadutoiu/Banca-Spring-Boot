package proiect.banca.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import proiect.banca.domain.Moneda;

import java.math.BigDecimal;
@Getter
@Setter
public class AdaugaDepozitDto {
    BigDecimal sold;
    BigDecimal dobanda;
    Integer perioadaDeConstituire;
    Moneda moneda;
}
