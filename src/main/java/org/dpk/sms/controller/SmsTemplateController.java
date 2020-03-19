package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SmsTemplateEntity;
import org.dpk.sms.service.SmsTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
//@RestController
@RequestMapping("/sms_templates")
@RequiredArgsConstructor
public class SmsTemplateController {

    private final SmsTemplateService smsTemplateService;

    @GetMapping("/{id}")
    public SmsTemplateEntity getThisSmsTemplate_by_path(@PathVariable("id") Long idSmsTemplate){
        return smsTemplateService.getThisSmsTemplateEntityById(idSmsTemplate);
    }

    @GetMapping("/all")
    public List<SmsTemplateEntity> getSmsTemplate(/*@RequestParam String name*/) {
        return smsTemplateService.getAllSmsTemplateEntities();
    }

    //--------------------------------
    @GetMapping
    public ModelAndView getSmsTemplatePage() {
        ModelAndView mav = new ModelAndView("st_sms_templates");
        mav.addObject("sms_template", smsTemplateService.getAllSmsTemplateEntities());

        return mav;
    }

    @GetMapping("/new_sms_template")
    public ModelAndView getNewSmsTemplatePage() {
        ModelAndView mav = new ModelAndView("st_new_sms_template");
        mav.addObject("sms_template", new SmsTemplateEntity());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditTariffPage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("st_new_sms_template");
        mav.addObject("sms_template", smsTemplateService.getThisSmsTemplateEntityById(id));
        return mav;
    }

    @PostMapping("/save")
    public String newSmsTemplate(SmsTemplateEntity entity) {
        smsTemplateService.saveThisSmsTemplateEntity(entity);
        return "redirect:/sms_templates";
    }
//-------------------------------------

    @PostMapping
    public void createSmsTemplate(@RequestBody SmsTemplateEntity smsTemplate) {
        smsTemplateService.saveThisSmsTemplateEntity(smsTemplate);
    }

    @DeleteMapping("/{id}")
    public void deleteSmsTemplate(@PathVariable("id") Long idSmsTemplate) {
        smsTemplateService.deleteThisSmsTemplateEntityById(idSmsTemplate);
    }
}
