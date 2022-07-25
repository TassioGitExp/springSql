package springsql.api.controller;

import org.springframework.web.bind.annotation.*;
import springsql.api.controller.request.UserRequest;
import springsql.api.controller.response.UserResponse;
import springsql.core.domain.User;
import springsql.core.ports.driver.userPorts.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("users")
public record UserController(
        CreateUserPort createUserPort,
        DeleteUserByIdPort deleteUserByIdPort,
        FindUserByEmailPort findUserByEmailPort,
        FindUserByIdPort findUserByIdPort,
        FindAllUserPort findAllUserPort,
        UpdateUserPort updateUserPort) {

    static final String pass = "pass5553211";

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {

        var user = userRequest.toUser();
        user = createUserPort.apply(user);

        return new UserResponse().fromUser(user);
    }

    @GetMapping("/{password}/{id}")
    public UserResponse findUserById(@PathVariable String password, @PathVariable String id) {
        if (!Objects.equals(password, pass))
            return null;

        var user = findUserByIdPort.apply(id);

        return new UserResponse().fromUser(user);
    }

    @GetMapping("/{password}/{email}")
    public UserResponse findUserByEmail(@PathVariable String password, @PathVariable String email) {
        if (!Objects.equals(password, pass))
            return null;

        var user = findUserByEmailPort.apply(email);

        return new UserResponse().fromUser(user);
    }

    @GetMapping("/{password}/show-all")
    public List<User> findAllUsers(@PathVariable String password) {
        if (!Objects.equals(password, pass))
            return null;

        var userList = findAllUserPort().apply();

        return userList.stream().toList();
    }

    @DeleteMapping("/delete/{password}/{id}")
    public void deleteUserById(@PathVariable String password, @PathVariable String id) {
        if (!Objects.equals(password, pass))
            return;

        deleteUserByIdPort.apply(id);
    }

    @PatchMapping("/update/{password}/{id}")
    public UserResponse updateUserById(@PathVariable String password, @PathVariable String id, @RequestBody UserRequest userRequest) {
        if (!Objects.equals(password, pass))
            return null;

        var user = findUserByIdPort.apply(id);

        user = userRequest.toUser();
        user = updateUserPort().apply(user);

        return new UserResponse().fromUser(user);
    }
}
