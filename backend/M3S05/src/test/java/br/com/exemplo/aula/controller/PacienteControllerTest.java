package br.com.exemplo.aula.controller;

import br.com.exemplo.aula.controllers.PacienteController;
import br.com.exemplo.aula.services.PacienteService;
import br.com.exemplo.aula.controllers.dto.PacienteResponseDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PacienteController.class)
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @Test
    void deveListarPacientes() throws Exception {
        PacienteResponseDTO paciente = new PacienteResponseDTO(1L, "Maria");
        Mockito.when(pacienteService.listarPacientes()).thenReturn(Collections.singletonList(paciente));

        mockMvc.perform(get("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Maria"));
    }
}
