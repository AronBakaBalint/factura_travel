// 
// Decompiled by Procyon v0.5.36
// 

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class View extends JFrame {
	private JTextField cumparatorF = new JTextField("");
	private JLabel cumparatorL = new JLabel("Cumparator: ");
	private JTextField nrOrdRegF = new JTextField("");
	private JLabel nrOrdRegL = new JLabel("Nr. Ord. Reg:");
	private JTextField cuiF = new JTextField("");
	private JLabel cuiL = new JLabel("CUI:");
	private JTextArea sediuF = new JTextArea("");
	private JLabel sediuL = new JLabel("Sediul:");
	private JTextField judetF = new JTextField("");
	private JLabel judetL = new JLabel("Judetul:");
	private JLabel ibanL = new JLabel("Cod IBAN:");
	private JTextField ibanF = new JTextField("");
	private JLabel bancaL = new JLabel("Banca:");
	private JTextField bancaF = new JTextField("");
	private JTextField tvaF = new JTextField("COTA TVA    5%");
	private JLabel dataL = new JLabel("Data:");
	private JTextField dataF = new JTextField(new Date().toString());
	private JCheckBox chitantaB = new JCheckBox("Chitanta");;
	private JCheckBox onePercent = new JCheckBox("1%");;
	private JButton export = new JButton("Generare");
	private JTable table;

	public View() {
		this.setSize(700, 540);
		this.setLayout(null);
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(3);
		final Border border = BorderFactory.createLineBorder(new Color(145, 145, 145));
		this.sediuF.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		this.cumparatorL.setBounds(40, 20, 80, 20);
		this.cumparatorF.setBounds(140, 20, 180, 20);
		this.add(this.cumparatorL);
		this.add(this.cumparatorF);
		this.nrOrdRegL.setBounds(40, 45, 80, 20);
		this.nrOrdRegF.setBounds(140, 45, 180, 20);
		this.add(this.nrOrdRegL);
		this.add(this.nrOrdRegF);
		this.cuiL.setBounds(40, 70, 80, 20);
		this.cuiF.setBounds(140, 70, 180, 20);
		this.add(this.cuiL);
		this.add(this.cuiF);
		this.sediuL.setBounds(40, 105, 80, 20);
		this.sediuF.setBounds(140, 105, 180, 40);
		this.add(this.sediuL);
		this.add(this.sediuF);
		this.judetL.setBounds(40, 160, 80, 20);
		this.judetF.setBounds(140, 160, 180, 20);
		this.add(this.judetL);
		this.add(this.judetF);
		this.ibanL.setBounds(40, 185, 80, 20);
		this.ibanF.setBounds(140, 185, 180, 20);
		this.add(this.ibanL);
		this.add(this.ibanF);
		this.bancaL.setBounds(40, 210, 80, 20);
		this.bancaF.setBounds(140, 210, 180, 20);
		this.add(this.bancaL);
		this.add(this.bancaF);
		this.tvaF.setBounds(40, 260, 100, 20);
		this.add(this.tvaF);
		this.dataL.setBounds(160, 260, 100, 20);
		this.add(dataL);
		this.dataF.setBounds(220, 260, 100, 20);
		this.add(dataF);
		this.onePercent.setBounds(140, 380, 120, 20);
		this.add(this.onePercent);
		this.chitantaB.setBounds(140, 420, 120, 20);
		this.add(this.chitantaB);
		this.export.setBounds(260, 420, 100, 20);
		this.add(this.export);
		final String[] header = { "Denumirea produselor sau a serviciilor", "U.M.", "Cantitate", "Pret Unitar (lei)" };
		final String[][] body = new String[1][4];
		(this.table = new JTable(body, header)).setPreferredScrollableViewportSize(new Dimension(1100, 100));
		final JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setBounds(40, 300, 600, 40);
		this.table.getColumnModel().getColumn(1).setMaxWidth(70);
		this.table.getColumnModel().getColumn(2).setMaxWidth(70);
		this.table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		this.add(scrollPane);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		dataF.setText(now.format(dtf)); 
	}
	
	

	public JLabel getDataL() {
		return dataL;
	}



	public void setDataL(JLabel dataL) {
		this.dataL = dataL;
	}



	public JTextField getDataF() {
		return dataF;
	}



	public void setDataF(JTextField dataF) {
		this.dataF = dataF;
	}



	public JTextField getCumparatorF() {
		return this.cumparatorF;
	}

	public void setCumparatorF(final JTextField cumparatorF) {
		this.cumparatorF = cumparatorF;
	}

	public JLabel getCumparatorL() {
		return this.cumparatorL;
	}

	public void setCumparatorL(final JLabel cumparatorL) {
		this.cumparatorL = cumparatorL;
	}

	public JTextField getNrOrdRegF() {
		return this.nrOrdRegF;
	}

	public void setNrOrdRegF(final JTextField nrOrdRegF) {
		this.nrOrdRegF = nrOrdRegF;
	}

	public JLabel getNrOrdRegL() {
		return this.nrOrdRegL;
	}

	public void setNrOrdRegL(final JLabel nrOrdRegL) {
		this.nrOrdRegL = nrOrdRegL;
	}

	public JTextField getCuiF() {
		return this.cuiF;
	}

	public void setCuiF(final JTextField cuiF) {
		this.cuiF = cuiF;
	}

	public JLabel getCuiL() {
		return this.cuiL;
	}

	public void setCuiL(final JLabel cuiL) {
		this.cuiL = cuiL;
	}

	public JTextArea getSediuF() {
		return this.sediuF;
	}

	public void setSediuF(final JTextArea sediuF) {
		this.sediuF = sediuF;
	}

	public JLabel getSediuL() {
		return this.sediuL;
	}

	public void setSediuL(final JLabel sediuL) {
		this.sediuL = sediuL;
	}

	public JTextField getJudetF() {
		return this.judetF;
	}

	public void setJudetF(final JTextField judetF) {
		this.judetF = judetF;
	}

	public JLabel getJudetL() {
		return this.judetL;
	}

	public void setJudetL(final JLabel judetL) {
		this.judetL = judetL;
	}

	public JLabel getIbanL() {
		return this.ibanL;
	}

	public void setIbanL(final JLabel ibanL) {
		this.ibanL = ibanL;
	}

	public JTextField getIbanF() {
		return this.ibanF;
	}

	public void setIbanF(final JTextField ibanF) {
		this.ibanF = ibanF;
	}

	public JLabel getBancaL() {
		return this.bancaL;
	}

	public void setBancaL(final JLabel bancaL) {
		this.bancaL = bancaL;
	}

	public JTextField getBancaF() {
		return this.bancaF;
	}

	public void setBancaF(final JTextField bancaF) {
		this.bancaF = bancaF;
	}

	public JTextField getTvaF() {
		return this.tvaF;
	}

	public void setTvaF(final JTextField tvaF) {
		this.tvaF = tvaF;
	}

	public JCheckBox getChitantaB() {
		return this.chitantaB;
	}

	public void setChitantaB(final JCheckBox chitantaB) {
		this.chitantaB = chitantaB;
	}

	public JButton getExport() {
		return this.export;
	}

	public void setExport(final JButton export) {
		this.export = export;
	}

	public JTable getTable() {
		return this.table;
	}

	public void setTable(final JTable table) {
		this.table = table;
	}

	public JCheckBox getOnePercent() {
		return this.onePercent;
	}

	public void setOnePercent(final JCheckBox onePercent) {
		this.onePercent = onePercent;
	}
}
