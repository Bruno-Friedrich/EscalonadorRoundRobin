
import java.util.ArrayList;
import java.io.*;

class Escalonador {
 public static void main(String[] args) {
  if (args.length != 11) {
    System.out.println("Argumentos passados de forma incorreta!\n");
    System.out.println("Uso: java Escalonador <número_01_a_10>.txt <quantum>.txt\n");
    System.exit(1);
  }

    // Ler o valor do quantum do último arquivo .txt
    int quantum = lerQuantum(args[10]);

    if (quantum == -1) {
        System.out.println("Erro ao ler o valor do quantum.");
        System.exit(1);
    }

    String outputFileName = "log" + String.format("%02d", quantum) + ".txt";

    try {
        File outputFolder = new File("log");
        outputFolder.mkdirs(); // Cria a pasta 'log' se ela não existir
        PrintStream saida = new PrintStream(new File(outputFolder, outputFileName));
        System.setOut(saida); // Redireciona a saída padrão para o arquivo de saída
    } catch (IOException e) {
        e.printStackTrace();
        System.exit(1);
    }
   
    // Cria um novo array somente com o nome dos 10 processos
    String[] argsParaTabela = new String[10];
    System.arraycopy(args, 0, argsParaTabela, 0, 10);

    TabelaDeProcessos lista = new TabelaDeProcessos(argsParaTabela);
   
   
    FilaDeProntos filaProntos = new FilaDeProntos(lista.getTabelaDeProcessos());
    FilaDeBloqueados filaBloqueados = new FilaDeBloqueados();

   int totalTrocas = 0;
   int totalInstrucoes = 0;
   int numeroProcessos = 0;
   
    while (filaBloqueados.getTamanho() != 0 || filaProntos.getTamanho() != 0)
    {
      int i = 0;
      boolean continuaProcesso = true;
      boolean operacaoES = false;

      for (int k = 0; i<filaBloqueados.contadorCicloBloqueado(); k++){
        BCP ProcessoPronto = filaBloqueados.removerProcesso();
          ProcessoPronto.setEstadoProcesso(Estado.GetEstado.PRONTO);
        filaProntos.adicionarProcesso(ProcessoPronto);
      }

      BCP processo;
      if (filaProntos.getTamanho() != 0){
        processo = filaProntos.removerProcesso();
        System.out.println("Executando " + processo.getProcessoNome());
        
        while (i < quantum && continuaProcesso && !operacaoES)
        {
          String instrucao = processo.proximaInstrucao();

          if (instrucao.matches("X=\\d+")) {
            // Extrair o número após "X="
            String numeroComoString = instrucao.substring(2);
            processo.setX(Double.parseDouble(numeroComoString));
          } else if (instrucao.matches("Y=\\d+")) {
            // Extrair o número após "Y="
            String numeroComoString = instrucao.substring(2);
            processo.setY(Double.parseDouble(numeroComoString));
          } else {
            switch (instrucao) {
              case "COM":
                  break;

              // Instrução de entrada e saída
              case "E/S":
              {
                operacaoES = true;
                processo.setEstadoProcesso(Estado.GetEstado.BLOQUEADO);
                filaBloqueados.adicionarProcesso(processo);
                System.out.println("E/S iniciada em " + processo.getProcessoNome());
              } break;                

              // Instrução que para a finalização do processo  
              case "SAIDA":
              {
                processo.setEstadoProcesso(Estado.GetEstado.FINALIZADO);
                continuaProcesso = false;
              } break;

              // Instrução não reconhecida
              default:
              {
                System.out.println("Instrução passada de forma errada!");
                System.out.println("COM - um comando qualquer");
                System.out.println("E/S - comando de E/S");
                System.out.println("X=? ou Y=? - comando de registrador (? um double)");
                System.out.println("SAIDA - encerra o programa");  
              } break; 
            }
          }
          i++;
        }

      // Mensagem falando que o processo terminou de usar a CPU
        if (i>1) {
            System.out.println("Interrompendo " + processo.getProcessoNome() + " após " + i + " instruções");
        }
        else{
           System.out.println("Interrompendo " + processo.getProcessoNome() + " após " + i + " instrução");
        }
  
        // Mensagem falando com informações do fim do processo
        if (!continuaProcesso){
          System.out.println(processo.getProcessoNome() + " terminado. " + "X=" + processo.getX() + ". Y=" + processo.getY() + ".");
        }
  
        if (continuaProcesso && !operacaoES) {
          filaProntos.adicionarProcesso(processo);
        }

        totalTrocas++; // Incrementa o total de trocas
        totalInstrucoes += i; // Adiciona o número de instruções deste processo
      }
      

  }
   // Cálculos finais
   double mediaTrocas = (double) totalTrocas / 10;
   double mediaInstrucoes = (double) totalInstrucoes / totalTrocas;
   // Imprimir informações no final
   System.out.println("MÉDIA DE TROCAS: " + mediaTrocas);
   System.out.println("MÉDIA DE INSTRUÇÕES: " + mediaInstrucoes);
   System.out.println("QUANTUM: " + quantum);
 }

private static int lerQuantum(String arquivoQuantum) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(arquivoQuantum));
        String linha;
        while ((linha = br.readLine()) != null) {
            try {
                return Integer.parseInt(linha); // Tentar converter a linha para inteiro
            } catch (NumberFormatException e) {
                System.err.println("Conteúdo do arquivo de quantum não é um número válido.");
                return -1; // Valor padrão em caso de erro na conversão
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return -1; // Valor padrão em caso de erro na leitura
}


}