package br.com.loteria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SorteioService {

    private List<Integer> listaNumerosSortiados = new ArrayList<>();

    SalvarArquivoService salvarArquivoService;

    public SorteioService(SalvarArquivoService salvarArquivoService){
        this.salvarArquivoService = salvarArquivoService;
    }

    public List<Integer> sorteio() throws IOException {

        for(Integer i = 0; this.listaNumerosSortiados.size() < 6; i++){

            Integer numeroSortiado = sortiarNumero();
            validarNumeroSortiado(numeroSortiado);
        }
        salvarArquivoService.salvar(this.listaNumerosSortiados);
        return this.listaNumerosSortiados;
    }

    public Integer sortiarNumero() {

        Random gerador = new Random();
        return gerador.nextInt(59);
    }

    public List<Integer> validarNumeroSortiado(Integer numero){

        Boolean numeroJaEstaNaLista = false;

        for (int i=1; i < this.listaNumerosSortiados.size(); i++){
            if(this.listaNumerosSortiados.get(i) == numero){
                numeroJaEstaNaLista = true;
            }
        }
        if(!numeroJaEstaNaLista) adicionaNumeroNaLista(numero);
        return this.listaNumerosSortiados;
    }

    public void adicionaNumeroNaLista(Integer numero){
        this.listaNumerosSortiados.add(numero);
    }
}







