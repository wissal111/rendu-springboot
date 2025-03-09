package tn.esprit.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Repisotories.IChambreRepository;
import tn.esprit.springproject.Repisotories.IFoyerRepository;
import tn.esprit.springproject.entities.Foyer;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
    IFoyerRepository foyerRepository;
    IChambreRepository chambreRepository;

    @Override
    public Foyer findById(Integer id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        foyerRepository.save(foyer);

        return foyer;
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);

    }
    @Override
    public Foyer getNomCapacity (String nom, Long capacity){
       return  foyerRepository.findByNameFoyerAndCapaciteFoyer(nom,capacity);
    }
}
