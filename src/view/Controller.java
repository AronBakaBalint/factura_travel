// 
// Decompiled by Procyon v0.5.36
// 

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Chitanta;
import model.Cumparator;
import model.Factura;
import model.Furnizor;
import model.Seria;

public class Controller {
	private View view;

	public Controller(final View v) {
		this.view = v;
		this.view.getExport().addActionListener(new Exporter());
	}

	private String[] getServicesFromTable() {
		final String[] services = new String[7];
		for (int i = 0; i < 7; ++i) {
			try {
				services[i] = this.view.getTable().getValueAt(i, 0).toString();
			} catch (Exception ex) {
			}
		}
		return services;
	}

	private int getLength() {
		for (int i = 0; i < 7; ++i) {
			try {
				this.view.getTable().getValueAt(i, 0).toString();
			} catch (Exception e) {
				return i;
			}
		}
		return 7;
	}

	private String[] getUMFromTable() {
		final String[] ums = new String[7];
		for (int i = 0; i < 7; ++i) {
			try {
				ums[i] = this.view.getTable().getValueAt(i, 1).toString();
			} catch (Exception ex) {
			}
		}
		return ums;
	}

	private int[] getQuantityFromTable() {
		final int[] quantities = new int[7];
		for (int i = 0; i < 7; ++i) {
			try {
				quantities[i] = Integer.parseInt(this.view.getTable().getValueAt(i, 2).toString());
			} catch (Exception ex) {
			}
		}
		return quantities;
	}

	private float[] getPricesFromTable() {
		final float[] prices = new float[7];
		for (int i = 0; i < 7; ++i) {
			try {
				prices[i] = Float.parseFloat(this.view.getTable().getValueAt(i, 3).toString());
			} catch (Exception ex) {
			}
		}
		return prices;
	}

	private int getAndUpdateChitanta() {
		int nr = 0;
		try {
			final FileReader fileReader = new FileReader("chitantanr.txt");
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
			final String line = bufferedReader.readLine();
			bufferedReader.close();
			nr = Integer.parseInt(line);
			final FileWriter fileWriter = new FileWriter("chitantanr.txt");
			final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(new StringBuilder(String.valueOf(nr + 1)).toString());
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return nr;
	}

	private int getAndUpdateFactura() {
		int nr = 0;
		try {
			final FileReader fileReader = new FileReader("facturanr.txt");
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
			final String line = bufferedReader.readLine();
			bufferedReader.close();
			nr = Integer.parseInt(line);
			final FileWriter fileWriter = new FileWriter("facturanr.txt");
			final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(new StringBuilder(String.valueOf(nr + 1)).toString());
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return nr;
	}

	private float getTVA() {
		return Float.parseFloat(
				this.view.getTvaF().getText().replaceAll("COTA TVA", "").replaceAll("%", "").replaceAll(" ", ""));
	}

	class Exporter implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent arg0) {
			try {
				final Document document = new Document(PageSize.A4);
				final int facturanr = Controller.this.getAndUpdateFactura();
				PdfWriter.getInstance(document, new FileOutputStream("factura_nr_" + facturanr + ".pdf"));
				document.open();
				final Furnizor furnizor = new Furnizor();
				final String furnizorData = furnizor.toString();
				Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, 0, BaseColor.BLACK);
				document.add(new Paragraph(furnizorData, f));
				final String cumpName = Controller.this.view.getCumparatorF().getText();
				final String nrOrdReg = Controller.this.view.getNrOrdRegF().getText();
				final String cui = Controller.this.view.getCuiF().getText();
				final String sediu = Controller.this.view.getSediuF().getText();
				final String judet = Controller.this.view.getJudetF().getText();
				final String codIban = Controller.this.view.getIbanF().getText();
				final String banca = Controller.this.view.getBancaF().getText();
				final Cumparator cumparator = new Cumparator(cumpName, nrOrdReg, cui, sediu, judet, codIban, banca);
				final String cumparatorData = cumparator.toString();
				f = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, 0, BaseColor.BLACK);
				final Paragraph cumparatorP = new Paragraph(cumparatorData, f);
				cumparatorP.setSpacingBefore(-150.0f);
				document.add(cumparatorP);
				f = new Font(Font.FontFamily.TIMES_ROMAN, 24.0f, 1, BaseColor.BLACK);
				final Paragraph titleP = new Paragraph(
						"                                                              FACTURA FISCALA");
				titleP.setSpacingBefore(-100.0f);
				document.add(titleP);
				final Seria seria = new Seria("UN  " + facturanr, view.getDataF().getText());
				f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, 0, BaseColor.BLACK);
				final String seriaText = seria.getSeria();
				final String seriaData = seria.getData();
				final Paragraph seriaP = new Paragraph(seriaText, f);
				final Paragraph seriaDataP = new Paragraph(seriaData, f);
				seriaP.setSpacingBefore(30.0f);
				document.add(seriaP);
				document.add(seriaDataP);
				final String[] services = Controller.this.getServicesFromTable();
				final String[] ums = Controller.this.getUMFromTable();
				final int[] quantities = Controller.this.getQuantityFromTable();
				final float[] prices = Controller.this.getPricesFromTable();
				final float tva = Controller.this.getTVA();
				final Paragraph p = new Paragraph("COTA T.V.A. :  " + tva + "%");
				p.setSpacingBefore(110.0f);
				document.add(p);
				final Factura factura = new Factura(services, ums, quantities, prices, tva, Controller.this.getLength(),
						Controller.this.view.getOnePercent().isSelected());
				document.add(factura.getUpperTable());
				document.add(factura.getLowerTable());
				if (Controller.this.view.getChitantaB().isSelected()) {
					f = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, 0, BaseColor.BLACK);
					final int chitantanr = Controller.this.getAndUpdateChitanta();
					document.add(new Paragraph(
							"______________________________________________________________________________"));
					final Chitanta chitanta = new Chitanta(cumparator, quantities[0], prices[0], tva, chitantanr,
							facturanr, view.getOnePercent().isSelected(), view.getDataF().getText());
					final Paragraph p2 = new Paragraph(chitanta.getVanzator(), f);
					p2.setSpacingAfter(20.0f);
					p2.setSpacingBefore(5.0f);
					document.add(p2);
					final Paragraph p3 = new Paragraph(
							"                                                                                   CHITANTA");
					p3.setSpacingBefore(-80.0f);
					document.add(p3);
					final Paragraph p4 = new Paragraph(
							"                                                                                                                                                                                             Nr.   "
									+ chitantanr,
							f);
					p4.setSpacingAfter(10.0f);
					p4.setSpacingBefore(-20.0f);
					document.add(p4);
					final Paragraph p5 = new Paragraph(
							"                                                                                                    "
									+ seriaData,
							f);
					p5.setSpacingAfter(50.0f);
					document.add(p5);
					final Paragraph p6 = new Paragraph(chitanta.getCumparator(), f);
					document.add(p6);
					document.add(new Paragraph(
							"______________________________________________________________________________"));
				}
				document.close();
			} catch (FileNotFoundException | DocumentException ex2) {
				JOptionPane.showMessageDialog(Controller.this.view, "Close the open PDF before operating");
			}
		}
	}
}
