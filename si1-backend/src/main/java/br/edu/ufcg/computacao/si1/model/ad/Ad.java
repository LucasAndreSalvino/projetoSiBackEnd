package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.Usuario;

import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Ad {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "category", nullable = false)
    private CategoryAd category;

    @Column(name = "description")
    private String description;

    @Column(name = "data_inicial" , nullable = false)
    private String dateCreation;

    @Column(name = "data_final", nullable = false)
    private String dateEnd;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario advertiser;

    public Ad(String title, CategoryAd category, String description, String dateCreation, String dateEnd, Usuario advertiser) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateEnd = dateEnd;
        this.advertiser = advertiser;
    }

    public Ad() {
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

    public String getDataCriacao() {
        return dateCreation;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dateCreation = dataCriacao;
    }

    public String getDataFinalizacao() {
        return dateEnd;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dateEnd = dataFinalizacao;
    }

    public Usuario getAnunciante() {
        advertiser.setAds(null);
        return advertiser;
    }

    public void setAnunciante(Usuario anunciante) {
        this.advertiser = anunciante;
    }

}
