package br.edu.infnet.jessefigueroapi.loaders;

import br.edu.infnet.jessefigueroapi.entities.Ferramenta;
import br.edu.infnet.jessefigueroapi.services.FerramentaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collection;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Component
public class FerramentaLoader implements ApplicationRunner {

    @Value("${path.ferramentas}")
    private String path;

    private final FerramentaService ferramentaService;

    public FerramentaLoader(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("ferramentas.csv");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while(line != null) {

            fields = line.split(";");

            Ferramenta ferramenta = new Ferramenta();
            ferramenta.setNome(fields[0]);
            ferramenta.setTipo(fields[1]);
            ferramenta.setFabricante(fields[2]);
            ferramenta.setPreco(Double.valueOf(fields[3]));
            ferramenta.setNumeroSerie(fields[4]);
            ferramenta.setDescricao(fields[5]);
            ferramenta.setDisponivel(Boolean.valueOf(fields[6]));

            ferramentaService.insert(ferramenta);

            line = reader.readLine();
        }

        Collection<Ferramenta> ferramentas = ferramentaService.findAll();

        ferramentas.forEach(System.out::println);

        System.out.println("[FerramentaLoader] Carga de dados concluída! Total: " + ferramentas.size() + " ferramentas cadastradas.");

        reader.close();
    }
}