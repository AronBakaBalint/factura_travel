// 
// Decompiled by Procyon v0.5.36
// 

package model;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

public class Factura
{
    private String[] numeProdusSauServicii;
    private String[] um;
    private int[] cantitate;
    private float[] pretUnitar;
    private float tva;
    private int length;
    private boolean onePercent;
    
    public Factura(final String[] numeProdusSauServicii, final String[] um, final int[] cantitate, final float[] pretUnitar, final float tva, final int len, final boolean onePercent) {
        this.numeProdusSauServicii = new String[15];
        this.numeProdusSauServicii = numeProdusSauServicii;
        this.um = um;
        this.cantitate = cantitate;
        this.pretUnitar = pretUnitar;
        this.tva = tva;
        this.length = len;
        this.onePercent = onePercent;
    }
    
    public Factura() {
        this.numeProdusSauServicii = new String[15];
    }
    
    public PdfPTable getUpperTable() {
        final PdfPTable table = new PdfPTable(new float[] { 2.1f, 10.0f, 3.0f, 6.0f, 6.0f, 6.0f, 4.375f });
        table.setLockedWidth(true);
        table.setTotalWidth(520.0f);
        table.setSpacingBefore(10.0f);
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, 1, BaseColor.BLACK);
        PdfPCell cell = new PdfPCell(new Phrase("Nr.\nCrt.", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Denumirea produselor sau a serviciilor", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("U.M.", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cantitatea", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Pret Unitar f.\nTVA-lei", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Valoarea\n-lei-", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Valoare\n T.V.A\n-lei-", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        if (!this.onePercent) {
            f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, 0, BaseColor.BLACK);
            for (int i = 0; i < this.length; ++i) {
                for (int j = 0; j < 7; ++j) {
                    switch (j) {
                        case 0: {
                            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(i + 1)).toString(), f));
                            cell.setRowspan(2);
                            break;
                        }
                        case 1: {
                            cell = new PdfPCell(new Phrase(String.valueOf(this.numeProdusSauServicii[i]) + "\n\n\nTermen de plata:   5 zile", f));
                            break;
                        }
                        case 2: {
                            cell = new PdfPCell(new Phrase(this.um[i], f));
                            break;
                        }
                        case 3: {
                            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(this.cantitate[i])).toString(), f));
                            break;
                        }
                        case 4: {
                            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(this.pretUnitar[i])).toString(), f));
                            break;
                        }
                        case 5: {
                            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(this.pretUnitar[i] * this.cantitate[i])).toString(), f));
                            break;
                        }
                        case 6: {
                            cell = new PdfPCell(new Phrase(String.format("%.2f", this.pretUnitar[i] * this.cantitate[i] * this.tva / 100.0f), f));
                            break;
                        }
                    }
                    cell.setFixedHeight(70.0f);
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                }
            }
        }
        else {
            f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, 0, BaseColor.BLACK);
            for (int i = 0; i < this.length; ++i) {
                for (int j = 0; j < 7; ++j) {
                    switch (j) {
                        case 0: {
                            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(i + 1)).toString(), f));
                            cell.setRowspan(2);
                            break;
                        }
                        case 1: {
                            cell = new PdfPCell(new Phrase(String.valueOf(this.numeProdusSauServicii[i]) + "\n\nTaxa turism 1%\n" + "\n\nTermen de plata:   5 zile", f));
                            break;
                        }
                        case 2: {
                            cell = new PdfPCell(new Phrase(this.um[i], f));
                            break;
                        }
                        case 3: {
                            cell = new PdfPCell(new Phrase(String.valueOf(this.cantitate[i]) + "\n\n1", f));
                            break;
                        }
                        case 4: {
                            cell = new PdfPCell(new Phrase(String.valueOf(this.pretUnitar[i]) + "\n\n" + this.pretUnitar[i] * this.cantitate[i] / 100.0f, f));
                            break;
                        }
                        case 5: {
                            cell = new PdfPCell(new Phrase(String.valueOf(this.pretUnitar[i] * this.cantitate[i]) + "\n\n" + this.pretUnitar[i] * this.cantitate[i] / 100.0f, f));
                            break;
                        }
                        case 6: {
                            cell = new PdfPCell(new Phrase(String.valueOf(String.format("%.2f", this.pretUnitar[i] * this.cantitate[i] * this.tva / 100.0f)) + "\n\n-", f));
                            break;
                        }
                    }
                    cell.setFixedHeight(70.0f);
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
                }
            }
        }
        cell = new PdfPCell(new Phrase("Factura valabila fara semnatura si stampila cf. art. V, alin (2) din Ordonanta nr 17/2015 si art. 319 alin (29) din Legea nr. 227/2015 privind Codul fiscal", f));
        cell.setColspan(6);
        table.addCell(cell);
        return table;
    }
    
    public PdfPTable getLowerTable() {
        final PdfPTable table = new PdfPTable(new float[] { 1.0f, 1.41f, 0.685f, 0.685f, 0.5f });
        table.setLockedWidth(true);
        table.setTotalWidth(520.0f);
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 9.0f, 0, BaseColor.BLACK);
        PdfPCell cell = new PdfPCell(new Phrase("Semnatura si stampila\nfurnizorului", f));
        cell.setRowspan(2);
        cell.setHorizontalAlignment(1);
        cell.setFixedHeight(100.0f);
        table.addCell(cell);
        String txt = "";
        txt = String.valueOf(txt) + "Date privind expeditia:\n";
        txt = String.valueOf(txt) + "Numele delegatului ....................................\n....................................................................\n";
        txt = String.valueOf(txt) + "Buletinul/cartea de identitate\n";
        txt = String.valueOf(txt) + "seria ........ nr ............ eliberat(a) ................\n";
        txt = String.valueOf(txt) + "la data de ......................... ora ....................\n";
        txt = String.valueOf(txt) + "Semnaturile ................................................";
        cell = new PdfPCell(new Phrase(txt, f));
        cell.setLeading(13.0f, 0.0f);
        cell.setRowspan(2);
        cell.setFixedHeight(100.0f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("TOTAL", f));
        cell.setFixedHeight(40.0f);
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        table.addCell(cell);
        if (!this.onePercent) {
            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(this.pretUnitar[0] * this.cantitate[0])).toString(), f));
        }
        else {
            cell = new PdfPCell(new Phrase(new StringBuilder(String.valueOf(this.pretUnitar[0] * this.cantitate[0] + this.pretUnitar[0] * this.cantitate[0] / 100.0f)).toString(), f));
        }
        cell.setFixedHeight(40.0f);
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(String.format("%.2f", this.pretUnitar[0] * this.cantitate[0] * this.tva / 100.0f), f));
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        cell.setFixedHeight(40.0f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Semnatura\nde primire", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        f = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, 1, BaseColor.BLACK);
        if (!this.onePercent) {
            cell = new PdfPCell(new Phrase(String.format("%.2f", this.pretUnitar[0] * this.cantitate[0] * (1.0f + this.tva / 100.0f)), f));
        }
        else {
            cell = new PdfPCell(new Phrase(String.format("%.2f", this.pretUnitar[0] * this.cantitate[0] * (1.0f + this.tva / 100.0f) + this.pretUnitar[0] * this.cantitate[0] / 100.0f), f));
        }
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        cell.setColspan(2);
        table.addCell(cell);
        table.setSpacingAfter(40.0f);
        return table;
    }
}
