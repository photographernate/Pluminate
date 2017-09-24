/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandcontrols;

/**
 *
 * @author ECE 590 Team 2
 */
public class BandMember {
    
    private String _instrumentType;
    private int _instrumentNumber;
    private String _xbeeMac;
    private String _ledColor;
    private int _ledTimer;
    
    public BandMember(String type, int num, String xbeeMac)
    {
        this._instrumentNumber = num;
        this._instrumentType = type;
        this._xbeeMac = xbeeMac;
    }
  
    public String getLedColor()
    {
        return _ledColor;
    }
    
    public void setLedColor(String color)
    {
        this._ledColor = color;
    }
    
    public int getLedTime()
    {
        return _ledTimer;
    }
    
    public void setLedTimer(int time)
    {
        this._ledTimer = time;
    }
    
    public String getZigbeeID()
    {
        return _xbeeMac;
    }
    
    public void getZigbeeID(String _xbeeMac)
    {
        this._xbeeMac = _xbeeMac;
    }
    
    /**
     * Builds a string representation of a band member object.
     * @return 
     */
    public String toString()
    {
        return this._instrumentType + ", " +  Integer.toString(this._instrumentNumber) + ", " + this._xbeeMac;
    }
}
