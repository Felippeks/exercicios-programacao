package br.com.exemplo.aula.service;

import br.com.exemplo.aula.controllers.dto.PacienteRequestDTO;
import br.com.exemplo.aula.controllers.dto.PacienteResponseDTO;
import br.com.exemplo.aula.entities.Paciente;
import br.com.exemplo.aula.repositories.PacienteRepository;
import br.com.exemplo.aula.services.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveListarTodosOsPacientes() {
        // Quando
        pacienteService.listarPacientes();

        // Então, o método findAll() do repositório deve ser chamado
        verify(pacienteRepository, times(1)).findAll();
    }

    @Test
    void deveBuscarPacientePorId() {
        Long id = 1L;
        Paciente paciente = new Paciente();
        paciente.setId(id);
        when(pacienteRepository.findById(id)).thenReturn(Optional.of(paciente));

        // Quando
        PacienteResponseDTO response = pacienteService.buscarPaciente(id);

        // Então
        assertNotNull(response);
        assertEquals(id, response.getId());
        verify(pacienteRepository, times(1)).findById(id);
    }

    @Test
    void deveSalvarPaciente() {
        PacienteRequestDTO request = new PacienteRequestDTO();
        request.setNome("João");

        Paciente paciente = new Paciente();
        paciente.setNome("João");

        when(pacienteRepository.save(any())).thenReturn(paciente);

        // Quando
        PacienteResponseDTO response = pacienteService.salvarPaciente(request);

        // Então
        assertNotNull(response);
        assertEquals("João", response.getNome());
        verify(pacienteRepository, times(1)).save(any(Paciente.class));
    }

    @Test
    void deveAtualizarPaciente() {
        Long id = 1L;
        Paciente paciente = new Paciente();
        paciente.setId(id);
        when(pacienteRepository.findById(id)).thenReturn(Optional.of(paciente));

        PacienteRequestDTO request = new PacienteRequestDTO();
        request.setNome("Maria");

        // Quando
        PacienteResponseDTO response = pacienteService.atualizarPaciente(id, request);

        // Então
        assertNotNull(response);
        assertEquals("Maria", response.getNome());
        verify(pacienteRepository, times(1)).save(paciente);
    }

    @Test
    void deveRemoverPaciente() {
        Long id = 1L;

        // Quando
        pacienteService.removerPaciente(id);

        // Então
        verify(pacienteRepository, times(1)).deleteById(id);
    }
}
