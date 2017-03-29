package br.edu.ufcg.computacao.si1.model;


public enum UserType {

    FISICA("PESSOA_FISICA"), JURIDICA("PESSOA_JURIDICA");

    private final String description;

    UserType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
