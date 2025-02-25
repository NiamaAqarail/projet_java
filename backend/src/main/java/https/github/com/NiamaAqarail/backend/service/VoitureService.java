package https.github.com.NiamaAqarail.backend.service;

import https.github.com.NiamaAqarail.backend.dto.VoitureDTO;
import https.github.com.NiamaAqarail.backend.model.Voiture;

import java.util.List;

public interface VoitureService {
    void addVoiture(Voiture voiture);

    List<Voiture> getVoitures();

    Voiture getVoiture(Integer id);

    void updateVoiture(Integer id, Voiture voiture);

    void deleteVoiture(Integer id);

    void updateMarque(Integer id, VoitureDTO voitureDTO);

    void updateModel(Integer id, VoitureDTO voitureDTO);

    void updateAnneeFab(Integer id, VoitureDTO voitureDTO);

    void updateCarburant(Integer id, VoitureDTO voitureDTO);

    void updateImmatriculation(Integer id, VoitureDTO voitureDTO);

    void updatePrix(Integer id, VoitureDTO voitureDTO);

    void updateEtat(Integer id, VoitureDTO voitureDTO);

    void updateImage(Integer id, VoitureDTO voitureDTO);
}
