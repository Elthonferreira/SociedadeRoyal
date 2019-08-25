package br.com.sociedaderoyal.api.services;

import br.com.sociedaderoyal.api.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorCpf(String cpf);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> getAll();
    Usuario persistir(Usuario usuario);
    void apagar(Long id);
}
