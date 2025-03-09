package tn.esprit.springproject.Repisotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entities.Chambre;
import tn.esprit.springproject.entities.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN Universite u ON u.foyer = f " +
            "WHERE u.nameUniversite = :nomUniversite " +
            "AND c.typeC = :type " +
            "AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE r.anneUniversitaire = CURRENT_DATE)")
    List<Chambre> findUnreservedRoomsByUniversityAndType(@Param("nomUniversite") String nomUniversite,
                                                         @Param("type") TypeChambre type);

    @Query("SELECT c FROM Chambre c " +
            "JOIN Bloc b ON c MEMBER OF b.chambres " +
            "WHERE b.idBloc = :idBloc " +
            "AND c.typeC = :typeC")
    List<Chambre> findRoomsByBlockAndType(@Param("idBloc") long idBloc,
                                          @Param("typeC") TypeChambre typeC);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);
}
