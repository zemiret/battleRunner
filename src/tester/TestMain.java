package tester;

import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Test main");


        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }
}
