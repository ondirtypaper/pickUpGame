package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JButton nextButton;
    private JButton backButton;
    private JButton saveLoadButton;
    private JPanel buttonPanel;
    private MemberBase memberBase;
    private SaveLoadPanel saveLoadPanel;

    public ControlPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new BorderLayout());

        // 저장/불러오기 패널 생성 및 중앙 배치
        saveLoadPanel = new SaveLoadPanel(memberBase);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        centerPanel.setBackground(Color.GREEN);  // Set background color to green
        centerPanel.add(saveLoadPanel);
        add(centerPanel, BorderLayout.CENTER);

        // 하단 버튼 패널 생성
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.GREEN);  // Set background color to green

        backButton = new JButton("이전");
        nextButton = new JButton("다음");

        buttonPanel.add(backButton, BorderLayout.WEST);
        buttonPanel.add(nextButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberBase.showPreviousPanel();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member currentMember = memberBase.getCurrentMember();
                if (currentMember != null) {
                    memberBase.showPanel("PointAssignment");
                } else {
                    JOptionPane.showMessageDialog(ControlPanel.this, "회원을 선택하세요.");
                }
            }
        });
    }
}