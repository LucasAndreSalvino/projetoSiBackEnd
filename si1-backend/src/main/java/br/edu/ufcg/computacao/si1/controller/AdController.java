package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.exception.AdException;
import br.edu.ufcg.computacao.si1.model.DTO.AdDTO;
import br.edu.ufcg.computacao.si1.model.DTO.BuyDTO;
import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.service.AdService;
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
public class AdController {
    private AdService adService;
    private UserService userService;

    @Autowired
    public AdController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @RequestMapping(value = "/ad", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AdDTO> create(@RequestBody AdDTO ad) {
        ResponseEntity<AdDTO> response;
        try{
            adService.create(ad);
            response = new ResponseEntity<>(ad, HttpStatus.OK);
        } catch (DataIntegrityViolationException e){
            response = new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (AdException e){
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public ResponseEntity<List<Ad>> getAll() {
        List<Ad> adverts = adService.getAll();

        return new ResponseEntity<>(adverts, HttpStatus.OK);
    }

    @RequestMapping(value = "/ad/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ad> getById(@PathVariable("id") Long id) {
       Ad ad = adService.getById(id);
       return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @RequestMapping(value = "/ad", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Ad> update(@RequestBody AdDTO ad) {
        ResponseEntity<Ad> bodyResponse;
        try{
            boolean success = adService.update(ad);
            HttpStatus status;

            if(success){
                status = HttpStatus.OK;
            }else{
               status = HttpStatus.BAD_REQUEST;
            }
            bodyResponse = new ResponseEntity<>(status);
        }catch (AdException a){
            bodyResponse = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return bodyResponse;
    }

    @RequestMapping(value = "/ad/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> removeById(@PathVariable("id") Long id) {
        boolean success = adService.remove(id);
        HttpStatus status;

        if(success){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(status);
    }

    @RequestMapping(value = "/ad", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> removeAll() {
        adService.removeAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/ad/buy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> toBuy(@RequestBody BuyDTO buy){

        adService.toSell(buy.getAd());
        userService.toBuy(buy.getBuyer(), buy.getAd().getValue());
        userService.toSell(buy.getAd().getAdvertiser(), buy.getAd().getTitle(), buy.getAd().getValue());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
