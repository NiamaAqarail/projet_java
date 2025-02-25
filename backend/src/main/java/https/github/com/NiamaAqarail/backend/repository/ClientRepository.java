package https.github.com.NiamaAqarail.backend.repository;

import https.github.com.NiamaAqarail.backend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Client c WHERE c.id = :id")
    void deleteClientById(@Param("id") Integer id);
}
