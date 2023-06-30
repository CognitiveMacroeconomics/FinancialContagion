

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
public class FrameDatabaseManager {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="-6,-4"
	private JPanel jContentPane = null;
	private JButton jButton_timeSeries = null;
	private JButton jButton_balanceSheet = null;
	private JLabel jLabel_startDate = null;
	private JComboBox jComboBox_startDate = null;
	private JLabel jLabel_endDate = null;
	private JComboBox jComboBox_endDate = null;
	private JLabel jLabel_bank = null;
	private JComboBox jComboBox_banks = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel_balanceSheet = null;
	private JLabel jLabel_variable = null;
	private JComboBox jComboBox_variables = null;
	private JPanel jPanel_plot = null;
	private JPanel jPanel_data = null;
	private JScrollPane jScrollPane_balanceSheet_Assets = null;
	private JScrollPane jScrollPane_balanceSheet_Liabilities = null;
	private JTable jTable_balanceSheet_Assets = null;
	private JTable jTable_balanceSheet_Liabilities = null;
	private JButton jButton_loadData = null;
	private JScrollPane jScrollPane_data = null;
	private JTable jTable_data = null;
	private JButton jButton_reset = null;
	private JTextArea jTextArea_description = null;
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(804, 640));
			jFrame.setTitle("Database Manager");
			jFrame.setPreferredSize(new Dimension(804, 640));
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_variable = new JLabel();
			jLabel_variable.setBounds(new Rectangle(44, 163, 60, 17));
			jLabel_variable.setText("Variable:");
			jLabel_variable.setVisible(false);
			jLabel_bank = new JLabel();
			jLabel_bank.setBounds(new Rectangle(44, 119, 59, 19));
			jLabel_bank.setText("Bank:");
			jLabel_bank.setVisible(false);
			jLabel_endDate = new JLabel();
			jLabel_endDate.setBounds(new Rectangle(436, 72, 30, 16));
			jLabel_endDate.setText("to:");
			jLabel_endDate.setVisible(false);
			jLabel_startDate = new JLabel();
			jLabel_startDate.setBounds(new Rectangle(45, 70, 36, 22));
			jLabel_startDate.setText("from:");
			jLabel_startDate.setVisible(false);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_timeSeries(), null);
			jContentPane.add(getJButton_balanceSheet(), null);
			jContentPane.add(jLabel_startDate, null);
			jContentPane.add(getJComboBox_startDate(), null);
			jContentPane.add(jLabel_endDate, null);
			jContentPane.add(getJComboBox_endDate(), null);
			jContentPane.add(jLabel_bank, null);
			jContentPane.add(getJComboBox_banks(), null);
			jContentPane.add(getJTabbedPane(), null);
			jContentPane.add(jLabel_variable, null);
			jContentPane.add(getJComboBox_variables(), null);
			jContentPane.add(getJButton_loadData(), null);
			jContentPane.add(getJButton_reset(), null);
			jContentPane.add(getJTextArea_description(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton_timeSeries	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_timeSeries() {
		if (jButton_timeSeries == null) {
			jButton_timeSeries = new JButton();
			jButton_timeSeries.setBounds(new Rectangle(44, 17, 329, 29));
			jButton_timeSeries.setText("Time Series");
			jButton_timeSeries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					jButton_timeSeries.setEnabled(false);
					jButton_balanceSheet.setEnabled(true);
					
					jLabel_startDate.setText("from:");
					jLabel_startDate.setVisible(true);
					jComboBox_startDate.setVisible(true);
					
					jLabel_endDate.setText("to:");
					jLabel_endDate.setVisible(true);
					jComboBox_endDate.setVisible(true);
					
					jLabel_bank.setVisible(true);
					jComboBox_banks.setVisible(true);
					
					jLabel_variable.setVisible(true);
					jComboBox_variables.setVisible(true);
					
					jTabbedPane.setVisible(true);
					
					jButton_loadData.setVisible(true);
					
					jButton_reset.setVisible(true);
					
					
//					loadData_TimeSeries(jComboBox_banks.getSelectedItem().toString(), 
//										jComboBox_startDate.getSelectedItem().toString(), 
//										jComboBox_endDate.getSelectedItem().toString(),
//										jComboBox_variables.getSelectedItem().toString());
				
				}
			});
		}
		return jButton_timeSeries;
	}

	/**
	 * This method initializes jButton_balanceSheet	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_balanceSheet() {
		if (jButton_balanceSheet == null) {
			jButton_balanceSheet = new JButton();
			jButton_balanceSheet.setBounds(new Rectangle(435, 15, 343, 31));
			jButton_balanceSheet.setText("Balance Sheet");
			jButton_balanceSheet.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					
					jButton_timeSeries.setEnabled(true);
					jButton_balanceSheet.setEnabled(false);
					
					
					jLabel_startDate.setText("date:");
					jLabel_startDate.setVisible(true);
					jComboBox_startDate.setVisible(true);
					
					jLabel_endDate.setVisible(false);
					jComboBox_endDate.setVisible(false);
										
					jLabel_bank.setVisible(true);
					jComboBox_banks.setVisible(true);
					
					jLabel_variable.setVisible(true);
					jComboBox_variables.setVisible(true);
					
					jTabbedPane.setVisible(true);

					jButton_loadData.setVisible(true);
					
					jButton_reset.setVisible(true);
					
//					loadData_BalanceSheet(jComboBox_banks.getSelectedItem().toString(), 
//							jComboBox_startDate.getSelectedItem().toString());
				}
			});
		}
		return jButton_balanceSheet;
	}

	/**
	 * This method initializes jComboBox_startDate	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_startDate() {
		if (jComboBox_startDate == null) {
			jComboBox_startDate = new JComboBox(DataControllerMySQL.getPeriodEndDateList().toArray());
			jComboBox_startDate.setBounds(new Rectangle(141, 74, 234, 19));
			jComboBox_startDate.setVisible(false);
		}
		return jComboBox_startDate;
	}

	/**
	 * This method initializes jComboBox_endDate	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_endDate() {
		if (jComboBox_endDate == null) {
			jComboBox_endDate = new JComboBox(DataControllerMySQL.getPeriodEndDateList().toArray());
			jComboBox_endDate.setBounds(new Rectangle(523, 72, 257, 20));
			jComboBox_endDate.setVisible(false);
		}
		return jComboBox_endDate;
	}

	/**
	 * This method initializes jComboBox_banks	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_banks() {
		if (jComboBox_banks == null) {
			jComboBox_banks = new JComboBox(DataControllerMySQL.getBanksList().toArray());
			jComboBox_banks.setBounds(new Rectangle(120, 120, 524, 19));
			jComboBox_banks.setVisible(false);
		}
		return jComboBox_banks;
	}

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new Rectangle(15, 222, 766, 385));
			jTabbedPane.setVisible(false);
			jTabbedPane.addTab("Balance Sheet", null, getJPanel_balanceSheet(), null);
			jTabbedPane.addTab("Plot", null, getJPanel_plot(), null);
			jTabbedPane.addTab("Data", null, getJPanel_data(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel_balanceSheet	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_balanceSheet() {
		if (jPanel_balanceSheet == null) {
			jPanel_balanceSheet = new JPanel();
			jPanel_balanceSheet.setLayout(new BoxLayout(getJPanel_balanceSheet(), BoxLayout.X_AXIS));
			jPanel_balanceSheet.add(getJScrollPane_balanceSheet_Assets(), null);
			jPanel_balanceSheet.add(getJScrollPane_balanceSheet_Liabilities(), null);
		}
		return jPanel_balanceSheet;
	}

	/**
	 * This method initializes jComboBox_variables	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_variables() {
		if (jComboBox_variables == null) {
			jComboBox_variables = new JComboBox(DataControllerMySQL.getVariablesList().toArray());
			jComboBox_variables.setBounds(new Rectangle(121, 162, 524, 21));
			jComboBox_variables.setVisible(false);
			jComboBox_variables.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jComboBox_variables;
	}

	/**
	 * This method initializes jPanel_plot	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_plot() {
		if (jPanel_plot == null) {
			jPanel_plot = new JPanel();
			jPanel_plot.setLayout(new GridBagLayout());
		}
		return jPanel_plot;
	}

	/**
	 * This method initializes jPanel_data	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_data() {
		if (jPanel_data == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridx = 0;
			jPanel_data = new JPanel();
			jPanel_data.setLayout(new GridBagLayout());
			jPanel_data.add(getJScrollPane_data(), gridBagConstraints);
		}
		return jPanel_data;
	}

	/**
	 * This method initializes jScrollPane_balanceSheet_Assets	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_balanceSheet_Assets() {
		if (jScrollPane_balanceSheet_Assets == null) {
			jScrollPane_balanceSheet_Assets = new JScrollPane();
			jScrollPane_balanceSheet_Assets.setViewportView(getJTable_balanceSheet_Assets());
		}
		return jScrollPane_balanceSheet_Assets;
	}

	/**
	 * This method initializes jScrollPane_balanceSheet_Liabilities	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_balanceSheet_Liabilities() {
		if (jScrollPane_balanceSheet_Liabilities == null) {
			jScrollPane_balanceSheet_Liabilities = new JScrollPane();
			jScrollPane_balanceSheet_Liabilities.setViewportView(getJTable_balanceSheet_Liabilities());
		}
		return jScrollPane_balanceSheet_Liabilities;
	}

	/**
	 * This method initializes jTable_balanceSheet_Assets	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable_balanceSheet_Assets() {
		if (jTable_balanceSheet_Assets == null) {
			jTable_balanceSheet_Assets = new JTableAlternateRowColor();
			jTable_balanceSheet_Assets.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
		return jTable_balanceSheet_Assets;
	}

	/**
	 * This method initializes jTable_balanceSheet_Liabilities	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable_balanceSheet_Liabilities() {
		if (jTable_balanceSheet_Liabilities == null) {
			jTable_balanceSheet_Liabilities = new JTableAlternateRowColor();
			jTable_balanceSheet_Liabilities.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
		return jTable_balanceSheet_Liabilities;
	}

	/**
	 * This method initializes jButton_loadData	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_loadData() {
		if (jButton_loadData == null) {
			jButton_loadData = new JButton();
			jButton_loadData.setBounds(new Rectangle(674, 162, 105, 32));
			jButton_loadData.setText("Load Data");
			jButton_loadData.setVisible(false);
			jButton_loadData.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
//					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
//					loadData_BalanceSheet("480228", "2009-03-31");
					
					if(jButton_balanceSheet.isEnabled())
					{
						loadData_TimeSeries(jComboBox_banks.getSelectedItem().toString(), 
										jComboBox_startDate.getSelectedItem().toString(), 
										jComboBox_endDate.getSelectedItem().toString(),
										jComboBox_variables.getSelectedItem().toString());
					}
					else
					{
						loadData_BalanceSheet(jComboBox_banks.getSelectedItem().toString(), 
								jComboBox_startDate.getSelectedItem().toString());
					}
					
				}
			});
		}
		return jButton_loadData;
	}

	/**
	 * This method initializes jScrollPane_data	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane_data() {
		if (jScrollPane_data == null) {
			jScrollPane_data = new JScrollPane();
			jScrollPane_data.setViewportView(getJTable_data());
		}
		return jScrollPane_data;
	}

	/**
	 * This method initializes jTable_data	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable_data() {
		if (jTable_data == null) {
			jTable_data = new JTable();
		}
		return jTable_data;
	}

	/**
	 * This method initializes jButton_reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_reset() {
		if (jButton_reset == null) {
			jButton_reset = new JButton();
			jButton_reset.setBounds(new Rectangle(670, 113, 110, 32));
			jButton_reset.setText("Reset");
			jButton_reset.setVisible(false);
		}
		return jButton_reset;
	}

	/**
	 * This method initializes jTextArea_description	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_description() {
		if (jTextArea_description == null) {
			jTextArea_description = new JTextArea();
			jTextArea_description.setBounds(new Rectangle(99, 194, 468, 30));
		}
		return jTextArea_description;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FrameDatabaseManager manager = new FrameDatabaseManager ();
		
		JFrame frame = manager.getJFrame();
		
		frame.pack();
		
		frame.setVisible(true);
		
	}
	
	private void timeSeriesClick ()
	{
		this.jLabel_startDate.setVisible(true);
		this.jLabel_startDate.setText("Date:");
		
		this.jLabel_endDate.setVisible(false);
		this.jComboBox_endDate.setVisible(false);
		this.jLabel_bank.setVisible(true);
		this.jComboBox_banks.setVisible(true);
	}
	
	public void loadData_BalanceSheet(String bankCert, String periodEndDate)
	{
		
		ArrayList<String> assetsList = new ArrayList<String>();
		ArrayList<String> liabilitiesList = new ArrayList<String>();
		
		assetsList.add("RCFD0081");
		assetsList.add("RCFD0071");
		assetsList.add("RCFD1754");
		assetsList.add("RCFD1773");
		assetsList.add("RCONB987");
		assetsList.add("RCFDB989");
		assetsList.add("RCFD5369");
		assetsList.add("RCFDB528");
		assetsList.add("RCFD3123");
		assetsList.add("RCFDB529");
		assetsList.add("RCFD3545");
		assetsList.add("RCFD2145");
		assetsList.add("RCFD2150");
		assetsList.add("RCFD2130");
		assetsList.add("RCFD0426");
		assetsList.add("RCFD3163");
		assetsList.add("RCFD2160");
		assetsList.add("RCFD2170");
		
		
		liabilitiesList.add("RCON6631");
		liabilitiesList.add("RCON6636");
		liabilitiesList.add("RCON2200");
		liabilitiesList.add("RCFN6631");
		liabilitiesList.add("RCFN6636");
		liabilitiesList.add("RCFN2200");
		liabilitiesList.add("RCONB993");
		liabilitiesList.add("RCFDB995");
		liabilitiesList.add("RCFD3548");
		liabilitiesList.add("RCFD3190");
		liabilitiesList.add("RCFD3200");
		liabilitiesList.add("RCFD2930");
		liabilitiesList.add("RCFD2948");
		liabilitiesList.add("RCFD3000");
		liabilitiesList.add("RCFD3838");
		liabilitiesList.add("RCFD3230");
		liabilitiesList.add("RCFD3839");
		liabilitiesList.add("RCFD3632");
		liabilitiesList.add("RCFDB530");
		liabilitiesList.add("RCFDA130");
		liabilitiesList.add("RCFD3210");
		liabilitiesList.add("RCFD3300");
		
		
		
		
		String[] header = {"Description", "Value"};
		
		
		Object[][] data_assets = new Object [assetsList.size()][header.length];
		Object[][] data_liabilities = new Object [liabilitiesList.size()][header.length];
		
		for(int i = 0; i < assetsList.size(); i ++)
		{
			data_assets[i][1] = DataControllerMySQL.getValue(bankCert, periodEndDate, assetsList.get(i));
			data_assets[i][0] = DataControllerMySQL.getDescription(assetsList.get(i));
			
		}
		
		for(int i = 0; i < liabilitiesList.size(); i ++)
		{
			data_liabilities[i][1] = DataControllerMySQL.getValue(bankCert, periodEndDate, liabilitiesList.get(i));
			data_liabilities[i][0] = DataControllerMySQL.getDescription(liabilitiesList.get(i));
			
		}
			
		DefaultTableModel dtm_assets = new DefaultTableModel(data_assets, header);
		DefaultTableModel dtm_liabilities = new DefaultTableModel(data_liabilities, header);
		
		this.jTable_balanceSheet_Assets.setModel(dtm_assets);
		this.jTable_balanceSheet_Liabilities.setModel(dtm_liabilities);
		
		jTable_balanceSheet_Assets.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_balanceSheet_Liabilities.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.jTable_balanceSheet_Assets.enable(false);
		this.jTable_balanceSheet_Liabilities.enable(false);
	}
	
	
	public void loadData_TimeSeries(String bankCert, String periodStartDate, String periodEndDate, String description)
	{		
		String[] header = {"EndPeriod", "Value"};
		
		ArrayList<String> dataList = new ArrayList<String>();
		
		ArrayList<String[]> data = new ArrayList<String[]>();

		ArrayList<String> dates = DataControllerMySQL.getPeriodEndDateList();
		
		int[] startDate = {Integer.valueOf(periodStartDate.split("-")[0]),
							Integer.valueOf(periodStartDate.split("-")[1]),
							Integer.valueOf(periodStartDate.split("-")[2])};
		
		int[] endDate = {Integer.valueOf(periodEndDate.split("-")[0]),
				Integer.valueOf(periodEndDate.split("-")[1]),
				Integer.valueOf(periodEndDate.split("-")[2])};
		
		for(int i = 0; i < dates.size(); i ++)
		{
			if (dates.get(i).split("-").length == 3)
			{

				int [] currentDate = {Integer.valueOf(dates.get(i).split("-")[0]),
						Integer.valueOf(dates.get(i).split("-")[1]),
						Integer.valueOf(dates.get(i).split("-")[2])};

				if (currentDate[0] <= endDate[0] && currentDate[1] <= endDate[1] &&
						currentDate[0] >= startDate[0] && currentDate[1] >= startDate[1])
				{
					String[] value = new String [3];
					value[0] = dates.get(i);
					value[1] = DataControllerMySQL.getValue(bankCert, dates.get(i), 
							DataControllerMySQL.getCode(description));
					data.add(value);
				}

			}
		}
		
		
		Object[][] dataFinal = new Object [data.size()][header.length];

		for(int i = 0; i < data.size(); i ++)
		{
			dataFinal[i][0] = data.get(i)[0];
			dataFinal[i][1] = data.get(i)[1];
		}
			
		DefaultTableModel dtm = new DefaultTableModel(dataFinal, header);
		
		this.jTable_data.setModel(dtm);
		
		jTable_data.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		this.jTable_data.enable(false);
	}

}
