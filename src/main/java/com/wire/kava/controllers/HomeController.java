package com.wire.kava.controllers;

import com.wire.kava.models.User;
import com.wire.kava.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class HomeController {
    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/user/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String username
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setUsername(username);
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/")
    public String index(Model model) {
        String[] users = {"Mikola", "Anna", "Sonya"};
        model.addAttribute("users", users);
        return "index";
    }
}
