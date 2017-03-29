package br.edu.ufcg.computacao.si1.model.ad;

public enum CategoryAd {

    MOVEL("MOVEL"), IMOVEL("IMOVEL"), EMPREGO("EMPREGO"), SERVICO("SERVICO");

    private final String description;

    CategoryAd(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
