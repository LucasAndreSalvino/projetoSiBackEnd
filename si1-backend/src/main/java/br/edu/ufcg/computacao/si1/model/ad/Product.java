package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Product extends Ad {

    private Double value;

    public Product(String title, CategoryAd category, String description, String dateCreation, String dateEnd, Usuario advertiser, Double value) {
        super(title, category, description, dateCreation, dateEnd, advertiser);
        this.value = value;
    }

    public Product() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
