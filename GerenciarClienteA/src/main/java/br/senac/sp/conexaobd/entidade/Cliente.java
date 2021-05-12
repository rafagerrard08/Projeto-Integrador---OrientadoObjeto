/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.entidade;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cliente {
    
    private String nome;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private String sexo;
    private String telefone;
    private String cpf;
    private String cnpj;
    private String tipo;
    private String status;
    private int idBanco;
    
    public Cliente( String nome, String endereco, String email, Date dataNascimento, String sexo, String telefone, String cpf, String cnpj, String tipo, String status ) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.status = status;
    }
    
    public boolean validarCPF() {
        return true;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Nome: %s <br/> Endereco: %s <br/> Email: %s <br/> Data Nascimento: %s <br/> Sexo: %s <br/> Telefone: %s <br/> Cpf: %s <br/> Cnpj: %s <br/> Tipo: %s <br/> Status: %s", nome, endereco, email, df.format( dataNascimento ), sexo, telefone, cpf, cnpj, tipo, status );
    }
    
    
    
}
