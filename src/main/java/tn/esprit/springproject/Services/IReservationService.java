package tn.esprit.springproject.Services;
import tn.esprit.springproject.entities.Reservation;

import java.util.Date;
import java.util.List;


public interface IReservationService {
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);
}



