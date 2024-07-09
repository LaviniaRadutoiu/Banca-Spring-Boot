package proiect.banca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proiect.banca.domain.Cont;
import proiect.banca.repository.ContRepository;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContService {

   final ContRepository contRepository;

   public String generareIban() {
        StringBuilder iban = new StringBuilder("RO00");
        Random random = new Random();
        for (int i = 0; i < 20; i++)
            iban.append(random.nextInt(10));
        return iban.toString();
    }
   public Cont saveCont(Cont cont){
       return contRepository.save(cont);

   }
   public List<Cont> findAll(){
       return (List<Cont>) contRepository.findAll();
   }
}
