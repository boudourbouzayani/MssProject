
package tn.mss.mssIntern.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.mss.mssIntern.modele.Tutorial;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    // FIRST METHOD
    @Query("SELECT e FROM Tutorial e WHERE e.name = :name")
    List<Tutorial> findAllByName2(@Param("name") String name);

    //second method

    List<Tutorial> findAllByName(String name);



}
