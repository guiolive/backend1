package br.ufg.inf.backend.StpDourados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.backend.StpDourados.model.UnidadeHospitalar;
import br.ufg.inf.backend.StpDourados.repository.UnidadeHospitalarRepository;

@Service
public class UnidadeHospitalarService {

    @Autowired
    private UnidadeHospitalarRepository unidadeHospitalarRepository;

    public List<UnidadeHospitalar> findAll() {
        return unidadeHospitalarRepository.findAll();
    }

    public Optional<UnidadeHospitalar> findById(Long id) {
        return unidadeHospitalarRepository.findById(id);
    }

    public UnidadeHospitalar save(UnidadeHospitalar unidadeHospitalar) {
        return unidadeHospitalarRepository.save(unidadeHospitalar);
    }

    public void deleteById(Long id) {
        unidadeHospitalarRepository.deleteById(id);
    }
}