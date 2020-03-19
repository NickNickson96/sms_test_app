package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ContactPersonEntity;
import org.dpk.sms.service.ContactPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/contact_persons")
@RequiredArgsConstructor
public class ContactPersonController {

    private final ContactPersonService contactPersonService;

    @GetMapping("/{id}")
    public ContactPersonEntity getThisContactPerson_by_path(@PathVariable("id") Long idContactPerson){
        return contactPersonService.getThisContactPersonEntityById(idContactPerson);
    }

    @GetMapping("/all")
    public List<ContactPersonEntity> getContactPerson(/*@RequestParam String name*/) {
        return contactPersonService.getAllContactPersonEntities();
    }

//--------------------------------
    @GetMapping
    public ModelAndView getContactPersonPage() {
        ModelAndView mav = new ModelAndView("cp_contact_persons");
        mav.addObject("contact_persons", contactPersonService.getAllContactPersonEntities());

        return mav;
    }

    @GetMapping("/new_contact_person")
    public ModelAndView getNewContactPersonPage() {
        ModelAndView mav = new ModelAndView("cp_new_contact_person");
        mav.addObject("new_contact_person", new ContactPersonEntity());
        return mav;
    }

    @PostMapping("/new")
    public String newContactPerson(ContactPersonEntity entity) {
        contactPersonService.saveThisContactPersonEntity(entity);
        return "redirect:/contact_persons";
    }
//-------------------------------------

    @PostMapping
    public void createContactPerson(@RequestBody ContactPersonEntity contactPerson) {
        contactPersonService.saveThisContactPersonEntity(contactPerson);
    }

    @DeleteMapping("/{id}")
    public void deleteContactPerson(@PathVariable("id") Long idContactPerson) {
        contactPersonService.deleteThisContactPersonEntityById(idContactPerson);
    }
}
