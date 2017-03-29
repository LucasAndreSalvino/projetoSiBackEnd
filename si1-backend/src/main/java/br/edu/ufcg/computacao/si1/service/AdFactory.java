package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.InvalidAdException;
import br.edu.ufcg.computacao.si1.model.ad.*;
import br.edu.ufcg.computacao.si1.model.DTO.AdDTO;
import br.edu.ufcg.computacao.si1.model.ad.Service;
import br.edu.ufcg.computacao.si1.repository.ad.*;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class AdFactory {
    private MobileRepository mobileRepository;
    private ImmobileRepository immobileRepository;
    private EmploymentRepository employmentRepository;
    private ServiceRepository serviceRepository;

    @Autowired
    public AdFactory(ServiceRepository serviceRepository, ImmobileRepository immobileRepository, EmploymentRepository employmentRepository, MobileRepository mobileRepository) {
        this.serviceRepository = serviceRepository;
        this.immobileRepository = immobileRepository;
        this.employmentRepository = employmentRepository;
        this.mobileRepository = mobileRepository;
    }

    public void saveAd(AdDTO AdDTO) throws InvalidAdException {

        CategoryAd category = AdDTO.getCategory();

        switch (category) {
            case MOVEL:
                mobileRepository.save(createMobile(AdDTO));
                break;
            case IMOVEL:
                immobileRepository.save(createImmobile(AdDTO));
                break;
            case EMPREGO:
                employmentRepository.save(createEmployment(AdDTO));
                break;
            case SERVICO:
                serviceRepository.save(createService(AdDTO));
                break;
            default:
                throw new InvalidAdException("Tipo de anúncio inválido.");
        }
    }

    public void updateAd(AdDTO AdDTO) throws InvalidAdException {
        CategoryAd category = AdDTO.getCategory();

        switch (category) {
            case MOVEL:
                mobileRepository.save(createMobile(AdDTO));
                break;

            case IMOVEL:
                Immobile immobile = createImmobile(AdDTO);
                immobile.setId(AdDTO.getId());
                immobileRepository.save(immobile);
                break;
            case EMPREGO:
                Employment employment = createEmployment(AdDTO);
                employment.setId(AdDTO.getId());
                employmentRepository.save(employment);
                break;
            case SERVICO:
                Service service = createService(AdDTO);
                service.setId(AdDTO.getId());
                serviceRepository.save(service);
                break;
            default:
                throw new InvalidAdException("Tipo de anúncio inválido.");
        }
    }

    private Mobile createMobile(AdDTO AdDTO){
        return new Mobile(AdDTO.getTitle(),
                AdDTO.getDescription(),
                AdDTO.getDateCreation(),
                AdDTO.getDateEnd(),
                AdDTO.getAdvertiser(),
                AdDTO.getValue());
    }

    private Immobile createImmobile(AdDTO AdDTO){
        return new Immobile(AdDTO.getTitle(),
                AdDTO.getDescription(),
                AdDTO.getDateCreation(),
                AdDTO.getDateEnd(),
                AdDTO.getAdvertiser(),
                AdDTO.getValue());
    }

    private Service createService(AdDTO AdDTO){
        return new Service(AdDTO.getTitle(),
                AdDTO.getDescription(),
                AdDTO.getDateCreation(),
                AdDTO.getDateEnd(),
                AdDTO.getAdvertiser(),
                AdDTO.getDateScheduling());
    }

    private Employment createEmployment(AdDTO AdDTO){
        return new Employment(AdDTO.getTitle(),
                AdDTO.getDescription(),
                AdDTO.getDateCreation(),
                AdDTO.getDateEnd(),
                AdDTO.getAdvertiser());
    }

}
