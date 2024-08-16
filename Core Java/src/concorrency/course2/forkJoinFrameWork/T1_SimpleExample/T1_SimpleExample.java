package concorrency.course2.forkJoinFrameWork.T1_SimpleExample;

import java.util.concurrent.ForkJoinPool;

public class T1_SimpleExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(600);
        simpleRecursiveAction.invoke();
    }
}
