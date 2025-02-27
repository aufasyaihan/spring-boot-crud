package com.example.SpringBoot.service;

import com.example.SpringBoot.model.Krs;
import com.example.SpringBoot.repository.KrsRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KrsService {
    private final KrsRepository krsRepository;

    public KrsService(KrsRepository krsRepository) {
        this.krsRepository = krsRepository;
        }

        public List<Krs> getAllKrs(int page, int size) {
            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "idKrs"));
            Page<Krs> krsPage= krsRepository.findAll(pageable);
            return krsPage.getContent();
        }

        public Optional<Krs> getKrsById(Long id) {
        return krsRepository.findById(id);
    }

    public Krs createKrs(Krs user) {
        return krsRepository.save(user);
    }

    public Krs updateKrs(Long id, Krs updatedKrs) {
        return krsRepository.findById(id).map(krs -> {
            krs.setNim(updatedKrs.getNim());
            krs.setKodeMatakuliah(updatedKrs.getKodeMatakuliah());
            krs.setMatakuliah(updatedKrs.getMatakuliah());
            krs.setSemester(updatedKrs.getSemester());
            krs.setTahunakademik(updatedKrs.getTahunakademik());
            return krsRepository.save(krs);
        }).orElseThrow(() -> new RuntimeException("KRS not found"));
    }
    
    public void deleteKrs(Long id) {
        krsRepository.deleteById(id);
    }
}
