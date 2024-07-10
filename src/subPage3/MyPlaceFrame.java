package subPage3;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyPlaceFrame extends JFrame {
	boolean registerWhether;
	public MyPlaceFrame(Point p) {
		Toolkit tk=getToolkit();
		setSize(400, 200);
		setLayout(null);
		setBackground(Color.white);
		
		setVisible(true);
		if(registerWhether=true) {
		
		JLabel inputName=new JLabel();
		inputName.setLocation(50, 0);
		inputName.setSize(300,25);
		inputName.setText("나만의 장소의 이름을 알려주세요!");
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setVerticalAlignment(SwingConstants.TOP);
		inputName.setHorizontalTextPosition(SwingConstants.CENTER);
		inputName.setVisible(true);
		add(inputName);
		
		JTextField placeName=new JTextField();
		placeName.setLocation(50, 50);
		placeName.setSize(300, 25);
		placeName.setText("장소 이름");
		placeName.setHorizontalAlignment(SwingConstants.LEFT);
		placeName.setToolTipText("20글자 이하여야 돼요!");
		placeName.setEditable(false);
		placeName.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		placeName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(placeName.getText().equals(""))
					placeName.setText("장소 이름");
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				placeName.setEditable(true);
				if(placeName.getText().equals("장소 이름")) {
					placeName.setText("");
				}
			}
		});
		placeName.setVisible(true);
		
		
		add(placeName);
		
		JButton regiButton=new JButton();
		regiButton.setText("등록");
		regiButton.setBounds(0, 100, 100, 50);
		regiButton.setVisible(true);
		regiButton.setBackground(Color.orange);
		regiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();
					JOptionPane.showMessageDialog(regiButton, "등록이 완료되었습니다.");
					registerWhether=false;
			}
		});
		
		JButton cancelButton=new JButton();
		cancelButton.setText("취소");
		cancelButton.setBounds(200, 100, 100, 50);
		cancelButton.setVisible(true);
		cancelButton.setBackground(Color.orange);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		add(regiButton);
		add(cancelButton);
		
		
		}
	}
	
}
