package https.github.com.NiamaAqarail.backend.repository;

import https.github.com.NiamaAqarail.backend.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Reparation r " +
            "WHERE r.voiture = :voiture " +
            "AND r.dateDebut <= :dateFin " +
            "AND r.dateFin >= :dateDebut")
    boolean isInReparation(@Param("voiture") Voiture voiture,
                           @Param("dateDebut") LocalDate dateDebut,
                           @Param("dateFin") LocalDate dateFin);
}
