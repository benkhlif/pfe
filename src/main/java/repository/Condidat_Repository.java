package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import entities.Condidat;

@Repository
public interface Condidat_Repository extends JpaRepository<Condidat, Long>{

}
