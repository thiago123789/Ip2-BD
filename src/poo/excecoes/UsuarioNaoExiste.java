/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.excecoes;

/**
 *
 * @author Thiago Gomes
 */
public class UsuarioNaoExiste extends Exception{
    public UsuarioNaoExiste(){
        super("Usuário não encontrado, verifique o login digitado.");
    }
}
