package by.it_academy.web.controller;

import by.it_academy.service.service.api.IProjectService;
import by.it_academy.service.service.dto.ProjectDto;
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


@RequiredArgsConstructor
@AutoConfigureMockMvc
@SpringBootTest
class ProjectControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockitoBean
    private final IProjectService projectService;

    @Test
    void create() throws Exception {
        ProjectDto projectDto = new ProjectDto("Test", "test controller");

        mockMvc.perform(MockMvcRequestBuilders.post("/projects")
                .content(objectMapper.writeValueAsString(projectDto)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));
    }

}