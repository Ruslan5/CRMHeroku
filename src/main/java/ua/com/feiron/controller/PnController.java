package ua.com.feiron.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.feiron.domain.Pn;
import ua.com.feiron.repository.PnRepository;
import ua.com.feiron.validation.PnValidator;

import java.util.List;

@Controller
public class PnController {

    private PnRepository pnRepository;
    private PnValidator pnValidator;

    @Autowired
    public PnController(PnRepository pnRepository, PnValidator pnValidator) {
        this.pnRepository = pnRepository;
        this.pnValidator = pnValidator;

    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPr() {
        return "index";
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String getProduct(Model model) {
        List<Pn> lists = this.pnRepository.listAll();
        model.addAttribute("lists", lists);
        return "product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addProduct(Model model) {
        model.addAttribute("pn", new Pn());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String addProduct(@ModelAttribute("pn") Pn pn, BindingResult bindingResult) {
        this.pnValidator.validate(pn, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }

        this.pnRepository.addProduct(pn);
        return "redirect:/product";
    }

    @RequestMapping(value = "deleteProduct/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String deleteProduct(@PathVariable Integer id) {

        this.pnRepository.removeProduct(id);
        return "redirect:/product";
    }
//    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
//    public void getEdit(@RequestParam(value = "id", required = true) Integer id, Model model){
//
//        model.addAttribute("profnastilAtribute", id);
//    }

    @RequestMapping(value = "calc", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public Model say(Double work_b, Double base_b, Double a,
                     Double b, Model model, Pn pn){
        List<Pn> lists = this.pnRepository.listAll();

        model.addAttribute("lists", lists);
        if (a != null && b != null && base_b != null && work_b != null ){
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("work_b", pn.getWork_b());
            model.addAttribute("base_b", pn.getBase_b());
            model.addAttribute("result", ((Math.ceil(b / work_b) * a * work_b)));
            model.addAttribute("sam", (int)((b / work_b * a * base_b * 6)));
            model.addAttribute("kl",(int)(Math.ceil(b / work_b)));


        }else {
            model.addAttribute("result",  "" );
        }
        return model;
    }
    @RequestMapping(value = "triangle", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public Model triangle(Double work_b, Double base_b,
                          Double b, Double c, Double h, Model model){
        if (b != null && h != null && base_b != null && work_b != null ) {
            model.addAttribute("b", b);
            model.addAttribute("h", h);
            model.addAttribute("work_b", work_b);
            model.addAttribute("base_b", base_b);
            model.addAttribute("result", ((Math.ceil(b / work_b) * base_b) * h) / 2);// Кол-во м.кв. материала
            model.addAttribute("sam", (int) (((Math.ceil(b / work_b) * base_b) * h)/2) * 6); // сол-во крепежа
            model.addAttribute("kl", (int) ((Math.ceil(b / work_b)))); // кол-во листов
        }else {
            model.addAttribute("result", "");
        }
        return model;
    }

    @RequestMapping(value = "trapezium", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public Model trapezium(Double work_b, Double base_b,
                           Double a, Double b, Double h, Model model){
        if (b != null && h != null && base_b != null && work_b != null ) {
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("h", h);
            model.addAttribute("work_b", work_b);
            model.addAttribute("base_b", base_b);
            model.addAttribute("result", ((a + (Math.ceil(b / work_b) * base_b)) / 2) * h);// Кол-во м.кв. материала
            model.addAttribute("sam", (int) ((a + (Math.ceil(b / work_b) * base_b) / 2) * h) * 6); // сол-во крепежа
            model.addAttribute("kl", (int) ((Math.ceil(b / work_b) * base_b))); // кол-во листов
        }else {
            model.addAttribute("result", "");
        }
        return model;
    }

}