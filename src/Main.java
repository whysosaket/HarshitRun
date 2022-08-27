import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        ImageIcon gameOver = new ImageIcon("./Images/gameOver.png");

        JFrame frame = new JFrame("Harshit Run");
        frame.setDefaultCloseOperation(3);
        frame.setSize(1000,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(gameOver.getImage());

        Game game = new Game();

        frame.add(game);
        frame.setVisible(true);
    }
}
