package br.edu.ufcg.computacao.si1.model.DTO;

import br.edu.ufcg.computacao.si1.model.Usuario;

public class BuyDTO {
    private AdDTO ad;
    protected Usuario buyer;

    public BuyDTO(AdDTO ad, Usuario comprador) {
        this.ad = ad;
        this.buyer = comprador;
    }

    public AdDTO getAd() {
        return ad;
    }

    public void setAd(AdDTO ad) {
        this.ad = ad;
    }

    public Usuario getBuyer() {
        return buyer;
    }

    public void setBuyer(Usuario buyer) {
        this.buyer = buyer;
    }
}
