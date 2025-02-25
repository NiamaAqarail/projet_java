package https.github.com.NiamaAqarail.backend.service.impl;

import https.github.com.NiamaAqarail.backend.dto.VoitureDTO;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.repository.VoitureRepository;
import https.github.com.NiamaAqarail.backend.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public void addVoiture(Voiture voiture) {
        voitureRepository.save(voiture);
    }

    @Override
    public List<Voiture> getVoitures() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture getVoiture(Integer id) {
        Voiture voiture = voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        return voiture;
    }

    @Override
    public void updateVoiture(Integer id, Voiture voiture) {
        voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setId(id);
        voitureRepository.save(voiture);
    }

    @Override
    public void deleteVoiture(Integer id) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voitureRepository.delete(voiture);
    }

    @Override
    public void updateMarque(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setMarque(voitureDTO.getMarque());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateModel(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setModel(voitureDTO.getModel());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateAnneeFab(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setAnneeFab(voitureDTO.getAnneeFab());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateCarburant(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setCarburant(voitureDTO.getCarburant());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateImmatriculation(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setImmatriculation(voitureDTO.getImmatriculation());
        voitureRepository.save(voiture);
    }

    @Override
    public void updatePrix(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setPrix(voitureDTO.getPrix());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateEtat(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setEtat(voitureDTO.getEtat());
        voitureRepository.save(voiture);
    }

    @Override
    public void updateImage(Integer id, VoitureDTO voitureDTO) {
        Voiture voiture =  voitureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id " + id));
        voiture.setImage(voitureDTO.getImage());
        voitureRepository.save(voiture);
    }
}
