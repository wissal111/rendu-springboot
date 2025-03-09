package tn.esprit.springproject.Repisotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r " +
            "JOIN Chambre c ON r.chambre.idChambre = c.idChambre " +
            "JOIN Bloc b ON c MEMBER OF b.chambres " +
            "JOIN Foyer f ON b MEMBER OF f.blocs " +
            "JOIN Universite u ON f MEMBER OF u.foyers " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND r.anneeUniversitaire = :anneeUniversitaire")
    List<Reservation> findReservationsByYearAndUniversity(@Param("anneeUniversitaire") Date anneeUniversitaire,
                                                          @Param("nomUniversite") String nomUniversite);
}

