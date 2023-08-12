package br.solutis.squad7.livraria.repository;

import br.solutis.squad7.livraria.Livro;
import br.solutis.squad7.livraria.livros.Impresso;
import br.solutis.squad7.livraria.livros.Eletronico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTipo(String impresso);
}
