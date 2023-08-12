package br.solutis.squad7.livraria.LivroDAO;

import br.solutis.squad7.livraria.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LivroDAO {
    private EntityManager entityManager;

     public void LivroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrarLivro(Livro livro) {
        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
    }

    public void removerLivro(Livro livro) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(livro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}
