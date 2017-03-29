package br.edu.ufcg.computacao.si1.repository.ad;

import br.edu.ufcg.computacao.si1.model.ad.Employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmploymentRepository extends CrudRepository<Employment, Long> {
  List<Employment> findAll();
}
