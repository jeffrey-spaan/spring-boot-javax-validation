package nl.systemation.javaxvalidation.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jeffrey Spaan
 * @Company Systemation
 * @Created on Thursday, August 27th, 2020
 */

@Repository // Mark this Java class as the repository layer
public interface UserRepository extends JpaRepository<User, Long> {
}
