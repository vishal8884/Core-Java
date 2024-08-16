package concorrency.course2.forkJoinFrameWork.T2_PrinitingIntegerAssesment;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

class Runner {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        PrintIntegerParallelService printIntegerParallelService = new PrintIntegerParallelService(list);
        printIntegerParallelService.invoke();
    }
}

public class PrintIntegerParallelService extends RecursiveAction {

    private List<Integer> list;

    public PrintIntegerParallelService(List<Integer> list){
        this.list = list;
    }

    @Override
    protected void compute() {
        if(list.size() > 2){
            //System.out.println("Parallel Tasks to print Integer with list size :: "+list.size()+"    list val :: "+list);
            PrintIntegerParallelService printIntegerParallelService1 = new PrintIntegerParallelService(list.subList(0, list.size()/2));
            PrintIntegerParallelService printIntegerParallelService2 = new PrintIntegerParallelService(list.subList((list.size()/2) , list.size()));

            invokeAll(printIntegerParallelService1,printIntegerParallelService2);
        }
        else{
            System.out.println("Sequential task to print integer with list size :: "+list);
        }
        System.out.println();

    }
}
