package concorrency.ThreadCooridintion.ref;

public class powerCalc {
    public static void main(String[] args) {

        long pow = getPow(2, 4);
        System.out.println("pow :: "+pow);
    }

    public static long getPow(int num,int pow){
        int numBackup = num;

        for(int i=0;i<pow-1;i++){
            System.out.println("i :: "+i+"   num :: "+num);
            num = num * numBackup;
        }

        return num;
    }
}

//2 * 2 * 2 * 2
