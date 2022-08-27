import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrassPanel extends JPanel implements ActionListener {

    Timer timer;
    GrassPanel(){
        this.setBackground(new Color(50,5,6));
        this.setBounds(0,440,1100,50);

        timer = new Timer(30,this);
    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
