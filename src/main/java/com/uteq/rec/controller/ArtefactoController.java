package com.uteq.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uteq.rec.entity.Artefacto;
import com.uteq.rec.service.ArtefactoService;

@Controller
@CrossOrigin("*")
public class ArtefactoController {
	@Autowired
	ArtefactoService artefactoService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<Artefacto> artefactos = this.artefactoService.findAll();
            model.addAttribute("artefactos", artefactos);
            return "views/artefactos";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarArtefacto(@ModelAttribute("artefacto") Artefacto artefacto) {
        try {
        	artefactoService.save(artefacto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newArtefacto(Model model) throws Exception {
        model.addAttribute("artefactos", artefactoService.findAll());
        Artefacto artefacto = new Artefacto();
        model.addAttribute("artefacto", artefacto);
        return "views/nuevo_artefacto";
    }
}
