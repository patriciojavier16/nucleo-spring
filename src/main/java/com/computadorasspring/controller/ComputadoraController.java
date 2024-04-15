package com.computadorasspring.controller;

import com.computadorasspring.entity.Computadora;
import com.computadorasspring.service.IComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/computadoras")
public class ComputadoraController {
    @Autowired
    private IComputadoraService iComputadoraService;
    @GetMapping
    public String listarComputadoras(Model model){
        List<Computadora> computadoras = iComputadoraService.obtenerTodo();
        model.addAttribute("listaComputadoras", computadoras);
        return  "listarComp";
    }
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaCompu(Model model){
        model.addAttribute("computadora", new Computadora());
        model.addAttribute("accion", "/computadoras/nueva");
        return "formularioComp";
    }
    @PostMapping("/nueva")
    public String guardarNuevaCompu(@ModelAttribute Computadora computadora){
        iComputadoraService.crearComputadora(computadora);
        return "redirect:/computadoras";
    }
    @GetMapping("editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id,@ModelAttribute Computadora computadora, Model model){
        model.addAttribute("computadoras",computadora);
        model.addAttribute("accion", "/computadoras/editar/"+id);
        return "formularioComp";
    }
    @PostMapping("editar/{id}")
    public String actualizarCompu(@PathVariable Long id,@ModelAttribute Computadora computadora){
        iComputadoraService.actualizarComputadora(id,computadora);
        return "redirect:/computadoras";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarCompu(@PathVariable Long id){
        iComputadoraService.eliminarComputadora(id);
        return "redirect:/computadoras";
    }
}
