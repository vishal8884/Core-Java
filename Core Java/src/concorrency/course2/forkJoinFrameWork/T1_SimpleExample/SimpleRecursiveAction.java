package concorrency.course2.forkJoinFrameWork.T1_SimpleExample;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    int simulateWork;

    public SimpleRecursiveAction(int simulateWork){
        this.simulateWork = simulateWork;
    }

    @Override
    protected void compute() {

        if(simulateWork > 100){
            System.out.println("parallel execution and split the tasks :: "+simulateWork);
            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulateWork/2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulateWork/2);

            invokeAll(action1,action2);

            //same as
//            action1.fork();
//            action2.fork();
//
//            action1.join();
//            action2.join();
        }
        else{
            System.out.println("sequential tasks");
        }
    }
}
