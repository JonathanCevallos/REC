package com.uteq.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uteq.rec.entity.Cliente;
import com.uteq.rec.service.ClienteService;

@Controller
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	ClienteService clienteService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<Cliente> cliente = this.clienteService.findAll();
            model.addAttribute("clientes", cliente);
            return "views/cliente";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        try {
        	clienteService.save(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newCliente(Model model) throws Exception {
        model.addAttribute("clientes", clienteService.findAll());
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "views/nuevo_cliente";
    }
}
