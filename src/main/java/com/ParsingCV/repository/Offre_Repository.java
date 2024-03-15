package com.ParsingCV.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ParsingCV.entities.Offre;
 

@Repository
public interface Offre_Repository extends JpaRepository<Offre, Long>{

}
