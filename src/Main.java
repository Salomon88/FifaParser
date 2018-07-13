import javax.swing.*;

/**
 * Created by salamon on 11.07.18.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*JFrame f= new JFrame();
        JTextArea area=new JTextArea("Welcome to FifaParser");
        area.setBounds(10,30, 350,350);
        f.add(area);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);*/

        while(true) {
            try {
                NetworkHelper.getRequest();
            } catch (Exception e) {
                System.err.println("Проблемы с сетью ");
                e.printStackTrace();
            }
            Thread.sleep(3000);
            Runtime.getRuntime().exec("echo 123");
        }
    }
}
