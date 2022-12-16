package mirea.example.learningenglishmanagementsystem.controllers;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.services.UserService;
import mirea.example.learningenglishmanagementsystem.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
@RequestMapping("/simple-english")
@AllArgsConstructor
public class UserController {

    private final WordService wordService;
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/dictionary")
    public ModelAndView dictionary(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("dictionary");


        modelAndView.addObject("wordsByUser", userService
                .findByLogin(userService.getLogin(authentication))
                .getWords());

        return modelAndView;
    }

}
