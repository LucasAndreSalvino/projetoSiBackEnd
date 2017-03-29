package br.edu.ufcg.computacao.si1.repository.ad;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> findAll();
}
