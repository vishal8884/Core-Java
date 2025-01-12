    package demo1;

    import java.util.*;
    import java.util.concurrent.TimeUnit;
    import java.util.stream.IntStream;

    public class RussianRoullete {

        public static void main(String[] args) {
            Set<Integer> visited = new HashSet<>();

            IntStream.range(0,5).forEach(elem -> {
                if(shoot(0,5,visited)){
                    System.out.println("Died in round :: "+elem);
                    throw new RuntimeException("Breaking as its died");
                }
                else{
                    System.out.println("You survived in round :: "+elem);
                }
                delay(1000);
            });
        }



        public static boolean shoot(int origin,int bound,Set<Integer> visited){
            boolean[] arr= {false,false,false,true,false,false};
            Random random = new Random();

            int pos = random.nextInt(origin, bound);


            while(visited.contains(pos)){
                pos = random.nextInt(origin, bound);
            }

            visited.add(pos);

            return arr[pos];
        }


        private static void delay(int ms) {
            try {
                TimeUnit.MILLISECONDS.sleep(ms);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
