package tn.mss.mssIntern.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.mss.mssIntern.modele.User;

import java.util.Date;
import java.util.List;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
  //@Query("SELECT p FROM User p WHERE p.password=:passwordOrEmail OR p.email=:passwordOrEmail")
  User findByEmail(String email);

  User findByPassword(String password);


}


