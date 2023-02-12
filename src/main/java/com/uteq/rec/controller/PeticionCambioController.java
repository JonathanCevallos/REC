package com.uteq.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uteq.rec.entity.PeticionCambio;
import com.uteq.rec.service.PeticionCambioService;

@Controller
@CrossOrigin("*")
@RequestMapping("peticioncambios")
public class PeticionCambioController {
	@Autowired
	PeticionCambioService peticionCambioService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<PeticionCambio> peticionCambio = this.peticionCambioService.findAll();
            model.addAttribute("peticionCambio", peticionCambio);
            return "views/peticioncambio";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarPeticionCambio(@ModelAttribute("peticionCambio") PeticionCambio peticionCambio) {
        try {
        	peticionCambioService.save(peticionCambio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newPeticionCambio(Model model) throws Exception {
        model.addAttribute("Proyectos", peticionCambioService.findAll());
        PeticionCambio peticionCambio = new PeticionCambio();
        model.addAttribute("peticionCambio", peticionCambio);
        return "views/nuevo_peticioncambio";
    }
}
