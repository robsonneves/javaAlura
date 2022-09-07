package br.com.loteria.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class EstatisticasServiceTeste {

    @Autowired
    EstatisticasService estatisticasService;

    @Test
    public void verificar6NumerosMaisSortiados() throws IOException {

        List<String> listaNumerosMaisSortiados = estatisticasService.quaisOsSeisNumerosMaisSortiados();
        assertEquals(listaNumerosMaisSortiados.size(), hasSize(6));
    }

}
