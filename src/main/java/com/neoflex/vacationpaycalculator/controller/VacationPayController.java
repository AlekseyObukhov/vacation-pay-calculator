package com.neoflex.vacationpaycalculator.controller;

import com.neoflex.vacationpaycalculator.dto.VacationPayDTO;
import com.neoflex.vacationpaycalculator.service.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class VacationPayController {

    @Autowired
    private VacationPayService vacationPayService;

    @GetMapping("/calculacte")
    public VacationPayDTO getVacationPay(@RequestParam("averageSalary") BigDecimal averageSalary,
                                         @RequestParam("NumberOfVacationDays") int numberOfVacationDays) {
        return vacationPayService.getVacationPay(averageSalary, numberOfVacationDays);
    }

}
