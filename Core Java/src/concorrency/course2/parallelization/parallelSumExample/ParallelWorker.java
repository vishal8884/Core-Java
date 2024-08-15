package concorrency.course2.parallelization.parallelSumExample;

public class ParallelWorker extends Thread {

    private int[] arr;
    private int low;
    private int high;
    private int partitialSum;


    public ParallelWorker(int[] arr,int low,int high){
        this.arr = arr;
        this.low = low;
        this.high = Math.min(arr.length,high);
    }
    //1,2,3,4,5,6

    @Override
    public void run() {
        partitialSum = 0;

        for(int i=low;i<high;i++){
            partitialSum = partitialSum + arr[i];
        }
    }

    public Integer getPartitalSum(){
        return partitialSum;
    }
}
