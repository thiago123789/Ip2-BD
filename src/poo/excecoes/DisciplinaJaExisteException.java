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
public class DisciplinaJaExisteException extends Exception{
    public DisciplinaJaExisteException(){
        super("Disciplina já está cadastrada no sistema");
    }
}
