package https.github.com.NiamaAqarail.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId // Ensures Client shares the same ID as User
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String nom;
    private String prenom;
    private String cni;
    private String tel;
    private String adresse;
    private String numPermis;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;

    @Version
    private Long version;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(String numPermis) {
        this.numPermis = numPermis;
    }
    public Client(){}
    public Client(String nom, String prenom, String cni, String tel, String adresse, String numPermis) {
        this.nom = nom;
        this.prenom = prenom;
        this.cni = cni;
        this.tel = tel;
        this.adresse = adresse;
        this.numPermis = numPermis;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cni='" + cni + '\'' +
                ", tel='" + tel + '\'' +
                ", adress='" + adresse + '\'' +
                ", numPermis='" + numPermis + '\'' +
                ", user='"+ user.toString()+
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
