package br.edu.ufcg.computacao.si1.repository.ad;

import br.edu.ufcg.computacao.si1.model.ad.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service, Long> {
    List<Service> findAll();
}
