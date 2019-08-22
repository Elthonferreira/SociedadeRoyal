package br.backend.spring.controllers;

import br.backend.spring.Services.ClienteService;
import br.backend.spring.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        if(clientes.isEmpty()) {
            return new ResponseEntity<>("Sem clientes cadastrados", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getByCpf(@PathVariable("cpf") String cpf) {
        Cliente cliente = clienteService.getByCpf(cpf);
        if(cliente == null) {
            return new ResponseEntity<>("Cliente de cpf "+cpf+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {
        Cliente aux = clienteService.getByCpf(cliente.getCpf());
        if(aux == null) {
            return new ResponseEntity<>(
                    clienteService.save(cliente),
                    HttpStatus.OK
            );
        }
        else {
            return new ResponseEntity<>("Cliente de cpf "+cliente.getCpf()+" já existe", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cliente novo) {
        Cliente velho = clienteService.getByCpf(novo.getCpf());
        if(velho == null) {
            return new ResponseEntity<>("Cliente de cpf "+novo.getCpf()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            novo.setId_cliente(velho.getId_cliente());
            return new ResponseEntity<>(
                    clienteService.update(novo),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Cliente cliente) {
        Cliente aux = clienteService.getByCpf(cliente.getCpf());
        if(aux == null) {
            return new ResponseEntity<>("Cliente de cpf "+cliente.getCpf()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            clienteService.delete(aux);
            return new ResponseEntity<>("Cliente de cpf "+cliente.getCpf()+" foi deletado", HttpStatus.OK);
        }
    }
}
