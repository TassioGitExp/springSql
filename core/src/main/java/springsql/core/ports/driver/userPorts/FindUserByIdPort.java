package springsql.core.ports.driver.userPorts;

import springsql.core.domain.User;

public interface FindUserByIdPort {

    User apply (String id);

}
