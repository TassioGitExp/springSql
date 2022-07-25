package springsql.core.us.userUS;

import org.springframework.stereotype.Service;
import springsql.core.domain.User;
import springsql.core.ports.driven.repository.UserRepositoryPort;
import springsql.core.ports.driver.userPorts.FindAllUserPort;

import java.util.List;

@Service
public record FindAllUserUS(UserRepositoryPort userRepositoryPort) implements FindAllUserPort {

    @Override
    public List<User> apply (){
        var userList = userRepositoryPort.findAll();

        if (userList.size() == 0)
            throw new RuntimeException("No users created.");
        else
            return userList;
    }
}
