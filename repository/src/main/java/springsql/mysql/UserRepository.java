package springsql.mysql;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsql.core.ports.driven.repository.UserRepositoryPort;

@Repository
public interface UserRepository extends JpaRepository <SecurityProperties.User, Long>, UserRepositoryPort {

}
