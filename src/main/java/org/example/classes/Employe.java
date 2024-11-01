package org.example.classes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employe{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String telephone;

	@OneToMany (mappedBy = "employe", fetch = FetchType.EAGER)
	private List<Projet> projets;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
}
