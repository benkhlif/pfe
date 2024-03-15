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
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Condidat;
 import jakarta.validation.Valid;
import repository.Condidat_Repository;

@Controller
@RequestMapping("/condidat")
public class Condidat_Controller {
    @Autowired
    Condidat_Repository condidat_repository;

    @GetMapping("/ListeCondidats")
    @ResponseBody  
    public List<Condidat> getAllCondidats() {
        return (List<Condidat>) condidat_repository.findAll();
    }

    @PostMapping("/creercondidat")
    @ResponseBody  
    public Condidat creerCondidat(@Valid @RequestBody Condidat condidat) {
        return condidat_repository.save(condidat);
    }
    
    @PutMapping("/{condidatId}")
    @ResponseBody
    public Condidat updateCondidat(@PathVariable Long condidatId, @RequestBody Condidat condidatRequest) {
        return condidat_repository.findById(condidatId).map(condidat -> {
            condidat.setNom(condidatRequest.getNom());
            condidat.setPrenom(condidatRequest.getPrenom());
            condidat.setAdresse(condidatRequest.getAdresse());
            condidat.setEmail(condidatRequest.getEmail());
            condidat.setTelephone(condidatRequest.getTelephone());
            condidat.setDiplome(condidatRequest.getDiplome());
            condidat.setLangues(condidatRequest.getLangues());
            condidat.setCompetences(condidatRequest.getCompetences());
            condidat.setFormations(condidatRequest.getFormations());
            condidat.setExperience(condidatRequest.getExperience());
             return condidat_repository.save(condidat);
        }).orElseThrow(() -> new IllegalArgumentException("CondidatId " + condidatId + " not found"));
    }

    @DeleteMapping("/{condidatId}")
	public ResponseEntity<?> deleteOffre(@PathVariable Long condidatId)
	{ return condidat_repository.findById(condidatId).map(condidat -> { 
		condidat_repository.delete(condidat); 
	return ResponseEntity.ok().build();
	 }).orElseThrow(() -> new IllegalArgumentException("ProviderId " + 
			 condidatId + " not found"));
	 }
	 
	 @GetMapping("/{condidatId}") public Condidat getcondidat(@PathVariable Long condidatId) { 
	 Optional<Condidat> c = condidat_repository.findById(condidatId);
	 
	 return c.get();}
}

