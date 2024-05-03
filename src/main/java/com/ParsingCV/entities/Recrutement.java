package com.ParsingCV.entities;

 import java.time.LocalDate;

 import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Recrutement") 
@Data
@ToString
public class Recrutement   {

    @Id 
  private Long recrutementId ;
    
    @ManyToOne
     @JoinColumn(name = "offre_id")
    private Offre offre;
    
   

	@ManyToOne
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
