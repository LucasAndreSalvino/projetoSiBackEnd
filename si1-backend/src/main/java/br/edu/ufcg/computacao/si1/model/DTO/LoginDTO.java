package br.edu.ufcg.computacao.si1.model.DTO;

public class LoginDTO {

    private String token;
    private long userID;

    public LoginDTO(String token, long userID) {
        this.token = token;
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
