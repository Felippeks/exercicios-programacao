package br.com.exemplo.aula.controller;

import br.com.exemplo.aula.controllers.ConsultaController;
import br.com.exemplo.aula.controllers.dto.ConsultaResponseDTO;
import br.com.exemplo.aula.services.ConsultaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsultaController.class)
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    @Test
    public void testBuscarConsultaPorId() throws Exception {
        ConsultaResponseDTO consultaResponse = new ConsultaResponseDTO(1L, null, null, "2024-09-01", "Observação");
        given(consultaService.buscarConsulta(1L)).willReturn(consultaResponse);

        mockMvc.perform(get("/consultas/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value(1L))
                .andExpect((ResultMatcher) jsonPath("$.observacoes").value("Observação"));
    }

    @Test
    public void testDeletarConsultaPorId() throws Exception {
        willDoNothing().given(consultaService).deletarConsulta(1L);

        mockMvc.perform(delete("/consultas/1"))
                .andExpect(status().isNoContent());
    }
}
