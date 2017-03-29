package br.edu.ufcg.computacao.si1.model.DTO;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.model.ad.CategoryAd;

public class AdDTO {

    private Long id;
    private String title;
    private CategoryAd category;
    private String description;
    private String dateCreation;
    private String dateEnd;
    private Double value;
    private String dateScheduling;
    private Usuario advertiser;

    public AdDTO(Long id, String title, CategoryAd category, String description, String dateCreation, String dateEnd, Double value, String dateScheduling, Usuario advertiser) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateEnd = dateEnd;
        this.value = value;
        this.dateScheduling = dateScheduling;
    }

    public AdDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryAd getCategory() {
        return category;
    }

    public void setCategory(CategoryAd category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDateScheduling() {
        return dateScheduling;
    }

    public void setDateScheduling(String dateScheduling) {
        this.dateScheduling = dateScheduling;
    }

    public Usuario getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Usuario advertiser) {
        this.advertiser = advertiser;
    }
}
