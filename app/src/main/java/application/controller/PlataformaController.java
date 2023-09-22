package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import application.model.Plataforma;
import application.model.PlataformaRepository;

@Controller
@RequestMapping("/plataforma")
public class PlataformaController {
    @Autowired
    private PlataformaRepository plataformaRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("plataformas", plataformaRepo.findAll());
        return "/plataforma/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/plataforma/insert";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Plataforma plataforma = new Plataforma();
        plataforma.setNome(nome);

        plataformaRepo.save(plataforma);

        return "redirect:/plataforma/list";
    }
}
