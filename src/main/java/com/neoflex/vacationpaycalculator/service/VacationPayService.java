package com.neoflex.vacationpaycalculator.service;

import com.neoflex.vacationpaycalculator.dto.VacationPayDTO;
import java.math.BigDecimal;

public interface VacationPayService {
    VacationPayDTO getVacationPay(BigDecimal averageSalary, int NumberOfVacationDays);
}
