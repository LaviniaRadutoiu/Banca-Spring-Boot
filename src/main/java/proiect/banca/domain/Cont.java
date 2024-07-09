package proiect.banca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cont {
    @Id
    @GeneratedValue
    Long id;
    String numarCont;
    double sold;
    @Enumerated(EnumType.STRING)
    Moneda moneda;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;




    public Cont(String numarCont, Moneda moneda, Client client) {
        this.numarCont = numarCont;
        this.moneda = moneda;
        this.sold = 0;
        this.client = client;

    }
}
