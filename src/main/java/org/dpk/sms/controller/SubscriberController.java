package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SubscriberEntity;
import org.dpk.sms.service.SubscriberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/subscribers")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService;

    @GetMapping("/{id}")
    public SubscriberEntity getThisSubscriber_by_path(@PathVariable("id") Long idSubscriber){
        return subscriberService.getThisSubscriberEntityById(idSubscriber);
    }

    @GetMapping("/all")
    public List<SubscriberEntity> getSubscriber() {
        return subscriberService.getAllSubscriberEntities();
    }

    //--------------------------------
    @GetMapping
    public ModelAndView getSubscriberPage() {
        ModelAndView mav = new ModelAndView("s_subscribers");
        mav.addObject("subscribers", subscriberService.getAllSubscriberEntities());

        return mav;
    }

    @GetMapping("/new_subscriber")
    public ModelAndView getNewSubscriberPage() {
        ModelAndView mav = new ModelAndView("s_new_subscriber");
        mav.addObject("subscriber", new SubscriberEntity());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditSubscriberPage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("s_new_subscriber");
        mav.addObject("subscriber", subscriberService.getThisSubscriberEntityById(id));
        return mav;
    }

    @PostMapping("/save")
    public String newSubscriber(SubscriberEntity entity) {
        subscriberService.saveThisSubscriberEntity(entity);
        return "redirect:/subscribers";
    }
    //-------------------------------------
    @PostMapping
    public void createSubscriber(@RequestBody SubscriberEntity subscriber) {
        subscriberService.saveThisSubscriberEntity(subscriber);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscriber(@PathVariable("id") Long idSubscriber) {
        subscriberService.deleteThisSubscriberEntityById(idSubscriber);
    }
}
