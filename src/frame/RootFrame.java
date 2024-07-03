package frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RootFrame extends JFrame{

	private static RootFrame instance;
	
	private RootFrame(JPanel e) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 기본 JFrame 구조
		
		setTitle("Pick A Game");
		setLayout(null);
		setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 300, ((int) tk.getScreenSize().getHeight()) / 2 - 400,
				600, 900);
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	public static void getInstance(JPanel e) {
		if(instance == null)instance = new RootFrame(e);
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		instance.revalidate();
		instance.repaint();
	}
}
