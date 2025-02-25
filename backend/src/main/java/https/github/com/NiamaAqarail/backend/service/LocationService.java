package https.github.com.NiamaAqarail.backend.service;

import https.github.com.NiamaAqarail.backend.dto.ClientDTO;
import https.github.com.NiamaAqarail.backend.dto.LocationDTO;
import https.github.com.NiamaAqarail.backend.dto.VoitureDTO;
import https.github.com.NiamaAqarail.backend.model.Location;

import java.util.List;

public interface LocationService {
    Location addLocation(Location location);

    List<Location> getLocations();

    Location getLocation(Integer id);

    void updateLocation(Integer id, Location location);

    void deleteLocation(Integer id);

    void updateLocationClient(Integer id, ClientDTO clientDTO);

    void updateLocationVoiture(Integer id, VoitureDTO voitureDTO);

    void updateLocationDateDeb(Integer id, LocationDTO locationDTO);

    void updateLocationDateFin(Integer id, LocationDTO locationDTO);

    void updateLocationEtat(Integer id, LocationDTO locationDTO);
}
