package br.com.sociedaderoyal.api.services.impl;

import br.com.sociedaderoyal.api.entities.Usuario;
import br.com.sociedaderoyal.api.repositories.UsuarioRepository;
import br.com.sociedaderoyal.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return this.usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return Optional.ofNullable(usuarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByCpf(email));
    }

    @Override
    public List<Usuario> getAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario persistir(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void apagar(Long id) {
        usuarioRepository.deleteById(id);
    }

}
