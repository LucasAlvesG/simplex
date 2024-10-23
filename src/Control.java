
public class Control {

    public static int numberOfConstraints = Table.table.length - 1;
    public static int numberOfVariables = Table.table[0].length - numberOfConstraints - 1;

    public static void control() {

        System.out.println("Tabela Inicial:");
        PrintFinalResolution.mostrarMatriz(Table.table, PrintFinalResolution.variaveisBasicas);

        while (!FindPivotColumn.negativoLinhaZero(Table.table)) {
            int pivotColumn = FindPivotColumn.findPivotColumn();

            int pivotRow = FindPivotRow.findPivotRow(pivotColumn);
            if (pivotRow == -1) {
                System.out.println("Linha pivô não encontrada.");
                break;
            }

            System.out.println("Pivotando na coluna " + pivotColumn + ", linha " + pivotRow);

            Pivot.pivot(pivotColumn, pivotRow);

            PrintFinalResolution.atualizarVariaveis(pivotRow, pivotColumn);

            PrintFinalResolution.mostrarMatriz(Table.table, PrintFinalResolution.variaveisBasicas);
        }

        // Imprimir a solução final
        PrintFinalResolution.printSolution();
    }
}
