package proiect.banca.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import proiect.banca.controller.dto.AdaugaClientDto;
import proiect.banca.domain.Client;
import proiect.banca.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    final ClientService clientService;
    @PostMapping
    public String addClient(@RequestBody AdaugaClientDto dto){
        clientService.saveClient(new Client(dto.getNume(), dto.getCnp(), dto.getAdresa()));
        return "Client adaugat";
    }

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAllClients();

    }
}
