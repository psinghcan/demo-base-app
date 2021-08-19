package com.psinghcan.demobaseapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/biz1")
public class Biz1Controller {
    @PreAuthorize("hasRole('BIZ1')")
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("biz1/biz1Page");
        return retVal;
    }
}
