
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

    // Atualiza as variáveis básicas conforme elas entram e saem da base
    public static void atualizarVariaveis(int pivotRow, int pivotColumn) {
        variaveisBasicas[pivotRow] = variaveis[pivotColumn];
    }

}
