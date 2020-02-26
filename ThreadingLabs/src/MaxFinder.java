import java.awt.*;

public class MaxFinder {
    public static void main(String[] args){
        Double[][] randArray = createArray();
        Double maxValue = randArray[0][0];
        for(int i=0; i<100; i++){
            for(int j=0; j<50; j++){
                if(randArray[i][j] > maxValue){
                    maxValue = randArray[i][j];
                }
            }
        }
        System.out.println("The max value is: " + maxValue);
    }

    private static Double[][] createArray(){
        int nRows = 100;
        int nCols = 50;
        Double[][] randArray = new Double[nRows][nCols];
        for(int r=0;r<nRows;r++) {
            for (int c = 0; c < nCols; c++) {
                randArray[r][c] = Math.random();
            }
        }
        return randArray;
    }
}
