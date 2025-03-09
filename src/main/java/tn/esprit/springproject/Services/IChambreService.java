package tn.esprit.springproject.Services;

import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
        List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
        List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    }
