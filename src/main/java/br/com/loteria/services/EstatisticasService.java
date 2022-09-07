package br.com.loteria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EstatisticasService {

    @Autowired
    private SalvarArquivoService salvarArquivoService;
    
    public List<String> quaisOsSeisNumerosMaisSortiados() throws IOException {

        List<String> listaNumerosSortiados = salvarArquivoService.lerArquivo();

        listaNumerosSortiados.stream().forEach(numero -> {
            System.out.println(numero);
        });

        return listaNumerosSortiados;
    }
}
