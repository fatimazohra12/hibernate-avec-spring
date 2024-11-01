package org.example.classes;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Tache.getByPriceSup", query = "SELECT t FROM Tache t WHERE t.prix > :sup")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private Double prix;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
    
}
