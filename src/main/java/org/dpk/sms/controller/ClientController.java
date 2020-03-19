package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.ClientDto;
import org.dpk.sms.service.ClientService;
import org.dpk.sms.service.TariffService;
import org.dpk.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final TariffService tariffService;
    private final UserService userService;

    //--------------------------------
    @GetMapping
    public ModelAndView getClientsPage() {
        ModelAndView mav = new ModelAndView("c_clients");
        mav.addObject("clients", clientService.getAllClientEntities());
        return mav;
    }

    @GetMapping("/new_client")
    public ModelAndView getNewClientPage() {
        ModelAndView mav = new ModelAndView("c_new_client");
        mav.addObject("tariffs", tariffService.getAllTariffEntities());
        mav.addObject("users", userService.getAllUserEntities());
        mav.addObject("new_client", new ClientDto());
        return mav;
    }

    @PostMapping("/new")
    public String newClient(ClientDto client) {
        clientService.saveThisClientEntity(client);
        return "redirect:/clients";
    }
    //-------------------------------------
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long idClient) {
        clientService.deleteThisClientEntityById(idClient);
    }
}
