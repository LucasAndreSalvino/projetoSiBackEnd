package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
        ResponseEntity<Usuario> bodyResponse;
        try{
            userService.createUser(user);
            bodyResponse = new ResponseEntity<>(user, HttpStatus.OK);
        }catch (DataIntegrityViolationException e){
            bodyResponse = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return bodyResponse;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Usuario> update(@RequestBody Usuario user) {
        boolean success = userService.update(user);
        HttpStatus status;

        if(success){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(status);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> removeById(@PathVariable("id") long id) {
        boolean success = userService.remove(id);
        HttpStatus status;

        if(success){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(status);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> removeAll() {
        userService.removeAll();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
