package com.ParsingCV.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "condidat") 
public class Condidat {
    @Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_condidat;
 	
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "nom")
	private String nom;
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "prenom")
    private String prenom;
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "adresse")
    private String adresse;
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "email")
    private String email;
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "telephone")
	private Long telephone;
    @NotBlank (message="le champ ne doit pas etre vide")
    @Column(name = "diplome")
	private String diplome;
    @NotBlank (message="le champ ne doit pas etre vide")
	private List<String> langues; 
    @NotBlank (message="le champ ne doit pas etre vide")
	private List<String> competences; 
    @NotBlank (message="le champ ne doit pas etre vide")
	private List<String> formations; 
    @NotBlank (message="le champ ne doit pas etre vide")
	private List<String> experience; 
	
	public Condidat() {
		super();
	}
	public Condidat(Long id_condidat, String nom, String prenom, String adresse, String email, Long telephone,
			String diplome, List<String> langues, List<String> competences, List<String> formations,
			List<String> experience) {
		super();
		this.id_condidat = id_condidat;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.diplome = diplome;
		this.langues = langues;
		this.competences = competences;
		this.formations = formations;
		this.experience = experience;
	}
	public Long getId_condidat() {
		return id_condidat;
	}
	public void setId_condidat(Long id_condidat) {
		this.id_condidat = id_condidat;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public List<String> getLangues() {
		return langues;
	}
	public void setLangues(List<String> langues) {
		this.langues = langues;
	}
	public List<String> getCompetences() {
		return competences;
	}
	public void setCompetences(List<String> competences) {
		this.competences = competences;
	}
	public List<String> getFormations() {
		return formations;
	}
	public void setFormations(List<String> formations) {
		this.formations = formations;
	}
	public List<String> getExperience() {
		return experience;
	}
	public void setExperience(List<String> experience) {
		this.experience = experience;
	}
	

	
	
	
}
