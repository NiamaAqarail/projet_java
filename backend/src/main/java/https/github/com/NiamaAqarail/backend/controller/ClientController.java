package https.github.com.NiamaAqarail.backend.controller;

import https.github.com.NiamaAqarail.backend.dto.ClientDTO;
import https.github.com.NiamaAqarail.backend.model.Client;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addClient(@RequestBody Client client) {
        try {
            clientService.addClient(client);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client added successfully");
            return ResponseEntity.ok(response); // Return JSON response
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to add the client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Return JSON response
        }
    }
    @GetMapping("/all")
    public List<Client> getClient(){
        return  clientService.getClients();
    }
    @GetMapping("/get")
    public Client getClient(@RequestParam Integer id){
        return clientService.getClient(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Integer id, @RequestBody Client client) {
        try {
            clientService.updateClient(id, client);
            return ResponseEntity.ok("Client updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the client: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteClient(@PathVariable Integer id) {
        try {
            clientService.deleteClient(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Client deleted successfully");
            return ResponseEntity.ok(response); // Return success message
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to delete the client: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PatchMapping("/update-nom/{id}")
    public ResponseEntity<Void> updateNom(@PathVariable Integer id, @RequestBody ClientDTO clientDTO){
        clientService.updateNom(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-prenom/{id}")
    public ResponseEntity<Void> updatePrenom(@PathVariable Integer id,@RequestBody ClientDTO clientDTO){
        clientService.updatePrenom(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-cni/{id}")
    public ResponseEntity<Void> updateCni(@PathVariable Integer id,@RequestBody ClientDTO clientDTO){
        clientService.updateCni(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-tel/{id}")
    public ResponseEntity<Void> updateTel(@PathVariable Integer id,@RequestBody ClientDTO clientDTO){
        clientService.updateTel(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-adresse/{id}")
    public ResponseEntity<Void> updateAdresse(@PathVariable Integer id,@RequestBody ClientDTO clientDTO){
        clientService.updateAdresse(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/update-numpermis/{id}")
    public ResponseEntity<Void> updateNumPermis(@PathVariable Integer id,@RequestBody ClientDTO clientDTO){
        clientService.updateNumPermis(id, clientDTO);
        return ResponseEntity.noContent().build();
    }
}