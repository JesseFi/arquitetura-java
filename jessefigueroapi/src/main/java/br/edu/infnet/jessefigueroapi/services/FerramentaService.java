// src/main/java/br/edu/infnet/jessefigueroapi/model/service/FerramentaService.java
package br.edu.infnet.jessefigueroapi.services;

import br.edu.infnet.jessefigueroapi.entities.Ferramenta;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FerramentaService {

    private Map<Integer, Ferramenta> ferramentas = new HashMap<>();
    private Integer nextId = 1;

    public void incluir(Ferramenta ferramenta) {
        ferramenta.setId(nextId++);
        ferramentas.put(ferramenta.getId(), ferramenta);
    }

    public void excluir(Integer id) {
        ferramentas.remove(id);
    }

    public Collection<Ferramenta> obterLista() {
        return ferramentas.values();
    }

    public Ferramenta obterPorId(Integer id) {
        return ferramentas.get(id);
    }
}