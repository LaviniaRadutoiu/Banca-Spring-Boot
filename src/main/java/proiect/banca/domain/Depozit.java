package proiect.banca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Depozit {
    @Id
    @GeneratedValue
    Long id;
    String numarCont;
    BigDecimal sold;
    BigDecimal dobanda;
    Integer perioadaDeConstituire;
    @Enumerated(EnumType.STRING)
    Moneda moneda;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    public Depozit(String numarCont, BigDecimal sold, BigDecimal dobanda, Integer perioadaDeConstituire, Moneda moneda, Client client) {
        this.numarCont = numarCont;
        this.sold = sold;
        this.dobanda = dobanda;
        this.perioadaDeConstituire = perioadaDeConstituire;
        this.moneda = moneda;
        this.client = client;
    }
}
