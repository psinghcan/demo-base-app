package com.psinghcan.demobaseapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecuredPageController
{
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/secure/index", method = RequestMethod.GET)
    public ModelAndView index1()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("index");
        return retVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/secure/adminPage", method = RequestMethod.GET)
    public ModelAndView adminPage()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("AdminPage");
        return retVal;
    }

    @PreAuthorize("hasRole('STAFF')")
    @RequestMapping(value="/secure/staffPage", method = RequestMethod.GET)
    public ModelAndView staffPage()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("StaffPage");
        return retVal;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/secure/userPage", method = RequestMethod.GET)
    public ModelAndView userPage()
    {
        ModelAndView retVal = new ModelAndView();
        retVal.setViewName("UserPage");
        return retVal;
    }
}
