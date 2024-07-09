package proiect.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proiect.banca.domain.Client;
import proiect.banca.domain.Credit;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {

    List<Credit> findAllByClient(Client client);

}
