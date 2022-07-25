package springsql.api.controller.response;

import lombok.Getter;
import springsql.core.domain.User;

@Getter
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;

    public UserResponse fromUser(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.password = user.getPassword();

        return this;
    }

}
