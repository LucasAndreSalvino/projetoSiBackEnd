package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.AdException;
import br.edu.ufcg.computacao.si1.model.DTO.AdDTO;
import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.repository.ad.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private AdRepository adRepository;
    private AdFactory adFactory;

    @Autowired
    public AdService(AdRepository adRepository, AdFactory adFactory) {
        this.adRepository = adRepository;
        this.adFactory = adFactory;
    }

    public void create(AdDTO ad) throws AdException {
        adFactory.saveAd(ad);
    }
    
    public List<Ad> getAll() {
        return adRepository.findAll();
    }


    public Ad getById(long id) {
        return adRepository.findOne(id);
    }


    public boolean update(AdDTO ad) throws AdException {
        if (adRepository.exists(ad.getId())) {
            adFactory.updateAd(ad);
            return true;
        }
        return false;
    }

    public boolean remove(Long id) {
        if (adRepository.exists(id)) {
            adRepository.delete(id);
            return true;
        }
        return false;
    }


    public void removeAll() { adRepository.deleteAll(); }

    public void toSell(AdDTO ad){
        this.remove(ad.getId());
    }

}
