import sun.rmi.runtime.Log;

/**
 * Created by Clanner on 2016/10/18.
 */
public class Test {
    public static void main(String[] args) {
        Clanner clanner = Clanner.getClanner();
        clanner.say();
        clanner.test();
    }

    public static class Clanner implements TestImp{

        private void say() {
            System.out.println("Hello World");
        }

        public static Clanner getClanner() {
            return SingleManager.clanner;
        }

        @Override
        public void test() {
            System.out.print(i);
        }

        @Override
        public void test2() {

        }

        public static class SingleManager {
            private static final Clanner clanner = new Clanner();
        }
    }
}
