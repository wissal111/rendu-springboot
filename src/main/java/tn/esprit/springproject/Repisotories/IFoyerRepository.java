package tn.esprit.springproject.Repisotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entities.Foyer;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer, Integer> {

    public default Foyer findByNameFoyerAndCapaciteFoyer(String nameFoyer, Long capaciteFoyer){
        return null;
    }
}
