package br.solutis.squad7.livraria.repository;

import br.solutis.squad7.livraria.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
