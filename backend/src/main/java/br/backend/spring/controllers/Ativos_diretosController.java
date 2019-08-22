package br.backend.spring.controllers;

import br.backend.spring.Services.Ativos_diretosService;
import br.backend.spring.models.Ativos_diretos;
import br.backend.spring.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/ativos_dir")
public class Ativos_diretosController {

    @Autowired
    private Ativos_diretosService ativos_diretosService;
    private ClienteController clienteController;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Ativos_diretos> ativos_diretos = ativos_diretosService.getAll();
        if(ativos_diretos.isEmpty()) {
            return new ResponseEntity<>("Sem ativos diretos cadastrados", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(ativos_diretos, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByUser(@PathVariable("usuario") String usuario) {
        Ativos_diretos ativos_diretos = ativos_diretosService.getByUser(usuario);
        if(ativos_diretos == null) {
            return new ResponseEntity<>("Ativo direto de usuario "+usuario+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(ativos_diretos, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ativos_diretos ativos_diretos) {
        Ativos_diretos aux = ativos_diretosService.getByUser(ativos_diretos.getUsuario());
       // int idCliente = ativos_diretos.getId_cliente();
       // Cliente cliente = clienteController.getById(idCliente);
       // aux.setCliente(cliente);
        if(aux == null) {
            return new ResponseEntity<>(

                    ativos_diretosService.save(ativos_diretos),
                    HttpStatus.OK
            );
        }
        else {
            return new ResponseEntity<>("Ativo direto de usuario "+ativos_diretos.getUsuario()+" já existe", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Ativos_diretos novo) {
        Ativos_diretos velho = ativos_diretosService.getByUser(novo.getUsuario());
        if(velho == null) {
            return new ResponseEntity<>("Ativo direto de usuario "+novo.getUsuario()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            novo.setUsuario(velho.getUsuario());
            return new ResponseEntity<>(
                    ativos_diretosService.update(novo),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Ativos_diretos ativos_diretos) {
        Ativos_diretos aux = ativos_diretosService.getByUser(ativos_diretos.getUsuario());
        if(aux == null) {
            return new ResponseEntity<>("Ativo direto de usuario "+ativos_diretos.getUsuario()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            ativos_diretosService.delete(aux);
            return new ResponseEntity<>("Ativo direto de usuario "+ativos_diretos.getUsuario()+" foi deletado", HttpStatus.OK);
        }
    }
}
