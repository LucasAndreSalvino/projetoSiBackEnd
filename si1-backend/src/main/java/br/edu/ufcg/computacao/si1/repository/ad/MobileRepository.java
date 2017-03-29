package br.edu.ufcg.computacao.si1.repository.ad;

import br.edu.ufcg.computacao.si1.model.ad.Mobile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MobileRepository extends CrudRepository<Mobile, Long> {
    List<Mobile> findAll();
}
