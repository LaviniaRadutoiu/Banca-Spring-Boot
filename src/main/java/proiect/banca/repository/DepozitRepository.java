package proiect.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proiect.banca.domain.Client;
import proiect.banca.domain.Credit;
import proiect.banca.domain.Depozit;

import java.util.List;

public interface DepozitRepository extends JpaRepository<Depozit, Long> {
    List<Depozit> findAllByClient(Client client);
}
