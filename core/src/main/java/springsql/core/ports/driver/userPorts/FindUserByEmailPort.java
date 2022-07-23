package springsql.core.ports.driver.userPorts;

import springsql.core.domain.User;

public interface FindUserByEmailPort {

    User apply (String email);

}
