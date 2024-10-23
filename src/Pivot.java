
public class Pivot {

    public static void pivot(int pivotColumn, int pivotRow) {
        float[][] tableLocal = Table.table;
        float pivotValue = tableLocal[pivotRow][pivotColumn];

        for (int j = 0; j < tableLocal[0].length; j++) {
            tableLocal[pivotRow][j] /= pivotValue;
        }

        for (int i = 0; i < tableLocal.length; i++) {
            if (i != pivotRow) {
                float fator = tableLocal[i][pivotColumn];
                for (int j = 0; j < tableLocal[0].length; j++) {
                    tableLocal[i][j] -= fator * tableLocal[pivotRow][j];
                }
            }
        }

        PrintFinalResolution.mostrarMatriz(Table.table, PrintFinalResolution.variaveisBasicas);
    }
}
