package controllers;

 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.Offre;
import jakarta.validation.Valid;
import repository.Offre_Repository;

@Controller
@RequestMapping("/offre")
public class Offre_Controller {
	@Autowired
	Offre_Repository offre_repository ;
	
	@GetMapping("/ListeOffre")
	public List<Offre> GetAllOffres() {
	return (List<Offre>) offre_repository.findAll() ; 
	}
	@PostMapping("/creerOffre")
	 public Offre creerOffre(@Valid @RequestBody Offre offre) { return offre_repository.save(offre);
	 }
	
	@PutMapping("/{offreId}")
	public Offre updateOffre(@PathVariable Long offreId, @Valid @RequestBody Offre offreRequest) {
	    return offre_repository.findById(offreId).map(offre -> { 
	        offre.setId_offre(offreRequest.getId_offre());
	        offre.setTitre(offreRequest.getTitre());
	        offre.setEntreprise(offreRequest.getEntreprise());
	        offre.setSecteur_d_activite(offreRequest.getSecteur_d_activite());
	        offre.setDescription(offreRequest.getDescription());
	        offre.setExigences(offreRequest.getExigences());
	        offre.setDate_publication(offreRequest.getDate_publication());
	        offre.setDate_limite(offreRequest.getDate_limite());
	        offre.setSalaire(offreRequest.getSalaire());
	        offre.setLocalisation(offreRequest.getLocalisation());
	        offre.setPostes_vacants(offreRequest.getPostes_vacants());
	        offre.setContrat(offreRequest.getContrat());
	        offre.setMot_clés(offreRequest.getMot_clés());

	        return offre_repository.save(offre);
	    }).orElseThrow(() -> new IllegalArgumentException("OffreId " + offreId + " not found"));
	}

	@DeleteMapping("/{offreId}")
	public ResponseEntity<?> deleteOffre(@PathVariable Long offreId)
	{ return offre_repository.findById(offreId).map(offre -> { 
		offre_repository.delete(offre); 
	return ResponseEntity.ok().build();
	 }).orElseThrow(() -> new IllegalArgumentException("offreId " + 
offreId + " not found"));
	 }
	 
	 @GetMapping("/{offreId}") public Offre getOffre(@PathVariable Long offreId) { 
	 Optional<Offre> o = offre_repository.findById(offreId);
	 
	 return o.get();}
	
}