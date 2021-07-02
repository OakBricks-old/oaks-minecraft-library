package oak.oakapi.etc;

public class CrashServer {

    //this is very simple

    public static void crashServer() {

        throw new RuntimeException();

    }

    public static void crashServerWithWarn() {

        System.out.println("OAKAPI HAS CRASHED THIS GAME, THIS IS INTENTIONAL DON'T REPORT THIS TO THE MOD DEV");

        throw new RuntimeException();

    }

}
