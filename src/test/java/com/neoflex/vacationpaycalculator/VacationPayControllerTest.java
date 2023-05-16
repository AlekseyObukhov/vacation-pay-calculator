package com.neoflex.vacationpaycalculator;

import com.neoflex.vacationpaycalculator.controller.VacationPayController;
import com.neoflex.vacationpaycalculator.dto.VacationPayDTO;
import com.neoflex.vacationpaycalculator.service.VacationPayService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VacationPayController.class)
class VacationPayControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private VacationPayService vacationPayService;
	@Test
	void getVacationPay() throws Exception {
		Mockito.when(vacationPayService.getVacationPay(BigDecimal.valueOf(43700), 30)).
				thenReturn(new VacationPayDTO(BigDecimal.valueOf(38927.10), "Сумма отпускных с вычетом НДФЛ"));
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/api/calculacte")
						.contentType(MediaType.APPLICATION_JSON)
						.param("averageSalary", String.valueOf(43700))
						.param("NumberOfVacationDays", String.valueOf(30))
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("vacationPay").value(BigDecimal.valueOf(38927.10)))
				.andReturn();
	}

}
