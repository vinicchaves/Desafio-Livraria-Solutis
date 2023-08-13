package br.solutis.squad7.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.solutis.squad7.livraria.entity.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l WHERE TYPE(l) = Impresso")
    List<Livro> findImpressosBy();

    @Query("SELECT l FROM Livro l WHERE TYPE(l) = Eletronico")
    List<Livro> findEletronicosBy();
}

