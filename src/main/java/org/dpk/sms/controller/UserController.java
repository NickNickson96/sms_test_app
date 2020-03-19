package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.UserDto;
import org.dpk.sms.service.RoleService;
import org.dpk.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    //-------------------------------------------------------------------------
    @GetMapping
    public ModelAndView getUsersPage() {
        ModelAndView mav = new ModelAndView("u_users");
        mav.addObject("users", userService.getAllUserEntities());

        return mav;
    }

    @GetMapping("/new_user")
    public ModelAndView getNewUserPage() {
        ModelAndView mav = new ModelAndView("u_new_user");
        mav.addObject("roles", roleService.getAllRoleEntities());
        mav.addObject("new_user", new UserDto());
        return mav;
    }

    @PostMapping("/new")
    public String newUser(UserDto user) {
        userService.saveThisUserEntity(user);
        return "redirect:/users";
    }
    //-------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long idUser) {
        userService.deleteThisUserEntityById(idUser);
    }
}
