package proiect.banca.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import proiect.banca.controller.dto.AdaugaCreditDto;
import proiect.banca.controller.dto.AdaugaDepozitDto;
import proiect.banca.domain.Credit;
import proiect.banca.domain.Depozit;
import proiect.banca.repository.ClientRepository;
import proiect.banca.repository.DepozitRepository;
import proiect.banca.service.DepozitService;

import java.util.List;

@RestController
@RequestMapping("/depozit")
@RequiredArgsConstructor
public class DepozitController {
    final DepozitService depozitService;
    final ClientRepository clientRepository;
    final DepozitRepository depozitRepository;

    @PostMapping("/{clientId}")
    public String addDepozit(@PathVariable Long clientId, @RequestBody AdaugaDepozitDto dto) {
        var client = clientRepository.findById(clientId);
        if (client.isEmpty())
            return "client inexistent";

        depozitService.saveDepozit(new Depozit(depozitService.generareIban(), dto.getSold(), dto.getDobanda(), dto.getPerioadaDeConstituire(), dto.getMoneda(), client.get()));
        return "depozit adaugat";
    }

    @GetMapping("/{clientId}")
    public List<Depozit> getDepozit(@PathVariable Long clientId) {
        var client = clientRepository.findById(clientId);
        return client.map(depozitRepository::findAllByClient).orElse(null);

    }
}
