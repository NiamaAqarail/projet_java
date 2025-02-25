package https.github.com.NiamaAqarail.backend.service;


import https.github.com.NiamaAqarail.backend.dto.ClientDTO;
import https.github.com.NiamaAqarail.backend.model.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);

    List<Client> getClients();

    Client getClient(Integer id);

    void updateClient(Integer id, Client client);

    void deleteClient(Integer id);

    void updateNom(Integer id, ClientDTO clientDTO);

    void updatePrenom(Integer id, ClientDTO clientDTO);

    void updateCni(Integer id, ClientDTO clientDTO);

    void updateTel(Integer id, ClientDTO clientDTO);

    void updateAdresse(Integer id, ClientDTO clientDTO);

    void updateNumPermis(Integer id, ClientDTO clientDTO);
}
