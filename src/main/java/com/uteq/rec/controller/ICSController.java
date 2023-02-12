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

import com.uteq.rec.entity.ICS;
import com.uteq.rec.service.ICSService;

@Controller
@CrossOrigin("*")
@RequestMapping("ICS")
public class ICSController {
	@Autowired
	ICSService iCSService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<ICS> iCS = this.iCSService.findAll();
            model.addAttribute("iCS", iCS);
            return "views/ICS";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarICS(@ModelAttribute("iCS") ICS iCS) {
        try {
        	iCSService.save(iCS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newICS(Model model) throws Exception {
        model.addAttribute("iCS", iCSService.findAll());
        ICS iCS = new ICS();
        model.addAttribute("iCS", iCS);
        return "views/nuevo_ICS";
    }
}
