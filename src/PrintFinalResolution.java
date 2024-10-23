
public class PrintFinalResolution {

    public static String[] variaveisBasicas = {"z", "f1", "f2", "f3"};
    public static String[] variaveis = {"z", "x1", "x2", "f1", "f2", "f3"};

    public static void printSolution() {
        System.out.println("Resultado Final:");

        System.out.println("z = " + Table.table[0][Table.table[0].length - 1]);

        for (int i = 1; i < variaveisBasicas.length; i++) {
            float valor = Table.table[i][Table.table[0].length - 1];

            if (valor != 0) {
                System.out.println(variaveisBasicas[i] + " = " + valor);
            }
        }
    }

    public static void atualizarVariaveis(int pivotRow, int pivotColumn) {
        variaveisBasicas[pivotRow] = variaveis[pivotColumn];
    }

    public static void mostrarMatriz(float[][] matriz, String[] variaveisBasicas) {
        System.out.println("Matriz:");

        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            System.out.print("Col " + (coluna + 1) + "\t");
        }
        System.out.println();

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.printf("%.2f\t", matriz[linha][coluna]);
            }
            System.out.println();
        }

        System.out.println("");
        System.out.println("");
    }

}
