package springsql.core.ports.driver.userPorts;

import springsql.core.domain.User;

import java.util.List;

public interface FindAllUserPort {

    List<User> apply ();

}
