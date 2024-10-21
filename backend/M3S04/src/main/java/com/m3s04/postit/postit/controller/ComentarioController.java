package com.m3s04.postit.postit.controller;

import com.m3s04.postit.postit.dto.ComentarioDTO;
import com.m3s04.postit.postit.model.Comentario;
import com.m3s04.postit.postit.service.ComentarioService;
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

@Tag(name = "Comentários", description = "Endpoints para gerenciamento de comentários")
@RestController
@RequestMapping("/sugestoes/{sugestaoId}/comentarios")
public class ComentarioController {
    private static final Logger logger = LoggerFactory.getLogger(ComentarioController.class);
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @Operation(summary = "Adicionar um novo comentário",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalhes do comentário a ser adicionado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ComentarioDTO.class),
                            examples = @ExampleObject(
                                    value = "{\"texto\": \"Este é um comentário.\"}"
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comentário adicionado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ComentarioDTO.class),
                            examples = @ExampleObject(
                                    value = "{\"id\": 1, \"sugestaoId\": 1, \"texto\": \"Este é um comentário.\", \"dataEnvio\": \"2023-10-01T12:00:00\"}"
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
    @PostMapping
    public ResponseEntity<ComentarioDTO> adicionarComentario(@PathVariable Long sugestaoId, @RequestBody ComentarioDTO comentarioDTO) {
        logger.info("Adicionando comentário para a sugestão com ID: {}", sugestaoId);
        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioDTO.getTexto());
        ComentarioDTO novoComentarioDTO = comentarioService.adicionarComentario(sugestaoId, comentario);
        logger.info("Comentário adicionado com sucesso. ID do comentário: {}", novoComentarioDTO.getId());
        return new ResponseEntity<>(novoComentarioDTO, HttpStatus.CREATED);
    }
}