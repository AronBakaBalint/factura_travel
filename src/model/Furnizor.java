// 
// Decompiled by Procyon v0.5.36
// 

package model;

public class Furnizor
{
    private String furnizor;
    private String nrOrdReg;
    private String cui;
    private String capitalSocial;
    private String sediu;
    private String judet;
    private String punctDeLucru;
    private String codIbanRon;
    private String codIbanEur;
    private String banca;
    
    public Furnizor() {
        this.furnizor = "UNITARIUS TRAVEL SRL";
        this.nrOrdReg = "J12/1420/2011";
        this.cui = "RO28545849";
        this.capitalSocial = "200 lei";
        this.sediu = "COM COJOCNA\nSTR MIHAI EMINESCU NR6";
        this.judet = "CLUJ";
        this.punctDeLucru = "CLUJ-NAPOCA\nBLD. 21 DEC. 1989 NR 14";
        this.codIbanRon = "RO20OTPV200000407248RO01";
        this.codIbanEur = "RO06OTPV2000004072480003";
        this.banca = "OTP";
    }
    
    @Override
    public String toString() {
        String txt = "";
        txt = String.valueOf(txt) + this.furnizor + "\n";
        txt = String.valueOf(txt) + "Nr. Ord. Reg: " + this.nrOrdReg + "\n";
        txt = String.valueOf(txt) + "CUI: " + this.cui + "\n";
        txt = String.valueOf(txt) + "Capital social: " + this.capitalSocial + "\n";
        txt = String.valueOf(txt) + "Sediu: " + this.sediu + "\n";
        txt = String.valueOf(txt) + "Judet: " + this.judet + "\n";
        txt = String.valueOf(txt) + "PUNCT DE LUCRU: " + this.punctDeLucru + "\n";
        txt = String.valueOf(txt) + "COD IBAN RON: " + this.codIbanRon + "\n";
        txt = String.valueOf(txt) + "COD IBAN EUR: " + this.codIbanEur + "\n";
        txt = String.valueOf(txt) + "Banca: " + this.banca;
        return txt;
    }
}
