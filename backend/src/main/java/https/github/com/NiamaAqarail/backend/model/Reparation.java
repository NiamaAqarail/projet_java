package https.github.com.NiamaAqarail.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reparations")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Reparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;
    private double cout;
    private String etat;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voiture_id", nullable = false)
    @JsonIgnore
    @JsonBackReference("reparations")
    private Voiture voiture;

    public Reparation(){

    }


    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    @Override
    public String toString() {
        return "Reparation{" +
                "id=" + id +
                ", voiture=" + voiture +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", cout=" + cout +
                ", etat='" + etat + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
