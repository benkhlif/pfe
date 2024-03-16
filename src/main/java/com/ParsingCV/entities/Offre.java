package com.ParsingCV.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
 
@Entity
@Table(name = "offre") 
 public class Offre {
@Id 
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id_offre;
@NotBlank (message="le champ ne doit pas etre vide")
private String titre;
@NotBlank (message="le champ ne doit pas etre vide")
private String entreprise;
@NotBlank (message="le champ ne doit pas etre vide")
private String secteur_d_activite; 
@NotBlank (message="le champ ne doit pas etre vide")
private String description;
@NotBlank (message="le champ ne doit pas etre vide")
private String exigences;
 private LocalDate  date_publication;
 private LocalDate  date_limite;
 private Long salaire; 
@NotBlank (message="le champ ne doit pas etre vide")
private String localisation;
 private Long Postes_vacants;
@NotBlank (message="le champ ne doit pas etre vide")
private String contrat;
@NotEmpty(message = "La liste de mots-clés ne doit pas être vide")
 private List<String> mot_clés;



public Offre(Long id_offre, String titre, String entreprise, String secteur_d_activite, String description,
		String exigences, LocalDate date_publication, LocalDate date_limite, Long salaire, String localisation,
		Long postes_vacants, String contrat, List<String> mot_clés) {
	super();
	this.id_offre = id_offre;
	this.titre = titre;
	this.entreprise = entreprise;
	this.secteur_d_activite = secteur_d_activite;
	this.description = description;
	this.exigences = exigences;
	this.date_publication = date_publication;
	this.date_limite = date_limite;
	this.salaire = salaire;
	this.localisation = localisation;
	Postes_vacants = postes_vacants;
	this.contrat = contrat;
	this.mot_clés = mot_clés;
}





public Offre() {
	super();
}





public Long getId_offre() {
	return id_offre;
}
public void setId_offre(Long id_offre) {
	this.id_offre = id_offre;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getEntreprise() {
	return entreprise;
}
public void setEntreprise(String entreprise) {
	this.entreprise = entreprise;
}
public String getSecteur_d_activite() {
	return secteur_d_activite;
}
public void setSecteur_d_activite(String secteur_d_activite) {
	this.secteur_d_activite = secteur_d_activite;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getExigences() {
	return exigences;
}
public void setExigences(String exigences) {
	this.exigences = exigences;
}
public LocalDate getDate_publication() {
	return date_publication;
}
public void setDate_publication(LocalDate date_publication) {
	this.date_publication = date_publication;
}
public LocalDate getDate_limite() {
	return date_limite;
}
public void setDate_limite(LocalDate date_limite) {
	this.date_limite = date_limite;
}
public Long getSalaire() {
	return salaire;
}
public void setSalaire(Long salaire) {
	this.salaire = salaire;
}
public String getLocalisation() {
	return localisation;
}
public void setLocalisation(String localisation) {
	this.localisation = localisation;
}
public Long getPostes_vacants() {
	return Postes_vacants;
}
public void setPostes_vacants(Long postes_vacants) {
	Postes_vacants = postes_vacants;
}
public String getContrat() {
	return contrat;
}
public void setContrat(String contrat) {
	this.contrat = contrat;
}
public List<String> getMot_clés() {
	return mot_clés;
}
public void setMot_clés(List<String> mot_clés) {
	this.mot_clés = mot_clés;
}

}
