// 
// Decompiled by Procyon v0.5.36
// 

package model;

public class Cumparator
{
    private String cumparator;
    private String nrOrdReg;
    private String cui;
    private String sediu;
    private String judet;
    private String codIban;
    private String banca;
    
    public Cumparator(final String cumparator, final String nrOrdReg, final String cui, final String sediu, final String judet, final String codIban, final String banca) {
        this.cumparator = cumparator;
        this.nrOrdReg = nrOrdReg;
        this.cui = cui;
        this.sediu = sediu;
        this.judet = judet;
        this.codIban = codIban;
        this.banca = banca;
    }
    
    @Override
    public String toString() {
        String txt = "";
        txt = String.valueOf(txt) + "                                                                                                                                                                                        Cumparator: " + this.cumparator + "\n";
        txt = String.valueOf(txt) + "                                                                                                                                                                                         Nr. Ord. Reg:" + this.nrOrdReg + "\n";
        txt = String.valueOf(txt) + "                                                                                                                                                                                          CUI: " + this.cui + "\n";
        try {
            txt = String.valueOf(txt) + "                                                                                                                                                                                          Sediu: " + this.sediu.substring(0, this.sediu.indexOf("\n")) + "\n";
            txt = String.valueOf(txt) + "                                                                                                                                                                                          " + this.sediu.substring(this.sediu.indexOf("\n")).replaceAll("\n", "") + "\n";
        }
        catch (Exception e) {
            txt = String.valueOf(txt) + "                                                                                                                                                                                          Sediu: " + this.sediu + "\n";
        }
        txt = String.valueOf(txt) + "                                                                                                                                                                                          Judet: " + this.judet + "\n";
        txt = String.valueOf(txt) + "                                                                                                                                                                                          COD IBAN: " + this.codIban + "\n";
        txt = String.valueOf(txt) + "                                                                                                                                                                                          Banca: " + this.banca;
        return txt;
    }
    
    public String getCumparator() {
        return this.cumparator;
    }
    
    public void setCumparator(final String cumparator) {
        this.cumparator = cumparator;
    }
    
    public String getNrOrdReg() {
        return this.nrOrdReg;
    }
    
    public void setNrOrdReg(final String nrOrdReg) {
        this.nrOrdReg = nrOrdReg;
    }
    
    public String getCui() {
        return this.cui;
    }
    
    public void setCui(final String cui) {
        this.cui = cui;
    }
    
    public String getSediu() {
        return this.sediu;
    }
    
    public void setSediu(final String sediu) {
        this.sediu = sediu;
    }
    
    public String getJudet() {
        return this.judet;
    }
    
    public void setJudet(final String judet) {
        this.judet = judet;
    }
    
    public String getCodIban() {
        return this.codIban;
    }
    
    public void setCodIban(final String codIban) {
        this.codIban = codIban;
    }
    
    public String getBanca() {
        return this.banca;
    }
    
    public void setBanca(final String banca) {
        this.banca = banca;
    }
}
