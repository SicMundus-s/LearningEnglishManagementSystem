package mirea.example.learningenglishmanagementsystem.controllers;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.models.Word;
import mirea.example.learningenglishmanagementsystem.services.UserService;
import mirea.example.learningenglishmanagementsystem.services.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/simple-english")
@AllArgsConstructor
public class WordController {

    private final UserService userService;
    private final WordService wordService;

    @GetMapping("/1000-popular-words")
    public ModelAndView lastWordPassed() {

        ModelAndView modelAndView = new ModelAndView("1000PopularWords");

        modelAndView.addObject("words", wordService.findAll());

        return modelAndView;
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/search-word")
    public String search(Model model, @RequestParam(name = "search") String search) {

        if(search.equals("")) {
            return "redirect:/simple-english/search";
        }

        model.addAttribute("searchWords", wordService.search(search));
        return "search";
    }


    @PostMapping("/add-word-dictionary")
    public String addWordToDictionary(@RequestParam(name = "wordId") Integer wordId, Authentication authentication) {

        User user = userService.findByLogin(userService.getLogin(authentication));
        Word word = wordService.findOne(wordId);
        userService.addWordToDictionary(word, user);

        return "redirect:/simple-english/search";

    }

    @PostMapping("/intervalPov")
    public void intervalPov() {

    }

}
