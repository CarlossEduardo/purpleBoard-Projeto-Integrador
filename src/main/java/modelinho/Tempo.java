/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelinho;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Tempo {
    int idTempo;
    Date datavenda;
    int dia;
    int mes;
    int ano;
    int bimestre;
    int trimestre;
    int semestre;

    public Tempo() {
    }

    public Tempo(int idTempo, Date datavenda, int dia, int mes, int ano, int bimestre, int trimestre, int semestre) {
        this.idTempo = idTempo;
        this.datavenda = datavenda;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.bimestre = bimestre;
        this.trimestre = trimestre;
        this.semestre = semestre;
    }

    public int getIdTempo() {
        return idTempo;
    }

    public void setIdTempo(int idTempo) {
        this.idTempo = idTempo;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    
}
