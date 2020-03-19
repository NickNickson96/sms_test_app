package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SmsEntity;
import org.dpk.sms.service.SmsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
//@RestController
@RequestMapping("/sms_messages")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @GetMapping("/{id}")
    public SmsEntity getThisSms_by_path(@PathVariable("id") Long idSms){
        return smsService.getThisSmsEntityById(idSms);
    }

    @GetMapping("/all")
    public List<SmsEntity> getSms(/*@RequestParam String name*/) {
        return smsService.getAllSmsEntities();
    }

    //--------------------------------
    @GetMapping
    public ModelAndView getSmsPage() {
        ModelAndView mav = new ModelAndView("s_sms");
        mav.addObject("sms", smsService.getAllSmsEntities());

        return mav;
    }

    @GetMapping("/new_sms")
    public ModelAndView getNewSmsPage() {
        ModelAndView mav = new ModelAndView("s_new_sms");
        mav.addObject("new_sms", new SmsEntity());
        return mav;
    }

    @PostMapping("/new")
    public String newSms(SmsEntity entity) {
        smsService.saveThisSmsEntity(entity);
        return "redirect:/sms_messages";
    }
    //-------------------------------------

    @PostMapping
    public void createSms(@RequestBody SmsEntity sms) {
        smsService.saveThisSmsEntity(sms);
    }

    @DeleteMapping("/{id}")
    public void deleteSms(@PathVariable("id") Long idSms) {
        smsService.deleteThisSmsEntityById(idSms);
    }
}
