public class NewAltMaxValue1DArray implements Runnable {
    private Double[] inputArray;
    private Double maxValue;
    private AltSharedDouble sharedMaxValue;

    public NewAltMaxValue1DArray(Double[] inputArray, AltSharedDouble maxValue){
        this.inputArray = inputArray;
        this.maxValue = maxValue.getD();
        this.sharedMaxValue = maxValue;
    }

    public void run(){
        for(int i=1; i<inputArray.length; i++){
            sharedMaxValue.compare(inputArray[i]);
        }
    }
}
