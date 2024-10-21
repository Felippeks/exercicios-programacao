package br.com.exemplo.aula.integration;

import br.com.exemplo.aula.entities.Consulta;
import br.com.exemplo.aula.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ConsultaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Test
    public void testSalvarConsulta() throws Exception {
        String consultaJson = "{ \"idNutricionista\": 1, \"idPaciente\": 1, \"data\": \"2024-09-01\", \"observacoes\": \"Primeira consulta\" }";

        mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.valueOf(consultaJson)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.observacoes").value("Primeira consulta"));
    }

    @Test
    public void testListarConsultas() throws Exception {
        Consulta consulta = new Consulta();
        consulta.setData(LocalDate.parse("2024-09-01"));
        consulta.setObservacoes("Primeira consulta");
        consultaRepository.save(consulta);

        mockMvc.perform(get("/consultas"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].observacoes").value("Primeira consulta"));
    }
}
