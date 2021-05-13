package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DonationService implements CrudService<Donation> {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void update(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void delete(long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> showAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation showById(long id) {
        return donationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Integer showQuantity(){
        return donationRepository.findAll()
                .stream()
                .mapToInt(entity->entity.getQuantity())
                .sum();
    }

    public Integer showDonationsNumber(){
        return donationRepository.countDonationByIdIsNotNull();
    }
}
