package com.m3s04.postit.postit.service;

import com.m3s04.postit.postit.dto.SugestaoDTO;
import com.m3s04.postit.postit.dto.ComentarioDTO;
import com.m3s04.postit.postit.model.Sugestao;
import com.m3s04.postit.postit.model.Comentario;
import com.m3s04.postit.postit.repository.SugestaoRepository;
import com.m3s04.postit.postit.repository.ComentarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SugestaoService {
    private static final Logger logger = LoggerFactory.getLogger(SugestaoService.class);
    private final SugestaoRepository sugestaoRepository;
    private final ComentarioRepository comentarioRepository;

    public SugestaoService(SugestaoRepository sugestaoRepository, ComentarioRepository comentarioRepository) {
        this.sugestaoRepository = sugestaoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    public List<SugestaoDTO> listarSugestoes(String titulo) {
        logger.info("Listando sugestões com título: {}", titulo);
        List<Sugestao> sugestoes;
        if (titulo == null || titulo.isEmpty()) {
            sugestoes = sugestaoRepository.findAll(Sort.by(Sort.Direction.DESC, "dataAtualizacao"));
        } else {
            sugestoes = sugestaoRepository.findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(titulo);
        }

        return sugestoes.stream()
                .map(sugestao -> new SugestaoDTO(sugestao.getId(), sugestao.getTitulo(), sugestao.getDescricao(),
                        sugestao.getDataEnvio(), sugestao.getDataAtualizacao()))
                .collect(Collectors.toList());
    }

    public SugestaoDTO criarSugestao(Sugestao sugestao) {
        logger.info("Criando nova sugestão com título: {}", sugestao.getTitulo());
        Sugestao novaSugestao = sugestaoRepository.save(sugestao);
        logger.info("Sugestão criada com sucesso. ID da sugestão: {}", novaSugestao.getId());
        return new SugestaoDTO(novaSugestao.getId(), novaSugestao.getTitulo(), novaSugestao.getDescricao(),
                novaSugestao.getDataEnvio(), novaSugestao.getDataAtualizacao());
    }

    public Optional<SugestaoDTO> obterSugestaoPorId(Long id) {
        logger.info("Obtendo sugestão com ID: {}", id);
        return sugestaoRepository.findById(id)
                .map(sugestao -> {
                    List<ComentarioDTO> comentarios = comentarioRepository.findBySugestaoOrderByDataEnvioDesc(sugestao)
                            .stream()
                            .map(comentario -> new ComentarioDTO(comentario.getId(), sugestao.getId(), comentario.getTexto(), comentario.getDataEnvio()))
                            .collect(Collectors.toList());
                    SugestaoDTO sugestaoDTO = new SugestaoDTO(sugestao.getId(), sugestao.getTitulo(), sugestao.getDescricao(),
                            sugestao.getDataEnvio(), sugestao.getDataAtualizacao());
                    sugestaoDTO.setComentarios(comentarios);
                    logger.info("Sugestão encontrada. ID: {}", sugestaoDTO.getId());
                    return sugestaoDTO;
                });
    }
}