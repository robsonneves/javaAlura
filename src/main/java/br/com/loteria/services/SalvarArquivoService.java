package br.com.loteria.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class SalvarArquivoService {

    @Value("${APP.FILE.PATH}")
    private String filePath;

    public Boolean verificarArquivoExiste() {

        String filePath = this.filePath;
        File file = new File(filePath);

        if (isFileExists(file)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Método para verificar se o arquivo existe e não é um diretório
    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public Boolean criarArquivo() throws IOException {

        FileWriter arq = new FileWriter(this.filePath);
        arq.close();
        return true;
    }


    public List<Integer> salvar(List<Integer> numerosSortiados) throws IOException {

        List<String> itensSalvos = this.lerArquivo();

        FileWriter arq = new FileWriter(this.filePath);
        PrintWriter gravarArq = new PrintWriter(arq);

        String dataFormatada = getData();

        itensSalvos.stream().forEach(linha -> {
            gravarArq.printf(linha + "\n");
        });

        gravarArq.printf(dataFormatada + " = " + numerosSortiados.toString() + ";");
        arq.close();
        return numerosSortiados;
    }

    private String getData() {

        Date data = new Date();
        String dataFormatada = new SimpleDateFormat("dd-MM-YYYY HH:mm").format(data);
        return dataFormatada;
    }

    public List<String> lerArquivo() throws IOException {

        FileReader arq = new FileReader(this.filePath);
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine();
        List<String> linhas = new ArrayList<String>();

        while (linha != null) {
            linhas.add(linha);
            linha = lerArq.readLine();
        }
        arq.close();
        return linhas;
    }
}
