package com.m3s04.postit.postit.service;

import com.m3s04.postit.postit.dto.ComentarioDTO;
import com.m3s04.postit.postit.model.Comentario;
import com.m3s04.postit.postit.model.Sugestao;
import com.m3s04.postit.postit.repository.ComentarioRepository;
import com.m3s04.postit.postit.repository.SugestaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    private static final Logger logger = LoggerFactory.getLogger(ComentarioService.class);
    private final ComentarioRepository comentarioRepository;
    private final SugestaoRepository sugestaoRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, SugestaoRepository sugestaoRepository) {
        this.comentarioRepository = comentarioRepository;
        this.sugestaoRepository = sugestaoRepository;
    }

    public ComentarioDTO adicionarComentario(Long sugestaoId, Comentario comentario) {
        logger.info("Adicionando comentário para a sugestão com ID: {}", sugestaoId);
        Sugestao sugestao = sugestaoRepository.findById(sugestaoId)
                .orElseThrow(() -> {
                    logger.error("Sugestão com ID: {} não encontrada", sugestaoId);
                    return new EntityNotFoundException("Sugestão não encontrada");
                });

        comentario.setSugestao(sugestao);
        sugestao.onUpdate();
        sugestaoRepository.save(sugestao);

        Comentario novoComentario = comentarioRepository.save(comentario);
        logger.info("Comentário adicionado com sucesso. ID do comentário: {}", novoComentario.getId());

        return new ComentarioDTO(novoComentario.getId(), sugestao.getId(), novoComentario.getTexto(),
                novoComentario.getDataEnvio());
    }
}