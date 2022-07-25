package springsql.api.controller.request;

import lombok.Setter;
import springsql.core.domain.User;

@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;

    public User toUser() {
        var user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
