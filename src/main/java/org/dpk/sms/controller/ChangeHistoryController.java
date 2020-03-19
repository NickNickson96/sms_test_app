package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ChangeHistoryEntity;
import org.dpk.sms.service.ChangeHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/change_history")
@RequiredArgsConstructor
public class ChangeHistoryController {

    private final ChangeHistoryService changeHistoryService;

    @GetMapping("/{id}")
    public ChangeHistoryEntity getThisChangeHistory_by_path(@PathVariable("id") Long idChangeHistory){
        return changeHistoryService.getThisChangeHistoryEntityById(idChangeHistory);
    }

    @GetMapping("/all")
    public List<ChangeHistoryEntity> getChangeHistory(/*@RequestParam String name*/) {
        return changeHistoryService.getAllChangeHistoryEntities();
    }

    //--------------------------------
    @GetMapping
    public ModelAndView getChangeHistoryPage() {
        ModelAndView mav = new ModelAndView("ch_change_history");
        mav.addObject("ch_history", changeHistoryService.getAllChangeHistoryEntities());

        return mav;
    }
//-------------------------------------

    @PostMapping
    public void createChangeHistory(@RequestBody ChangeHistoryEntity changeHistory) {
        changeHistoryService.saveThisChangeHistoryEntity(changeHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteChangeHistory(@PathVariable("id") Long idChangeHistory) {
        changeHistoryService.deleteThisChangeHistoryEntityById(idChangeHistory);
    }
}
