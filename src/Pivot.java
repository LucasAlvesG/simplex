
public class Pivot {

    public static void pivot(int pivotColumn, int pivotRow) {
        float[][] tableLocal = Table.table;
        float pivotValue = tableLocal[pivotRow][pivotColumn];

        for (int j = 0; j < tableLocal[0].length; j++) {
            tableLocal[pivotRow][j] = tableLocal[pivotRow][j] / pivotValue;
        }

        for (int i = 0; i < tableLocal.length; i++) {
            if (i != pivotRow) {
                float factor = tableLocal[i][pivotColumn];
                for (int j = 0; j < tableLocal[0].length; j++) {
                    tableLocal[i][j] = tableLocal[i][j] + (-factor * tableLocal[pivotRow][j]);
                }
            }
        }
    }
}
