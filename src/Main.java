/**
 * Created by salamon on 11.07.18.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(JsonParser.ANSI_GREEN + "Ну что же поищем финал!!!");
        boolean networkAvailable = true;
        while(true) {
            try {
                NetworkHelper.getRequest();
                if(!networkAvailable) {
                   networkAvailable = true;
                   System.out.println(JsonParser.ANSI_GREEN + "Соединение с фифой востановленно!!!");
                }
            } catch (Exception e) {
                if(networkAvailable) {
                    System.err.println("Проблемы с сетью ");
                }
                networkAvailable = false;
            }
            Thread.sleep(3000);
        }
    }
}
