// 
// Decompiled by Procyon v0.5.36
// 

package model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import calculator.BasePriceCalculator;
import calculator.PriceCalculator;

public class Factura {
	private String numeProdusSauServicii;
	private String um;
	private String numeMasa;
	private String masaUm;
	private PriceCalculator priceCalculator;
	private PriceCalculator masaServitaCalculator;

	public Factura(String numeProdusSauServicii, String numeMasa, String um, String masaUm, PriceCalculator priceCalculator, PriceCalculator masaServitaCalculator) {
		this.numeProdusSauServicii = numeProdusSauServicii;
		this.um = um;
		this.priceCalculator = priceCalculator;
		this.masaServitaCalculator = masaServitaCalculator;
		this.numeMasa = numeMasa;
		this.masaUm = masaUm;
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
				cell = new PdfPCell(new Phrase(1 + "", f));
				cell.setRowspan(2);
				break;
			}
			case 1: {
				cell = new PdfPCell(new Phrase(this.numeProdusSauServicii + priceCalculator.getNumeProduse() + "\n" + numeMasa, f));
				break;
			}
			case 2: {
				if(priceCalculator instanceof BasePriceCalculator) {
					cell = new PdfPCell(new Phrase(this.um + "\n\n" + masaUm, f));
				} else {
					cell = new PdfPCell(new Phrase(this.um + "\n\n\n\n" + masaUm, f));
				}
				break;
			}
			case 3: {
				cell = new PdfPCell(new Phrase(priceCalculator.getQuantity() + "\n\n" + masaServitaCalculator.getQuantity(), f));
				break;
			}
			case 4: {
				cell = new PdfPCell(new Phrase(priceCalculator.getUnitPrice() + "\n\n" + masaServitaCalculator.getUnitPrice() , f));
				break;
			}
			case 5: {
				String masaServitaPrice = masaServitaCalculator.getPriceWithoutTVA();
				if(masaServitaPrice.equals("0")) {
					cell = new PdfPCell(new Phrase(priceCalculator.getPriceWithoutTVA() + "\n\n", f));
				} else {
					cell = new PdfPCell(new Phrase(priceCalculator.getPriceWithoutTVA() + "\n\n" + masaServitaPrice, f));
				}
				break;
			}
			case 6: {
				String masaServitaTVA = masaServitaCalculator.getTVA();
				if(masaServitaTVA.equals("0")) {
					cell = new PdfPCell(new Phrase(priceCalculator.getTVA() + "\n\n", f));
				} else {
					cell = new PdfPCell(new Phrase(priceCalculator.getTVA() + "\n\n" + masaServitaTVA, f));
				}
				
				break;
			}
			}
			cell.setFixedHeight(70.0f);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);
		}

		cell = new PdfPCell(new Phrase(
				"Factura valabila fara semnatura si stampila cf. art. V, alin (2) din Ordonanta nr 17/2015 si art. 319 alin (29) din Legea nr. 227/2015 privind Codul fiscal. \nTermen de plata 5 zile, dupa care se percep penalizari de 0,1% pe zi.", f));
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
		txt = String.valueOf(txt)
				+ "Numele delegatului ....................................\n....................................................................\n";
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
		cell = new PdfPCell(new Phrase(String.format(PriceCalculator.FORMAT_MODE, Float.parseFloat(priceCalculator.getTotalWithoutTVA().replace(",", ".")) + Float.parseFloat(masaServitaCalculator.getTotalWithoutTVA().replace(",", "."))), f));
		cell.setFixedHeight(40.0f);
		cell.setHorizontalAlignment(1);
		cell.setVerticalAlignment(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(String.format(PriceCalculator.FORMAT_MODE, Float.parseFloat(priceCalculator.getTVA().replace("-", "").replace(",", ".").trim()) + Float.parseFloat(masaServitaCalculator.getTVA().replace("-", "").replace(",", ".").trim())), f));
		cell.setHorizontalAlignment(1);
		cell.setVerticalAlignment(5);
		cell.setFixedHeight(40.0f);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Semnatura\nde primire", f));
		cell.setHorizontalAlignment(1);
		table.addCell(cell);
		f = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, 1, BaseColor.BLACK);
		cell = new PdfPCell(new Phrase(priceCalculator.getTotalPrice() + masaServitaCalculator.getTotalPrice() + "", f));
		cell.setHorizontalAlignment(1);
		cell.setVerticalAlignment(5);
		cell.setColspan(2);
		table.addCell(cell);
		table.setSpacingAfter(40.0f);
		return table;
	}
}
