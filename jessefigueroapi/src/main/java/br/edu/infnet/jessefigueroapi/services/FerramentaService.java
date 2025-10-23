package br.edu.infnet.jessefigueroapi.services;

import br.edu.infnet.jessefigueroapi.entities.Ferramenta;
import br.edu.infnet.jessefigueroapi.interfaces.CrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FerramentaService implements CrudService<Ferramenta, Integer> {

    private final Map<Integer, Ferramenta> ferramentas = new ConcurrentHashMap<Integer, Ferramenta>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Ferramenta insert(Ferramenta ferramenta) {

        ferramenta.setId(nextId.getAndIncrement());
        ferramentas.put(ferramenta.getId(), ferramenta);

        return ferramenta;
    }

    @Override
    public void delete(Integer id) {
        ferramentas.remove(id);
    }

    @Override
    public List<Ferramenta> findAll() {
        return new ArrayList<Ferramenta>(ferramentas.values());
    }

    @Override
    public Ferramenta update(Integer id, Ferramenta ferramenta) {

        ferramentas.put(ferramenta.getId(), ferramenta);

        return ferramenta;
    }

    @Override
    public Ferramenta findById(Integer id) {
        Ferramenta ferramenta = ferramentas.get(id);

        return ferramenta;
    }

    public Ferramenta available(Integer id) {
        Ferramenta f = findById(id);

        if (!f.getDisponivel()) {
            System.err.println("A ferramenta " + f.getNome() + " não está indísponivel!");

            return f;
        }

        f.setDisponivel(false);

        return f;
    }
}