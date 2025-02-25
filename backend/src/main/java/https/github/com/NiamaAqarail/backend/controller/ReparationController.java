package https.github.com.NiamaAqarail.backend.controller;


import https.github.com.NiamaAqarail.backend.dto.ReparationDTO;
import https.github.com.NiamaAqarail.backend.model.Reparation;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.service.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reparation")
@CrossOrigin("*")

public class ReparationController {
    @Autowired
    private ReparationService reparationService;


    @PostMapping("/add")
    public String addReparation(@RequestBody Reparation reparation){
        try{
            reparationService.addReparation(reparation);
            return "Reparation added successfully";
        }catch (Exception e){
            return "Failed to add the reparation: "+e.getMessage();
        }
    }
    @GetMapping("/all")
    public List<Reparation> getAllReparations(){
        return reparationService.getAllReparations();
    }
//    @GetMapping("/voiture")
//    public Voiture getReparationVoiture(@RequestParam Integer id){
//        return reparationService.getReparationVoiture(id);
//    }
    @GetMapping("/get")
    public Reparation getReparation(@RequestParam Integer id){
        return reparationService.getReparation(id);
    }
    @PutMapping("/update/{id}")
    public String updateReparation(@PathVariable Integer id, @RequestBody Reparation reparation){
        try{
            reparationService.updateReparation(id,reparation);
            return "Reparation updated successfully";
        }catch (Exception e){
            return "Failed to update the reparation : " + e.getMessage();
        }
    }
    @PatchMapping("/update-cout/{id}")
    public String updateReparationCout(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationCout(id, reparationDTO);
            return "Reparation cost updated successfully";
        }catch (Exception e){
            return "Failed to update reparation: "+e.getMessage();
        }
    }
    @PatchMapping("/update-datedebut/{id}")
    public String updateReparationDateDeb(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationDateDeb(id,reparationDTO);
            return "The reparation starting date was updated successfully";
        }catch(Exception e){
            return "Failed to update the reparation starting date: "+e.getMessage();
        }
    }
    @PatchMapping("/update-datefin/{id}")
    public String updateReparationDateFin(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationDateFin(id,reparationDTO);
            return "The reparation ending date was updated successfully";
        }catch(Exception e){
            return "Failed to update the reparation ending date: "+e.getMessage();
        }
    }
    @PatchMapping("/update-description/{id}")
    public String updateReparationDescription(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationDescription(id,reparationDTO);
            return "The reparation description was updated successfully";
        }catch(Exception e){
            return "Failed to update the reparation description: "+e.getMessage();
        }
    }
    @PatchMapping("/update-etat/{id}")
    public String updateReparationEtat(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationEtat(id,reparationDTO);
            return "The reparation state was updated successfully";
        }catch(Exception e){
            return "Failed to update the reparation state: "+e.getMessage();
        }
    }
    @PatchMapping("/update-voiture/{id}")
    public String updateReparationVoiture(@PathVariable Integer id, @RequestBody ReparationDTO reparationDTO){
        try{
            reparationService.updateReparationVoiture(id,reparationDTO);
            return "The repared car was updated successfully";
        }catch(Exception e){
            return "Failed to update the repared car: "+e.getMessage();
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteReparation(@PathVariable Integer id){
        try{
            reparationService.deleteVoiture(id);
            return "The reparation was deleted successfully";
        }catch(Exception e){
            return "Failed to delete the reparation : "+e.getMessage();
        }
    }
}
