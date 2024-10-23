
public class FindPivotColumn {

    public static boolean negativoLinhaZero(float[][] table) {
        for (int i = 0; i < table[0].length - 1; i++) {
            if (table[0][i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static int findPivotColumn() {
        float[][] tableLocal = Table.table;
        int pivotColumn = -1;
        float menorValor = 0;

        for (int i = 0; i < tableLocal[0].length - 1; i++) {
            if (tableLocal[0][i] < menorValor) {
                menorValor = tableLocal[0][i];
                pivotColumn = i;
            }
        }
        return pivotColumn;
    }
}
