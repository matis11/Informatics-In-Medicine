import inout.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Piotr on 2017-03-03.
 */
public class main {
    public static BufferedImage copyImg(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public static JFrame initGui() {
        img Image = new img("C:\\Users\\Piotr\\image.png");
        tomograph tom = new tomograph(Image);
        int[] coords = tom.getCoords();
        int w = Image.getWidth();
        BufferedImage first1 = copyImg(Image.getImage());
        BufferedImage sin = copyImg(Image.getImage());
        ImageIcon first = new ImageIcon(first1);
        int h = Image.getHeight();
        BufferedImage temp = Image.getImage();
        Graphics2D rect = temp.createGraphics();
        rect.setColor(Color.RED);
        rect.drawRect(coords[0] - 1, coords[1] - 1, coords[2] - coords[0] + 2, coords[3] - coords[1] + 2);
        rect.dispose();
        ImageIcon second = new ImageIcon(temp);
        JLabel panel = new JLabel(first);
        JLabel panel2 = new JLabel(second);
        JLabel mid = new JLabel(new ImageIcon(sin));
        JPanel br = new JPanel();
        JButton b1 = new JButton("- step");
        JButton b2 = new JButton("+ step");
        JButton b3 = new JButton("- detectors");
        JButton b4 = new JButton("+ detectors");
        JButton b5 = new JButton("- angle width");
        JButton b6 = new JButton("+ angle width");
        b1.setPreferredSize(new Dimension(150, 35));
        b2.setPreferredSize(new Dimension(150, 35));
        b3.setPreferredSize(new Dimension(150, 35));
        b4.setPreferredSize(new Dimension(150, 35));
        b5.setPreferredSize(new Dimension(150, 35));
        b6.setPreferredSize(new Dimension(150, 35));
        br.add(b1);
        br.add(b2);
        br.add(b3);
        br.add(b4);
        br.add(b5);
        br.add(b6);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(br, BorderLayout.BEFORE_FIRST_LINE);
        frame.getContentPane().add(panel, BorderLayout.WEST);
        frame.getContentPane().add(mid, BorderLayout.CENTER);
        frame.getContentPane().add(panel2, BorderLayout.EAST);
        frame.pack();
        return frame;
    }

    public static void main(String[] args) {
        JFrame frame = initGui();
        frame.setVisible(true);
    }
}
