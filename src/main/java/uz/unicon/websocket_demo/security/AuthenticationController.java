package uz.unicon.websocket_demo.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.unicon.websocket_demo.user.User;
import uz.unicon.websocket_demo.user.UserDto;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @PostMapping(value = "/register")
    public User register(@RequestBody UserDto dto) {
        return new User();
    }

    @GetMapping(value = "/login")
    public Object login(User user) {
        Map<String, Object> response = new HashMap<>();
        response.put("login", user.getUsername());
        return response;
    }
}
