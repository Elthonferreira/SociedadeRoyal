package br.com.sociedaderoyal.api.services;

import br.com.sociedaderoyal.api.entities.Fatura;

import java.util.List;
import java.util.Optional;

public interface FaturaService {
    Optional<Fatura> buscarPorId(Long id);
    List<Fatura> buscarPorUsuario(Long id);
    List<Fatura> getAll();
    Fatura persistir(Fatura fatura);
    void apagar(Long id);
}
