import java.util.Arrays;

public class Main {
    private int rows, cols;
    private float[][] table;
    private boolean solutionIsUnbounded = false;


    public static enum ERROR {
        NOT_OPTIMAL,
        IS_OPTIMAL,
        UNBOUNDED
    };

    public Main(int numOfConstraints, int numOfUnknowns) {
        rows = numOfConstraints + 1;
        cols = numOfUnknowns + 1;
        table = new float[rows][cols];
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = String.format("%.2f", table[i][j]);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fillTable(float[][] data) {
        for (int i = 0; i < table.length; i++) {
            System.arraycopy(data[i], 0, this.table[i], 0, data[i].length);
        }
    }

    public ERROR compute() {
        if (checkOptimality()) {
            return ERROR.IS_OPTIMAL;
        }

        int pivotColumn = findEnteringColumn();
        System.out.println("Pivot Column: " + pivotColumn);

        float[] ratios = calculateRatios(pivotColumn);
        if (solutionIsUnbounded) return ERROR.UNBOUNDED;
        int pivotRow = findSmallestValue(ratios);

        formNextTableau(pivotRow, pivotColumn);
        return ERROR.NOT_OPTIMAL;
    }

    private boolean checkOptimality() {
        boolean isOptimal = true;
        for (int j = 0; j < cols - 1; j++) {
            if (table[rows - 1][j] < 0) {
                isOptimal = false;
                break;
            }
        }
        return isOptimal;
    }
    

    private int findEnteringColumn() {
        int specificColum = -1;
        cols = table[0].length;
        rows = table.length;
        int [][] result = new int [rows][cols];

        if (rows > 0 && cols > 0) {
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
    
                   result[i][j] = (int) table[i][j];
            
                
                   if(result[i][1] >= -3 && result [i] [1] <= 1){
                        System.out.println("Encontrou" + j);
                        specificColum = j;
                        return specificColum;

                   }

                   if (result[i][j] == -3) {
                    int [] newB = new int[j];
                        for(int k = 0; k < j; k++){
                            newB[k] = result[i][k];
                        }
                        System.out.println("Valores até a coluna -3: " + Arrays.toString(newB));
                    }
                
                }
                     
            }
        }  
        return specificColum;
    }
        


    private float[] calculateRatios(int pivotColumn) {
        // Implementar cálculo de razões
        return new float[rows];
    }

    private int findSmallestValue(float[] ratios) {
        // Implementar lógica para encontrar o menor valor
        return 0;
    }

    private void formNextTableau(int pivotRow, int pivotColumn) {
        // Implementar formação do próximo tableau
    }

    public static void main(String[] args) {
        // Exemplo de uso
        float[][] data = {
            {1, -3, -2, 0, 0, 0},
            {0, 2, 1, 1, 0, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1}
        };

        Main simplex = new Main(3, 6);
        simplex.fillTable(data);
        simplex.print();
        simplex.findEnteringColumn();

        while (simplex.compute() == ERROR.NOT_OPTIMAL) {
            simplex.print();
        }
    }
}