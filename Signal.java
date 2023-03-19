import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.Serializable;
public class Signal extends Frame implements MouseListener
{
    private Color col=Color.red;
    Choice sgen=new Choice();
    Label l1=new Label("Ready");
    public Signal()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new FlowLayout());
        add(l1);
        this.addMouseListener(this);
    }
    public void mousePressed(MouseEvent me)
    {
        Color c;
        if(col==Color.red)
        {
            c=Color.yellow;
            l1.setText("Ready");
        }
        else if(col==Color.yellow)
        {
            c=Color.green;
            l1.setText("Move");
        }
        else if(col==Color.green)
        {
            c=Color.red;
            l1.setText("Stopped");
        }
        else
        {
            c=Color.red;
            l1.setText("Stopped");
        }
        setCol(c);
        repaint();
    }
    public void mouseEntered(MouseEvent me)
    {

    }
    public void mouseExited(MouseEvent me)
    {

    }
    public void mouseReleased(MouseEvent me)
    {

    }
    public void mouseClicked(MouseEvent me)
    {

    }
    public void setCol(Color c)
    {
        col=c;
        repaint();
    }
    public Color getCol()
    {
        return col;
    }
    public void paint(Graphics g)
    {
        System.out.println(col.toString());
        g.setColor(col);
        g.fillOval(50,50,100,100);
    }
    public static void main(String[] args)
    {
        Signal c=new Signal();
    }
}

