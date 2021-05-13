package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class InstitutionService implements CrudService<Institution> {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void update(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void delete(long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public List<Institution> showAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution showById(long id) {
        return institutionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
