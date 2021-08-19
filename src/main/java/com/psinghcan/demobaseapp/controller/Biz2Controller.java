package com.psinghcan.demobaseapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/biz2")
public class Biz2Controller {
    @PreAuthorize("hasRole('BIZ2')")
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("biz2/biz2Page");
        return retVal;
    }
}
