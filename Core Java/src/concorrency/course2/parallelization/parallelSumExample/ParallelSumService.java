package concorrency.course2.parallelization.parallelSumExample;

public class ParallelSumService {

    private ParallelWorker[] parallelWorkers;
    private int numberOfThreads;

    public ParallelSumService(int numberOfThreads){
        this.parallelWorkers = new ParallelWorker[numberOfThreads];
        this.numberOfThreads = numberOfThreads;
    }


    //1,2,3,4,5,6
    public int sum(int[] nums){
        int size = (int) Math.ceil(nums.length * 1.0/numberOfThreads);  //size for summing up ...divides equally..ex chunks of 2 for len = 6

        for(int i=0;i<numberOfThreads;i++){
            parallelWorkers[i] = new ParallelWorker(nums,i*size,(i+1) * size);
            parallelWorkers[i].start();
        }


        try {
            for(ParallelWorker parallelWorker : parallelWorkers)
                parallelWorker.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        int totalSum = 0;

        for(ParallelWorker parallelWorker : parallelWorkers){
            totalSum += parallelWorker.getPartitalSum();
        }

        return totalSum;
    }
}
