import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista(null,null);
        Random random = new Random();
        for(int i=8;i>0;i--)
            lista.insertList(random.nextInt(141));

        lista.showList();

        long tempoInicial = System.currentTimeMillis();

        lista.shellSort();

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;

        System.out.println("Tempo de execução: " + tempoExecucao + " milissegundos");

        lista.showList();

    }


}