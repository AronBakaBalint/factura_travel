// 
// Decompiled by Procyon v0.5.36
// 

package model;

public class Seria
{
    private String seriaSiNr;
    private String data;
    
    public Seria(final String seriaSiNr, String data) {
        this.data = data;
        this.seriaSiNr = seriaSiNr;
    }
    
    public String getSeria() {
        return "                                                                                         Seria si Nr.:  " + this.seriaSiNr;
    }
    
    public String getData() {
        return "                                                                                         Data:  " + this.data;
    }
}
