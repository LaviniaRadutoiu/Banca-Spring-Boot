package proiect.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import proiect.banca.domain.Client;
import proiect.banca.domain.Cont;

import java.util.Optional;

public interface ContRepository extends JpaRepository<Cont,Long> {
    boolean existsByClient(Client client);
    Optional<Cont> findByClient (Client client);
}
