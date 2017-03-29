package br.edu.ufcg.computacao.si1.repository.ad;

import br.edu.ufcg.computacao.si1.model.ad.Immobile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImmobileRepository extends CrudRepository<Immobile, Long> {
    List<Immobile> findAll();
}
