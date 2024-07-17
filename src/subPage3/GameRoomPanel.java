package subPage3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import frame.ControlPanel;
import frame.RootFrame;

public class GameRoomPanel extends JPanel {
	
	public GameRoomPanel() {
		setSize(RootFrame.FRAME_WIDTH, RootFrame.FRAME_HEIGHT);
		setLayout(null);
		setVisible(true);
		setBackground(Color.black);
		
		add(GameRoomPanel_Top.gameRoomPanel_Top);
		
		
		ControlPanel controlPanel = new ControlPanel();
		controlPanel.setBackground(RootFrame.MAIN_RED);
		controlPanel.setSize(600, 100);
		controlPanel.setLocation(0, 801);
		controlPanel.setVisible(true);
		add(controlPanel);
	}
	
}

class GameRoomPanel_Top extends JPanel implements ActionListener {

	private JButton createRoomButton;
	private JPanel roomsPanel;
	private ArrayList<JButton> roomButtons;

	public static GameRoomPanel_Top gameRoomPanel_Top = new GameRoomPanel_Top();

	public GameRoomPanel_Top() {
		setLocation(0, 0);
		setSize(600, 800);
		setLayout(new BorderLayout());

		// Create the panel for rooms
		roomsPanel = new JPanel();
		roomsPanel.setLayout(new BoxLayout(roomsPanel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(roomsPanel);
		add(scrollPane, BorderLayout.CENTER);

		// Create the "Create Room" button
		createRoomButton = new JButton("방 만들기");
		createRoomButton.addActionListener(this);
		add(createRoomButton, BorderLayout.SOUTH);

		roomButtons = new ArrayList<>();

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createRoomButton) {
			new CreateRoomFrame(this);
		} else {
			for (JButton button : roomButtons) {
				if (e.getSource() == button) {
					new ChatRoomFrame(button.getText());
				}
			}
		}
	}

	public void addRoomButton(String roomName) {
		JButton roomButton = new JButton(roomName);
		roomButton.addActionListener(this);
		roomButtons.add(roomButton);
		roomsPanel.add(roomButton);
		roomsPanel.revalidate();
		roomsPanel.repaint();
	}

}

class CreateRoomFrame extends JFrame implements ActionListener {

	private JComboBox<String> roomTypeComboBox;
	private JButton registerButton;
	private GameRoomPanel_Top gameRoomPanel;

	public CreateRoomFrame(GameRoomPanel_Top gameRoomPanel) {
		this.gameRoomPanel = gameRoomPanel;

		setTitle("Create Room");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());

		setLocationRelativeTo(null);
		setResizable(false);

		// Room type selection
		String[] roomTypes = { "1on1", "2on2", "3on3", "4on4", "5on5" };
		roomTypeComboBox = new JComboBox<>(roomTypes);
		add(roomTypeComboBox);

		// Register button
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		add(registerButton);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			String selectedRoomType = (String) roomTypeComboBox.getSelectedItem();
			gameRoomPanel.addRoomButton(selectedRoomType + " Room");
			dispose();
		}
	}
}

class ChatRoomFrame extends JFrame {

	private JTextArea chatArea;
	private JTextField chatInputField;
	private JButton sendButton;

	public ChatRoomFrame(String roomName) {
		setTitle(roomName);
		setSize(500, 700);
		setLayout(null);
		setLocationRelativeTo(null);
//		setResizable(false);

		// User area
		JPanel userArea = new JPanel();
		userArea.setBackground(Color.orange);
		userArea.setLocation(0, 0);
		userArea.setSize(500, 300);
		userArea.setLayout(null);
		add(userArea);

		// Chat area panel
		JPanel chatPanel = new JPanel();
		chatPanel.setLocation(0, 300);
		chatPanel.setSize(500,300);
		chatPanel.setLayout(null);
		chatPanel.setBackground(Color.cyan);
		
		
		// Chat area
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		JScrollPane chatScrollPane = new JScrollPane(chatArea);
		chatScrollPane.setBounds(0, 300, 500, 300);
		chatPanel.add(chatScrollPane);
		

		// Chat input panel
		JPanel chatInputPanel = new JPanel();
		chatInputPanel.setBounds(0,600,500,100);
		chatInputPanel.setLayout(null);
		add(chatInputPanel);
		
		chatInputField = new JTextField();
		chatInputField.setBounds(0, 0, 400, 100);
		chatInputField.setMargin(new Insets(0, 0, 0, 0));
		chatInputPanel.add(chatInputField);

		sendButton = new JButton("Send");
		sendButton.addActionListener(e -> sendMessage());
		sendButton.setBounds(200, 0, 100, 100);
		sendButton.setMargin(new Insets(0, 0, 0, 0));
		chatInputPanel.add(sendButton);

		add(chatPanel);

		
		setVisible(true);
	}

	private void sendMessage() {
		String message = chatInputField.getText();
		if (!message.isEmpty()) {
			chatArea.append("You: " + message + "\n");
			chatInputField.setText("");
		}
	}
}

