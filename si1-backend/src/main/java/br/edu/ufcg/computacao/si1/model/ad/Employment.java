package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.Entity;

@Entity
public class Employment extends Ad {

    public Employment(String title, String description, String dateCreation, String dateEnd, Usuario advertiser) {
        super(title, CategoryAd.EMPREGO, description, dateCreation, dateEnd, advertiser);
    }

    public Employment() {
    }
}
