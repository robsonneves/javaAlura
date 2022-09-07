package br.com.loteria.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class SalvarArquivoServiceTest {

    @Autowired
    private SalvarArquivoService salvarArquivoService;

    @Test
    public void verificarSeArquivoExiste() {

        Boolean arquivoExiste = salvarArquivoService.verificarArquivoExiste();
        assertEquals(true, arquivoExiste);
    }

    @Test
    public void verificaSeSalvoNoArquivo() throws IOException {

        List<Integer> listaNumeros = new ArrayList<Integer>();

        for (Integer i=1; i < 7; i++){
            listaNumeros.add(i);
        }

        List<Integer> listaDeNumerosSortiadosSalva = salvarArquivoService.salvar(listaNumeros);
        assertEquals(listaNumeros, listaDeNumerosSortiadosSalva);
    }
}
