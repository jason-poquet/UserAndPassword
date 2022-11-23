package fr.mysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.mysite.entities.User;
/**
 * UserRepository to access data sources
 * 
 * @author Jason POQUET
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE u.name=:name")
    User findUserByName(@Param("name") String name);
    
}
