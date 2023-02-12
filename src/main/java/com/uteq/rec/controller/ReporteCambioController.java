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

import com.uteq.rec.entity.ReporteCambio;
import com.uteq.rec.service.ReporteCambioService;

@Controller
@CrossOrigin("*")
@RequestMapping("reportecambios")
public class ReporteCambioController {
	@Autowired
	ReporteCambioService reporteCambioService;

    @GetMapping("")
    public String findAll(Model model) {
        try {
            List<ReporteCambio> reporteCambio = this.reporteCambioService.findAll();
            model.addAttribute("reporteCambio", reporteCambio);
            return "views/reporteCambio";
        } catch (Exception e) {
            String err = "Ocurrio un error: " + e.getMessage();
            model.addAttribute("error", err);
            return "Error";
        }
    }

    @PostMapping("/save")
    public String guardarReporteCambio(@ModelAttribute("reporteCambio") ReporteCambio reporteCambio) {
        try {
        	reporteCambioService.save(reporteCambio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index";
    }

    @GetMapping({"/new"})
    public String newProyecto(Model model) throws Exception {
        model.addAttribute("reporteCambio", reporteCambioService.findAll());
        ReporteCambio reporteCambio = new ReporteCambio();
        model.addAttribute("reporteCambio", reporteCambio);
        return "views/nuevo_Proyecto_LSB";
    }
}
