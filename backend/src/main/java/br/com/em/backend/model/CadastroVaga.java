package br.com.em.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cadastro_vaga")
@Getter
@Setter
public class CadastroVaga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vaga;
    private String tipo;
    private String descricao;
    private String cargo;
    private String local;
    private String turno;
    private Double salario;

}
