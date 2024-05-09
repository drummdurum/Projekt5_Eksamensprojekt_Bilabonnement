package dk.kea.projekt5_eksamensprojekt_bilabonnement.controller;

import dk.kea.projekt5_eksamensprojekt_bilabonnement.model.LeasingModel;
import dk.kea.projekt5_eksamensprojekt_bilabonnement.repository.LeasingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class LeasingController {
    LeasingRepository leasingRepository;

    @GetMapping("/watchLeasingAgreements")
    public String OverviewOfLeasings() {
        return "watchLeasingAgreements";
    }


    @GetMapping("/makeNewLeasing")
    public String makeNewLeasing(){
        return "makeNewLeasing";
    }

    @PostMapping("/makeNewLeasing")
    public String newLeasingMade(
            @RequestParam("Pris") double monthly_price,
            @RequestParam("startdato") LocalDate start_leasing,
            @RequestParam("slutdato") LocalDate end_leasing,
            @RequestParam("navn") String customer_name,
            @RequestParam("Ubegrænset") boolean is_unlimited,
            @RequestParam("limited") boolean is_limited,
            @RequestParam("carId") int car_id,
            @RequestParam("ansat") String employee_name){

        LeasingModel leasingModel =new LeasingModel(monthly_price,start_leasing,end_leasing,customer_name,is_unlimited,is_limited,car_id,employee_name);
        leasingRepository.leasingNewContrakt(leasingModel);

        return "redirect:/watchLeasingAgreements";
    }
}
