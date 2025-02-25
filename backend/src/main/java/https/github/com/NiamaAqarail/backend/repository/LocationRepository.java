package https.github.com.NiamaAqarail.backend.repository;

import https.github.com.NiamaAqarail.backend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "SELECT * FROM locations l WHERE l.voiture_id = :voitureId ORDER BY l.date_debut ASC LIMIT 1", nativeQuery = true)
    Location getNearestLoan(@Param("voitureId") Integer voitureId);
}
