package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.domain.User;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.CreateUserPort;

@Service
public record CreateUserUS(UserRepositoryPort userRepositoryPort) implements CreateUserPort {

    @Override
    public User apply(User user) {

        if (userRepositoryPort.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email already exists.");

        if (userRepositoryPort.existsById(user.getId()))
            throw new RuntimeException("User already exists (ID already taken).");

        user = userRepositoryPort.save(user);

        return user;
    }
}
