package mirea.example.learningenglishmanagementsystem.controllers;

import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.services.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/simple-english")
public class WordController {

    private final WordService wordService;
    private final ModelMapper modelMapper;

    public WordController(WordService wordService, ModelMapper modelMapper) {
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/1000-popular-words")
    public ModelAndView lastWordPassed() {
        ModelAndView modelAndView = new ModelAndView("1000PopularWords");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        if(user.getPopularWordId() != null) {
//            modelAndView.addObject("word", wordService.getWordById(1));
//        } else {
//            modelAndView.addObject("word", wordService.getWordById(user.getPopularWordId()));
//        }

        modelAndView.addObject("user", user);



        return modelAndView;
    };

}
