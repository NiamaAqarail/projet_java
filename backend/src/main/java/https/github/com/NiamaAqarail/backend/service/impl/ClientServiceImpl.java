package https.github.com.NiamaAqarail.backend.service.impl;

import https.github.com.NiamaAqarail.backend.dto.ClientDTO;
import https.github.com.NiamaAqarail.backend.model.Client;
import https.github.com.NiamaAqarail.backend.model.User;
import https.github.com.NiamaAqarail.backend.repository.ClientRepository;
import https.github.com.NiamaAqarail.backend.repository.UserRepository;
import https.github.com.NiamaAqarail.backend.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addClient(Client client) {
        User user = userRepository.save(client.getUser());
        client.setUser(user);
        clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid client id "+id));
        return client;
    }

    @Override
    public void updateClient(Integer id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id " + id));
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id " + id));
        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setCni(client.getCni());
        existingClient.setTel(client.getTel());
        existingClient.setAdresse(client.getAdresse());
        existingClient.setNumPermis(client.getNumPermis());
        existingClient.setUser(existingUser);
        clientRepository.save(existingClient);
    }
    @Override
    public void deleteClient(Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id " + id);
        }
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid client id "+ id));
        Integer user_id = client.getUser().getId();
        userRepository.deleteById(user_id);
        clientRepository.deleteClientById(id);
    }

    @Override
    public void updateNom(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setNom(clientDTO.getNom());
        clientRepository.save(client);
    }

    @Override
    public void updatePrenom(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setPrenom(clientDTO.getPrenom());
        clientRepository.save(client);
    }

    @Override
    public void updateCni(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setCni(clientDTO.getCni());
        clientRepository.save(client);
    }

    @Override
    public void updateTel(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setTel(clientDTO.getTel());
        clientRepository.save(client);
    }

    @Override
    public void updateAdresse(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setAdresse(clientDTO.getAdresse());
        clientRepository.save(client);
    }

    @Override
    public void updateNumPermis(Integer id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+id));
        client.setNumPermis(clientDTO.getNumPermis());
        clientRepository.save(client);
    }
}
