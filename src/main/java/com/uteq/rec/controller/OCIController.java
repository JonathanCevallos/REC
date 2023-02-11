package com.uteq.rec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uteq.rec.entity.OCI;
import com.uteq.rec.service.OCIService;

@Controller
@CrossOrigin("*")
public class OCIController {
	 @Autowired
	 OCIService oCIService;

	    @GetMapping("")
	    public String findAll(Model model) {
	        try {
	            List<OCI> oCI = this.oCIService.findAll();
	            model.addAttribute("oCI", oCI);
	            return "views/OCI";
	        } catch (Exception e) {
	            String err = "Ocurrio un error: " + e.getMessage();
	            model.addAttribute("error", err);
	            return "Error";
	        }
	    }

	    @PostMapping("/save")
	    public String guardarOCI(@ModelAttribute("oCI") OCI oCI) {
	        try {
	        	oCIService.save(oCI);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	        return "redirect:/index";
	    }

	    @GetMapping({"/new"})
	    public String newOCI(Model model) throws Exception {
	        model.addAttribute("oCI", oCIService.findAll());
	        OCI oCI = new OCI();
	        model.addAttribute("oCI", oCI);
	        return "views/nuevo_OCI";
	    }
}
