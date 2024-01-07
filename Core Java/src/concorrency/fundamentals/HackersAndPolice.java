package concorrency.fundamentals;

import java.util.stream.IntStream;

public class HackersAndPolice {
    private static final int MAX = 9999;

    public static void main(String[] args) {
        Thread hackerThreadAsc = new Thread(() -> {
            IntStream.range(0,MAX);
        });

        Thread hackerThreadDsc = new Thread(() -> {

        });
    }
}


class Vault {
    private String password;

    public Vault(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

