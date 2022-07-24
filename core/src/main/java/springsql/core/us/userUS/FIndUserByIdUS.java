package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.domain.User;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.FindUserByIdPort;

@Service
public record FIndUserByIdUS(UserRepositoryPort userRepositoryPort) implements FindUserByIdPort {

    @Override
    public User apply(String id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found."));
    }
}
