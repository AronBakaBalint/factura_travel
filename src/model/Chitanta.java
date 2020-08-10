// 
// Decompiled by Procyon v0.5.36
// 

package model;

import converter.Converter;

public class Chitanta
{
    private String furnizor;
    private String nrOrdReg;
    private String cui;
    private String capitalSocial;
    private String sediu;
    private String judet;
    private String punctDeLucru;
    private String codIbanRon;
    private int chitantanr;
    private int facturanr;
    private Cumparator cumparator;
    private int quantity;
    private float price;
    private float tva;
    private boolean onePercent;
    private String date;
    
    public Chitanta(Cumparator cumparator, int quantity, float price, float tva, int chitantanr, int facturanr,  boolean onePercent, String date) {
        this.furnizor = "UNITARIUS TRAVEL SRL";
        this.nrOrdReg = "J12/1420/2011";
        this.cui = "RO28545849";
        this.capitalSocial = "200 lei";
        this.sediu = "COM COJOCNA\nSTR MIHAI EMINESCU NR6";
        this.judet = "CLUJ";
        this.punctDeLucru = "CLUJ-NAPOCA\nBLD. 21 DEC. 1989 NR 14";
        this.codIbanRon = "RO20OTPV200000407248RO01";
        this.cumparator = cumparator;
        this.quantity = quantity;
        this.price = price;
        this.tva = tva;
        this.chitantanr = chitantanr;
        this.facturanr = facturanr;
        this.onePercent = onePercent;
        this.date = date;
    }
    
    @Override
    public String toString() {
        String txt = "";
        txt = String.valueOf(txt) + this.furnizor + "\n";
        txt = String.valueOf(txt) + "Nr. Ord. Reg: " + this.nrOrdReg + "                                                                                                                                          Nr.  " + this.chitantanr + "\n";
        txt = String.valueOf(txt) + "CUI: " + this.cui + "\n";
        txt = String.valueOf(txt) + "Capital social: " + this.capitalSocial + "                                                                                                                                                     _____________________________________\n";
        txt = String.valueOf(txt) + "Sediu: " + this.sediu + "\n";
        txt = String.valueOf(txt) + "Judet: " + this.judet + "\n";
        txt = String.valueOf(txt) + "PUNCT DE LUCRU: " + this.punctDeLucru + "                                                                                                                                            _____________________________________\n";
        txt = String.valueOf(txt) + "COD IBAN RON: " + this.codIbanRon + "\n";
        return txt;
    }
    
    public String getVanzator() {
        return this.toString();
    }
    
    public String getCumparator() {
        String txt = "";
        txt = String.valueOf(txt) + "Am primit de la   " + this.cumparator.getCumparator() + "\n";
        txt = String.valueOf(txt) + "Nr RC:                    CIF:  " + this.cumparator.getCui() + "\n";
        try {
            txt = String.valueOf(txt) + "Adresa:  " + this.cumparator.getSediu().substring(this.cumparator.getSediu().indexOf("\n") + 1);
        }
        catch (Exception e) {
            txt = String.valueOf(txt) + "Adresa: " + this.cumparator.getSediu();
        }
        txt = String.valueOf(txt) + "            Judetul  " + this.cumparator.getJudet() + "\n";
        float suma;
        if (!this.onePercent) {
            suma = this.quantity * this.price * (1.0f + this.tva / 100.0f);
        }
        else {
            suma = this.quantity * this.price * (1.0f + this.tva / 100.0f + 0.01f);
        }
        if (suma - Math.floor(suma) > 0.95) {
            suma = (float)Math.round(suma);
        }
        if (suma == Math.floor(suma)) {
            txt = String.valueOf(txt) + "Suma de:  " + suma * 100.0f / 100.0f + "              adica:  " + Converter.number2String((int)Math.floor(suma)) + "lei\n";
        }
        else {
            txt = String.valueOf(txt) + "Suma de:  " + String.format("%.2f", suma) + "              adica:  " + Converter.number2String((int)Math.floor(suma));
            txt = String.valueOf(txt) + "leisi";
            txt = String.valueOf(txt) + Converter.number2String(Math.round(suma * 100.0f % 100.0f)) + "bani\n";
        }
        txt = String.valueOf(txt) + "reprezentand:  CV FACT " + this.facturanr + "/" + date + "                                                                                             Casier,";
        return txt;
    }
}
