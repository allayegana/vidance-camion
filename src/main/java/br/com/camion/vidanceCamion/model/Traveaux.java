package br.com.camion.vidanceCamion.model;





import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
public class Traveaux implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tv_Sequence", sequenceName = "tv_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tv_Sequence")
    @Column(name = "ID")
    private Long id;

    @NotBlank
    private String prenom;

    @NotBlank
    private String Nom;

    @NotBlank
    private String ville;

    @NotBlank
    private String quartier;

    @NotBlank
    private String adresse;

    @NotBlank
    @NotEmpty
    private String type;

    @NotBlank
    private String datePrecis;

    private String prix = "a discuter";

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    private String hj = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
    public String getHj() {
        return hj;
    }


    public void setHj(String hj) {
        this.hj = hj;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getDatePrecis() {
        return datePrecis;
    }

    public void setDatePrecis(String datePrecis) {
        this.datePrecis = datePrecis;
    }

}
