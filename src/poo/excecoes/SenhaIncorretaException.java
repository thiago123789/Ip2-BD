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
public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException(){
        super("Senha Incorrente. Tente Novamente...");
    }
}
