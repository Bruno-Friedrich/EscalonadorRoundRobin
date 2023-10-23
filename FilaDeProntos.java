import java.util.ArrayList;

public class FilaDeProntos {
    private ArrayList<BCP> filaDeProntos;

    public FilaDeProntos(ArrayList<BCP> processos) {
        filaDeProntos = new ArrayList<>(processos);
    }

    public void adicionarProcesso(BCP processo) {
        filaDeProntos.add(processo);
    }

    public BCP removerProcesso() {
        if (filaDeProntos.isEmpty()) {
            return null; // Retorna null se a fila estiver vazia
        }
        return filaDeProntos.remove(0); // Remove e retorna o primeiro processo da fila
    }

    public int getTamanho() {
        return filaDeProntos.size();
    }
}
