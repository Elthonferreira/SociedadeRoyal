package br.backend.spring.Repositories;

import br.backend.spring.models.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
    public Fatura findByIdbusca(Long id);
}
