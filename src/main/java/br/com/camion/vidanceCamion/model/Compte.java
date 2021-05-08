package br.com.camion.vidanceCamion.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Entity
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "cp_Sequence", sequenceName = "cp_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cp_Sequence")
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

    private int voyage ;

    @NotBlank
    private String datePrecis;

    private double prix ;



    private String hj = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));

    public String getHj() {
        return hj;
    }

    public void setHj(String hj) {

        this.hj = hj;
    }


    public double getPrix() {
        return prix;
    }

    public double setPrix(double prix) {
        this.prix = prix;
        return prix;
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

    public int getVoyage() {
        return voyage;
    }

    public void setVoyage(int voyage) {
            this.voyage = voyage;


    }


    public String getDatePrecis() {
        return datePrecis;
    }

    public void setDatePrecis(String datePrecis) {
        this.datePrecis = datePrecis;
    }


//
//    public double retornarValor() {
//
//        double result = getPrix();
//        double valorFinal;
//
//
//
//        for (int i = 0; i < getVoyage() ; i++){
//           result = result + 20000;
//        }
//
//        valorFinal = (setPrix(result));
//
//        return  valorFinal  ;
//      String result ;
//
//       if (getVoyage() == 1){
//           result =  (setPrix(20000)+"FCFA");
//
//       }else if(getVoyage() >=2 && getVoyage() <=5) {
//           result =   (setPrix(100000) + "FCFA");
//
//       }else if(getVoyage() >= 6 && getVoyage() <= 10) {
//           result =    (setPrix(200000) + "FCFA");
//
//       }else {
//           result = "A discuter";
//       }
//       return result;
//






}
