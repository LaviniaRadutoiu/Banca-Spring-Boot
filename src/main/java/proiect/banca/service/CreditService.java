package proiect.banca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proiect.banca.domain.Client;
import proiect.banca.domain.Credit;
import proiect.banca.repository.CreditRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreditService {

    final CreditRepository creditRepository;

    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }
    public List<Credit> getAllCredits(){

        return (List<Credit>) creditRepository.findAll();
    }
    public String generareIban() {
        StringBuilder iban = new StringBuilder("RO00");
        Random random = new Random();
        for (int i = 0; i < 20; i++)
            iban.append(random.nextInt(10));
        return iban.toString();
    }
}
