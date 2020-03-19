package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.DebitHistoryEntity;
import org.dpk.sms.service.DebitHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/debit_history")
@RequiredArgsConstructor
public class DebitHistoryController {

    private final DebitHistoryService debitHistoryService;

    @GetMapping("/{id}")
    public DebitHistoryEntity getThisDebitHistory_by_path(@PathVariable("id") Long idDebitHistory){
        return debitHistoryService.getThisDebitHistoryEntityById(idDebitHistory);
    }

    @GetMapping("/all")
    public List<DebitHistoryEntity> getDebitHistory(/*@RequestParam String name*/) {
        return debitHistoryService.getAllDebitHistoryEntities();
    }
//--------------------------------
    @GetMapping
    public ModelAndView getDebitHistoryPage() {
        ModelAndView mav = new ModelAndView("dh_debit_history");
        mav.addObject("dh_history", debitHistoryService.getAllDebitHistoryEntities());

        return mav;
    }
//-------------------------------------

    @PostMapping
    public void createDebitHistory(@RequestBody DebitHistoryEntity debitHistory) {
        debitHistoryService.saveThisDebitHistoryEntity(debitHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteDebitHistory(@PathVariable("id") Long idDebitHistory) {
        debitHistoryService.deleteThisDebitHistoryEntityById(idDebitHistory);
    }
}
