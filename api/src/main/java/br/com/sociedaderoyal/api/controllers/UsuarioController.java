package br.com.sociedaderoyal.api.controllers;

import br.com.sociedaderoyal.api.dtos.UsuarioDto;
import br.com.sociedaderoyal.api.entities.Usuario;
import br.com.sociedaderoyal.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*") // depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Usuario> usuarios = usuarioService.getAll();
        if(usuarios.isEmpty()) {
            return new ResponseEntity<>("Sem usuários cadastrados", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        if(!usuario.isPresent()) {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(converterUsuarioDto(usuario.get()), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        Optional<Usuario> aux = usuarioService.buscarPorCpf(usuario.getCpf());

        if(!aux.isPresent()) {
            Usuario usuario1 = usuarioService.persistir(usuario);
            return new ResponseEntity<>(converterUsuarioDto(usuario1), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("CPF já cadastrado", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Usuario> aux = usuarioService.buscarPorId(id);
        if(!aux.isPresent()) {
            return new ResponseEntity<>("Usuário não existe", HttpStatus.NOT_FOUND);
        }
        else {
            usuarioService.apagar(id);
            return new ResponseEntity<>("Usuário deletado", HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/ativosdiretos")
    public ResponseEntity<?> getAtivosDiretos(@PathVariable("id") Long id) {
        Optional<Usuario> aux = usuarioService.buscarPorId(id);
        if(!aux.isPresent()) {
            return new ResponseEntity<>("Usuário não existe", HttpStatus.NOT_FOUND);
        }
        else {
            List<Usuario> ativosDiretos = aux.get().getFilhos();
            List<UsuarioDto> response = new ArrayList<>();

            ativosDiretos.forEach(ativo -> response.add(converterUsuarioDto(ativo)));

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    private UsuarioDto converterUsuarioDto(Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setCpf(usuario.getCpf());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setDataCriacao(usuario.getDataCriacao());
        usuarioDto.setPerfil(usuario.getPerfil());
        usuarioDto.setTelefone(usuario.getTelefone());

        return usuarioDto;
    }
}
