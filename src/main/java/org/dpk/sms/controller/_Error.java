package org.dpk.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")


public class _Error /*implements ErrorController*/
{

    @GetMapping
    public ModelAndView getHeaderMenuPage() {
        ModelAndView mav = new ModelAndView("error");

        return mav;
    }

    /*
    public String handleError() {
        //do something like logging
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
    */

}
