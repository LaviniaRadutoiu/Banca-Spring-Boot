package proiect.banca.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import proiect.banca.controller.dto.AdaugaContDto;
import proiect.banca.controller.dto.OperatiuneDto;
import proiect.banca.domain.Cont;
import proiect.banca.repository.ClientRepository;
import proiect.banca.repository.ContRepository;
import proiect.banca.service.ContService;

@RestController
@RequestMapping("/cont")
@RequiredArgsConstructor
public class ContContrloller {

    final ContService contService;
    final ClientRepository clientRepository;
    final ContRepository contRepository;

    @PostMapping("/{clientId}")
    public String addCont(@RequestBody AdaugaContDto dto, @PathVariable Long clientId) {
        var client = clientRepository.findById(clientId);
        if (client.isEmpty())
            return "client inexistent";

        if (contRepository.existsByClient(client.get()))
            return "cont curent existent";

        contService.saveCont(new Cont(contService.generareIban(), dto.getMoneda(), client.get()));
        return "cont adaugat";

    }

    @GetMapping("/{clientId}")
    public Cont getCont(@PathVariable Long clientId) {
        var client = clientRepository.findById(clientId);
        if (client.isEmpty())
            return null;
        var cont = contRepository.findByClient(client.get());
        return cont.orElse(null);
    }

    @PostMapping("/depunere/{contId}")
    public String depunereCont(@PathVariable Long contId, @RequestBody OperatiuneDto dto) {
        var cont = contRepository.findById(contId);
        if (cont.isEmpty())
            return "Cont inexistent!";
        cont.get().setSold(cont.get().getSold() + dto.getSuma());
     contRepository.save(cont.get());
    return "Suma depozitata";
    }
    @PostMapping("/retragere/{contId}")
    public String retragereCont(@PathVariable Long contId, @RequestBody OperatiuneDto dto) {
        var cont = contRepository.findById(contId);
        if (cont.isEmpty())
            return "Cont inexistent!";
        if(cont.get().getSold()< dto.getSuma())
            return "Foduri insuficiente!";
        cont.get().setSold(cont.get().getSold() - dto.getSuma());
        contRepository.save(cont.get());
        return "Suma retrasa";
    }
}
