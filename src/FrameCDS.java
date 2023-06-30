import jas.engine.Sim;
import jas.engine.SimEngine;
import jas.graph.GraphViewer;
import jas.graphics.plot.TimeSeriesPlotter;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JToolBar;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;

import javax.swing.BoxLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class FrameCDS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jJMenuBar = null;
	private JPanel jContentPane = null;
	private JMenuItem jMenuItemExit = null;
	private JMenu jMenuFile = null;
	private JMenu jMenuHelp = null;
	private JMenuItem jMenuItemAbout = null;
	private JToolBar jToolBar = null;
	private JButton jButton_loadData = null;
	private JButton jButton_run = null;
	private JButton jButton_pause = null;
	private JButton jButton_step = null;
	private JButton jButton_stop = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField jTextField1 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JTextField jTextField2 = null;
	private JCheckBox jCheckBox = null;
	private JTabbedPane jTabbedPane_main = null;
	private JPanel jPanel_data = null;
	private JScrollPane jScrollPane_data = null;
	private JTable jTable_data = null;
	private JComboBox jComboBox_data = null;
	private JComboBox jComboBox_banks = null;
	private JComboBox jComboBox_exp = null;
	private JComboBox jComboBox_net = null;
	private JPanel jPanel_network = null;
	private BasicVisualizationServer<Integer, String> graphVisualizer = null;
	private JPanel jPanel_log = null;
	private JTextArea jTextArea_log = null;
	private JScrollPane jScrollPane_log = null;
	private RadialTreeLensDemo treeCollapseDemo = null; // @jve:decl-index=0:

	private JPanel showLayouts = null;

	private SimEngine eng = null;
	private Model model = null;

	private DefaultCategoryDataset dataset_indegrees; // @jve:decl-index=0:
	private DefaultCategoryDataset dataset_outdegrees; // @jve:decl-index=0:

	private TimeSeries seriesCDSCover = null;
	private TimeSeries seriesCC = null; // @jve:decl-index=0:
	private ChartPanel jPanel_CDSCover = null;
	private ChartPanel jPanel_CC = null;
	private ChartPanel jPanel_inDegrees = null;
	private ChartPanel jPanel_outDegrees = null;
	private JLabel jLabel_tick = null;
	private JLabel jLabel_tickValue = null;
	private JLabel jLabel8 = null;
	private JTextField jTextField3 = null;
	private JPanel jPanel_indegrees = null;
	private JPanel jPanel_outdegrees = null;
	private JPanel jPanel_chart2 = null;

	private int counter = 0;
	private JLabel jLabel9 = null;
	private JLabel jLabel_numDB = null;
	private JPanel jPanel_bottom = null;
	private ChartPanel jPanel_bottom1 = null;
	private ChartPanel jPanel_bottom2 = null;
	private ChartPanel jPanel_bottom3 = null;
	private ChartPanel jPanel_bottom4 = null;
	private JTabbedPane jTabbedPane_left = null;
	private JPanel jPanel_parameters = null;
	private JPanel jPanel_contagionLeft = null;

	private JPanel controlPanel = null;
	private JPanel jPanel_Contagion_Control_Left = null;

	private int contagionVisualizersizeX = 200;
	private int contagionVisualizersizeY = 250;
	private JTabbedPane jTabbedPane_leftBottom = null;
	private JPanel jPanel_statistics1 = null;
	private JPanel jPanel_statistics2 = null;
	private JPanel jPanel_statistics3 = null;
	private JLabel jLabel91 = null;
	private JLabel jLabel92 = null;
	private JLabel jLabel93 = null;
	private JLabel jLabel94 = null;
	private JLabel jLabel95 = null;
	private JLabel jLabel96 = null;
	private JLabel jLabel97 = null;
	private JLabel jLabel98 = null;
	private JLabel jLabel99 = null;

	private GraphCDS graphCDS = null; // @jve:decl-index=0:
	private GraphContagion graphContagion = null; // @jve:decl-index=0:
	private JLabel jLabel910 = null;
	private JLabel jLabel_simRound = null;
	private JScrollPane jScrollPane_contagionLeft = null;
	private JPanel jPanel_contagionLeft2 = null;
	private JLabel jLabel_numDB1 = null;
	private JLabel jLabel_CC = null;
	private JLabel jLabel_CDS = null;
	private JLabel jLabel911 = null;
	private JLabel jLabel912 = null;
	private JLabel jLabel_INmean = null;
	private JLabel jLabel_INstd = null;
	private JLabel jLabel_INskew = null;
	private JLabel jLabel_INkurt = null;
	private JLabel jLabel_INconn = null;
	private JLabel jLabel_INclust = null;
	private JLabel jLabel_OUTmean = null;
	private JLabel jLabel_OUTstd = null;
	private JLabel jLabel_OUTskew = null;
	private JLabel jLabel_OUTkurt = null;
	private JLabel jLabel_OUTconn = null;
	private JLabel jLabel_OUTclust = null;
	private JLabel jLabel913 = null;
	private JLabel jLabel914 = null;
	private JLabel jLabel915 = null;
	private JLabel jLabel916 = null;
	private JLabel jLabel917 = null;
	private JLabel jLabel918 = null;
	private JLabel jLabel919 = null;
	private JLabel jLabel920 = null;
	private JLabel jLabel921 = null;
	private JLabel jLabel922 = null;
	private JLabel jLabel923 = null;
	private JLabel jLabel924 = null;

	public FrameCDS(SimEngine eng, Model model) throws HeadlessException {
		super();

		this.eng = eng;

		this.model = model;

		this.model.frame = this;

		eng.addModel(this.model);

		initialize();

	}

	private void initialize() {
		this.setSize(1591, 987);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(1591, 987));
		this.setMinimumSize(new Dimension(1, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("CDS framework");

	}

	public void loadData() {
		String[] header = { "cert", "Name", "CDS Buy", "CDS Sell",
				"Core Capital", "MBS", "SPV" };

		ArrayList<Bank> banks = DataController.getBanks();

		Object[][] data = new Object[banks.size()][header.length];

		for (int i = 0; i < DataController.getBanks().size(); i++) {
			for (int j = 0; j < header.length; j++) {
				Bank bank = banks.get(i);
				data[i][0] = bank.getCert();
				data[i][1] = bank.getNameshort();

				if (Parameters.rndMatrixTest) {
					data[i][2] = this.model.nodes.get(i).getB();
					data[i][3] = this.model.nodes.get(i).getG();
				} else {
					data[i][2] = bank.getCtddfswb();
					data[i][3] = bank.getCtddfswg();
				}
				data[i][4] = bank.getCC();
				data[i][5] = bank.getMBS();
				data[i][6] = bank.getSPV();

			}
		}

		DefaultTableModel dtm = new DefaultTableModel(data, header);
		jTable_data.setModel(dtm);

		jTable_data.enable(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setPreferredSize(new Dimension(490, 350));
			jContentPane.setLayout(new BorderLayout(0, 0));
			jContentPane.add(getJToolBar(), BorderLayout.NORTH);
			jContentPane.add(getJTabbedPane_left(), BorderLayout.WEST);

		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenuFile());
			jJMenuBar.add(getJMenuHelp());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenuItemExit
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemExit() {
		if (jMenuItemExit == null) {
			jMenuItemExit = new JMenuItem();
			jMenuItemExit.setMnemonic(KeyEvent.VK_X);
			jMenuItemExit.setText("Exit");
		}
		return jMenuItemExit;
	}

	/**
	 * This method initializes jMenuFile
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuFile() {
		if (jMenuFile == null) {
			jMenuFile = new JMenu();
			jMenuFile.setMnemonic(KeyEvent.VK_F);
			jMenuFile.setText("File");
			jMenuFile.add(getJMenuItemExit());
		}
		return jMenuFile;
	}

	/**
	 * This method initializes jMenuHelp
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuHelp() {
		if (jMenuHelp == null) {
			jMenuHelp = new JMenu();
			jMenuHelp.setText("Help");
			jMenuHelp.setMnemonic(KeyEvent.VK_H);
			jMenuHelp.add(getJMenuItemAbout());
		}
		return jMenuHelp;
	}

	/**
	 * This method initializes jMenuItemAbout
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemAbout() {
		if (jMenuItemAbout == null) {
			jMenuItemAbout = new JMenuItem();
			jMenuItemAbout.setText("About");
			jMenuItemAbout.setMnemonic(KeyEvent.VK_A);

		}
		return jMenuItemAbout;
	}

	/**
	 * This method initializes jToolBar
	 * 
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jLabel924 = new JLabel();
			jLabel924.setText("Default");
			jLabel924.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			jLabel923 = new JLabel();
			jLabel923.setText("Net Buyer  ");
			jLabel923.setForeground(Color.cyan);
			jLabel923.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			jLabel922 = new JLabel();
			jLabel922.setText("Buyer  ");
			jLabel922.setForeground(Color.blue);
			jLabel922.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			jLabel921 = new JLabel();
			jLabel921.setText("Net Seller  ");
			jLabel921.setForeground(Color.pink);
			jLabel921.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			jLabel920 = new JLabel();
			jLabel920.setText(" Seller  ");
			jLabel920.setForeground(Color.red);
			jLabel920.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			jLabel919 = new JLabel();
			jLabel919.setText("                      Color code: ");
			jLabel919.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabel_simRound = new JLabel();
			jLabel_simRound.setText("0");
			jLabel_simRound.setForeground(new Color(0, 150, 0));
			jLabel_simRound.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabel910 = new JLabel();
			jLabel910.setText("    Simulation round:  ");
			jLabel910.setForeground(new Color(0, 150, 0));
			jLabel910.setFont(new Font("Dialog", Font.BOLD, 14));
			jToolBar = new JToolBar();
			jToolBar.setBounds(new Rectangle(0, 0, 1007, 36));
			jToolBar.add(getJButton_loadData());
			jToolBar.add(getJButton_run());
			jToolBar.add(getJButton_pause());
			jToolBar.add(getJButton_step());
			jToolBar.add(getJButton_stop());
			jToolBar.add(jLabel910);
			jToolBar.add(jLabel_simRound);

		}
		return jToolBar;
	}

	/**
	 * This method initializes jButton_loadData
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton_loadData() {
		if (jButton_loadData == null) {
			jButton_loadData = new JButton();
			jButton_loadData.setText("Load Data");
			jButton_loadData.setIcon(new ImageIcon(getClass().getResource(
					"/images/load.png")));
			jButton_loadData
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							loadData_click();

						}
					});
		}
		return jButton_loadData;
	}

	/**
	 * This method initializes jButton_run
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton_run() {
		if (jButton_run == null) {
			jButton_run = new JButton();
			jButton_run.setText("Run");
			jButton_run.setIcon(new ImageIcon(getClass().getResource(
					"/images/start.png")));
			jButton_run.setEnabled(false);
			jButton_run.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()
					eng.start();
				}
			});
		}
		return jButton_run;
	}

	/**
	 * This method initializes jButton_pause
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton_pause() {
		if (jButton_pause == null) {
			jButton_pause = new JButton();
			jButton_pause.setText("Pause");
			jButton_pause.setIcon(new ImageIcon(getClass().getResource(
					"/images/pause.png")));
			jButton_pause.setEnabled(false);
			jButton_pause
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							eng.stop();
						}
					});
		}
		return jButton_pause;
	}

	/**
	 * This method initializes jButton_step
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton_step() {
		if (jButton_step == null) {
			jButton_step = new JButton();
			jButton_step.setText("Step");
			jButton_step.setIcon(new ImageIcon(getClass().getResource(
					"/images/step.png")));
			jButton_step.setEnabled(false);
			jButton_step.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()
					eng.stop();
					eng.stepTime();
				}
			});
		}
		return jButton_step;
	}

	/**
	 * This method initializes jButton_stop
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton_stop() {
		if (jButton_stop == null) {
			jButton_stop = new JButton();
			jButton_stop.setText("Stop");
			jButton_stop.setIcon(new ImageIcon(getClass().getResource(
					"/images/stop.png")));
			jButton_stop.setEnabled(false);
			jButton_stop.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()
					eng.stop();

					stop_click();
				}
			});
		}
		return jButton_stop;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setText("0.0");
			jTextField.setVisible(false);
			jTextField.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println(e); // TODO Auto-generated Event stub
					// actionPerformed()
					Parameters.OutsideEntityLoss = Double.valueOf(jTextField
							.getText());
				}
			});

		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("0.1");
			jTextField1.setVisible(false);
			jTextField1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()

					Parameters.percentageMBS = Double.valueOf(jTextField1
							.getText());
				}
			});
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("0");
			jTextField2.setVisible(false);
		}
		return jTextField2;
	}

	/**
	 * This method initializes jCheckBox
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBox() {
		if (jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setText("Print files");
		}
		return jCheckBox;
	}

	/**
	 * This method initializes jTabbedPane_main
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane_main() {
		if (jTabbedPane_main == null) {
			jTabbedPane_main = new JTabbedPane();
			jTabbedPane_main.setBounds(new Rectangle(308, 40, 840, 700));
			jTabbedPane_main.setName("");
			jTabbedPane_main.setToolTipText("");
			// jTabbedPane_main.addTab("FDIC Data - Q1 2004", null,
			// getJPanel_data(), null);
			 jTabbedPane_main.addTab("FDIC Data - Q4 2006", null,
			 getJPanel_data(), null);
//			jTabbedPane_main.addTab("FDIC Data - Q4 2007", null,
//					getJPanel_data(), null);
			jTabbedPane_main.setVisible(false);
			jTabbedPane_main.addTab("Network", null, getJPanel_network(), null);
			jTabbedPane_main.addTab("log", null, getJPanel_log(), null);
		}
		return jTabbedPane_main;
	}

	/**
	 * This method initializes jPanel_data
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_data() {
		if (jPanel_data == null) {
			jPanel_data = new JPanel();
			jPanel_data.setLayout(null);
			jPanel_data.setVisible(false);
			jPanel_data.add(getJScrollPane_data(), null);
		}
		return jPanel_data;
	}

	/**
	 * This method initializes jScrollPane_data
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane_data() {
		if (jScrollPane_data == null) {
			jScrollPane_data = new JScrollPane();
			jScrollPane_data.setBounds(new Rectangle(0, 0, 637, 749));
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
			jTable_data = new JTableAlternateRowColor();
			jTable_data.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			jTable_data.setBounds(new Rectangle(0, 0, 637, 749));
		}
		return jTable_data;
	}

	/**
	 * This method initializes jComboBox_data
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox_data() {
		if (jComboBox_data == null) {
			jComboBox_data = new JComboBox(Parameters.dataList());
			jComboBox_data
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							JComboBox cb = (JComboBox) e.getSource();
							String param = (String) cb.getSelectedItem();
							// System.out.println(param); // TODO Auto-generated
							// Event stub actionPerformed()
							// if (param == "Q1 2004")
							if (param == "Q4 2006")
							// if (param == "Q4 2007")
							{

							}

						}
					});

		}
		return jComboBox_data;
	}

	/**
	 * This method initializes jComboBox_banks
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox_banks() {
		if (jComboBox_banks == null) {
			jComboBox_banks = new JComboBox(
					DataController.getBanksNameShortAndInsuranceCompanies());
			this.jComboBox_banks.setSelectedIndex(0);
			jComboBox_banks
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JComboBox cb = (JComboBox) e.getSource();
							String param = (String) cb.getSelectedItem();
							if (param == DataController
									.getBanksNameShortAndOutsideEntity()[DataController
									.getBanksNameShortAndOutsideEntity().length - 1]) {
								jLabel3.setVisible(true);
								jTextField.setVisible(true);

								Parameters.DefaultingBank = 0;
							} else {
								jLabel3.setVisible(false);
								jTextField.setVisible(false);

								Parameters.DefaultingBank = cb
										.getSelectedIndex() + 1;
								Parameters.OutsideEntityLoss = 0;
							}

						}
					});
		}
		return jComboBox_banks;
	}

	/**
	 * This method initializes jComboBox_exp
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox_exp() {
		if (jComboBox_exp == null) {
			jComboBox_exp = new JComboBox(Parameters.experimentsList());
			jComboBox_exp
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JComboBox cb = (JComboBox) e.getSource();
							String param = (String) cb.getSelectedItem();
							if (param == Parameters.experimentsList()[1]) {
								jLabel5.setVisible(true);
								jTextField1.setVisible(true);

								Parameters.lossCoverOnly = false;
								Parameters.concentrationRisk = false;
							} else if (param == Parameters.experimentsList()[2]) {
								jLabel5.setVisible(true);
								jTextField1.setVisible(true);

								Parameters.lossCoverOnly = false;
								Parameters.concentrationRisk = true;
							} else {
								jLabel5.setVisible(false);
								jTextField1.setVisible(false);

								Parameters.lossCoverOnly = true;
								Parameters.concentrationRisk = false;
							}
						}
					});
		}
		return jComboBox_exp;
	}

	/**
	 * This method initializes jComboBox_net
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox_net() {
		if (jComboBox_net == null) {
			jComboBox_net = new JComboBox(Parameters.networksList());
			jComboBox_net
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// System.out.println("actionPerformed()"); // TODO
							// Auto-generated Event stub actionPerformed()
							JComboBox cb = (JComboBox) e.getSource();
							String param = (String) cb.getSelectedItem();
							if (param == Parameters.networksList()[1]) {
								jLabel7.setVisible(true);
								jTextField2.setVisible(true);

								Parameters.rndMatrixTest = true;
							} else {
								jLabel7.setVisible(false);
								jTextField2.setVisible(false);

								Parameters.rndMatrixTest = false;
							}
						}
					});
		}
		return jComboBox_net;
	}

	private void loadData_click() {
		this.eng.buildModels();

		jContentPane.add(getJTabbedPane_main(), BorderLayout.EAST);
		jContentPane.add(getJTabbedPane_leftBottom(), BorderLayout.CENTER);
		jContentPane.add(getJPanel_bottom(), BorderLayout.SOUTH);

		jToolBar.add(jLabel919);
		jToolBar.add(jLabel920);
		jToolBar.add(jLabel921);
		jToolBar.add(jLabel922);
		jToolBar.add(jLabel923);
		jToolBar.add(jLabel924);

		loadData();

		this.getJTabbedPane_main().setVisible(true);
		this.getJButton_loadData().setEnabled(false);
		this.getJButton_run().setEnabled(true);
		this.getJButton_pause().setEnabled(true);
		this.getJButton_step().setEnabled(true);
		this.getJButton_stop().setEnabled(true);
		// this.jPanel_left.enableInputMethods(false);

		this.getJTabbedPane_left().remove(0);

		this.disenableLeftPanel();

		jTabbedPane_left.addTab("Contagion", null, getJPanel_contagionLeft(),
				null);
		this.getJTabbedPane_left().addTab("Parameters",
				this.getJPanel_parameters());

		// this.treeCollapseDemo.setInitialNode(this.model.nodes.get(this.model.defaultBank
		// ));

		if (this.model.defaultBank < 0) {
			this.graphContagion.setInitialNode(this.model.nodes
					.get(this.model.nodes.size() - 1));
		} else {
			this.graphContagion.setInitialNode(this.model.nodes
					.get(this.model.defaultBank));
		}

		// this.jTabbedPane_left.getComponent(1).show();

		double cc = 0;
		double cds = 0;

		for (int i = 0; i < model.nodes.size(); i++) {
			cc += model.nodes.get(i).getCC_last();
			cds += model.nodes.get(i).getB();
		}

		this.jLabel_CC.setText(String
				.valueOf((double) ((int) (cc * 100)) / 100));
		this.jLabel_CDS.setText(String
				.valueOf((double) ((int) (cds * 100)) / 100));

		this.updateCharts();

	}

	private void stop_click() {
		// this.eng = new SimEngine ();
		//
		// this.model = new Model (this);

		// eng.rebuildModels();

		this.getJTabbedPane_main().setVisible(false);
		this.getJButton_loadData().setEnabled(true);
		this.getJButton_run().setEnabled(false);
		this.getJButton_pause().setEnabled(false);
		this.getJButton_step().setEnabled(false);
		this.getJButton_stop().setEnabled(false);

		// this.jPanel_left.enableInputMethods(true);

		this.enableLeftPanel();
	}

	/**
	 * This method initializes jPanel_network
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_network() {
		if (jPanel_network == null) {
			jPanel_network = new JPanel();
			// create a control panel and buttons for demo
			// functions
			JPanel controlPanel = new JPanel();
			// jPanel_network.setLayout(new BoxLayout(getJPanel_network(),
			// BoxLayout.X_AXIS));
			// jPanel_network.setLayout(new BoxLayout(getJPanel_network(),
			// BoxLayout.Y_AXIS));
			jPanel_network.setLayout(new BorderLayout());
			jPanel_network.add(getGraphCDS(), BorderLayout.CENTER);
			controlPanel.add(graphCDS.graphMouse.getModeComboBox(), null);
			jPanel_network.add(controlPanel, BorderLayout.NORTH);

		}
		return jPanel_network;
	}

	/**
	 * This method initializes jPanel_contagion
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_log() {
		if (jPanel_log == null) {
			jPanel_log = new JPanel();
			jPanel_log.setLayout(new BorderLayout());
			// jPanel_log.setLayout(null);
			jPanel_log.add(getJScrollPane_log(), null);
		}
		return jPanel_log;
	}

	private JScrollPane getJScrollPane_log() {
		if (jScrollPane_log == null) {
			jScrollPane_log = new JScrollPane();
			// jScrollPane_log.setLayout(null);
			jScrollPane_log.setViewportView(getJTextArea_log());
		}
		return jScrollPane_log;
	}

	public JTextArea getJTextArea_log() {
		if (jTextArea_log == null) {
			jTextArea_log = new JTextArea();
			// jPanel_contagion.setLayout(new GridBagLayout());
			jTextArea_log.setWrapStyleWord(true);
			// jTextArea_log.setLayout(null);
			// jPanel_contagion.add(getTreeCollapseDemo(), null);
		}
		return jTextArea_log;
	}

	/**
	 * This method initializes treeCollapseDemo
	 * 
	 * @return TreeCollapseDemo
	 */
	private RadialTreeLensDemo getTreeCollapseDemo() {
		if (treeCollapseDemo == null) {
			treeCollapseDemo = new RadialTreeLensDemo();
			// treeCollapseDemo.setBounds(new Rectangle(0, 0, 295, 315));
		}
		return treeCollapseDemo;
	}

	private JPanel getShowLayouts() {
		if (showLayouts == null) {
			showLayouts = ShowLayouts.getGraphPanel(Network.getGraph(
					this.model.nodes,
					this.model.matrices.get(this.model.matrices.size() - 1)));
			showLayouts.setBounds(new Rectangle(0, 0, 700, 477));
		}
		return showLayouts;
	}

	/**
	 * This method initializes jPanel_chart1
	 * 
	 * @return javax.swing.JPanel
	 */

	private JFreeChart getChartCDSCover() {
		seriesCDSCover = new TimeSeries("CDS Cover", Millisecond.class);
		// seriesCC = new TimeSeries("Core Capital", Long.class);
		TimeSeriesCollection datasetPrice = new TimeSeriesCollection(
				seriesCDSCover);

		// datasetPrice.addSeries(seriesCC);

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Aggregate CDS Cover", "Order", "$bn", datasetPrice, false,
				true, false);
		chart.setBackgroundPaint(Color.white);

		XYPlot plot = chart.getXYPlot();

		// LegendTitle legend = (LegendTitle) chart.getSubtitle(0);
		// legend.setPosition(RectangleEdge.RIGHT);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4));
		ValueAxis axis = plot.getDomainAxis();
		axis.setAutoRange(true);
		// axis.setFixedAutoRange(900000.0); // 15 minutes

		return chart;
	}

	private JFreeChart getChartCC() {
		seriesCC = new TimeSeries("CC", Millisecond.class);
		TimeSeriesCollection datasetCC = new TimeSeriesCollection();
		datasetCC.addSeries(seriesCC);

		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"Aggregate Core Capital", "Order", "$bn", datasetCC, false,
				true, false);
		chart.setBackgroundPaint(Color.white);

		XYPlot plot = chart.getXYPlot();

		// LegendTitle legend = (LegendTitle) chart.getSubtitle(0);
		// legend.setPosition(RectangleEdge.RIGHT);

		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(4, 4, 4, 4));
		ValueAxis axis = plot.getDomainAxis();
		axis.setAutoRange(true);
		// axis.setFixedAutoRange(900000.0); // 15 minutes

		return chart;
	}

	private JFreeChart getChartInDegrees() {
		dataset_indegrees = new DefaultCategoryDataset();

		JFreeChart chart = ChartFactory.createBarChart("In Degrees", "k in",
				"freq", dataset_indegrees, PlotOrientation.VERTICAL, false,
				true, false);

		return chart;
	}

	private JFreeChart getChartOutDegrees() {
		dataset_outdegrees = new DefaultCategoryDataset();

		JFreeChart chart = ChartFactory.createBarChart("Out Degrees", "k out",
				"freq", dataset_outdegrees, PlotOrientation.VERTICAL, false,
				true, false);

		return chart;
	}

	/**
	 * This method initializes jPanel_CDSCover
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_CDSCover() {
		if (jPanel_CDSCover == null) {
			jPanel_CDSCover = new ChartPanel(this.getChartCDSCover());
			jPanel_CDSCover.setLayout(new GridBagLayout());
			jPanel_CDSCover.setBounds(new Rectangle(0, 0, 500, 240));
		}
		return jPanel_CDSCover;
	}

	/**
	 * This method initializes jPanel_CC
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_CC() {
		if (jPanel_CC == null) {
			jPanel_CC = new ChartPanel(this.getChartCC());
			jPanel_CC.setLayout(new GridBagLayout());
			jPanel_CC.setBounds(new Rectangle(0, 0, 500, 240));
		}
		return jPanel_CC;
	}

	private ChartPanel getJPanel_inDegrees() {
		if (jPanel_inDegrees == null) {
			jPanel_inDegrees = new ChartPanel(this.getChartInDegrees());
			jPanel_inDegrees.setLayout(new GridBagLayout());
			jPanel_inDegrees.setBounds(new Rectangle(0, 0, 500, 240));
		}
		return jPanel_inDegrees;
	}

	private ChartPanel getJPanel_outDegrees() {
		if (jPanel_outDegrees == null) {
			jPanel_outDegrees = new ChartPanel(this.getChartOutDegrees());
			jPanel_outDegrees.setLayout(new GridBagLayout());
			jPanel_outDegrees.setBounds(new Rectangle(0, 0, 500, 240));
		}
		return jPanel_outDegrees;
	}

	public void update() {
		this.jLabel_simRound.setText(String.valueOf(Sim.getAbsoluteTime()
				+ this.counter));
		if (this.model.getDBs() != null)
			this.jLabel_numDB1
					.setText(String.valueOf(this.model.getDBs().length
							+ Integer.valueOf(this.jLabel_numDB1.getText())));

		double cc = 0;
		double cds = 0;

		for (int i = 0; i < model.nodes.size(); i++) {
			cc += model.nodes.get(i).getCC_last();
			cds += model.nodes.get(i).getB();
		}

		this.jLabel_CC.setText(String
				.valueOf((double) ((int) (cc * 100)) / 100));
		this.jLabel_CDS.setText(String
				.valueOf((double) ((int) (cds * 100)) / 100));

		this.jLabel_INmean.setText(String.valueOf(this.model.getStatisticsIN()
				.get(0)));
		this.jLabel_INstd.setText(String.valueOf(this.model.getStatisticsIN()
				.get(2)));
		this.jLabel_INskew.setText(String.valueOf(this.model.getStatisticsIN()
				.get(3)));
		this.jLabel_INkurt.setText(String.valueOf(this.model.getStatisticsIN()
				.get(4)));
		this.jLabel_INconn.setText(String.valueOf(this.model.getStatisticsIN()
				.get(5)));
		this.jLabel_INclust.setText(String.valueOf(this.model.getStatisticsIN()
				.get(6)));

		this.jLabel_OUTmean.setText(String.valueOf(this.model
				.getStatisticsOUT().get(0)));
		this.jLabel_OUTstd.setText(String.valueOf(this.model.getStatisticsOUT()
				.get(2)));
		this.jLabel_OUTskew.setText(String.valueOf(this.model
				.getStatisticsOUT().get(3)));
		this.jLabel_OUTkurt.setText(String.valueOf(this.model
				.getStatisticsOUT().get(4)));
		this.jLabel_OUTconn.setText(String.valueOf(this.model
				.getStatisticsOUT().get(5)));
		this.jLabel_OUTclust.setText(String.valueOf(this.model
				.getStatisticsOUT().get(6)));

		// else this.jLabel_numDB1.setText(String.valueOf(0));

		this.updateCharts();
	}

	public void updateCharts() {

		double cc = 0;
		double cds = 0;

		for (int i = 0; i < model.nodes.size(); i++) {
			cc += model.nodes.get(i).getCC_last();
			cds += model.nodes.get(i).getB();
		}

		Date date = new Date(107, 05, 01, (int) Sim.getAbsoluteTime()
				+ this.counter, 0, 0);

		this.counter = 1;
		Millisecond m = new Millisecond(date);

		this.seriesCC.add(m, cc);
		this.seriesCDSCover.add(m, cds);

		this.updateInDegrees();
		this.updateOutDegrees();

		//

		// showLayouts =
		// ShowLayouts.getGraphPanel(Network.getGraph(this.model.matrices.get(this.model.matrices.size()
		// - 1)));
		// showLayouts.setBounds(new Rectangle(0, 0, 700, 477));

		this.graphCDS.update(this.model.nodes,
				this.model.matrices.get(this.model.matrices.size() - 1));

		this.jPanel_network.repaint();

		// this.treeCollapseDemo.updateTree(this.model.contagionList,
		// this.model.nodes);

		this.graphContagion.update(this.model.contagionList, this.model.nodes);

		this.jPanel_contagionLeft.repaint();

		this.repaint();
	}

	public void updateInDegrees() {
		this.dataset_indegrees.clear();

		for (int i = 0; i < this.model.inDegrees.size(); i++) {
			this.dataset_indegrees.addValue(this.model.inDegrees.get(i).value,
					"In Degrees",
					String.valueOf(this.model.inDegrees.get(i).id));
		}
	}

	public void updateOutDegrees() {
		this.dataset_outdegrees.clear();

		for (int i = 0; i < this.model.outDegrees.size(); i++) {
			this.dataset_outdegrees.addValue(
					this.model.outDegrees.get(i).value, "Out Degrees",
					String.valueOf(this.model.outDegrees.get(i).id));
		}
	}

	/**
	 * This method initializes jTextField3
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setText("0.2");
			jTextField3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// System.out.println("actionPerformed()"); // TODO
					// Auto-generated Event stub actionPerformed()
					Parameters.percentageCC = Double.valueOf(jTextField3
							.getText());
				}
			});
		}
		return jTextField3;
	}

	public void enableLeftPanel() {
		this.jComboBox_data.enable(true);
		this.jComboBox_banks.enable(true);
		this.jComboBox_exp.enable(true);
		this.jComboBox_net.enable(true);

		this.jTextField.enable(true);
		this.jTextField1.enable(true);
		this.jTextField2.enable(true);
		this.jTextField3.enable(true);

		this.jCheckBox.enable(true);
	}

	public void disenableLeftPanel() {
		this.jComboBox_data.enable(false);
		this.jComboBox_banks.enable(false);
		this.jComboBox_exp.enable(false);
		this.jComboBox_net.enable(false);

		this.jTextField.enable(false);
		this.jTextField1.enable(false);
		this.jTextField2.enable(false);
		this.jTextField3.enable(false);

		this.jCheckBox.enable(false);
	}

	/**
	 * This method initializes jPanel_indegrees
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_indegrees() {
		if (jPanel_indegrees == null) {
			jPanel_indegrees = new JPanel();
			jPanel_indegrees.setLayout(null);
			jPanel_indegrees.add(this.getJPanel_inDegrees(), null);
		}
		return jPanel_indegrees;
	}

	/**
	 * This method initializes jPanel_outdegrees
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_outdegrees() {
		if (jPanel_outdegrees == null) {
			jPanel_outdegrees = new JPanel();
			jPanel_outdegrees.setLayout(null);
			jPanel_outdegrees.add(this.getJPanel_outDegrees(), null);
		}
		return jPanel_outdegrees;
	}

	/**
	 * This method initializes jPanel_chart2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_chart2() {
		if (jPanel_chart2 == null) {
			jPanel_chart2 = new JPanel();
			jPanel_chart2.setLayout(null);
			jPanel_chart2.add(getJPanel_CC(), null);
		}
		return jPanel_chart2;
	}

	/**
	 * This method initializes jPanel_bottom
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_bottom() {
		if (jPanel_bottom == null) {
			jPanel_bottom = new JPanel();
			jPanel_bottom.setLayout(null);
			jPanel_bottom.setBounds(new Rectangle(5, 550, 1008, 166));
			jPanel_bottom.setBorder(BorderFactory.createLineBorder(
					SystemColor.activeCaption, 2));
			jPanel_bottom.add(getJPanel_bottom1(), null);
			jPanel_bottom.add(getJPanel_bottom2(), null);
			jPanel_bottom.add(getJPanel_bottom3(), null);
			jPanel_bottom.add(getJPanel_bottom4(), null);
		}
		return jPanel_bottom;
	}

	/**
	 * This method initializes jPanel_bottom1
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_bottom1() {
		if (jPanel_bottom1 == null) {
			jPanel_bottom1 = new ChartPanel(this.getChartCC());
			jPanel_bottom1.setLayout(new GridBagLayout());
			jPanel_bottom1.setBounds(new Rectangle(2, 2, 251, 161));
		}
		return jPanel_bottom1;
	}

	/**
	 * This method initializes jPanel_bottom2
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_bottom2() {
		if (jPanel_bottom2 == null) {
			jPanel_bottom2 = new ChartPanel(this.getChartCDSCover());
			jPanel_bottom2.setLayout(new GridBagLayout());
			jPanel_bottom2.setBounds(new Rectangle(253, 2, 251, 161));
		}
		return jPanel_bottom2;
	}

	/**
	 * This method initializes jPanel_bottom3
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_bottom3() {
		if (jPanel_bottom3 == null) {
			jPanel_bottom3 = new ChartPanel(this.getChartInDegrees());
			jPanel_bottom3.setLayout(new GridBagLayout());
			jPanel_bottom3.setBounds(new Rectangle(504, 2, 251, 161));
		}
		return jPanel_bottom3;
	}

	/**
	 * This method initializes jPanel_bottom4
	 * 
	 * @return javax.swing.JPanel
	 */
	private ChartPanel getJPanel_bottom4() {
		if (jPanel_bottom4 == null) {
			jPanel_bottom4 = new ChartPanel(this.getChartOutDegrees());
			jPanel_bottom4.setLayout(new GridBagLayout());
			jPanel_bottom4.setBounds(new Rectangle(755, 2, 251, 161));
		}
		return jPanel_bottom4;
	}

	/**
	 * This method initializes jTabbedPane_left
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane_left() {
		if (jTabbedPane_left == null) {
			jTabbedPane_left = new JTabbedPane();
			jTabbedPane_left.setBounds(new Rectangle(5, 40, 497, 356));
			jTabbedPane_left.addTab("Parameters", null, getJPanel_parameters(),
					null);
			// jTabbedPane_left.addTab("Contagion", null,
			// getJScrollPane_contagionLeft(), null);
		}
		return jTabbedPane_left;
	}

	/**
	 * This method initializes jPanel_parameters
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_parameters() {
		if (jPanel_parameters == null) {
			jPanel_parameters = new JPanel();
			GridBagLayout gbl_jPanel_parameters = new GridBagLayout();
			gbl_jPanel_parameters.columnWidths = new int[] { 75, 14, 15, 0 };
			gbl_jPanel_parameters.rowHeights = new int[] { 23, 20, 20, 20, 21,
					24, 23, 22, 21, 21, 20, 0 };
			gbl_jPanel_parameters.columnWeights = new double[] { 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_jPanel_parameters.rowWeights = new double[] { 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			jPanel_parameters.setLayout(gbl_jPanel_parameters);
			jLabel = new JLabel();
			jLabel.setText("Dataset data:");

			GridBagConstraints gbc_jLabel = new GridBagConstraints();
			gbc_jLabel.anchor = GridBagConstraints.WEST;
			gbc_jLabel.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel.gridwidth = 2;
			gbc_jLabel.gridx = 0;
			gbc_jLabel.gridy = 0;
			jPanel_parameters.add(jLabel, gbc_jLabel);
			GridBagConstraints gbc_jComboBox_data = new GridBagConstraints();
			gbc_jComboBox_data.fill = GridBagConstraints.HORIZONTAL;
			gbc_jComboBox_data.anchor = GridBagConstraints.SOUTH;
			gbc_jComboBox_data.insets = new Insets(0, 0, 5, 0);
			gbc_jComboBox_data.gridx = 2;
			gbc_jComboBox_data.gridy = 0;
			jPanel_parameters.add(getJComboBox_data(), gbc_jComboBox_data);
			jLabel1 = new JLabel();
			jLabel1.setText("Simulations parameters:");
			GridBagConstraints gbc_jLabel1 = new GridBagConstraints();
			gbc_jLabel1.anchor = GridBagConstraints.WEST;
			gbc_jLabel1.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel1.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel1.gridx = 0;
			gbc_jLabel1.gridy = 1;
			jPanel_parameters.add(jLabel1, gbc_jLabel1);
			jLabel2 = new JLabel();
			jLabel2.setText("Trigger bank:");
			GridBagConstraints gbc_jLabel2 = new GridBagConstraints();
			gbc_jLabel2.anchor = GridBagConstraints.WEST;
			gbc_jLabel2.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel2.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel2.gridx = 0;
			gbc_jLabel2.gridy = 3;
			jPanel_parameters.add(jLabel2, gbc_jLabel2);
			jLabel3 = new JLabel();
			jLabel3.setText("% loss:");
			jLabel3.setVisible(false);
			GridBagConstraints gbc_jComboBox_banks = new GridBagConstraints();
			gbc_jComboBox_banks.fill = GridBagConstraints.BOTH;
			gbc_jComboBox_banks.insets = new Insets(0, 0, 5, 0);
			gbc_jComboBox_banks.gridx = 2;
			gbc_jComboBox_banks.gridy = 3;
			jPanel_parameters.add(getJComboBox_banks(), gbc_jComboBox_banks);
			GridBagConstraints gbc_jLabel3 = new GridBagConstraints();
			gbc_jLabel3.anchor = GridBagConstraints.WEST;
			gbc_jLabel3.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel3.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel3.gridwidth = 2;
			gbc_jLabel3.gridx = 0;
			gbc_jLabel3.gridy = 4;
			jPanel_parameters.add(jLabel3, gbc_jLabel3);
			GridBagConstraints gbc_jTextField = new GridBagConstraints();
			gbc_jTextField.fill = GridBagConstraints.BOTH;
			gbc_jTextField.insets = new Insets(0, 0, 5, 0);
			gbc_jTextField.gridx = 2;
			gbc_jTextField.gridy = 4;
			jPanel_parameters.add(getJTextField(), gbc_jTextField);

			jLabel8 = new JLabel();
			jLabel8.setText("Core Capital buffer:");
			GridBagConstraints gbc_jLabel8 = new GridBagConstraints();
			gbc_jLabel8.anchor = GridBagConstraints.WEST;
			gbc_jLabel8.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel8.gridx = 0;
			gbc_jLabel8.gridy = 5;
			jPanel_parameters.add(jLabel8, gbc_jLabel8);
			GridBagConstraints gbc_jTextField3 = new GridBagConstraints();
			gbc_jTextField3.fill = GridBagConstraints.HORIZONTAL;
			gbc_jTextField3.anchor = GridBagConstraints.NORTH;
			gbc_jTextField3.insets = new Insets(0, 0, 5, 0);
			gbc_jTextField3.gridx = 2;
			gbc_jTextField3.gridy = 5;
			jPanel_parameters.add(getJTextField3(), gbc_jTextField3);
			jLabel4 = new JLabel();
			jLabel4.setText("Experiment:");
			GridBagConstraints gbc_jLabel4 = new GridBagConstraints();
			gbc_jLabel4.anchor = GridBagConstraints.WEST;
			gbc_jLabel4.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel4.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel4.gridx = 0;
			gbc_jLabel4.gridy = 6;
			jPanel_parameters.add(jLabel4, gbc_jLabel4);
			GridBagConstraints gbc_jComboBox_exp = new GridBagConstraints();
			gbc_jComboBox_exp.fill = GridBagConstraints.HORIZONTAL;
			gbc_jComboBox_exp.anchor = GridBagConstraints.NORTH;
			gbc_jComboBox_exp.insets = new Insets(0, 0, 5, 0);
			gbc_jComboBox_exp.gridx = 2;
			gbc_jComboBox_exp.gridy = 6;
			jPanel_parameters.add(getJComboBox_exp(), gbc_jComboBox_exp);
			jLabel5 = new JLabel();
			jLabel5.setText("% MBS:");
			jLabel5.setVisible(false);
			GridBagConstraints gbc_jLabel5 = new GridBagConstraints();
			gbc_jLabel5.anchor = GridBagConstraints.WEST;
			gbc_jLabel5.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel5.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel5.gridx = 0;
			gbc_jLabel5.gridy = 7;
			jPanel_parameters.add(jLabel5, gbc_jLabel5);
			GridBagConstraints gbc_jTextField1 = new GridBagConstraints();
			gbc_jTextField1.fill = GridBagConstraints.HORIZONTAL;
			gbc_jTextField1.anchor = GridBagConstraints.NORTH;
			gbc_jTextField1.insets = new Insets(0, 0, 5, 0);
			gbc_jTextField1.gridx = 2;
			gbc_jTextField1.gridy = 7;
			jPanel_parameters.add(getJTextField1(), gbc_jTextField1);
			jLabel6 = new JLabel();
			jLabel6.setText("Network topology:");
			GridBagConstraints gbc_jLabel6 = new GridBagConstraints();
			gbc_jLabel6.anchor = GridBagConstraints.WEST;
			gbc_jLabel6.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel6.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel6.gridx = 0;
			gbc_jLabel6.gridy = 8;
			jPanel_parameters.add(jLabel6, gbc_jLabel6);
			GridBagConstraints gbc_jComboBox_net = new GridBagConstraints();
			gbc_jComboBox_net.fill = GridBagConstraints.BOTH;
			gbc_jComboBox_net.insets = new Insets(0, 0, 5, 0);
			gbc_jComboBox_net.gridx = 2;
			gbc_jComboBox_net.gridy = 8;
			jPanel_parameters.add(getJComboBox_net(), gbc_jComboBox_net);
			jLabel7 = new JLabel();
			jLabel7.setText("rnd seed:");
			jLabel7.setVisible(false);
			GridBagConstraints gbc_jLabel7 = new GridBagConstraints();
			gbc_jLabel7.anchor = GridBagConstraints.WEST;
			gbc_jLabel7.fill = GridBagConstraints.VERTICAL;
			gbc_jLabel7.insets = new Insets(0, 0, 5, 5);
			gbc_jLabel7.gridx = 0;
			gbc_jLabel7.gridy = 9;
			jPanel_parameters.add(jLabel7, gbc_jLabel7);
			GridBagConstraints gbc_jTextField2 = new GridBagConstraints();
			gbc_jTextField2.fill = GridBagConstraints.BOTH;
			gbc_jTextField2.insets = new Insets(0, 0, 5, 0);
			gbc_jTextField2.gridx = 2;
			gbc_jTextField2.gridy = 9;
			jPanel_parameters.add(getJTextField2(), gbc_jTextField2);
			GridBagConstraints gbc_jCheckBox = new GridBagConstraints();
			gbc_jCheckBox.fill = GridBagConstraints.BOTH;
			gbc_jCheckBox.insets = new Insets(0, 0, 0, 5);
			gbc_jCheckBox.gridwidth = 2;
			gbc_jCheckBox.gridx = 0;
			gbc_jCheckBox.gridy = 10;
			jPanel_parameters.add(getJCheckBox(), gbc_jCheckBox);
		}
		return jPanel_parameters;
	}

	/**
	 * This method initializes jPanel_contagionLeft
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_contagionLeft() {
		if (jPanel_contagionLeft == null) {
			jPanel_contagionLeft = new JPanel();
			jPanel_Contagion_Control_Left = new JPanel();
			jPanel_contagionLeft.setLayout(new BorderLayout());
			jPanel_contagionLeft.add(this.getGraphContagion(), null);
			// jPanel_contagionLeft.add(this.getTreeCollapseDemo(), null);
			jPanel_Contagion_Control_Left.add(
					this.graphContagion.graphMouse2.getModeComboBox(), null);
			jPanel_contagionLeft.add(jPanel_Contagion_Control_Left,
					BorderLayout.NORTH);

		}
		return jPanel_contagionLeft;
	}

	/**
	 * This method initializes jTabbedPane_leftBottom
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane_leftBottom() {
		if (jTabbedPane_leftBottom == null) {
			jTabbedPane_leftBottom = new JTabbedPane();
			jTabbedPane_leftBottom.setBounds(new Rectangle(5, 400, 497, 148));
			jTabbedPane_leftBottom.addTab("Statistics", null,
					getJPanel_statistics1(), null);
			jTabbedPane_leftBottom.addTab("InDegrees", null,
					getJPanel_statistics2(), null);
			jTabbedPane_leftBottom.addTab("OutDegrees", null,
					getJPanel_statistics3(), null);
		}
		return jTabbedPane_leftBottom;
	}

	/**
	 * This method initializes jPanel_statistics1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_statistics1() {
		if (jPanel_statistics1 == null) {
			jLabel912 = new JLabel();
			jLabel912.setBounds(new Rectangle(255, 85, 22, 20));
			jLabel912.setForeground(new Color(0, 150, 0));
			jLabel912.setText("$bn");
			jLabel911 = new JLabel();
			jLabel911.setBounds(new Rectangle(255, 50, 23, 20));
			jLabel911.setForeground(Color.blue);
			jLabel911.setText("$bn");
			jLabel_CDS = new JLabel();
			jLabel_CDS.setBounds(new Rectangle(177, 85, 74, 20));
			jLabel_CDS.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_CDS.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_CDS.setForeground(new Color(0, 150, 0));
			jLabel_CDS.setText("0");
			jLabel_CC = new JLabel();
			jLabel_CC.setBounds(new Rectangle(176, 50, 76, 20));
			jLabel_CC.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_CC.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_CC.setForeground(Color.blue);
			jLabel_CC.setText("0");
			jLabel_numDB1 = new JLabel();
			jLabel_numDB1.setBounds(new Rectangle(173, 13, 104, 20));
			jLabel_numDB1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_numDB1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_numDB1.setForeground(Color.red);
			jLabel_numDB1.setText("0");
			jLabel93 = new JLabel();
			jLabel93.setBounds(new Rectangle(5, 85, 129, 20));
			jLabel93.setForeground(new Color(0, 150, 0));
			jLabel93.setText("Aggregate CDS Cover:");
			jLabel92 = new JLabel();
			jLabel92.setBounds(new Rectangle(5, 50, 136, 20));
			jLabel92.setForeground(Color.blue);
			jLabel92.setText("Aggregate Core Capital:");
			jLabel91 = new JLabel();
			jLabel91.setBounds(new Rectangle(5, 13, 133, 20));
			jLabel91.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel91.setForeground(Color.red);
			jLabel91.setText("Num Defaulting Banks:");
			jPanel_statistics1 = new JPanel();
			jPanel_statistics1.setLayout(null);
			jPanel_statistics1.add(jLabel91, null);
			jPanel_statistics1.add(jLabel92, null);
			jPanel_statistics1.add(jLabel93, null);
			jPanel_statistics1.add(jLabel_numDB1, null);
			jPanel_statistics1.add(jLabel_CC, null);
			jPanel_statistics1.add(jLabel_CDS, null);
			jPanel_statistics1.add(jLabel911, null);
			jPanel_statistics1.add(jLabel912, null);
		}
		return jPanel_statistics1;
	}

	/**
	 * This method initializes jPanel_statistics2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_statistics2() {
		if (jPanel_statistics2 == null) {
			jLabel_INclust = new JLabel();
			jLabel_INclust.setBounds(new Rectangle(220, 85, 65, 19));
			jLabel_INclust.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INclust.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INclust.setForeground(new Color(0, 150, 0));
			jLabel_INclust.setText("0");
			jLabel_INconn = new JLabel();
			jLabel_INconn.setBounds(new Rectangle(220, 50, 65, 20));
			jLabel_INconn.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INconn.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INconn.setForeground(Color.blue);
			jLabel_INconn.setText("0");
			jLabel_INkurt = new JLabel();
			jLabel_INkurt.setBounds(new Rectangle(220, 13, 65, 21));
			jLabel_INkurt.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INkurt.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INkurt.setForeground(Color.red);
			jLabel_INkurt.setText("0");
			jLabel_INskew = new JLabel();
			jLabel_INskew.setBounds(new Rectangle(70, 85, 65, 20));
			jLabel_INskew.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INskew.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INskew.setForeground(new Color(0, 150, 0));
			jLabel_INskew.setText("0");
			jLabel_INstd = new JLabel();
			jLabel_INstd.setBounds(new Rectangle(70, 50, 65, 20));
			jLabel_INstd.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INstd.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INstd.setForeground(Color.blue);
			jLabel_INstd.setText("0");
			jLabel_INmean = new JLabel();
			jLabel_INmean.setBounds(new Rectangle(70, 13, 65, 20));
			jLabel_INmean.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_INmean.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_INmean.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_INmean.setForeground(Color.red);
			jLabel_INmean.setText("0");
			jLabel99 = new JLabel();
			jLabel99.setBounds(new Rectangle(150, 85, 52, 21));
			jLabel99.setForeground(new Color(0, 150, 0));
			jLabel99.setText("Cluster:");
			jLabel98 = new JLabel();
			jLabel98.setBounds(new Rectangle(150, 50, 55, 20));
			jLabel98.setForeground(Color.blue);
			jLabel98.setText("Connect:");
			jLabel97 = new JLabel();
			jLabel97.setBounds(new Rectangle(150, 13, 51, 20));
			jLabel97.setForeground(Color.red);
			jLabel97.setText("Kurt:");
			jLabel96 = new JLabel();
			jLabel96.setBounds(new Rectangle(5, 85, 40, 20));
			jLabel96.setForeground(new Color(0, 150, 0));
			jLabel96.setText("Skew:");
			jLabel95 = new JLabel();
			jLabel95.setBounds(new Rectangle(5, 50, 40, 20));
			jLabel95.setForeground(Color.blue);
			jLabel95.setText("Std:");
			jLabel94 = new JLabel();
			jLabel94.setBounds(new Rectangle(5, 13, 40, 20));
			jLabel94.setForeground(Color.red);
			jLabel94.setText("Mean:");
			jPanel_statistics2 = new JPanel();
			jPanel_statistics2.setLayout(null);
			jPanel_statistics2.add(jLabel94, null);
			jPanel_statistics2.add(jLabel95, null);
			jPanel_statistics2.add(jLabel96, null);
			jPanel_statistics2.add(jLabel97, null);
			jPanel_statistics2.add(jLabel98, null);
			jPanel_statistics2.add(jLabel99, null);
			jPanel_statistics2.add(jLabel_INmean, null);
			jPanel_statistics2.add(jLabel_INstd, null);
			jPanel_statistics2.add(jLabel_INskew, null);
			jPanel_statistics2.add(jLabel_INkurt, null);
			jPanel_statistics2.add(jLabel_INconn, null);
			jPanel_statistics2.add(jLabel_INclust, null);
		}
		return jPanel_statistics2;
	}

	/**
	 * This method initializes jPanel_statistics3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_statistics3() {
		if (jPanel_statistics3 == null) {
			jLabel918 = new JLabel();
			jLabel918.setBounds(new Rectangle(150, 85, 53, 20));
			jLabel918.setForeground(new Color(0, 150, 0));
			jLabel918.setText("Cluster:");
			jLabel917 = new JLabel();
			jLabel917.setBounds(new Rectangle(150, 50, 52, 20));
			jLabel917.setForeground(Color.blue);
			jLabel917.setText("Connect:");
			jLabel916 = new JLabel();
			jLabel916.setBounds(new Rectangle(150, 13, 46, 20));
			jLabel916.setForeground(Color.red);
			jLabel916.setText("Kurt:");
			jLabel915 = new JLabel();
			jLabel915.setBounds(new Rectangle(5, 85, 40, 20));
			jLabel915.setForeground(new Color(0, 150, 0));
			jLabel915.setText("Skew:");
			jLabel914 = new JLabel();
			jLabel914.setBounds(new Rectangle(5, 50, 40, 20));
			jLabel914.setForeground(Color.blue);
			jLabel914.setText("Std:");
			jLabel913 = new JLabel();
			jLabel913.setBounds(new Rectangle(5, 13, 40, 20));
			jLabel913.setForeground(Color.red);
			jLabel913.setText("Mean:");
			jLabel_OUTclust = new JLabel();
			jLabel_OUTclust.setBounds(new Rectangle(220, 85, 65, 20));
			jLabel_OUTclust.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTclust.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTclust.setForeground(new Color(0, 150, 0));
			jLabel_OUTclust.setText("0");
			jLabel_OUTconn = new JLabel();
			jLabel_OUTconn.setBounds(new Rectangle(220, 50, 65, 20));
			jLabel_OUTconn.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTconn.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTconn.setForeground(Color.blue);
			jLabel_OUTconn.setText("0");
			jLabel_OUTkurt = new JLabel();
			jLabel_OUTkurt.setBounds(new Rectangle(220, 13, 65, 20));
			jLabel_OUTkurt.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTkurt.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTkurt.setForeground(Color.red);
			jLabel_OUTkurt.setText("0");
			jLabel_OUTskew = new JLabel();
			jLabel_OUTskew.setBounds(new Rectangle(70, 85, 65, 20));
			jLabel_OUTskew.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTskew.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTskew.setForeground(new Color(0, 150, 0));
			jLabel_OUTskew.setText("0");
			jLabel_OUTstd = new JLabel();
			jLabel_OUTstd.setBounds(new Rectangle(70, 50, 65, 20));
			jLabel_OUTstd.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTstd.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTstd.setForeground(Color.blue);
			jLabel_OUTstd.setText("0");
			jLabel_OUTmean = new JLabel();
			jLabel_OUTmean.setBounds(new Rectangle(70, 13, 65, 20));
			jLabel_OUTmean.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel_OUTmean.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_OUTmean.setForeground(Color.red);
			jLabel_OUTmean.setText("0");
			jPanel_statistics3 = new JPanel();
			jPanel_statistics3.setLayout(null);
			jPanel_statistics3.add(jLabel_OUTmean, null);
			jPanel_statistics3.add(jLabel_OUTstd, null);
			jPanel_statistics3.add(jLabel_OUTskew, null);
			jPanel_statistics3.add(jLabel_OUTkurt, null);
			jPanel_statistics3.add(jLabel_OUTconn, null);
			jPanel_statistics3.add(jLabel_OUTclust, null);
			jPanel_statistics3.add(jLabel913, null);
			jPanel_statistics3.add(jLabel914, null);
			jPanel_statistics3.add(jLabel915, null);
			jPanel_statistics3.add(jLabel916, null);
			jPanel_statistics3.add(jLabel917, null);
			jPanel_statistics3.add(jLabel918, null);
		}
		return jPanel_statistics3;
	}

	private VisualizationViewer<? extends Object, ? extends Object> getGraphCDS() {
		if (this.graphCDS == null) {
			this.graphCDS = new GraphCDS();
		}
		return graphCDS.getGraphVisualizer(Network.getGraph(this.model.nodes,
				this.model.matrices.get(this.model.matrices.size() - 1)), 650,
				450);
	}

	private VisualizationViewer<? extends Object, ? extends Object> getGraphContagion() {
		if (this.graphContagion == null) {
			this.graphContagion = new GraphContagion();
		}
		return graphContagion.getGraphVisualizer(this.model.contagionList,
				this.model.nodes, 497, 497);

	}

	/**
	 * This method initializes jScrollPane_contagionLeft
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane_contagionLeft() {
		if (jScrollPane_contagionLeft == null) {
			jScrollPane_contagionLeft = new JScrollPane();
			// jScrollPane_contagionLeft.add(this.getTreeCollapseDemo(), null);
			jScrollPane_contagionLeft
					.setViewportView(getJPanel_contagionLeft2());
		}
		return jScrollPane_contagionLeft;
	}

	/**
	 * This method initializes jPanel_contagionLeft2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel_contagionLeft2() {
		if (jPanel_contagionLeft2 == null) {
			jPanel_contagionLeft2 = new JPanel();
			jPanel_contagionLeft2.setLayout(null);
			// jPanel_contagionLeft2.add(this.getTreeCollapseDemo(), null);
		}
		return jPanel_contagionLeft2;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
