package stores.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stores.DealType;
import stores.Deals;
import stores.data.DealTypeRepository;

@Controller
public class DealTypeController {
    private final DealTypeRepository dealTypeRepository;

    public DealTypeController(DealTypeRepository dealTypeRepository) {
        this.dealTypeRepository = dealTypeRepository;
    }

    @GetMapping("/typedeal")
    public String showDealTypeForm(Model model) {
        model.addAttribute("dealTypes", dealTypeRepository.findAll());
        return "typedeal";
    }

    
    @PostMapping("/selectdeal")
    public String selectDealType(@RequestParam("dealTypeId") Long dealTypeId, Model model) {
    	
        DealType dealType = dealTypeRepository.findById(dealTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid deal type Id:" + dealTypeId));
        model.addAttribute("selectedDealType", dealType);
        
        // Создание объекта Deals и установка typeId
        Deals deal = new Deals();
        deal.setTypeId(dealTypeId);
        model.addAttribute("deal", deal);

        return "deal"; 
    }

}


