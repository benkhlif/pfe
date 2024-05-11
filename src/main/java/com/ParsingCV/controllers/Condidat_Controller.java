package com.ParsingCV.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ParsingCV.entities.Condidat;
import com.ParsingCV.repository.Condidat_Repository;


  @Controller
 @CrossOrigin(origins = "http://localhost:4200")
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
    public Condidat creerCondidat(@RequestParam("file") MultipartFile file,
                                  @RequestParam("nom") String nom,
                                  @RequestParam("prenom") String prenom,
                                  @RequestParam("adresse") String adresse,
                                  @RequestParam("email") String email,
                                  @RequestParam("telephone") String telephone,
                                  @RequestParam("diplome") String diplome,
                                  @RequestParam("langues") String langues,
                                  @RequestParam("competences") String competences,
                                  @RequestParam("formations") String formations,
                                  @RequestParam("experience") String experience) throws IOException {
        Condidat condidat = new Condidat();
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            condidat.setPhoto(photoBytes);
        } 
        condidat.setNom(nom);
        condidat.setPrenom(prenom);
        condidat.setAdresse(adresse);
        condidat.setEmail(email);
        condidat.setTelephone(telephone);
        condidat.setDiplome(diplome);
        condidat.setLangues(langues);
        condidat.setCompetences(competences);
        condidat.setFormations(formations);
        condidat.setExperience(experience);
      return condidat_repository.save(condidat);
    }
    
 
    @PutMapping("/{id_condidat}")
    @ResponseBody
    public ResponseEntity<Condidat> updateCondidat(@PathVariable Long id_condidat,
                                                    @RequestParam(value = "file", required = false) MultipartFile file,
                                                    @ModelAttribute Condidat condidatRequest) {
        return condidat_repository.findById(id_condidat).map(condidat -> {
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
            if (file != null && !file.isEmpty()) {
                try {
                    condidat.setPhoto(file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Condidat updatedCondidat = condidat_repository.save(condidat);
            return ResponseEntity.ok(updatedCondidat);
        }).orElse(ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{condidatId}")
	public ResponseEntity<?> deleteOffre(@PathVariable Long condidatId)
	{ return condidat_repository.findById(condidatId).map(condidat -> { 
		condidat_repository.delete(condidat); 
	return ResponseEntity.ok().build();
	 }).orElseThrow(() -> new IllegalArgumentException("CondidatId  " + 
			 condidatId + " not found"));
	 } 

    @GetMapping("/{condidatId}")
    public ResponseEntity<Condidat> getCondidatById(@PathVariable Long condidatId) { 
        Optional<Condidat> c = condidat_repository.findById(condidatId);
        return c.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

