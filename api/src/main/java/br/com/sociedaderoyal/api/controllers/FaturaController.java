package br.com.sociedaderoyal.api.controllers;

import br.com.sociedaderoyal.api.entities.Fatura;
import br.com.sociedaderoyal.api.entities.Usuario;
import br.com.sociedaderoyal.api.services.FaturaService;
import br.com.sociedaderoyal.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*") // depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/faturas")
public class FaturaController {
    @Autowired
    private FaturaService faturaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable("id") Long id) {
        List<Fatura> faturas = faturaService.buscarPorUsuario(id);
        return new ResponseEntity<>(faturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Fatura> fatura = faturaService.buscarPorId(id);
        if(!fatura.isPresent()) {
            return new ResponseEntity<>("Fatura não encontrada", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(fatura.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/user/id")
    public ResponseEntity<?> save(@PathVariable("id") Long id, @RequestBody Fatura fatura) {
        Optional<Usuario> aux = usuarioService.buscarPorId(id);

        if(aux.isPresent()) {
            Fatura fatura1 = this.faturaService.persistir(fatura);
            return new ResponseEntity<>(fatura1, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.BAD_REQUEST);
        }
    }
}
