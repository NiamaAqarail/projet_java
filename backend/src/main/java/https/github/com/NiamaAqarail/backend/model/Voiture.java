package https.github.com.NiamaAqarail.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "voitures")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marque;
    private String model;
    private int anneeFab;
    private String carburant;
    private String immatriculation;
    private double prix;
    private String etat;
    private String image;


//    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference("voiture")
//    private List<Reparation> reparations;

//    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Location> locations;

//    public List<Location> getLocations() {
//        return locations;
//    }
//
//    public void setLocations(List<Location> locations) {
//        this.locations = locations;
//    }

//    public List<Reparation> getReparations() {
//        return reparations;
//    }
//
//    public void setReparations(List<Reparation> reparations) {
//        this.reparations = reparations;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnneeFab() {
        return anneeFab;
    }

    public void setAnneeFab(int anneeFab) {
        this.anneeFab = anneeFab;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//    public void addReparation(Reparation reparation){
//        this.reparations.add(reparation);
//    }
    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", model='" + model + '\'' +
                ", anneeFab=" + anneeFab +
                ", carburant='" + carburant + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", prix=" + prix +
                ", etat='" + etat + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
