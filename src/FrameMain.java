

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
public class FrameMain {

	private JFrame jFrame_main = null;  //  @jve:decl-index=0:visual-constraint="0,0"
	private JPanel jContentPane_main = null;
	private JMenuBar jJMenuBar_main = null;
	private JMenu jMenu_file = null;
	private JMenu jMenu_tools = null;
	/**
	 * This method initializes jFrame_main	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame_main() {
		if (jFrame_main == null) {
			jFrame_main = new JFrame();
			jFrame_main.setSize(new Dimension(625, 310));
			jFrame_main.setTitle("Financial Contagion Simulator");
			jFrame_main.setJMenuBar(getJJMenuBar_main());
			jFrame_main.setContentPane(getJContentPane_main());
		}
		return jFrame_main;
	}

	/**
	 * This method initializes jContentPane_main	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane_main() {
		if (jContentPane_main == null) {
			jContentPane_main = new JPanel();
			jContentPane_main.setLayout(null);
		}
		return jContentPane_main;
	}

	/**
	 * This method initializes jJMenuBar_main	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar_main() {
		if (jJMenuBar_main == null) {
			jJMenuBar_main = new JMenuBar();
			jJMenuBar_main.add(getJMenu_file());
			jJMenuBar_main.add(getJMenu_tools());
		}
		return jJMenuBar_main;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_file() {
		if (jMenu_file == null) {
			jMenu_file = new JMenu();
			jMenu_file.setText("File");
		}
		return jMenu_file;
	}

	/**
	 * This method initializes jMenu_tools	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu_tools() {
		if (jMenu_tools == null) {
			jMenu_tools = new JMenu();
			jMenu_tools.setText("Tools");
		}
		return jMenu_tools;
	}

}
