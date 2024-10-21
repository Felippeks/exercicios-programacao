package br.senai.lab365.Petshop.services;

import br.senai.lab365.Petshop.models.Pet;
import br.senai.lab365.Petshop.models.Tutor;
import br.senai.lab365.Petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public void cadastrar(Tutor tutor) {
        tutorRepository.adicionar(tutor);
    }

    public List<Tutor> listar() {
        return tutorRepository.listar();
    }

    public Tutor buscar(int id) {
        return tutorRepository.buscar(id);
    }

    public boolean remover(int id) {
        Tutor tutorExcluir = tutorRepository.buscar(id);
        if (tutorExcluir != null) {
            tutorRepository.remover(tutorExcluir);
            return true;
        }
        return false;
    }

    public Tutor atualizar(int id, Tutor tutorAtualizado) {
        Tutor tutorExistente = tutorRepository.buscar(id);
        if (tutorExistente != null) {
            tutorAtualizado.setId(tutorExistente.getId());
            tutorRepository.remover(tutorExistente);
            tutorRepository.adicionar(tutorAtualizado);
            return tutorAtualizado;
        }
        return null;
    }

}