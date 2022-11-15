package mirea.example.learningenglishmanagementsystem.controllers;

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
@RequestMapping("/simple-english")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
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
        return "redirect:/user";
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
