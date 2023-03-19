import java.awt.*;
import java.awt.event.*;
public class Click extends Frame implements MouseListener
{
    Label l;
    TextField t;
    private Integer count=0;
    public Click()
    {
        l=new Label("click ME");
        t=new TextField("0",10);
        setLayout(new FlowLayout());
        add(l);
        add(t);
        l.addMouseListener(this);
        setSize(300,200);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent me)
    {
        count=count+1;
        t.setText(count.toString());
    }
    public void mousePressed(MouseEvent me)
    {

    } 
    public void mouseReleased(MouseEvent me)
    {

    }
    public void mouseEntered(MouseEvent me)
    {

    }
    public void mouseExited(MouseEvent me)
    {

    }
    public static void main(String args[])throws Exception
    {
        Click c=new Click();
    }
}

