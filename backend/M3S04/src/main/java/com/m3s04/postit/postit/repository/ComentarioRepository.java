package com.m3s04.postit.postit.repository;

import com.m3s04.postit.postit.model.Comentario;
import com.m3s04.postit.postit.model.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findBySugestaoOrderByDataEnvioDesc(Sugestao sugestao);
}

