package com.neoflex.vacationpaycalculator.service;


import com.neoflex.vacationpaycalculator.dto.VacationPayDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayServiceImpl implements VacationPayService {
    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;
    private static final double NDFL = 0.13;


    @Override
    public VacationPayDTO getVacationPay(BigDecimal averageSalary, int NumberOfVacationDays) {

        BigDecimal salaryPerDay = averageSalary.divide(BigDecimal.valueOf(AVERAGE_DAYS_IN_MONTH), 2, RoundingMode.HALF_EVEN);

        BigDecimal vacationPayWithoutNDFL = salaryPerDay.multiply(BigDecimal.valueOf(NumberOfVacationDays));

        BigDecimal tax = vacationPayWithoutNDFL.multiply(BigDecimal.valueOf(NDFL)).setScale(0, RoundingMode.HALF_UP);

        BigDecimal vacationPay = vacationPayWithoutNDFL.subtract(tax);

        return new VacationPayDTO(vacationPay, "Сумма отпускных с вычетом НДФЛ");
    }
}


