package com.example.prueba.retoopcional.controllers;

import com.example.prueba.retoopcional.models.entity.Empleado;
import com.example.prueba.retoopcional.models.entity.Pago;
import com.example.prueba.retoopcional.models.service.IEmpleadoService;
import com.example.prueba.retoopcional.models.service.IPagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    IPagoService pagoService;
    @Autowired
    IEmpleadoService empleadoService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("pagos", pagoService.findAll());
        model.addAttribute("titulo", "Lista de pagos");
        return "pagos/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("titulo", "Crear multiples pagos");
        return "pagos/create";
    }

    @PostMapping("/store")
    public String store(
            Model model,
            @RequestParam(name = "item_id[]", required = false) Long[] itemId,
            @RequestParam(name = "cantidad[]", required = false) Integer[] cantidad,
            RedirectAttributes flash) {

        if (itemId == null || itemId.length == 0) {
            model.addAttribute("titulo", "Crear multiples pagos");
            model.addAttribute("error", "Error: Debe haber por lo menos un pago!!! ");
            return "/pagos/create";
        }
        Empleado empleado = null;
        Pago pago = null;
        for (int i = 0; i < itemId.length; i++) {
            empleado = empleadoService.findById(itemId[i]);
            pago = new Pago();
            pago.setEmpleado(empleado);
            pago.setCantidad(empleadoService.getSalario(empleado, cantidad[i]));
            pagoService.save(pago);
        }
        flash.addFlashAttribute("success", "Pagos realizados con exito!!!");
        return "redirect:/pagos/index";

    }
}
