 public class CurrencyBean
 {
    float usc,canc,ausc;
    public CurrencyBean()
    {
    }
    public void setUSC(float usc)
    {
        this.usc=usc;
        //System.out.println("IN US Currency --->"+(usc/40));
    }
    public void setCANC(float canc)
    {
        this.canc=canc;
        //System.out.println("IN CANADA Currency --->"+(canc/35));
    }
    public void setAUSC(float ausc)
    {
        this.ausc=ausc;
        //System.out.println("IN  AUSTRALIAN Currency --->"+(ausc/30));
    }
    public float getUSC()
    {
        return usc/40;    
    }
    public float getCANC()
    {
        return canc/35;    
    }
    public float getAUSC()
    {
        return ausc/30;    
    }
 }