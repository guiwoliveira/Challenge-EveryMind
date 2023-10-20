package br.com.em.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.em.backend.model.CadastroVaga;
import br.com.em.backend.model.ModelResponse;
import br.com.em.backend.service.CadastroService;

@RestController
@CrossOrigin(origins = "*")
public class CadastroController {
    
    @Autowired
    private CadastroService cs;

    @DeleteMapping("/remover/{id_vaga}")
    public ResponseEntity<ModelResponse> remover(@PathVariable long id_vaga){
        return cs.remover(id_vaga);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody CadastroVaga cv){
        return cs.cadastrarAlterar(cv, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroVaga cv){
        return cs.cadastrarAlterar(cv, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<CadastroVaga> listar(){
        return cs.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API EveryMind funcionando!";
    }

}
