package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.RoleEntity;
import org.dpk.sms.service.AccessRightService;
import org.dpk.sms.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final AccessRightService accessRightService;

    //--------------------------------
    @GetMapping
    public ModelAndView getRolesPage() {
        ModelAndView mav = new ModelAndView("r_roles");
        mav.addObject("rights", accessRightService.getAllAccessRightEntities());
        mav.addObject("roles", roleService.getAllRoleEntities());
        return mav;
    }

    @GetMapping("/new_role")
    public ModelAndView getNewRolePage() {
        ModelAndView mav = new ModelAndView("r_new_role");
/*        mav.addObject("tariffs", tariffService.getAllTariffEntities());
        mav.addObject("users", userService.getAllUserEntities());*/
/*        mav.addObject("new_client", new ClientDto());*/
        mav.addObject("new_role",new RoleEntity());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditRolePage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("r_new_role");
        mav.addObject("role", roleService.getThisRoleEntityById(id));
        return mav;
    }

    @PostMapping("/save")
    public String newRole(RoleEntity role) { /*(RoleDto role)*/
        roleService.saveThisRoleEntity(role);
        return "redirect:/roles";
    }
    //-------------------------------------


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long idRole) {
        roleService.deleteThisRoleEntityById(idRole);
    }
}
