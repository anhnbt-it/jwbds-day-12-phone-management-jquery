package org.example.controller;

import org.example.model.Smartphone;
import org.example.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Media;

@Controller
@RequestMapping("smartphones")
public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping
    public ModelAndView getSmartPhone() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Smartphone> smartphones = smartphoneService.findAll();
        modelAndView.addObject("smartphones", smartphones);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView createSmartphoneForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("smartphone", new Smartphone());
        return modelAndView;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @GetMapping("{id}/edit")
    public ModelAndView editSmartphoneForm(@PathVariable("id") Integer id)  {
        Smartphone smartphone = smartphoneService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("smartphone", smartphone);
        return modelAndView;
    }

    @PostMapping(value = "{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable("id") Integer id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }

    @PostMapping(value = "{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id) {
        return smartphoneService.remove(id);
    }

}
