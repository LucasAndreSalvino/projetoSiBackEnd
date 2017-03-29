package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.Entity;

@Entity
public class Immobile extends Product {

    public Immobile(String title, String description, String dateCreation, String dateEnd, Usuario advertiser, Double value) {
        super(title, CategoryAd.IMOVEL, description, dateCreation, dateEnd, advertiser, value);
    }

    public Immobile() {
    }
}
