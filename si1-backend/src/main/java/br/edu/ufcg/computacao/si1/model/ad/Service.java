package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.Entity;

@Entity
public class Service extends Ad {

    private String dateScheduling;

    public Service(String title, String description, String dateCreation, String dateEnd, Usuario advertiser, String dateScheduling) {
        super(title, CategoryAd.SERVICO, description, dateCreation, dateEnd, advertiser);
        this.dateScheduling = dateScheduling;
    }

    public Service(String dateScheduling) {
        this.dateScheduling = dateScheduling;
    }

    public String getDateScheduling() {
        return dateScheduling;
    }

    public void setDateScheduling(String dateScheduling) {
        this.dateScheduling = dateScheduling;
    }
}
