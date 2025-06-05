package com.cazacubrindusa.demo.controller;

import com.cazacubrindusa.demo.model.Thesis;
import com.cazacubrindusa.demo.service.ThesisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThesisController {
    private final ThesisService service;

    public ThesisController(ThesisService service) {
        this.service = service;
    }

    @PostMapping("/thesis")
    public ResponseEntity<Thesis> create(@RequestBody Thesis thesis) {
        Thesis created = service.create(thesis);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/theses")
    public List<Thesis> list() {
        return service.findAll();
    }

    @GetMapping("/thesis/{id}")
    public ResponseEntity<Thesis> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/thesis/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Thesis thesis) {
        if (thesis.getTitle() == null || thesis.getTitle().isBlank()) {
            return ResponseEntity.badRequest().body("Title must not be empty");
        }
        return service.update(id, thesis)
            .<ResponseEntity<?>>map(t -> ResponseEntity.ok(t))
            .orElseGet(() -> ResponseEntity.badRequest()
                                   .body("No thesis with id " + id));
    }

    @DeleteMapping("/thesis/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest()
               .body("No thesis with id " + id);
    }
}
