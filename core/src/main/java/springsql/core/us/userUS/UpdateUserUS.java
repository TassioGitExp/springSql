package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.domain.User;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.UpdateUserPort;

@Service
public record UpdateUserUS(UserRepositoryPort userRepositoryPort) implements UpdateUserPort {

    @Override
    public User apply(User user) {
        if (!userRepositoryPort.existsById(user.getId()))
            throw new RuntimeException("User not found.");
        else {
            user = userRepositoryPort.save(user);
            return user;
        }
    }
}
