package byAJ.Securex.controllers;

import byAJ.Securex.repositories.BookRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model, Authentication auth){

        {
            System.out.println(auth.getName()+" authorities:"+auth.getAuthorities().toString());
            model.addAttribute("person",bookRepository.findBookByTitle(auth.get()));
        }
        else
        model.addAttribute("inMemory",true);
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}
