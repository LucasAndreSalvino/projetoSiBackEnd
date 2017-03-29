package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario createUser(Usuario user) {
        return usuarioRepository.save(user);
    }


    public Usuario getUserById(Long id) {
        return usuarioRepository.findOne(id);
    }


    public Usuario getByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }


    public boolean update(Usuario user) {
        if (usuarioRepository.exists(user.getId())) {
            usuarioRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean remove(Long id) {
        if (usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
            return true;
        }
        return false;
    }

    public void removeAll() {
        usuarioRepository.deleteAll();
    }



    public void toBuy(Usuario buyer, Double value) {
        Usuario user = this.getUserById(buyer.getId());
        user.toBuy(value);
        this.update(user);
    }

    public void toSell(Usuario buyer, String titleAd, Double value) {
        Usuario user = this.getUserById((buyer.getId()));
        user.toSell(value, titleAd);
        this.update(user);
    }


}
