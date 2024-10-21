package br.com.exemplo.aula.service;

import br.com.exemplo.aula.controllers.dto.NutricionistaRequestDTO;
import br.com.exemplo.aula.controllers.dto.NutricionistaResponseDTO;
import br.com.exemplo.aula.entities.Nutricionista;
import br.com.exemplo.aula.repositories.NutricionistaRepository;
import br.com.exemplo.aula.services.NutricionistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class NutricionistaServiceTest {

    @InjectMocks
    private NutricionistaService nutricionistaService;

    @Mock
    private NutricionistaRepository nutricionistaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveListarNutricionistas() {
        // Quando
        nutricionistaService.listarNutricionistas();

        // Então, o método findAll() do repositório deve ser chamado
        verify(nutricionistaRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarNutricionistaPorId() {
        Long id = 1L;
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setId(id);
        when(nutricionistaRepository.findById(id)).thenReturn(Optional.of(nutricionista));

        // Quando
        NutricionistaResponseDTO response = nutricionistaService.buscarNutricionista(id);

        // Então
        assertNotNull(response);
        assertEquals(id, response.getId());
        verify(nutricionistaRepository, times(1)).findById(id);
    }

    @Test
    void deveSalvarNutricionista() {
        NutricionistaRequestDTO request = new NutricionistaRequestDTO();
        request.setNome("Ana");

        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNome("Ana");

        when(nutricionistaRepository.save(any())).thenReturn(nutricionista);

        // Quando
        NutricionistaResponseDTO response = nutricionistaService.salvarNutricionista(request);

        // Então
        assertNotNull(response);
        assertEquals("Ana", response.getNome());
        verify(nutricionistaRepository, times(1)).save(any(Nutricionista.class));
    }

    @Test
    void deveRemoverNutricionista() {
        Long id = 1L;

        // Quando
        nutricionistaService.removerNutricionista(id);

        // Então
        verify(nutricionistaRepository, times(1)).deleteById(id);
    }
}
