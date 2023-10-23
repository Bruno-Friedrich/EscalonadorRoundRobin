import java.util.ArrayList;

public class FilaDeBloqueados {
  private ArrayList<BCP> filaDeBloqueados = new ArrayList<>();

  public void adicionarProcesso(BCP processo) {
    processo.setTempoBloqueado(2);
    filaDeBloqueados.add(processo);
  }

  public BCP removerProcesso() {
      if (filaDeBloqueados.isEmpty()) {
          return null; // Retorna null se a fila estiver vazia
      }
      return filaDeBloqueados.remove(0); // Remove e retorna o primeiro processo da fila
  }

  public int getTamanho() {
    return filaDeBloqueados.size();
  }
  
  public int contadorCicloBloqueado(){
    int contador = 0;
    for(BCP bcp : filaDeBloqueados){
      int tempoBloqueado = bcp.getTempoBloqueado();
      bcp.setTempoBloqueado(tempoBloqueado - 1);
      if(bcp.getTempoBloqueado() == 0){
        contador++;
      }
    }
    return contador;
  }
}
