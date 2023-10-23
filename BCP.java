import java.util.ArrayList;


public class BCP{
  // Variáveis utilizadas para cada Bloco de Controle de Processos
  private int PC;
  private double X;
  private double Y;
  private int TempoBloqueado;
  private Estado.GetEstado EstadoProcesso = Estado.GetEstado.PRONTO;
  private ArrayList<String> Processo;

  public BCP(ArrayList<String> Processo){
    this.Processo = Processo;
    PC = 1;
    X = 0;
    Y = 0;
    TempoBloqueado = 0;
  }

  public void setPC(int PC){
    this.PC = PC;
  }
  
  public void setX(double X){
    this.X = X;
  }

  public void setY(double Y){
    this.Y = Y;
  }

  public void setTempoBloqueado(int TempoBloqueado){
    this.TempoBloqueado = TempoBloqueado;
  }

  public void setEstadoProcesso(Estado.GetEstado EstadoProcesso){
    this.EstadoProcesso = EstadoProcesso;
  }

  public double getX(){
    return X;
  }

  public double getY(){
    return Y;
  }

  public int getTempoBloqueado(){
    return TempoBloqueado;
  }

  public int getPC(){
    return PC;
  }

  public Estado.GetEstado getEstadoProcesso(){
    return EstadoProcesso;
  }

  public String getProcessoNome(){
    return Processo.get(0);
  }

  public ArrayList<String> getInstrucoesProcesso(){
    return Processo;
  }
  
  public String proximaInstrucao(){
    // Recebe o próximo bloco de controle de processos
    String Instrucao = null;
    try{
      Instrucao = Processo.get(PC);
      PC++;
    }

    catch (ArrayIndexOutOfBoundsException ex)
    {
      System.out.println("Acesso indevido a memória");  
    }

    finally{
      return Instrucao;
    }
  }

}