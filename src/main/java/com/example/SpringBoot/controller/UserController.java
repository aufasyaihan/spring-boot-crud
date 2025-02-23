package com.example.SpringBoot.controller;

import com.example.SpringBoot.model.Krs;
import com.example.SpringBoot.service.KrsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/krs")
public class UserController {
    private final KrsService krsService;

    public UserController(KrsService krsService) {
        this.krsService = krsService;
    }

    @GetMapping
    public List<Krs> getAllKrs() {
        return krsService.getAllKrs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Krs> getKrsById(@PathVariable Long id) {
        Optional<Krs> krs = krsService.getKrsById(id);
        return krs.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Krs createKrs(@RequestBody Krs krs) {
        return krsService.createKrs(krs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Krs> updateKrs(@PathVariable Long id, @RequestBody Krs krs) {
        try {
            Krs updatedKrs = krsService.updateKrs(id, krs);
            return ResponseEntity.ok(updatedKrs);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKrs(@PathVariable Long id) {
        krsService.deleteKrs(id);
        return ResponseEntity.noContent().build();
    }
}
