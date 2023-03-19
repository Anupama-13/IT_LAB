import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener
{
    private Integer r,res;
    int op;
    TextField t=new TextField("0",25);
    Button b1=new Button("1");
    Button b2=new Button("2");
    Button b3=new Button("3");
    Button b4=new Button("4");
    Button b5=new Button("5");
    Button b6=new Button("6");
    Button b7=new Button("7");
    Button b8=new Button("8");
    Button b9=new Button("9");
    Button b0=new Button("0");
    Button b10=new Button("+");
    Button b11=new Button("-");
    Button b12=new Button("/");
    Button b13=new Button("x");
    Button b14=new Button("=");
    Button b15=new Button("clear");
    public Calculator()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new GridLayout(6,6));
        add(b1);add(b2);add(b3);add(b4);add(b5);
        add(b6);add(b7);add(b8);add(b9);add(b0);
        add(b10);add(b11);add(b12);add(b13);add(b14);add(b15);
        add(t);
        b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
        b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
        b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
        b9.addActionListener(this);b10.addActionListener(this);b11.addActionListener(this);
        b12.addActionListener(this);b13.addActionListener(this);b14.addActionListener(this);b15.addActionListener(this);
        r=0;
    }
    public void actionPerformed(ActionEvent e)
    {
        String v=e.getActionCommand();
        if(v.equals("0")){
            r=Integer.parseInt(r.toString()+"0");
            t.setText(r.toString());
        }
        else if(v.equals("1")){
            r=Integer.parseInt(r.toString()+"1");
            t.setText(r.toString());
        }
        else if(v.equals("2")){
            r=Integer.parseInt(r.toString()+"2");
            t.setText(r.toString());
        }
        else if(v.equals("3")){
            r=Integer.parseInt(r.toString()+"3");
            t.setText(r.toString());
        }
        else if(v.equals("4")){
            r=Integer.parseInt(r.toString()+"4");
            t.setText(r.toString());
        }
        else if(v.equals("5")){
            r=Integer.parseInt(r.toString()+"5");
            t.setText(r.toString());
        }
        else if(v.equals("6")){
            r=Integer.parseInt(r.toString()+"6");
            t.setText(r.toString());
        }
        else if(v.equals("7")){
            r=Integer.parseInt(r.toString()+"7");
            t.setText(r.toString());
        }
        else if(v.equals("8")){
            r=Integer.parseInt(r.toString()+"8");
            t.setText(r.toString());
        }
        else if(v.equals("9")){
            r=Integer.parseInt(r.toString()+"9");
            t.setText(r.toString());
        }
        else if(v.equals("+")){
            res=r;r=0;
            t.setText("0");
            op=0;
        }
        else if(v.equals("-")){
            res=r;r=0;
            t.setText("0");
            op=1;
        }
        else if(v.equals("x")){
            res=r;r=0;
            t.setText("0");
            op=2;
        }
        else if(v.equals("/")){
            res=r;r=0;
            t.setText("0");
            op=3;
        }
        else if(v.equals("="))
        {
            r=Integer.parseInt(t.getText());
            if(op==0)
                r=res+r;
            else if(op==1)
                r=res-r;
            else if (op==2)
                r=res*r;
            else if(op==3)
            {
                if(r!=0)
                    r=res/r;
                else{
                    //String t1="error";
                    //t.setText(t1);
                    System.out.print("ERROR");
                }
            }
            t.setText(r.toString());
        }
        else if(v.equals("clear"))
        {
            r=0;
            t.setText(r.toString());
        }
    }
    public static void main(String args[])
    {
        Calculator c=new Calculator();
    }



}