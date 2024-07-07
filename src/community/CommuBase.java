package community;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CommuBase extends JFrame{

		private static CommuBase instance;

		private CommuBase(JPanel e) {
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			setTitle("Pick up game");
			setLayout(null);
			setBounds(((int)tk.getScreenSize().getHeight()) /2 - 300,
					((int) tk.getScreenSize().getHeight())/2 -400,
					600,900);
			add(e);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		
		public static void getInstance(JPanel e) {
			instance = new CommuBase(e);
			
			instance.getContentPane().removeAll();
			instance.getContentPane().add(e);
			instance.revalidate();
			instance.repaint();
			}
}
