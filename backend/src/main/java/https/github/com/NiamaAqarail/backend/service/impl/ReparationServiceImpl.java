package https.github.com.NiamaAqarail.backend.service.impl;

import https.github.com.NiamaAqarail.backend.dto.ReparationDTO;
import https.github.com.NiamaAqarail.backend.model.Reparation;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.repository.ReparationRepository;
import https.github.com.NiamaAqarail.backend.repository.VoitureRepository;
import https.github.com.NiamaAqarail.backend.service.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReparationServiceImpl implements ReparationService {
    @Autowired
    private ReparationRepository reparationRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public void addReparation(Reparation reparation) {
        Voiture voiture = voitureRepository.findById(reparation.getVoiture().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid car id "+reparation.getVoiture().getId()));
        reparation.setVoiture(voiture);
        voiture.setEtat("indisponible");
        voitureRepository.save(voiture);
        reparationRepository.save(reparation);
    }

    @Override
    public List<Reparation> getAllReparations() {
        return reparationRepository.findAll();
    }

    @Override
    public Reparation getReparation(Integer id) {
        return reparationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id "+ id));
    }

    @Override
    public Voiture getReparationVoiture(Integer id) {
        reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        Voiture voiture =  reparationRepository.findVoitureByReparationId(id);
        return voiture;
    }

    @Override
    public void updateReparation(Integer id, Reparation reparation) {
        reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setId(id);
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationCout(Integer id, ReparationDTO reparationDTO) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setCout(reparationDTO.getCout());
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationDateDeb(Integer id, ReparationDTO reparationDTO) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setDateDebut(reparationDTO.getDateDebut());
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationDateFin(Integer id, ReparationDTO reparationDTO) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setDateFin(reparationDTO.getDateFin());
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationDescription(Integer id, ReparationDTO reparationDTO) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setDescription(reparationDTO.getDescription());
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationEtat(Integer id, ReparationDTO reparationDTO) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setEtat(reparationDTO.getEtat());
        reparationRepository.save(reparation);
    }

    @Override
    public void updateReparationVoiture(Integer id, ReparationDTO reparationDTO) {
        Voiture voiture = voitureRepository.findById(reparationDTO.getVoiture().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + reparationDTO.getVoiture().getId()));
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparation.setVoiture(voiture);
        reparationRepository.save(reparation);
    }

    @Override
    public void deleteVoiture(Integer id) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid reparation id " + id));
        reparationRepository.delete(reparation);
    }

}
