import java.awt.*;
import java.awt.event.*;
public class Currency extends Frame implements ActionListener
 {
    TextField t1,t2,t3,t4;
    Label l1,l2,l3;
    public Currency()
    {
        setSize(400,400);
        setVisible(true);
        Button b=new Button("Convert");
        setLayout(new GridLayout(4,2));
        t1=new TextField("0",5);
        t2=new TextField("0",5);
        t3=new TextField("0",5);
        t4=new TextField("0",15);
        l1=new Label("ENter rupees to convert into US");
        l2=new Label("ENter rupees to convert into CAN");
        l3=new Label("ENter rupees to convert into AUS");
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b);add(t4);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            float us,can,aus;
            us=Float.parseFloat(t1.getText());
            can=Float.parseFloat(t2.getText());
            aus=Float.parseFloat(t3.getText());
            CurrencyBean cb=new CurrencyBean();
            cb.setUSC(us);
            cb.setCANC(can);
            cb.setAUSC(aus);
            String usans=Float.toString(cb.getUSC());
            String canans=Float.toString(cb.getCANC());
            String ausans=Float.toString(cb.getAUSC());
            t4.setText(" US :" +usans+ "  CAN :  "+canans+"  AUS :   "+ausans);
        }
        catch(Exception err)
        {
            System.out.print(err);
        }

    }
    public static void main(String args[])
    {
        Currency c=new Currency();
    }

 }