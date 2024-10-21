package br.com.exemplo.aula.integration;

import br.com.exemplo.aula.controllers.dto.NutricionistaRequestDTO;
import br.com.exemplo.aula.controllers.dto.NutricionistaResponseDTO;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.repositories.NutricionistaRepository;
import br.com.exemplo.aula.services.NutricionistaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NutricionistaServiceIntegrationTest {

    @Autowired
    private NutricionistaService nutricionistaService;

    @MockBean
    private NutricionistaRepository nutricionistaRepository;

    @Test
    void deveListarNutricionistas() {
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNome("Ana");
        when(nutricionistaRepository.findAll()).thenReturn(Collections.singletonList(nutricionista));

        // Quando
        List<NutricionistaResponseDTO> nutricionistas = nutricionistaService.listarNutricionistas();

        // Então
        assertFalse(nutricionistas.isEmpty());
        verify(nutricionistaRepository, times(1)).findAll();
    }

    @Test
    void deveSalvarNutricionista() {
        NutricionistaRequestDTO request = new NutricionistaRequestDTO();
        request.setNome("Carlos");

        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNome("Carlos");

        when(nutricionistaRepository.save(any())).thenReturn(nutricionista);

        // Quando
        NutricionistaResponseDTO response = nutricionistaService.salvarNutricionista(request);

        // Então
        assertNotNull(response);
        assertEquals("Carlos", response.getNome());
        verify(nutricionistaRepository, times(1)).save(any(Nutricionista.class));
    }
}
