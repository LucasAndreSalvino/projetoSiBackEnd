package br.edu.ufcg.computacao.si1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebPagesController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getPageIndex() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
}