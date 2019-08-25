package br.com.sociedaderoyal.api.repositories;

import br.com.sociedaderoyal.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf);

    Usuario findByEmail(String email);

    Optional<Usuario> findById(Long id);

    Usuario findByCpfOrEmail(String cpf, String email);
}
