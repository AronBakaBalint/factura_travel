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
	private JCheckBox chitantaB = new JCheckBox("Chitanta");
	private JCheckBox onePercent = new JCheckBox("1%");
	private JCheckBox masaServita = new JCheckBox("Masa servita");
	private JButton export = new JButton("Generare");
	private JTable table;

	public View() {
		setSize(700, 540);
		setLayout(null);
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		setDefaultCloseOperation(3);
		final Border border = BorderFactory.createLineBorder(new Color(145, 145, 145));
		sediuF.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		cumparatorL.setBounds(40, 20, 80, 20);
		cumparatorF.setBounds(140, 20, 180, 20);
		add(cumparatorL);
		add(cumparatorF);
		nrOrdRegL.setBounds(40, 45, 80, 20);
		nrOrdRegF.setBounds(140, 45, 180, 20);
		add(nrOrdRegL);
		add(nrOrdRegF);
		cuiL.setBounds(40, 70, 80, 20);
		cuiF.setBounds(140, 70, 180, 20);
		add(cuiL);
		add(cuiF);
		sediuL.setBounds(40, 105, 80, 20);
		sediuF.setBounds(140, 105, 180, 40);
		add(sediuL);
		add(sediuF);
		judetL.setBounds(40, 160, 80, 20);
		judetF.setBounds(140, 160, 180, 20);
		add(judetL);
		add(judetF);
		ibanL.setBounds(40, 185, 80, 20);
		ibanF.setBounds(140, 185, 180, 20);
		add(ibanL);
		add(ibanF);
		bancaL.setBounds(40, 210, 80, 20);
		bancaF.setBounds(140, 210, 180, 20);
		add(bancaL);
		add(bancaF);
		tvaF.setBounds(40, 260, 100, 20);
		add(tvaF);
		dataL.setBounds(160, 260, 100, 20);
		add(dataL);
		dataF.setBounds(220, 260, 100, 20);
		add(dataF);
		onePercent.setBounds(140, 380, 100, 20);
		add(onePercent);
		chitantaB.setBounds(240, 380, 100, 20);
		add(chitantaB);
		masaServita.setBounds(340, 380, 100, 20);
		add(masaServita);
		export.setBounds(260, 420, 100, 20);
		add(export);
		final String[] header = { "Denumirea produselor sau a serviciilor", "U.M.", "Cantitate", "Pret Total (lei)" };
		final String[][] body = new String[2][4];
		(table = new JTable(body, header)).setPreferredScrollableViewportSize(new Dimension(1100, 100));
		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 300, 600, 55);
		table.getColumnModel().getColumn(1).setMaxWidth(70);
		table.getColumnModel().getColumn(2).setMaxWidth(70);
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		add(scrollPane);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		dataF.setText(now.format(dtf)); 
	}
	
	public Float getBaseTotal() {
		return Float.parseFloat(table.getValueAt(0, 3).toString());
	}
	
	public String getNumeServicii() {
		return table.getValueAt(0, 0).toString();
	}
	
	public String getUM() {
		return table.getValueAt(0, 1).toString();
	}
	
	public Integer getQuantity() {
		return Integer.parseInt(table.getValueAt(0, 2).toString());
	}
	
	public String getNumeMasa() {
		try{
			return table.getValueAt(1, 0).toString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public Float getMasaServitaTotal() {
		try{
			return Float.parseFloat(table.getValueAt(1, 3).toString());
		} catch(Exception e) {
			return 0.0f;
		}
	}
	
	public String getMasaUM() {
		try {
			return table.getValueAt(1, 1).toString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public Integer getMasaQuantity() {
		try{
			return Integer.parseInt(table.getValueAt(1, 2).toString());
		} catch(Exception e) {
			return 0;
		}
	}
	
	public boolean isMasaServitaSelected() {
		return masaServita.isSelected();
	}
	
	public boolean isChitantaSelected() {
		return chitantaB.isSelected();
	}
	
	public boolean isOnePercentSelected() {
		return onePercent.isSelected();
	}
	
	public Float getTvaValue() {
		return Float.parseFloat(
				tvaF.getText().replaceAll("COTA TVA", "").replaceAll("%", "").replaceAll(" ", ""));
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
		return cumparatorF;
	}

	public void setCumparatorF(final JTextField cumparatorF) {
		this.cumparatorF = cumparatorF;
	}

	public JLabel getCumparatorL() {
		return cumparatorL;
	}

	public void setCumparatorL(final JLabel cumparatorL) {
		this.cumparatorL = cumparatorL;
	}

	public JTextField getNrOrdRegF() {
		return nrOrdRegF;
	}

	public void setNrOrdRegF(final JTextField nrOrdRegF) {
		this.nrOrdRegF = nrOrdRegF;
	}

	public JLabel getNrOrdRegL() {
		return nrOrdRegL;
	}

	public void setNrOrdRegL(final JLabel nrOrdRegL) {
		this.nrOrdRegL = nrOrdRegL;
	}

	public JTextField getCuiF() {
		return cuiF;
	}

	public void setCuiF(final JTextField cuiF) {
		this.cuiF = cuiF;
	}

	public JLabel getCuiL() {
		return cuiL;
	}

	public void setCuiL(final JLabel cuiL) {
		this.cuiL = cuiL;
	}

	public JTextArea getSediuF() {
		return sediuF;
	}

	public void setSediuF(final JTextArea sediuF) {
		this.sediuF = sediuF;
	}

	public JLabel getSediuL() {
		return sediuL;
	}

	public void setSediuL(final JLabel sediuL) {
		this.sediuL = sediuL;
	}

	public JTextField getJudetF() {
		return judetF;
	}

	public void setJudetF(final JTextField judetF) {
		this.judetF = judetF;
	}

	public JLabel getJudetL() {
		return judetL;
	}

	public void setJudetL(final JLabel judetL) {
		this.judetL = judetL;
	}

	public JLabel getIbanL() {
		return ibanL;
	}

	public void setIbanL(final JLabel ibanL) {
		this.ibanL = ibanL;
	}

	public JTextField getIbanF() {
		return ibanF;
	}

	public void setIbanF(final JTextField ibanF) {
		this.ibanF = ibanF;
	}

	public JLabel getBancaL() {
		return bancaL;
	}

	public void setBancaL(final JLabel bancaL) {
		this.bancaL = bancaL;
	}

	public JTextField getBancaF() {
		return bancaF;
	}

	public void setBancaF(final JTextField bancaF) {
		this.bancaF = bancaF;
	}

	public JTextField getTvaF() {
		return tvaF;
	}

	public void setTvaF(final JTextField tvaF) {
		this.tvaF = tvaF;
	}

	public JCheckBox getChitantaB() {
		return chitantaB;
	}

	public void setChitantaB(final JCheckBox chitantaB) {
		this.chitantaB = chitantaB;
	}

	public JButton getExport() {
		return export;
	}

	public void setExport(final JButton export) {
		this.export = export;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(final JTable table) {
		this.table = table;
	}

	public JCheckBox getOnePercent() {
		return onePercent;
	}

	public void setOnePercent(final JCheckBox onePercent) {
		this.onePercent = onePercent;
	}
	
	public JCheckBox getMasaServita() {
		return masaServita;
	}

	public void setMasaServita(JCheckBox masaServita) {
		this.masaServita = masaServita;
	}	
	
}
