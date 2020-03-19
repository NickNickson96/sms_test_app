package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.AuthorizationHistoryEntity;
import org.dpk.sms.service.AuthorizationHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/authorization_history")
@RequiredArgsConstructor
public class AuthorizationHistoryController {

    private final AuthorizationHistoryService authorizationHistoryService;

    @GetMapping("/{id}")
    public AuthorizationHistoryEntity getThisAuthorizationHistory_by_path(@PathVariable("id") Long idAuthorizationHistory){
        return authorizationHistoryService.getThisAuthorizationHistoryEntityById(idAuthorizationHistory);
    }

    @GetMapping("/all")
    public List<AuthorizationHistoryEntity> getAuthorizationHistory(/*@RequestParam String name*/) {
        return authorizationHistoryService.getAllAuthorizationHistoryEntities();
    }

    //---------------------------------------
    @GetMapping
    public ModelAndView getAuthorizationHistoryPage() {
        ModelAndView mav = new ModelAndView("ah_authorization_history");
        mav.addObject("ah_history", authorizationHistoryService.getAllAuthorizationHistoryEntities());

        return mav;
    }
    //-------------------------------------

    @PostMapping
    public void createAuthorizationHistory(@RequestBody AuthorizationHistoryEntity authorizationHistory) {
        authorizationHistoryService.saveThisAuthorizationHistoryEntity(authorizationHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorizationHistory(@PathVariable("id") Long idAuthorizationHistory) {
        authorizationHistoryService.deleteThisAuthorizationHistoryEntityById(idAuthorizationHistory);
    }
}
