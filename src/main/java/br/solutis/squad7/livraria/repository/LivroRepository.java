package br.solutis.squad7.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.solutis.squad7.livraria.entity.Livro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findImpressosBy();
    List<Livro> findEletronicosBy();
}

