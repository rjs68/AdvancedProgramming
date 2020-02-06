package Iterator;

import java.util.Iterator;
import java.util.Random;

public class IteratedArray implements Iterable<Double>{
    private Double[] randomNumbers;

    public IteratedArray(int userSize){
        randomNumbers = new Double[userSize];
        insertRandomNumbers();
    }

    private void insertRandomNumbers(){
        Random rand = new Random();
        for(int i=0; i<randomNumbers.length; i++){
            double value = rand.nextDouble() - 0.5;
            randomNumbers[i] = value;
        }
    }

    public Iterator<Double> iterator(){
        Iterator<Double> iterator = new Iterator<Double>(){
            private int position;

            public Double next(){
                Double nextDouble = randomNumbers[position];
                while(nextDouble<0 && hasNext()){
                    nextDouble = randomNumbers[position];
                }
                position++;
                return nextDouble;
            }

            public boolean hasNext(){
                while(position<randomNumbers.length && randomNumbers[position]<0){
                    position++;
                }

                if(position<randomNumbers.length){
                    return true;
                }
                return false;
            }
        };
        return iterator;
    }
}