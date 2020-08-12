// 
// Decompiled by Procyon v0.5.36
// 

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import calculator.BasePriceCalculator;
import factory.PriceCalculatorFactory;
import model.Chitanta;
import model.Cumparator;
import model.Factura;
import model.Furnizor;
import model.Seria;
import service.ChitantaManagementService;
import service.FacturaManagementService;
import service.impl.ChitantaManagementServiceImpl;
import service.impl.FacturaManagementServiceImpl;

public class Controller {

	private View view;

	private final ChitantaManagementService chitantaService = new ChitantaManagementServiceImpl();

	private final FacturaManagementService facturaService = new FacturaManagementServiceImpl();

	private final PriceCalculatorFactory priceCalculatorFactory = new PriceCalculatorFactory();

	public Controller(final View v) {
		this.view = v;
		this.view.getExport().addActionListener(new Exporter());
	}

	class Exporter implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent arg0) {
			try {
				final Document document = new Document(PageSize.A4);
				final int facturanr = facturaService.getFacturaNr();
				facturaService.updateFacturaNr();
				PdfWriter.getInstance(document, new FileOutputStream("factura_nr_" + facturanr + ".pdf"));
				document.open();
				final Furnizor furnizor = new Furnizor();
				final String furnizorData = furnizor.toString();
				Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, 0, BaseColor.BLACK);
				document.add(new Paragraph(furnizorData, f));
				final String cumpName = view.getCumparatorF().getText();
				final String nrOrdReg = view.getNrOrdRegF().getText();
				final String cui = view.getCuiF().getText();
				final String sediu = view.getSediuF().getText();
				final String judet = view.getJudetF().getText();
				final String codIban = view.getIbanF().getText();
				final String banca = view.getBancaF().getText();
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
				final String services = view.getNumeServicii();
				final String um = view.getUM();
				final String masaName = view.getNumeMasa();
				final String masaUm = view.getMasaUM();
				final float tva = view.getTvaValue();
				final Paragraph p = new Paragraph("COTA T.V.A. :  " + tva + "%");
				p.setSpacingBefore(110.0f);
				document.add(p);
				final Factura factura = new Factura(services, masaName, um, masaUm,
						priceCalculatorFactory.getPriceCalculator(view),
						new BasePriceCalculator(view.getMasaServitaTotal(), 5f, view.getMasaQuantity()));
				document.add(factura.getUpperTable());
				document.add(factura.getLowerTable());
				if (view.isChitantaSelected()) {
					createChitanta(cumparator, document, facturanr, seriaData);
				}
				document.close();
			} catch (FileNotFoundException | DocumentException ex2) {
				JOptionPane.showMessageDialog(view, "Close the open PDF before operating");
			}
		}

		private void createChitanta(Cumparator cumparator, Document document, Integer facturanr, String seriaData) throws DocumentException {
			Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, 0, BaseColor.BLACK);
			final int chitantanr = chitantaService.getChitantaNr();
			chitantaService.updateChitantaNr();
			document.add(
					new Paragraph("______________________________________________________________________________"));
			final Chitanta chitanta = new Chitanta(cumparator, view.getBaseTotal() + view.getMasaServitaTotal(),
					chitantanr, facturanr, view.getDataF().getText());
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
			document.add(
					new Paragraph("______________________________________________________________________________"));
		}
	}

}
