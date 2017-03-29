package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    List<Usuario> findAll();

    Usuario findByEmail(String email);
}
