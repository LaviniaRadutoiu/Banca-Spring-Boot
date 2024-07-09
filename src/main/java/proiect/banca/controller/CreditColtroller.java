package proiect.banca.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import proiect.banca.controller.dto.AdaugaCreditDto;
import proiect.banca.domain.Cont;
import proiect.banca.domain.Credit;
import proiect.banca.repository.ClientRepository;
import proiect.banca.repository.CreditRepository;
import proiect.banca.service.CreditService;

import java.util.List;

@RestController
@RequestMapping("/credit")
@RequiredArgsConstructor
public class CreditColtroller {

    final CreditService creditService;
    final ClientRepository clientRepository;
    final CreditRepository creditRepository;

    @PostMapping("/{clientId}")
    public String addCredit(@PathVariable Long clientId, @RequestBody AdaugaCreditDto dto) {
        var client = clientRepository.findById(clientId);
        if (client.isEmpty())
            return "client inexistent";

        creditService.saveCredit(new Credit(creditService.generareIban(), dto.getSold(), dto.getDobanda(), dto.getMoneda(), client.get(), dto.getPerioadaDeCreditare()));
        return "credit adaugat";
    }

    @GetMapping("/{clientId}")
    public List<Credit> getCredit(@PathVariable Long clientId) {
        var client = clientRepository.findById(clientId);
        return client.map(creditRepository::findAllByClient).orElse(null);

    }
}
