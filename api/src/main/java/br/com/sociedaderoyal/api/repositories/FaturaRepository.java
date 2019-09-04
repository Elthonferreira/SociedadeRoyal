package br.com.sociedaderoyal.api.repositories;

import br.com.sociedaderoyal.api.entities.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    Optional<Fatura> findById(Long id);
    List<Fatura> findFaturasByCliente(Long id);
}
