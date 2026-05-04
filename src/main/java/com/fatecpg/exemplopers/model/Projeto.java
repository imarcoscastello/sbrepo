package com.fatecpg.exemplopers.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity  // Indica que esta classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Table(name = "projetos") // Especifica o nome da tabela no banco de dados que esta entidade irá mapear.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Projeto {

    @Id // Indica que o campo "id" é a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o valor do campo "id" será gerado automaticamente
    @Column(nullable = false) // Especifica que a coluna "id" é obrigatória (não pode ser nula)
    @ToString.Include
    @EqualsAndHashCode.Include
    private long id;

    @Column(nullable = false, unique = true) // Especifica que a coluna "nome" é obrigatória e única (sem repetições)
    @ToString.Include
    private String nome;

    @Column(length = 255, nullable = false) // Especifica o tamanho máximo da coluna "descricao"
    private String descricao;

    @Column(precision = 14, scale = 2, nullable = false) // Especifica a precisão e escala da coluna "orcamento"
    private BigDecimal orcamento;
 
    @JsonBackReference
    @ManyToMany(mappedBy = "projetos")
    private Set<Funcionario> funcionarios = new HashSet<>();
}
