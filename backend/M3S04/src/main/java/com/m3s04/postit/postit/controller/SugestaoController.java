package com.m3s04.postit.postit.controller;

import com.m3s04.postit.postit.dto.SugestaoDTO;
import com.m3s04.postit.postit.model.Sugestao;
import com.m3s04.postit.postit.service.SugestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sugestões", description = "Endpoints para gerenciamento de sugestões")
@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {
    private static final Logger logger = LoggerFactory.getLogger(SugestaoController.class);
    private final SugestaoService sugestaoService;

    public SugestaoController(SugestaoService sugestaoService) {
        this.sugestaoService = sugestaoService;
    }

    @Operation(summary = "Criar uma nova sugestão",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalhes da sugestão a ser criada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SugestaoDTO.class),
                            examples = @ExampleObject(
                                    value = "{\"titulo\": \"Nova Sugestão\", \"descricao\": \"Descrição da sugestão.\"}"
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sugestão criada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SugestaoDTO.class),
                            examples = @ExampleObject(
                                    value = "{\"id\": 1, \"titulo\": \"Nova Sugestão\", \"descricao\": \"Descrição da sugestão.\", \"dataEnvio\": \"2023-10-01T12:00:00\", \"dataAtualizacao\": \"2023-10-01T12:00:00\"}"
                            )
                    )
            )
    })
    @PostMapping
    public ResponseEntity<SugestaoDTO> criarSugestao(@RequestBody SugestaoDTO sugestaoDTO) {
        logger.info("Criando nova sugestão com título: {}", sugestaoDTO.getTitulo());
        Sugestao sugestao = new Sugestao();
        sugestao.setTitulo(sugestaoDTO.getTitulo());
        sugestao.setDescricao(sugestaoDTO.getDescricao());
        SugestaoDTO novaSugestaoDTO = sugestaoService.criarSugestao(sugestao);
        logger.info("Sugestão criada com sucesso. ID da sugestão: {}", novaSugestaoDTO.getId());
        return new ResponseEntity<>(novaSugestaoDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar todas as sugestões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sugestões listadas com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SugestaoDTO.class),
                            examples = @ExampleObject(
                                    value = "[{\"id\": 1, \"titulo\": \"Sugestão 1\", \"descricao\": \"Descrição 1\", \"dataEnvio\": \"2023-10-01T12:00:00\", \"dataAtualizacao\": \"2023-10-01T12:00:00\"}]"
                            )
                    )
            )
    })
    @GetMapping
    public ResponseEntity<List<SugestaoDTO>> listarSugestoes(@RequestParam(required = false) String titulo) {
        logger.info("Listando sugestões com título: {}", titulo);
        return ResponseEntity.ok(sugestaoService.listarSugestoes(titulo));
    }

    @Operation(summary = "Obter sugestão por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sugestão obtida com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SugestaoDTO.class),
                            examples = @ExampleObject(
                                    value = "{\"id\": 1, \"titulo\": \"Sugestão 1\", \"descricao\": \"Descrição 1\", \"dataEnvio\": \"2023-10-01T12:00:00\", \"dataAtualizacao\": \"2023-10-01T12:00:00\", \"comentarios\": []}"
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Sugestão não encontrada",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"error\": \"Sugestão não encontrada\"}"
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<SugestaoDTO> obterSugestaoPorId(@PathVariable Long id) {
        logger.info("Obtendo sugestão com ID: {}", id);
        return sugestaoService.obterSugestaoPorId(id)
                .map(sugestaoDTO -> {
                    logger.info("Sugestão encontrada. ID: {}", sugestaoDTO.getId());
                    return ResponseEntity.ok(sugestaoDTO);
                })
                .orElseGet(() -> {
                    logger.warn("Sugestão com ID: {} não encontrada", id);
                    return ResponseEntity.notFound().build();
                });
    }
}