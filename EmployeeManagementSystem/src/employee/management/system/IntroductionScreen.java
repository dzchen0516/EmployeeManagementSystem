package employee.management.system;

import javax.swing.*;

public class IntroductionScreen extends JFrame {
    IntroductionScreen() {
        RawIconConverter splashImg = new RawIconConverter(0,0,1170, 650, "icons/front.gif");
        add(splashImg.convertIcons());

        setSize(1170, 650);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);

        //hide the introduction screen after 5000 ms
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new IntroductionScreen();
    }
}
