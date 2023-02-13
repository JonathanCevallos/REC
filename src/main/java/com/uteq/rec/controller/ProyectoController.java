package com.uteq.rec.controller;

import com.uteq.rec.entity.Participante;
import com.uteq.rec.entity.ProductOwner;
import com.uteq.rec.entity.Proyecto;
import com.uteq.rec.service.ClienteService;
import com.uteq.rec.service.ParticipanteService;
import com.uteq.rec.service.ProductOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.uteq.rec.service.ProyectoService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService ProyectoService;

    @Autowired
    ParticipanteService participanteService;

    @Autowired
    ClienteService  clienteService;

    @Autowired
    ProductOwnerService productOwnerService;



    @GetMapping("/all")
    public String findAll(Model model) {
        try {
           // List<Proyecto> Proyectos = this.ProyectoService.findAll();
           // model.addAttribute("Proyectos", Proyectos);
            return "views/";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarProyecto(@ModelAttribute("Proyecto") Proyecto Proyecto) {
        try {
            ProyectoService.save(Proyecto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newProyecto(Model model) throws Exception {
        model.addAttribute("Proyectos", ProyectoService.findAll());
        model.addAttribute("participantes", participanteService.findAll());
        model.addAttribute("productOwners", productOwnerService.findAll());
        model.addAttribute("clientes", clienteService.findAll());
        Proyecto proyecto = new Proyecto();
        model.addAttribute("proyecto", proyecto);
        return "views/proyecto";
    }
    
}
