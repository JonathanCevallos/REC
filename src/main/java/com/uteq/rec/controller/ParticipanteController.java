package com.uteq.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uteq.rec.entity.Participante;
import com.uteq.rec.service.ParticipanteService;

@Controller
@CrossOrigin("*")
@RequestMapping("participantes")
public class ParticipanteController {
	@Autowired
	ParticipanteService participanteService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<Participante> participante = this.participanteService.findAll();
            model.addAttribute("participantes", participante);
            return "views/participante";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarParticipante(@ModelAttribute("participante") Participante participante) {
        try {
        	participanteService.save(participante);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newParticipante(Model model) throws Exception {
        model.addAttribute("participantes", participanteService.findAll());
        Participante participante = new Participante();
        model.addAttribute("participante", participante);
        return "views/nuevo_participante";
    }
}
