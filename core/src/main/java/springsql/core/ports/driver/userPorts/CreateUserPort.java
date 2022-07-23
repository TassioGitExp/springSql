package springsql.core.ports.driver.userPorts;

import springsql.core.domain.User;

public interface CreateUserPort {

    User apply (User user);

}
