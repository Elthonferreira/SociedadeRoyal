package br.backend.spring.Repositories;

import br.backend.spring.models.Ativos_diretos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ativos_diretosRepository extends JpaRepository<Ativos_diretos, Long> {
    public Ativos_diretos findByUsuario(String usuario);
}
