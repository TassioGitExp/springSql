package springsql.core.ports.driven.repository;

import springsql.core.domain.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save (User user);

    boolean existsById (String id);

    boolean existsByEmail (String email);

    Optional<User> findById (String id);

    Optional<User> findByEmail (String email);

    void deleteById (String id);

}
