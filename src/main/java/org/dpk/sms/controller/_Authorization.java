package org.dpk.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//===USER
import org.dpk.sms.dto.UserDto;
import org.dpk.sms.controller.UserController;
import org.dpk.sms.service.UserService;

@Controller
@RequestMapping("/authorization")
//@RequestMapping("/login")
//@RequestMapping({"/login", "/authorization"})
//@RequestMapping({"/login", "/authorization"})
//@RequestMapping(value = {"/login", "/authorization","", "/", "welcome","home"}, path = {"/login", "/authorization","", "/", "welcome","home"})
//@RequestMapping({"/login", "/authorization","", "/", "welcome","home"})

public class _Authorization {
    //===USER
/*    private final UserService userService;*/

    @GetMapping
    public ModelAndView getAuthorizationAndLoginPage() {
        ModelAndView mav = new ModelAndView("authorization");
        mav.addObject("new_user", new UserDto());
        return mav;
    }


}
