package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.ClientsSubscribersGroupDto;
import org.dpk.sms.entity.ClientsSubscribersGroupEntity;
import org.dpk.sms.service.ClientsSubscribersGroupService;
import org.dpk.sms.service.SubscriberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/clients_subscribers_groups")
@RequiredArgsConstructor
public class ClientsSubscribersGroupController {

    private final ClientsSubscribersGroupService clientsSubscribersGroupService;
    private final SubscriberService subscriberService;
    //-----------------------------------
    @GetMapping
    public ModelAndView getClientsSubscribersGroupPage() {
        ModelAndView mav = new ModelAndView("csg_clients_subscribers_groups");
        mav.addObject("clients_subscribers_groups", clientsSubscribersGroupService.getAllClientsSubscribersGroupEntities());

        return mav;
    }

    @GetMapping("/new_client_s_subscribers_group")
    public ModelAndView getNewClientsSubscribersGroupPage() {
        ModelAndView mav = new ModelAndView("csg_new_clients_subscribers_group");
        mav.addObject("subs", subscriberService.getAllSubscriberEntities());
        mav.addObject("new_client_s_subscribers_group", new ClientsSubscribersGroupDto());
        return mav;
    }

    @PostMapping("/new")
    public String newClientsSubscribersGroup(ClientsSubscribersGroupDto csg) {
        clientsSubscribersGroupService.saveThisClientsSubscribersGroupEntity(csg);
        return "redirect:/clients_subscribers_groups";
    }
    //-------------------------------------
    @DeleteMapping("/{id}")
    public void deleteClientsSubscribersGroup(@PathVariable("id") Long idClientsSubscribersGroup) {
        clientsSubscribersGroupService.deleteThisClientsSubscribersGroupEntityById(idClientsSubscribersGroup);
    }
}
