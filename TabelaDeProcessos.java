import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TabelaDeProcessos {
  private ArrayList<BCP> tabelaDeProcessos;

  public TabelaDeProcessos(String[] args) {
    tabelaDeProcessos = new ArrayList<>();

    for (String arg : args) {
      ArrayList<String> processo = lerArquivoParaArrayList(arg);
      BCP bcp = new BCP(processo);
      tabelaDeProcessos.add(bcp);
      System.out.println("Carregando " + bcp.getProcessoNome());
    }

    Collections.sort(tabelaDeProcessos, new Comparator<BCP>() {
        @Override
        public int compare(BCP bcp1, BCP bcp2) {
            String nome1 = bcp1.getProcessoNome();
            String nome2 = bcp2.getProcessoNome();

            // Compare pelo tamanho dos nomes
            int tamanho1 = nome1.length();
            int tamanho2 = nome2.length();

            if (tamanho1 < tamanho2) {
                return -1;
            } else if (tamanho1 > tamanho2) {
                return 1;
            } else {
                // Se os tamanhos são iguais, compare os nomes
                return nome1.compareTo(nome2);
            }
        }
    });
  }

  private ArrayList<String> lerArquivoParaArrayList(String nomeArquivo) {
    ArrayList<String> linhas = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
      String linha;
      while ((linha = br.readLine()) != null) {
        linhas.add(linha);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return linhas;
  }

  public ArrayList<BCP> getTabelaDeProcessos(){
    return tabelaDeProcessos;
  }
  
  public BCP getProcesso(int id) {
    return tabelaDeProcessos.get(id);
  }

  public void imprimeProcesos(){
     for (BCP bcp : tabelaDeProcessos) {
         ArrayList<String> instrucoes = bcp.getInstrucoesProcesso();
         System.out.println("Instruções do processo " + bcp.getProcessoNome() + ":");
         for (String instrucao : instrucoes) {
             System.out.println(instrucao);
         }
     }
  }
}