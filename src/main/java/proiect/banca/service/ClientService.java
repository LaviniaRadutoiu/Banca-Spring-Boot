package proiect.banca.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proiect.banca.domain.Client;
import proiect.banca.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    final ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
     public List<Client> getAllClients(){
        return (List<Client>) clientRepository.findAll();
     }

}
