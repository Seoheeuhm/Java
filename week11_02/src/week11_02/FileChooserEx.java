package week11_02;

import javax.swing.*;
import javax.swing.filechooser.*;

import week11_02.OptionPaneEx.MyPanel;

import java.awt.event.*;
import java.awt.*;



public class FileChooserEx extends JFrame{
	private JLabel imgLabel = new JLabel();
	
	public FileChooserEx() {
		setTitle("파일 탐색기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(imgLabel);
		createMenu();
		
		setSize(500,250);
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu FileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		openItem.addActionListener(new OpenFileActionListener());
		
		FileMenu.add(openItem);
		mb.add(FileMenu);
		setJMenuBar(mb);
	}
	
	class OpenFileActionListener implements ActionListener {
		private JFileChooser chooser;
		FileNameExtensionFilter filter;
		
		public OpenFileActionListener() {
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter("JPG, GIF, PNG Images", "jpg", "gif", "png");			
		}
		
		public void actionPerformed(ActionEvent e) {
			chooser.setFileFilter(filter);
			int result = chooser.showOpenDialog(null);
			
			if(result != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String filePath = chooser.getSelectedFile(). getPath();
			imgLabel.setIcon(new ImageIcon(filePath));
			pack();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileChooserEx();
	}

}
