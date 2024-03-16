package com.ParsingCV.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Recrutement") 
@Data
@ToString
public class Recrutement implements Serializable {

    private static final long serialVersionUID = -4052226728617667534L;
    @EmbeddedId
 private Recrutement_key id ;
    @ManyToOne
    @MapsId("idOffre")
    @JoinColumn(name = "offre_id")
    private Offre offre;
    
   

	@ManyToOne
    @MapsId("idCondidat")
    @JoinColumn(name = "condidat_id")
    private Condidat condidat;
    
    private double score;

    private LocalDate dateCandidature;

    private String etatRecrutement;

    private String commentaires;

    private Long evaluationCandidat;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public LocalDate getDateCandidature() {
		return dateCandidature;
	}

	public void setDateCandidature(LocalDate dateCandidature) {
		this.dateCandidature = dateCandidature;
	}

	public String getEtatRecrutement() {
		return etatRecrutement;
	}

	public void setEtatRecrutement(String etatRecrutement) {
		this.etatRecrutement = etatRecrutement;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Long getEvaluationCandidat() {
		return evaluationCandidat;
	}

	public void setEvaluationCandidat(Long evaluationCandidat) {
		this.evaluationCandidat = evaluationCandidat;
	}

}
