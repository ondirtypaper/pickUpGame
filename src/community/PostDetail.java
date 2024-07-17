package community;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import frame.RootFrame;



public class PostDetail extends JPanel {
    public PostDetail(CommuVO commuVO) {
        setBackground(Color.white);
        setLayout(null);
        setSize(600, 900);

        JLabel title = new JLabel(commuVO.getTitle());
        title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        title.setBounds(50, 20, 500, 30);
        add(title);

        JLabel writer = new JLabel("작성자: " + commuVO.getpName());
        writer.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        writer.setBounds(50, 50, 500, 20);
        add(writer);

        JTextArea detail = new JTextArea(commuVO.getDeTail());
        detail.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        detail.setLineWrap(true);
        detail.setWrapStyleWord(true);
        detail.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detail);
        scrollPane.setBounds(50, 80, 500, 680);
        add(scrollPane);

        JButton btnBack = new JButton("뒤로가기");
        btnBack.setBackground(Color.white);
        btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnBack.setBounds(200, 780, 200, 50);
        btnBack.addActionListener(e -> RootFrame.setFrameFor(new CommuBegin()));
        add(btnBack);
    }
}