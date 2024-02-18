package stores.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import jakarta.validation.Valid;
import stores.Deals;
import stores.data.DealsRepository;

@Controller
@RequestMapping("/deal")
@SessionAttributes("deal")
public class DealController {
    private final DealsRepository dealRepository;
    private static final Logger log = LoggerFactory.getLogger(DealController.class);

    public DealController(DealsRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @GetMapping("/create")
    public String dealForm(Model model) {
        model.addAttribute("deal", new Deals());
        return "deal";
    }

    @PostMapping("/submit")
    public String processDeal(@Validated Deals deal, Errors errors, 
    		SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "deal";
        }
        log.info("Deal submitted: {}", deal);
        dealRepository.save(deal);
        sessionStatus.setComplete();
        return "redirect:/final";
    }
}







