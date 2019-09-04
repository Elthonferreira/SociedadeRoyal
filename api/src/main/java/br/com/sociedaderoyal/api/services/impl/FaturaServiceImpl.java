package br.com.sociedaderoyal.api.services.impl;

import br.com.sociedaderoyal.api.entities.Fatura;
import br.com.sociedaderoyal.api.repositories.FaturaRepository;
import br.com.sociedaderoyal.api.services.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaServiceImpl  implements FaturaService {

    @Autowired
    private FaturaRepository faturaRepository;

    @Override
    public Optional<Fatura> buscarPorId(Long id) {
        return this.faturaRepository.findById(id);
    }

    @Override
    public List<Fatura> buscarPorUsuario(Long id) {
        return this.faturaRepository.findFaturasByClienteId(id);
    }

    @Override
    public List<Fatura> getAll() {
        return this.faturaRepository.findAll();
    }

    @Override
    public Fatura persistir(Fatura fatura) {
        return this.faturaRepository.save(fatura);
    }

    @Override
    public void apagar(Long id) {
        this.faturaRepository.deleteById(id);
    }
}
