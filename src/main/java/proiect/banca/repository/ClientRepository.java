package proiect.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import proiect.banca.domain.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
Optional<Client> findById(Long id);

}
