package br.com.em.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.em.backend.model.CadastroVaga;
import br.com.em.backend.model.ModelResponse;
import br.com.em.backend.repository.CadastroRepository;

@Service
public class CadastroService {
    
    @Autowired
    private CadastroRepository cr;

    @Autowired
    private ModelResponse mr;

    public Iterable<CadastroVaga> listar(){
        return cr.findAll();
    }

    // * Cadastrar ou alterar a vaga
    public ResponseEntity<?> cadastrarAlterar(CadastroVaga cv, String acao){
        
        if(cv.getTipo().equals("")){
            mr.setMensage("O tipo da vaga é obrigatório!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else if(cv.getDescricao().equals("")){
            mr.setMensage("A descrição é obrigatória!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else if(cv.getCargo().equals("")){
            mr.setMensage("O cargo é obrigatório!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else if(cv.getLocal().equals("")){
            mr.setMensage("O local é obrigatório!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else if(cv.getTurno().equals("")){
            mr.setMensage("O turno é obrigatório!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else if(cv.getSalario() == null){
            mr.setMensage("O salario é obrigatório!");
            return new ResponseEntity<ModelResponse>(mr, HttpStatus.BAD_REQUEST);
        } else {
            if(acao.equals("cadastrar")){
                return new ResponseEntity<CadastroVaga>(cr.save(cv), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<CadastroVaga>(cr.save(cv), HttpStatus.OK);
            }
        }    

    }

    public ResponseEntity<ModelResponse> remover(long id_vaga){
        
        cr.deleteById(id_vaga);
        
        mr.setMensage("A vaga foi removida!");
        return new ResponseEntity<ModelResponse>(mr, HttpStatus.OK);
    
    }

}
