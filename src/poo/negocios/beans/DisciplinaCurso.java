/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.negocios.beans;

/**
 *
 * @author Thiago Gomes
 */
public class DisciplinaCurso {
    private String codigoDisciplina;
    private int codidgoCurso;

    public DisciplinaCurso(String codigoDisciplina, int codidgoCurso) {
        this.setCodigoDisciplina(codigoDisciplina);
        this.setCodidgoCurso(codidgoCurso);
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodidgoCurso() {
        return codidgoCurso;
    }

    public void setCodidgoCurso(int codidgoCurso) {
        this.codidgoCurso = codidgoCurso;
    }
    
    
    
}
