package br.backend.spring.Services;

import br.backend.spring.Repositories.Ativos_diretosRepository;
import br.backend.spring.models.Ativos_diretos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ativos_diretosService {
    @Autowired
    private Ativos_diretosRepository ativos_diretosRepository;

    public Ativos_diretos save(Ativos_diretos ativos_diretos){ return ativos_diretosRepository.save(ativos_diretos);}

    public List<Ativos_diretos> getAll(){ return ativos_diretosRepository.findAll();}

    public Ativos_diretos getByUser (String usuario) { return ativos_diretosRepository.findByUsuario(usuario);}

    public Ativos_diretos update (Ativos_diretos ativos_diretos) { return ativos_diretosRepository.save(ativos_diretos);}

    public void delete (Ativos_diretos ativos_diretos) { ativos_diretosRepository.delete(ativos_diretos);}
}


