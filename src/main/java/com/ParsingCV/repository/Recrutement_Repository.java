package com.ParsingCV.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParsingCV.entities.Recrutement;
import com.ParsingCV.entities.Recrutement_key;

public interface Recrutement_Repository extends JpaRepository< Recrutement , Recrutement_key>{

}
