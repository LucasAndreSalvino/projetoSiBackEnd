package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.DTO.LoginDTO;
import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginController {
    private LoginService loginService;
    public static final String KEY = "Ve7GLoDiKyX3f3XV";

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<LoginDTO> authenticate(@RequestBody Usuario user) {
        try{
            LoginDTO bodyResponse = loginService.authenticate(user);
            return new ResponseEntity<>(bodyResponse, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

}
