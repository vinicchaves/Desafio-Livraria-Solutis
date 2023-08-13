package br.solutis.squad7.livraria.repository;

import br.solutis.squad7.livraria.entity.Eletronico;
import br.solutis.squad7.livraria.entity.Impresso;
import org.springframework.data.jpa.repository.JpaRepository;
import br.solutis.squad7.livraria.entity.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findImpressosBy();

    List<Livro> findEletronicosBy();
}

