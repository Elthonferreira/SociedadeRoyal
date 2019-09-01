package br.backend.spring.Services;

import br.backend.spring.Repositories.ClienteRepository;
import br.backend.spring.Repositories.FaturaRepository;
import br.backend.spring.models.Cliente;
import br.backend.spring.models.Fatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    @Autowired
    private FaturaRepository faturaRepository;

    public Fatura save(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> getAll() {
        return faturaRepository.findAll();
    }

    public Fatura getById_fatura(Long id_fatura) {return faturaRepository.findByIdbusca(id_fatura);}

    public Fatura update(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public void delete(Fatura fatura) {
        faturaRepository.delete(fatura);
    }
}
