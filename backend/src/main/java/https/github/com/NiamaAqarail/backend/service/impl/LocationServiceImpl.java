package https.github.com.NiamaAqarail.backend.service.impl;

import https.github.com.NiamaAqarail.backend.dto.ClientDTO;
import https.github.com.NiamaAqarail.backend.dto.LocationDTO;
import https.github.com.NiamaAqarail.backend.dto.VoitureDTO;
import https.github.com.NiamaAqarail.backend.model.Client;
import https.github.com.NiamaAqarail.backend.model.Location;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import https.github.com.NiamaAqarail.backend.repository.ClientRepository;
import https.github.com.NiamaAqarail.backend.repository.LocationRepository;
import https.github.com.NiamaAqarail.backend.repository.VoitureRepository;
import https.github.com.NiamaAqarail.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Location addLocation(Location location) throws ResponseStatusException {
        Client client = clientRepository.findById(location.getClient().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id " + location.getClient().getId()));
        Voiture voiture = voitureRepository.findById(location.getVoiture().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid car id " + location.getVoiture().getId()));
        if(voiture.getEtat() == "indisponible"){
            Location nearestLoan = locationRepository.getNearestLoan(voiture.getId());
            if(location.getDateFin().isAfter(nearestLoan.getDateDebut().minusWeeks(1))){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La voiture est réservé pour cette période");
            }
            if(voitureRepository.isInReparation(voiture,location.getDateDebut(),location.getDateFin())){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"La voiture est en cours de réparation");
            }
        }
        voiture.setEtat("indisponible");
        location.setClient(client);
        location.setVoiture(voiture);
        locationRepository.save(location);
        return location;
    }
    @Override
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid location id" + id));
        return location;
    }

    @Override
    public void updateLocation(Integer id, Location location) {
        locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid location id " + id));
        Client client = clientRepository.findById(location.getClient().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id" + location.getClient().getId()));
        Voiture voiture = voitureRepository.findById(location.getVoiture().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id" + location.getVoiture().getId()));
        location.setClient(client);
        location.setVoiture(voiture);
        location.setId(id);
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id " + id));
        Voiture voiture = voitureRepository.findById(location.getVoiture().getId()).orElseThrow();
        locationRepository.delete(location);
        voiture.setEtat("disponible");
        voitureRepository.save(voiture);
    }

    @Override
    public void updateLocationClient(Integer id, ClientDTO clientDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id "+ id));
        Client client = clientRepository.findById(clientDTO.getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid client id "+ clientDTO.getId()));
        location.setId(id);
        location.setClient(client);
        locationRepository.save(location);
    }

    @Override
    public void updateLocationVoiture(Integer id, VoitureDTO voitureDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id "+ id));
        Voiture voiture = voitureRepository.findById(voitureDTO.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid voiture id "+ voitureDTO.getId()));
        location.setId(id);
        location.setVoiture(voiture);
        locationRepository.save(location);
    }
    @Override
    public void updateLocationDateDeb(Integer id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id "+ id));
        location.setId(id);
        location.setDateDebut(locationDTO.getDateDebut());
    }

    @Override
    public void updateLocationDateFin(Integer id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id "+ id));
        location.setId(id);
        location.setDateFin(locationDTO.getDateFin());
    }
    @Override
    public void updateLocationEtat(Integer id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid loan id "+ id));
        location.setId(id);
        location.setEtat(locationDTO.getEtat());
    }
}
