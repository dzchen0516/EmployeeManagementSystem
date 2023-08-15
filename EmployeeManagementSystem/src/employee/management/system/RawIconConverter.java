package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class RawIconConverter {
    private int x;
    private int y;
    private int width;
    private int height;
    private String iconPath;
    JLabel iconImg;

    RawIconConverter(int x, int y, int width, int height, String iconPath)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.iconPath = iconPath;
    }

    JLabel convertIcons()
    {
        //convert gif to image and then convert it to JLabel so that we can add to the window
        ImageIcon rawIcon = new ImageIcon(ClassLoader.getSystemResource(iconPath));
        Image scaledRawIcon = rawIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon iconImgIcon = new ImageIcon(scaledRawIcon);
        iconImg = new JLabel(iconImgIcon);
        iconImg.setBounds(x,y,width,height);
        return iconImg;
    }

    public JLabel getIconImg() {
        return iconImg;
    }

}
