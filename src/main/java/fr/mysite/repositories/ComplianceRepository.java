package fr.mysite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.mysite.entities.Compliance;

/**
 * ComplianceRepository to access data sources
 * @author Jason POQUET
 *
 */
@Repository
public interface ComplianceRepository extends JpaRepository<Compliance, Long>{

}
