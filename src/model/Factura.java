// 
// Decompiled by Procyon v0.5.36
// 

package model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import calculator.PriceCalculator;

public class Factura
{
    private String numeProdusSauServicii;
    private String um;
    private int cantitate;
    private float pretTotal;
    private PriceCalculator priceCalculator;
    
    public Factura(final String numeProdusSauServicii, final String um, final int cantitate, final float pretTotal, final int len, PriceCalculator priceCalculator) {
        this.numeProdusSauServicii = numeProdusSauServicii;
        this.um = um;
        this.cantitate = cantitate;
        this.pretTotal = pretTotal;
        this.priceCalculator = priceCalculator;
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
        
            f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, 0, BaseColor.BLACK);
                for (int j = 0; j < 7; ++j) {
                    switch (j) {
                        case 0: {
                            cell = new PdfPCell(new Phrase(1+"", f));
                            cell.setRowspan(2);
                            break;
                        }
                        case 1: {
                            cell = new PdfPCell(new Phrase(this.numeProdusSauServicii + priceCalculator.getNumeProduse(), f));
                            break;
                        }
                        case 2: {
                            cell = new PdfPCell(new Phrase(this.um, f));
                            break;
                        }
                        case 3: {
                            cell = new PdfPCell(new Phrase(priceCalculator.getQuantity(), f));
                            break;
                        }
                        case 4: {
                            cell = new PdfPCell(new Phrase(priceCalculator.getUnitPrice(), f));
                            break;
                        }
                        case 5: {
                            cell = new PdfPCell(new Phrase(priceCalculator.getPriceWithoutTVA(), f));
                            break;
                        }
                        case 6: {
                            cell = new PdfPCell(new Phrase(priceCalculator.getTVA(), f));
                            break;
                        }
                    }
                    cell.setFixedHeight(70.0f);
                    cell.setHorizontalAlignment(1);
                    table.addCell(cell);
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
        cell = new PdfPCell(new Phrase(priceCalculator.getTotalWithoutTVA()+"", f));
        cell.setFixedHeight(40.0f);
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(priceCalculator.getTVA().replace("-", "").trim(), f));
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        cell.setFixedHeight(40.0f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Semnatura\nde primire", f));
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        f = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, 1, BaseColor.BLACK);
        cell = new PdfPCell(new Phrase(pretTotal+"", f));
        cell.setHorizontalAlignment(1);
        cell.setVerticalAlignment(5);
        cell.setColspan(2);
        table.addCell(cell);
        table.setSpacingAfter(40.0f);
        return table;
    }
}
