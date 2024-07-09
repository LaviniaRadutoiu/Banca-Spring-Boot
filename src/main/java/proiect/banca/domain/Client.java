package proiect.banca.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    Long id;
    String nume;
    String cnp;
    String adresa;

    public Client(String nume, String cnp, String adresa) {
        this.nume = nume;
        this.cnp = cnp;
        this.adresa = adresa;
    }
}
