package br.com.futurodev.agenda.repository;

import br.com.futurodev.agenda.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
    @Query(value = "select c from ContatoModel  c where c.nome like %?1% ")
    ArrayList<ContatoModel> getContatoModelByName(String nome);

}
