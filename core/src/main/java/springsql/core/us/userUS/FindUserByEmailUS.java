package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.domain.User;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.FindUserByEmailPort;

@Service
public record FindUserByEmailUS(UserRepositoryPort userRepositoryPort) implements FindUserByEmailPort {

    @Override
    public User apply(String email) {

        return userRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found."));
    }
}
