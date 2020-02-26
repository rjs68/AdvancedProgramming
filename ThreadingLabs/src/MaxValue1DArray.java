public class MaxValue1DArray implements Runnable {
    private Double[] inputArray;
    private Double[] maxValues;
    private int maxValuesPosition;

    public MaxValue1DArray(Double[] inputArray, Double[] maxValues, int maxValuesPosition){
        this.inputArray = inputArray;
        this.maxValues = maxValues;
        this.maxValuesPosition = maxValuesPosition;
    }

    public void run(){
        maxValues[maxValuesPosition] = inputArray[0];
        for(int i=1; i<inputArray.length; i++){
            if(inputArray[i]>maxValues[maxValuesPosition]){
                maxValues[maxValuesPosition] = inputArray[i];
            }
        }
    }
}
