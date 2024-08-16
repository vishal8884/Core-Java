package concorrency.course2.forkJoinFrameWork.T2_PrinitingIntegerAssesment.actual;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

class Runner {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        PrintAction printIntegerParallelService = new PrintAction(list);
        printIntegerParallelService.invoke();
    }
}

public class PrintAction extends RecursiveAction {

    private List<Integer> nums;

    public PrintAction(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    protected void compute() {
        // the problem is small enough (containing 2 items) so we use
        // standard sequential print operation
        if(nums.size() < 2) {
            for(Integer num : nums)
                System.out.println(num);
        } else {
            // otherwise we split the problem into 2 sub-problems
            // [a,b,c] --> [a] and [b,c]
            // [a,b,c,d] --> [a,b] and [c,d]
            List<Integer> left = nums.subList(0, nums.size()/2);
            List<Integer> right = nums.subList(nums.size()/2,  nums.size());

            PrintAction action1 = new PrintAction(left);
            PrintAction action2 = new PrintAction(right);

            // it means these actions are thrown into the pool
            // fork-join assigns different threads to different tasks
            // so these will be executed with different treads
            invokeAll(action1, action2);
        }
    }
}
