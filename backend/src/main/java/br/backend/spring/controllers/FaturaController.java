package br.backend.spring.controllers;

import br.backend.spring.Services.ClienteService;
import br.backend.spring.Services.FaturaService;
import br.backend.spring.models.Cliente;
import br.backend.spring.models.Fatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/faturas")
public class FaturaController {
    @Autowired
    private FaturaService faturaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Fatura> faturas = faturaService.getAll();
        if(faturas.isEmpty()) {
            return new ResponseEntity<>("Sem faturas", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(faturas, HttpStatus.OK);
        }
    }

    @GetMapping("/{id_fatura}")
    public ResponseEntity<?> getByCpf(@PathVariable("id_fatura") Long id_fatura) {
        Fatura faturas = faturaService.getById_fatura(id_fatura);
        if(faturas == null) {
            return new ResponseEntity<>("Fatura de id "+id_fatura+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(faturas, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Fatura faturas) {
        Fatura aux = faturaService.getById_fatura(faturas.getId_fatura());
        if(aux == null) {
            return new ResponseEntity<>(
                    faturaService.save(faturas),
                    HttpStatus.OK
            );
        }
        else {
            return new ResponseEntity<>("Fatura de id "+faturas.getId_fatura()+" já existe", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Fatura novo) {
        Fatura velho = faturaService.getById_fatura(novo.getId_fatura());
        if(velho == null) {
            return new ResponseEntity<>("Fatura de id "+novo.getId_fatura()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            novo.setId_fatura(velho.getId_fatura());
            return new ResponseEntity<>(
                    faturaService.update(novo),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Fatura faturas) {
        Fatura aux = faturaService.getById_fatura(faturas.getId_fatura());
        if(aux == null) {
            return new ResponseEntity<>("Fatura de id "+faturas.getId_fatura()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            faturaService.delete(aux);
            return new ResponseEntity<>("Fatura de id "+faturas.getId_fatura()+" foi deletada", HttpStatus.OK);
        }
    }
}
