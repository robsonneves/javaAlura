package br.com.loteria.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class SorteioServiceTest {

    @Autowired
    private SorteioService sorteioService;

    @Test
    public void soteia6NumerosDe1a60naoRepete() throws IOException {

        List<Integer> listaNumerosSortiados = sorteioService.sorteio();
        assertThat(listaNumerosSortiados, hasSize(6));
    }
}
