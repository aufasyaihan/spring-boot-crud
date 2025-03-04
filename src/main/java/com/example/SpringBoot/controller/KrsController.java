package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.MetaDTO;
import com.example.SpringBoot.dto.ResponseDTO;
import com.example.SpringBoot.model.Krs;
import com.example.SpringBoot.service.KrsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/krs")
public class KrsController {
    private final KrsService krsService;

    public KrsController(KrsService krsService) {
        this.krsService = krsService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<Krs>> getAllKrs() {
        List<Krs> krsList = krsService.getAllKrs(1, 350000);
        MetaDTO meta = new MetaDTO(200, "Success");
        ResponseDTO<Krs> response = new ResponseDTO<>(meta, krsList);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Krs>> getKrsById(@PathVariable Long id) {
        Optional<Krs> krs = krsService.getKrsById(id);
        if (krs.isPresent()) {
            ResponseDTO<Krs> response = new ResponseDTO<>(
                    new MetaDTO(200, "Success"),
                    List.of(krs.get()));
            return ResponseEntity.ok(response);
        } else {
            ResponseDTO<Krs> response = new ResponseDTO<>(
                    new MetaDTO(404, "KRS Not Found"),
                    List.of());
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<Krs>> createKrs(@RequestBody Krs krs) {
        Krs createdKrs = krsService.createKrs(krs);
        ResponseDTO<Krs> response = new ResponseDTO<>(
                new MetaDTO(201, "Success"),
                List.of(createdKrs)
        );
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Krs>> updateKrs(@PathVariable Long id, @RequestBody Krs krs) {
        try {
            Krs updatedKrs = krsService.updateKrs(id, krs);
            ResponseDTO<Krs> response = new ResponseDTO<>(
                    new MetaDTO(200, "Success"),
                    List.of(updatedKrs)
            );
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            ResponseDTO<Krs> response = new ResponseDTO<>(
                    new MetaDTO(404, "KRS Not Found"),
                    List.of()
            );
            return ResponseEntity.status(404).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteKrs(@PathVariable Long id) {
        krsService.deleteKrs(id);
        ResponseDTO<Void> response = new ResponseDTO<>(
                new MetaDTO(200, "Success"),
                null);
        return ResponseEntity.ok(response);
    }
}
