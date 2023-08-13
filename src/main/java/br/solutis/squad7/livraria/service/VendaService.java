package br.solutis.squad7.livraria.service;

import br.solutis.squad7.livraria.entity.Venda;
import br.solutis.squad7.livraria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda buscarVendaPorId(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}
