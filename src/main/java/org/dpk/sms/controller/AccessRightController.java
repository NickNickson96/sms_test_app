package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.AccessRightEntity;
import org.dpk.sms.service.AccessRightService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/access_rights")
@RequiredArgsConstructor
public class AccessRightController {

    private final AccessRightService accessRightService;
//-----------------------------------
    @GetMapping
    public ModelAndView getAccessRightsPage() {
        ModelAndView mav = new ModelAndView("ar_access_rights");
        mav.addObject("rights", accessRightService.getAllAccessRightEntities());

        return mav;
    }

    @GetMapping("/new_access_right")
    public ModelAndView getNewAccessRightPage() {
        ModelAndView mav = new ModelAndView("ar_new_access_right");
        mav.addObject("access_right", new AccessRightEntity());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditAccessRightPage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("ar_new_access_right");
        mav.addObject("access_right", accessRightService.getThisAccessRightEntityById(id));
        return mav;
    }

    @PostMapping("/save")
    public String newAccessRight(AccessRightEntity entity) {
        accessRightService.saveThisAccessRightEntity(entity);
        return "redirect:/access_rights";
    }
//-------------------------------------
    @DeleteMapping("/{id}")
    public void deleteAccessRight(@PathVariable("id") Long idAccessRight) {
        accessRightService.deleteThisAccessRightEntityById(idAccessRight);
    }
}
