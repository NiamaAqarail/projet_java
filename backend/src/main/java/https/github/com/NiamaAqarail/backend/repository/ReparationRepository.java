package https.github.com.NiamaAqarail.backend.repository;

import https.github.com.NiamaAqarail.backend.model.Reparation;
import https.github.com.NiamaAqarail.backend.model.Voiture;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReparationRepository extends JpaRepository<Reparation, Integer> {
    @Query(value = "SELECT v.* FROM voitures v, reparations r WHERE r.voiture_id = v.id", nativeQuery = true)
    Voiture findVoitureByReparationId(@Param("id") Integer id);
}
