package br.edu.infnet.jessefigueroapi.controllers;

import br.edu.infnet.jessefigueroapi.entities.Ferramenta;
import br.edu.infnet.jessefigueroapi.services.FerramentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/ferramentas")
public class FerramentaController {

    private final FerramentaService ferramentaService;

    public FerramentaController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }

    @PostMapping
    public Ferramenta insert(@RequestBody Ferramenta ferramenta) {
        Ferramenta f = ferramentaService.insert(ferramenta);

        return f;
    }

    @PutMapping("/{id}")
    public Ferramenta update(@PathVariable Integer id, @RequestBody Ferramenta ferramenta) {
        Ferramenta f = ferramentaService.update(id, ferramenta);

        return f;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        ferramentaService.delete(id);
    }

    @GetMapping
    public List<Ferramenta> findAll() {
        return  ferramentaService.findAll();
    }

    @GetMapping("/{id}")
    public Ferramenta findById(@PathVariable Integer id) {
        return ferramentaService.findById(id);
    }

    @PatchMapping("/{id}/disponivel")
    public Ferramenta disponivel(@PathVariable Integer id) {
        Ferramenta f = ferramentaService.available(id);

        return f;
    }
}
