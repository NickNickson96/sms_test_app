package org.dpk.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")

public class _Menu {

//    private final AccessRightService accessRightService;
    //-----------------------------------
    @GetMapping
    public ModelAndView getHeaderMenuPage() {
        ModelAndView mav = new ModelAndView("header_menu");
//        mav.addObject("rights", accessRightService.getAllAccessRightEntities());

        return mav;
    }



}
