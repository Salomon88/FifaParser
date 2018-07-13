/**
 * Created by salamon on 11.07.18.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        while(true) {
            try {
                NetworkHelper.getRequest();
            } catch (Exception e) {
                System.err.println("Проблемы с сетью ");
                e.printStackTrace();
            }
            Thread.sleep(3000);
        }
    }
}
