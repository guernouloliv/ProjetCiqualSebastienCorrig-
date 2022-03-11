package fr.epita.TP_CIQUAL.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.epita.TP_CIQUAL.domaine.Aliment;

@Repository
public interface AlimentDao extends CrudRepository<Aliment, Long>{

}
