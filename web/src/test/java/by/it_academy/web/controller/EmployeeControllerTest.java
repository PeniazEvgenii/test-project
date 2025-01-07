package by.it_academy.web.controller;

import by.it_academy.service.service.api.IEmployeeService;
import by.it_academy.service.service.dto.EmployeeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
@RequiredArgsConstructor
class EmployeeControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockitoBean
    private final IEmployeeService employeeService;

    @Test
    void create() throws Exception {

        EmployeeDto employeeDto = EmployeeDto.builder()
                .email("test@test.com")
                .firstname("Test")
                .lastname("Test")
                .patronymic("Test")
                .position("test")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));
    }
}