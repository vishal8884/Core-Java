package concorrency.course2.parallelization.parallelSumExample;

public class ParallelSumRunner {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors :: "+availableProcessors);

        ParallelSumService parallelSumService = new ParallelSumService(availableProcessors);
        int sum = parallelSumService.sum(new int[]{1, 2, 3, 4, 10});

        System.out.println(sum);
    }
}
