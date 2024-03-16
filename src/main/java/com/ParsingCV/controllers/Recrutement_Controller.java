package com.ParsingCV.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 import com.ParsingCV.entities.Recrutement;
import com.ParsingCV.entities.Recrutement_key;
import com.ParsingCV.repository.Recrutement_Repository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/recrutement")
public class Recrutement_Controller {
	Recrutement_Repository recrutement_repository ;

	@GetMapping("/afficher")
    @ResponseBody  
	public List<Recrutement> GetAllrecrutements() {
	return (List<Recrutement>) recrutement_repository.findAll() ; 
	}
	
	@PostMapping("/creerrecrutement")
 	 public Recrutement creerrecrutement(@Valid @RequestBody Recrutement recrutement) 
	{ return recrutement_repository.save(recrutement);	 }
	
	@PutMapping("/{recrutementId}")
    @ResponseBody  
	public Recrutement updaterecrutement(@PathVariable Recrutement_key recrutementId, @Valid @RequestBody Recrutement recrutementRequest) {
	    return recrutement_repository.findById(recrutementId).map(recrutement -> { 
	    	recrutement.setScore(recrutementRequest.getScore());
	    	recrutement.setDateCandidature(recrutementRequest.getDateCandidature());
	    	recrutement.setCommentaires(recrutementRequest.getCommentaires());
	    	recrutement.setEvaluationCandidat(recrutementRequest.getEvaluationCandidat());
	         

	        return recrutement_repository.save(recrutement);
	    }).orElseThrow(() -> new IllegalArgumentException("recrutementId " + recrutementId + " not found"));
	}


	@DeleteMapping("/{recrutementId}")
    @ResponseBody  
	public ResponseEntity<?> deleteRecrutement(@PathVariable Recrutement_key recrutementeId)
	{ return recrutement_repository.findById(recrutementeId).map(recrutement -> { 
		recrutement_repository.delete(recrutement); 
	return ResponseEntity.ok().build();
	 }).orElseThrow(() -> new IllegalArgumentException("recrutementeId " + 
			 recrutementeId + " not found"));
	 }
	 
	 @GetMapping("/{RecrutementId}") public Recrutement getRecrutement(@PathVariable Recrutement_key recrutementId) { 
	 Optional<Recrutement> o = recrutement_repository.findById(recrutementId);
	 
	 return o.get();}
	
}
