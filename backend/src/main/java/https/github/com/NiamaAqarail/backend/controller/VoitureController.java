package https.github.com.NiamaAqarail.backend.controller;


import https.github.com.NiamaAqarail.backend.dto.VoitureDTO;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voiture")
public class VoitureController {
    @Autowired
    private VoitureService voitureService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addVoiture(@RequestBody Voiture voiture) {
        try {
            voitureService.addVoiture(voiture);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Car added successfully");
            return ResponseEntity.ok(response); // Return JSON response
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to add the car: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // Return JSON response
        }
    }
    @GetMapping("/all")
    public List<Voiture> getVoitures(){
        return voitureService.getVoitures();
    }
    @GetMapping("/get")
    public Voiture getVoiture(@RequestParam Integer id){
        return voitureService.getVoiture(id);
    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Map<String, String>> updateVoiture(@PathVariable Integer id, @RequestBody Voiture voiture) {
//        try {
//            voitureService.updateVoiture(id, voiture);
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Car updated successfully");
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Failed to update the car: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        }
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVoiture(@PathVariable Integer id, @RequestBody Voiture voiture) {
        try {
            voitureService.updateVoiture(id, voiture);
            return ResponseEntity.ok("Car updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the car: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteVoiture(@PathVariable Integer id) {
        try {
            voitureService.deleteVoiture(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Car deleted successfully");
            return ResponseEntity.ok(response); // Return success message
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Failed to delete the car: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PatchMapping("/update-marque/{id}")
    public String updateMarque(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateMarque(id, voitureDTO);
            return "Car's brand updated successfully";
        }catch (Exception e){
            return "Failed to update the car's brand "+ e.getMessage();
        }
    }
    @PatchMapping("/update-model/{id}")
    public String updateModel(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateModel(id, voitureDTO);
            return "Car's model updated successfully";
        }catch(Exception e){
            return "Failed to update the car's model " + e.getMessage();
        }
    }
    @PatchMapping("/update-anneefab/{id}")
    public String updateAnneeFab(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateAnneeFab(id, voitureDTO);
            return "Car's manufacturing date updated successfully";
        }catch(Exception e){
            return "Failed to update the car's manufacturing date " + e.getMessage();
        }
    }
    @PatchMapping("/update-carburant/{id}")
    public String updateCarburant(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateCarburant(id, voitureDTO);
            return "Car's fue type updated successfully";
        }catch(Exception e){
            return "Failed to update the car's fuel type " + e.getMessage();
        }
    }
    @PatchMapping("/update-immat/{id}")
    public String updateImmatricuation(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateImmatriculation(id, voitureDTO);
            return "Car's pate number updated successfully";
        }catch(Exception e){
            return "Failed to update the car's pate number " + e.getMessage();
        }
    }
    @PatchMapping("/update-prix/{id}")
    public String updatePrix(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updatePrix(id, voitureDTO);
            return "Car's price updated successfully";
        }catch(Exception e){
            return "Failed to update the car's price " + e.getMessage();
        }
    }
    @PatchMapping("/update-etat/{id}")
    public String updateEtat(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateEtat(id, voitureDTO);
            return "Car's state updated successfully";
        }catch(Exception e){
            return "Failed to update the car's state " + e.getMessage();
        }
    }
    @PatchMapping("/update-image/{id}")
    public String updateImage(@PathVariable Integer id, @RequestBody VoitureDTO voitureDTO){
        try{
            voitureService.updateImage(id, voitureDTO);
            return "Car's image updated successfully";
        }catch(Exception e){
            return "Failed to update the car's image " + e.getMessage();
        }
    }

}
