package tn.esprit.springproject.Services;

import tn.esprit.springproject.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer findById(Integer id);
    public List<Foyer> findAll();
    public Foyer save(Foyer foyer);
    public void delete(Foyer foyer);
    public Foyer getNomCapacity(String nom,Long capacity);
    //ou bien     public void delete(lond id);
}
