package mirea.example.learningenglishmanagementsystem.controllers;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.dto.UserDTO;
import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class RegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping(value = {"/", "/login"})
    public String showLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistration(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping()
    public String registration(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(convertToUser(userDTO));
        return "redirect:/user/login";
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }



}
