import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game extends JPanel implements ActionListener, KeyListener {

    Random random = new Random();
    ImageIcon harshitImage = new ImageIcon("./Images/harshit.png");
    ImageIcon gameOver = new ImageIcon("./Images/gameOver.png");
    //cloud icons
    ImageIcon cloud1 = new ImageIcon("./Images/cloud1.png");
    ImageIcon cloud2 = new ImageIcon("./Images/cloud2.png");
    ImageIcon cloud3 = new ImageIcon("./Images/cloud3.png");
    ImageIcon cloud4 = new ImageIcon("./Images/cloud4.png");

    //cactus images
    ImageIcon catt = new ImageIcon("./Images/catt.png");
    ImageIcon catw = new ImageIcon("./Images/catw.png");
    JLabel harshit;
    JLabel gameOverLabel;
    JLabel cloudLabel1;
    JLabel cloudLabel2;
    JLabel cloudLabel3;
    JLabel cloudLabel4;

    //cactus labels
    JLabel catt1;
    JLabel catt2;
    JLabel catw1;
    JLabel catw2;
    JPanel grassPanel;
    JPanel grassLabel;
    Timer timer;
    int x, speed, points, pointIncrement, pointX, prevDig;

    boolean play=false, jumpUP=false, jumpDOWN=false, doubleJump=true;

    Game(){
        this.setFocusable(true);
        this.setBackground(new Color(50,150,250));
        this.setLayout(null);
        this.addKeyListener(this);

        timer = new Timer(30,this);

        grassPanel = new JPanel();
        grassPanel.setBackground(new Color(50,5,6));
        grassPanel.setBounds(0,430,1100,50);

        grassLabel = new JPanel();
        grassLabel.setBackground(new Color(10,80,30));
        grassLabel.setBounds(0,430,1100,10);

        harshit = new JLabel();
        harshit.setIcon(harshitImage);

        //gameOver
        gameOverLabel = new JLabel();
        gameOverLabel.setIcon(gameOver);

        //setting the clouds
        cloudLabel1  = new JLabel();
        cloudLabel2 = new JLabel();
        cloudLabel3 = new JLabel();
        cloudLabel4 = new JLabel();

        cloudLabel1.setIcon(cloud1);
        cloudLabel2.setIcon(cloud2);
        cloudLabel3.setIcon(cloud3);
        cloudLabel4.setIcon(cloud4);

        //setting up cactus
        catt1 = new JLabel();
        catt2 = new JLabel();
        catw1 = new JLabel();
        catw2 = new JLabel();

        catt1.setIcon(catt);
        catt2.setIcon(catt);
        catw1.setIcon(catw);
        catw2.setIcon(catw);

        defaultValues();

        this.add(gameOverLabel);
        this.add(catt1);
        this.add(catt2);
        this.add(catw1);
        this.add(catw2);
        this.add(cloudLabel4);
        this.add(cloudLabel1);
        this.add(cloudLabel2);
        this.add(cloudLabel3);
        this.add(grassLabel);
        this.add(grassPanel);
        this.add(harshit);

    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.white);
        g2d.setFont(new Font(null,Font.BOLD,30));
        g2d.drawString(""+points,pointX,50);

        if(!play){
            g2d.setFont(new Font(null,Font.BOLD,12));
            g2d.drawString("Use SPACE to Start Game",430,50);
            g2d.drawString("Use SPACE to Jump",450,80);
            g2d.drawString("Use SPACE mid-air to Double Jump",400,110);
        }

        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(harshit.getY()>193&&jumpUP){
            harshit.setBounds(120,harshit.getY()-6,60,80);
            if(harshit.getY()==193) {
                jumpDOWN=true;
                jumpUP=false;
            }
        }
        else if(harshit.getY()<355&&jumpDOWN){
            harshit.setBounds(120,harshit.getY()+6,60,80);
            if(harshit.getY()==355){
                jumpDOWN=false;
                doubleJump=true;
            }
        }


        // moving the clouds
        //cloud1
        if(cloudLabel1.getX()>-140){
            cloudLabel1.setBounds(cloudLabel1.getX()-3,cloudLabel1.getY(),cloud1.getIconWidth(),cloud1.getIconHeight());
        }else{
            cloudLabel1.setBounds(random.nextInt(1600,2000),random.nextInt(0,150),cloud1.getIconWidth(),cloud1.getIconHeight());
        }

        //cloud2
        if(cloudLabel2.getX()>-140){
            cloudLabel2.setBounds(cloudLabel2.getX()-1,cloudLabel2.getY(),cloud2.getIconWidth(),cloud2.getIconHeight());
        }else{
            cloudLabel2.setBounds(random.nextInt(1000,1200),random.nextInt(50,200),cloud2.getIconWidth(),cloud2.getIconHeight());
        }

        //cloud3
        if(cloudLabel3.getX()>-140){
            cloudLabel3.setBounds(cloudLabel3.getX()-1,cloudLabel3.getY(),cloud3.getIconWidth(),cloud3.getIconHeight());
        }else{
            cloudLabel3.setBounds(random.nextInt(1300,1600),random.nextInt(20,170),cloud3.getIconWidth(),cloud3.getIconHeight());
        }

        //cloud4
        if(cloudLabel4.getX()>-140){
            cloudLabel4.setBounds(cloudLabel4.getX()-3,cloudLabel4.getY(),cloud4.getIconWidth(),cloud4.getIconHeight());
        }else{
            cloudLabel4.setBounds(random.nextInt(1800,2500),random.nextInt(0,150),cloud4.getIconWidth(),cloud4.getIconHeight());
        }


        // for moving cactus
        if(catt1.getX()>=-100){
            catt1.setBounds(catt1.getX()-speed,catt1.getY(),catt1.getWidth(),catt1.getHeight());
        }else {
            x=random.nextInt(1000,1400);
            catt1.setBounds(x,catt1.getY(),catt1.getWidth(),catt1.getHeight());
        }

        if(catt2.getX()>=-100){
            catt2.setBounds(catt2.getX()-speed,catt2.getY(),catt2.getWidth(),catt2.getHeight());
        }else {
            x=x+random.nextInt(50,150);
            catt2.setBounds(x,catt2.getY(),catt2.getWidth(),catt2.getHeight());
        }

        if(catw1.getX()>=-100){
            catw1.setBounds(catw1.getX()-speed,catw1.getY(),catw1.getWidth(),catw1.getHeight());
        }else {
            x=x+random.nextInt(50,150);
            catw1.setBounds(x+random.nextInt(200,500),catw1.getY(),catw1.getWidth(),catw1.getHeight());
        }

        if(catw2.getX()>=-100){
            catw2.setBounds(catw2.getX()-speed,catw2.getY(),catw2.getWidth(),catw2.getHeight());
        }else {
            x=x+random.nextInt(50,150);
            catw2.setBounds(x+random.nextInt(200,500),catw2.getY(),catw2.getWidth(),catw2.getHeight());
        }

        //points
        points+=pointIncrement;
        if((int)Math.log10(points)+1>prevDig) {
            prevDig = (int) Math.log10(points) + 1;
            pointX -= 20;
            speed += 3;
            pointIncrement *= 5;
        }

        //losing case
        if(new Rectangle(catt1.getX(),catt1.getY(),catt1.getWidth()-10,catt1.getHeight()-5).intersects(new Rectangle(harshit.getX(),harshit.getY(),harshit.getWidth(),harshit.getHeight()))){
            lost();
        }
        if(new Rectangle(catt2.getX(),catt2.getY(),catt2.getWidth()-10,catt2.getHeight()-5).intersects(new Rectangle(harshit.getX(),harshit.getY(),harshit.getWidth(),harshit.getHeight()))){
            lost();
        }
        if(new Rectangle(catw1.getX(),catw1.getY(),catw1.getWidth(),catw1.getHeight()).intersects(new Rectangle(harshit.getX(),harshit.getY(),harshit.getWidth(),harshit.getHeight()))){
            lost();
        }
        if(new Rectangle(catw2.getX(),catw2.getY(),catw2.getWidth(),catw2.getHeight()).intersects(new Rectangle(harshit.getX(),harshit.getY(),harshit.getWidth(),harshit.getHeight()))){
            lost();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!play&&e.getKeyCode()==32){
            play=true;
            defaultValues();
            timer.start();
        }
        else {
            if (e.getKeyCode() == 32 && !jumpDOWN) {
                jumpUP = true;
            } else if (e.getKeyCode() == 32 && jumpDOWN && doubleJump) {
                doubleJump = false;
                jumpUP = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    void defaultValues(){
        harshit.setBounds(120,355,60,80);
        gameOverLabel.setBounds(0,0,0,0);

        //clouds
        cloudLabel1.setBounds(random.nextInt(1200,1400),random.nextInt(0,150),cloud1.getIconWidth(),cloud1.getIconHeight());
        cloudLabel2.setBounds(1000,random.nextInt(50,150),cloud2.getIconWidth(),cloud2.getIconHeight());
        cloudLabel3.setBounds(1300,random.nextInt(20,170),cloud3.getIconWidth(),cloud3.getIconHeight());
        cloudLabel4.setBounds(random.nextInt(1800,2400),random.nextInt(0,150),cloud4.getIconWidth(),cloud4.getIconHeight());

        catt1.setBounds(450,375,30,55);
        catt2.setBounds(750,375,30,55);
        catw1.setBounds(1250,390,40,40);
        catw2.setBounds(780,390,40,40);

        points=0;
        speed=6;
        pointIncrement=2;
        prevDig=3;
        pointX=920;

        jumpUP=false;
        jumpDOWN=false;
        doubleJump=true;
    }

    void lost(){
        play=false;
        timer.stop();
        harshit.setBounds(0,0,0,0);
        gameOverLabel.setBounds(300,200,400,300);
    }
}
