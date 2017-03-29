package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.Entity;

@Entity
public class Mobile extends Product {

    public Mobile(String title, String description, String dateCreation, String dateEnd, Usuario advertiser, Double value) {
        super(title, CategoryAd.MOVEL, description, dateCreation, dateEnd, advertiser, value);
    }

    public Mobile() {
    }
}
