package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.DeleteUserByIdPort;

@Service
public record DeleteUserByIdUS(UserRepositoryPort userRepositoryPort) implements DeleteUserByIdPort {

    @Override
    public void apply(String id) {
        if (!userRepositoryPort.existsById(id))
            throw new RuntimeException("User not found.");
        else
            userRepositoryPort.deleteById(id);
    }
}
