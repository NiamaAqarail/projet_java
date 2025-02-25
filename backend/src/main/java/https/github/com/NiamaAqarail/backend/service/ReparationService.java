package https.github.com.NiamaAqarail.backend.service;

import https.github.com.NiamaAqarail.backend.dto.ReparationDTO;
import https.github.com.NiamaAqarail.backend.model.Reparation;
import https.github.com.NiamaAqarail.backend.model.Voiture;

import java.util.List;

public interface ReparationService {
    void addReparation(Reparation reparation);

    List<Reparation> getAllReparations();

    Reparation getReparation(Integer id);

    Voiture getReparationVoiture(Integer id);

    void updateReparation(Integer id, Reparation reparation);

    void updateReparationCout(Integer id, ReparationDTO reparationDTO);

    void updateReparationDateDeb(Integer id, ReparationDTO reparationDTO);

    void updateReparationDateFin(Integer id, ReparationDTO reparationDTO);

    void updateReparationDescription(Integer id, ReparationDTO reparationDTO);

    void updateReparationEtat(Integer id, ReparationDTO reparationDTO);

    void updateReparationVoiture(Integer id, ReparationDTO reparationDTO);

    void deleteVoiture(Integer id);
}
