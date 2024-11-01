package org.example.classes;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Date dateDebut;
	private Date dateFin;

	@ManyToOne
	@JoinColumn (name = "employe_id")
	private Employe employe;
	@OneToMany (mappedBy = "projet", fetch = FetchType.EAGER)
	private List<Tache> taches;
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
}

