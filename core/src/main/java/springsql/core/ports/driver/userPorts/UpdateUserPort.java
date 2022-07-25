package springsql.core.ports.driver.userPorts;

import springsql.core.domain.User;

public interface UpdateUserPort {

    User apply (User user);

}
