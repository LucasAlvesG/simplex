public class Main {
    private int rows, cols;
    private float[][] table;
    private boolean solutionIsUnbounded = false;
    private static int [] columSmall;
    private static int [] rigthCollum;
    private static float [] quociente;


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

    public ERROR compute(float [][] dataArray, int colunaDois) {
        if (checkOptimality()) {
            return ERROR.IS_OPTIMAL;
        }

        int pivotColumn = findEnteringColumn(dataArray, colunaDois);
        System.out.println("Pivot Column: " + pivotColumn);

        float[] ratios = calculateRatios();
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
    

    private int findEnteringColumn(float [][] arrayNovo, int coluna) {
        this.rows = 5;
        this.cols = 6;

        int [] menorLinha = new int[arrayNovo.length];
        int auxiliar = 1000;
        int posicaoMenor = 0;
        int specificColum = -1;
        int [] colunaRigth = new int[arrayNovo.length];

        for(int k = 0; k < arrayNovo.length; k++){
            for(int w = 0; w < arrayNovo.length; w++){
                if (arrayNovo[k][w] < auxiliar) {
                    auxiliar = (int) arrayNovo[k][w];
                    posicaoMenor = w;
                }
                colunaRigth [k] = (int) arrayNovo[k][coluna - 1]; 
            }
        }

        if (rows > 0 && cols > 0) {
                for(int j = 0; j < arrayNovo.length; j++){

                    menorLinha [j] = (int) arrayNovo[j][posicaoMenor];
                    System.out.println(arrayNovo[j][posicaoMenor]);

                }      
    
        }
        columSmall = new int[menorLinha.length];

        for(int i = 0; i < menorLinha.length; i++){
            columSmall[i] = menorLinha[i];
        }
        
        rigthCollum = colunaRigth;
        return specificColum;
    }
        
    private static float[] calculateRatios() {
        quociente = new float[rigthCollum.length];
        float rows [] = new float[rigthCollum.length];

        for(int i = 0; i < rigthCollum.length; i++){
            float resultadoQuociente = 0;
            if(i==0){resultadoQuociente = 0;}
            else {resultadoQuociente = rigthCollum[i]/columSmall[i];}
            rows[i] = resultadoQuociente;
            quociente[i] = resultadoQuociente;
            
        }
        return rows;
    }

    private int findSmallestValue(float[] ratios) {
        return 0;
    }

    private void formNextTableau(int pivotRow, int pivotColumn) {
        // Implementar formação do próximo tableau
    }

    public static void main(String[] args) {

        int coluna = 7;
        int linha = 4;

        float[][] data = {
            {1, -3, -2, 0, 0, 0,0},
            {0, 2, 1, 1, 0, 0,100},
            {0, 1, 1, 0, 1, 0,80},
            {0, 1, 0, 0, 0, 1,40},
        };
        
        Main simplex = new Main(linha, coluna);
        simplex.findEnteringColumn(data, coluna);
        
        
        calculateRatios();

        // imprimeTeste(quociente);
    }

    public static void imprimeTeste (float[]teste){
        for(int i = 0; i< teste.length; i++){
            System.out.println("___________________");
            System.out.println(teste[i]);
        }
    }
}