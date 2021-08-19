package com.psinghcan.demobaseapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("admin/adminPage");
        return retVal;
    }
}
