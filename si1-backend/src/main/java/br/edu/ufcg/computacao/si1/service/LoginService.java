package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.model.DTO.LoginDTO;
import br.edu.ufcg.computacao.si1.util.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    public LoginDTO authenticate(Usuario user) throws Exception{

        Usuario userAuthenticated = this.authenticUser(user);
        String token = TokenManager.getToken(userAuthenticated.getEmail());

        return new LoginDTO( token, userAuthenticated.getId() );
    }


    private Usuario authenticUser(Usuario user) throws Exception {
        Usuario userAuthenticated = userService.getByEmail(user.getEmail());

        if(user.getEmail() == null || user.getSenha() == null){
            throw new Exception("Email e Senha são obrigatórios");
        }

        if(userAuthenticated == null) {
            throw new Exception("Usuário não encontrado.");
        }

        if (!userAuthenticated.getSenha().equals(user.getSenha())) {
            throw new Exception("Usuário ou senha inválida.");
        }
        return userAuthenticated;
    }

}
