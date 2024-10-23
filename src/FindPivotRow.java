
public class FindPivotRow {

    public static int findPivotRow(int pivotColumn) {
        float[][] tableLocal = Table.table;
        int pivotRow = -1;
        float quocienteMenor = Float.MAX_VALUE;
        for (int i = 0; i < Control.numberOfConstraints; i++) {
            if (Table.table[i][pivotColumn] > 0) {
                float quociente = tableLocal[i][tableLocal[0].length - 1] / tableLocal[i][pivotColumn];
                if (quociente < quocienteMenor) {
                    quocienteMenor = quociente;
                    pivotRow = i;
                }
            }
        }
        return pivotRow;
    }
}
