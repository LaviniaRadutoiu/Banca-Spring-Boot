package proiect.banca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proiect.banca.domain.Credit;
import proiect.banca.domain.Depozit;
import proiect.banca.repository.DepozitRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DepozitService {
    final DepozitRepository depozitRepository;

    public Depozit saveDepozit(Depozit depozit) {

        return depozitRepository.save(depozit);
    }
    public List<Depozit> getAlldeposits(){

        return (List<Depozit>) depozitRepository.findAll();
    }
    public String generareIban() {
        StringBuilder iban = new StringBuilder("RO00");
        Random random = new Random();
        for (int i = 0; i < 20; i++)
            iban.append(random.nextInt(10));
        return iban.toString();
    }
}
