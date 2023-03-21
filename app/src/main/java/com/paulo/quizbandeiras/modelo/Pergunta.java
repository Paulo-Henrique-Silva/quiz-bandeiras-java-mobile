package com.paulo.quizbandeiras.modelo;

import com.paulo.quizbandeiras.R;

public class Pergunta {

    private int idImagemBandeira;

    private String alternativa1Texto;

    private String alternativa2Texto;

    private String alternativa3Texto;

    private String alternativa4Texto;

    private int idAlternativaCorreta;

    public Pergunta(int idImagemBandeira, String alternativa1Texto, String alternativa2Texto, String alternativa3Texto, String alternativa4Texto, int idAlternativaCorreta) {
        this.idImagemBandeira = idImagemBandeira;
        this.alternativa1Texto = alternativa1Texto;
        this.alternativa2Texto = alternativa2Texto;
        this.alternativa3Texto = alternativa3Texto;
        this.alternativa4Texto = alternativa4Texto;
        this.idAlternativaCorreta = idAlternativaCorreta;
    }

    public int getIdImagemBandeira() {
        return idImagemBandeira;
    }

    public void setIdImagemBandeira(int idImagemBandeira) {
        this.idImagemBandeira = idImagemBandeira;
    }

    public int getIdAlternativaCorreta() {
        return idAlternativaCorreta;
    }

    public void setIdAlternativaCorreta(int idAlternativaCorreta) {
        this.idAlternativaCorreta = idAlternativaCorreta;
    }

    public String getAlternativa1Texto() {
        return alternativa1Texto;
    }

    public void setAlternativa1Texto(String alternativa1Texto) {
        this.alternativa1Texto = alternativa1Texto;
    }

    public String getAlternativa2Texto() {
        return alternativa2Texto;
    }

    public void setAlternativa2Texto(String alternativa2Texto) {
        this.alternativa2Texto = alternativa2Texto;
    }

    public String getAlternativa3Texto() {
        return alternativa3Texto;
    }

    public void setAlternativa3Texto(String alternativa3Texto) {
        this.alternativa3Texto = alternativa3Texto;
    }

    public String getAlternativa4Texto() {
        return alternativa4Texto;
    }

    public void setAlternativa4Texto(String alternativa4Texto) {
        this.alternativa4Texto = alternativa4Texto;
    }

}
