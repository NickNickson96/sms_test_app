package org.dpk.sms.controller;

import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.TariffEntity;
import org.dpk.sms.service.TariffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tariffs")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    /*@GetMapping
    public String jumpToRootSection () { String answer = "You're in Tariffs root section";return answer; }
*/
    @GetMapping("/{id}")
    public TariffEntity getThisTariff(@PathVariable("id") Long idTariff){
        return tariffService.getThisTariffEntityById(idTariff);
    }
//------------------------------------
    @GetMapping
    public ModelAndView getTariffsPage() {
        ModelAndView mav = new ModelAndView("t_tariffs");
        mav.addObject("tariffs", tariffService.getAllTariffEntities());

        return mav;
    }

    @GetMapping("/new_tariff")
    public ModelAndView getNewTariffPage() {
        ModelAndView mav = new ModelAndView("t_new_tariff");
        mav.addObject("tariff", new TariffEntity());
        return mav;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditTariffPage(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("t_new_tariff");
        mav.addObject("tariff", tariffService.getThisTariffEntityById(id));
        return mav;
    }

    @PostMapping("/save")
    public String newTariff(TariffEntity entity) {
        tariffService.saveThisTariffEntity(entity);
        return "redirect:/tariffs";
    }
//-----------------------------------------
    @GetMapping("/all")
    public List<TariffEntity> getTariffs() {
        return tariffService.getAllTariffEntities();
    }

    @PostMapping
    public void createTariff(@RequestBody TariffEntity tariff) {
        tariffService.saveThisTariffEntity(tariff);
    }

    @DeleteMapping("/{id}")
    public void deleteTariff(@PathVariable("id") Long idTariff) {
        tariffService.deleteThisTariffEntityById(idTariff);
    }

}
