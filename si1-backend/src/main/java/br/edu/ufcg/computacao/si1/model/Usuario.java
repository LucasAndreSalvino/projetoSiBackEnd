package br.edu.ufcg.computacao.si1.model;

import br.edu.ufcg.computacao.si1.model.ad.Ad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USUARIO_ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String senha;

    @Column
    private Double balanceDebtor;

    @Column
    private Double balanceCreditor;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(targetEntity = Ad.class, mappedBy = "advertiser", cascade = CascadeType.ALL)
    private List<Ad> ads;

    @ElementCollection
    private List<String> notifications;

    public Usuario() {
        this.balanceDebtor = new Double(0);
        this.balanceCreditor = new Double(0);
        this.notifications = new ArrayList<>();
    }

    public Usuario(String name, String email, String senha, UserType userType) {

        this.name = name;
        this.email = email;
        this.senha = senha;
        this.userType = userType;
        this.balanceDebtor = new Double(0);
        this.balanceCreditor = new Double(0);
        this.notifications = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getBalanceDebtor() {
        return balanceDebtor;
    }

    public void setBalanceDebtor(Double balanceDebtor) {
        this.balanceDebtor = balanceDebtor;
    }

    public Double getBalanceCreditor() {
        return balanceCreditor;
    }

    public void setBalanceCreditor(Double balanceCreditor) {
        this.balanceCreditor = balanceCreditor;
    }

    public UserType getTipoUsuario() {
        return userType;
    }

    public void setTipoUsuario(UserType userType) {
        this.userType = userType;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }


    public void toSell(Double value, String titleAd) {
        this.creditBalance(value);

        String mensagemNotificacao = String.format("O anúncios: %s foi vendido!", titleAd);
        this.notifyForsale(mensagemNotificacao);
    }

    public void toBuy(double value) {
        this.debitBalance(value);
    }


    private void debitBalance(Double value) {
        this.balanceDebtor += value;
    }

    private void creditBalance(Double value){
        this.balanceCreditor += value;
    }

    private void notifyForsale(String message) {
        this.notifications.add(message);
    }
}
