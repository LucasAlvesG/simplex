
public class FindPivotRow {

    public static int findPivotRow(int pivotColumn) {
        float[][] tableLocal = Table.table;
        int pivotRow = -1;
        double menorQuociente = Double.MAX_VALUE;

        for (int i = 1; i < Control.numberOfConstraints + 1; i++) {
            if (tableLocal[i][pivotColumn] > 0) {
                float quociente = tableLocal[i][tableLocal[0].length - 1] / tableLocal[i][pivotColumn];
                if (quociente < menorQuociente) {
                    menorQuociente = quociente;
                    pivotRow = i;
                }
            }
        }
        return pivotRow;
    }
}
