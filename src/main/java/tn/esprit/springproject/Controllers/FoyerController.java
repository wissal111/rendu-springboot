package tn.esprit.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Services.IFoyerService;
import tn.esprit.springproject.entities.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    IFoyerService service;
    @PostMapping("/saveFoyer")
    public Foyer saveFoyer(Foyer foyer) {
        return service.save(foyer);
    }
    @GetMapping("/getFoyer/{id}")
public Foyer getFoyer(@PathVariable int id) {
    return service.findById(id);
    }
    @GetMapping("/getNomCapacity/{nom}/{capacity}")
    public Foyer getFoyer(@PathVariable("nom") String nom, @PathVariable("capacity") Long capacity) {
        return service.getNomCapacity( nom, capacity);
    }
}

