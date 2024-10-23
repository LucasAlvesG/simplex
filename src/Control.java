
public class Control {

    public static int numberOfConstraints = Table.table.length - 1;
    public static int numberOfVariables = Table.table[0].length - numberOfConstraints - 1;

    public static void control() {
        while (!FindPivotColumn.negativoLinhaZero(Table.table)) {
            int pivotColumn = FindPivotColumn.findPivotColumn();

            int pivotRow = FindPivotRow.findPivotRow(pivotColumn);
            if (pivotRow == -1) {
                System.out.println("linha pivô não encontrada.");
                break;
            }

            Pivot.pivot(pivotColumn, pivotRow);

            PrintFinalResolution.atualizarVariaveis(pivotRow, pivotColumn);

        }
        PrintFinalResolution.printSolution();
    }
}
