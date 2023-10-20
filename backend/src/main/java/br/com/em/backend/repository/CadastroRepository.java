package br.com.em.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.em.backend.model.CadastroVaga;

@Repository
public interface CadastroRepository extends CrudRepository<CadastroVaga, Long>{
    
}
