package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.CreditHistoryEntity;
import org.dpk.sms.service.CreditHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/credit_history")
@RequiredArgsConstructor
public class CreditHistoryController {

    private final CreditHistoryService creditHistoryService;

    @GetMapping("/{id}")
    public CreditHistoryEntity getThisCreditHistory_by_path(@PathVariable("id") Long idCreditHistory){
        return creditHistoryService.getThisCreditHistoryEntityById(idCreditHistory);
    }

    @GetMapping("/all")
    public List<CreditHistoryEntity> getCreditHistory(/*@RequestParam String name*/) {
        return creditHistoryService.getAllCreditHistoryEntities();
    }

//--------------------------------
    @GetMapping
    public ModelAndView getCreditHistoryPage() {
        ModelAndView mav = new ModelAndView("crh_credit_history");
        mav.addObject("crh_history", creditHistoryService.getAllCreditHistoryEntities());

        return mav;
    }
//-------------------------------------

    @PostMapping
    public void createCreditHistory(@RequestBody CreditHistoryEntity creditHistory) {
        creditHistoryService.saveThisCreditHistoryEntity(creditHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteCreditHistory(@PathVariable("id") Long idCreditHistory) {
        creditHistoryService.deleteThisCreditHistoryEntityById(idCreditHistory);
    }
}
