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
public class Credit {
    @Id
    @GeneratedValue
    Long id;
    String numarCont;
    BigDecimal sold;
    BigDecimal dobanda;
    Integer perioadaDeCreditare;
    @Enumerated(EnumType.STRING)
    Moneda moneda;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    public Credit(String numarCont, BigDecimal sold, BigDecimal dobanda, Moneda moneda, Client client,Integer perioadaDeCreditare) {
        this.numarCont = numarCont;
        this.sold = sold;
        this.dobanda = dobanda;
        this.moneda = moneda;
        this.client = client;
        this.perioadaDeCreditare = perioadaDeCreditare;

    }
}