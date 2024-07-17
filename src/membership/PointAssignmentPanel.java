package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointAssignmentPanel extends JPanel {
    private JTextField pointsField;
    private JButton assignButton;
    private JLabel resultLabel;
    private MemberBase memberBase;

    public PointAssignmentPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel pointsLabel = new JLabel("부여할 포인트:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(pointsLabel, gbc);

        pointsField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(pointsField, gbc);

        assignButton = new JButton("포인트 부여");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(assignButton, gbc);

        resultLabel = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(resultLabel, gbc);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int points = Integer.parseInt(pointsField.getText());
                    Member member = memberBase.getMember();
                    member.setPoints(points);
                    resultLabel.setText("포인트가 성공적으로 부여되었습니다. 현재 등급: " + member.getGrade());

                    // MemberInfoPanel 업데이트
                    MemberInfoPanel memberInfoPanel = (MemberInfoPanel) memberBase.getMainPanel().getComponent(1);
                    memberInfoPanel.updateMemberInfo(member);

                    // 플래티넘 회원이면 특별한 상품 패널로 이동
                    if (member.getGrade().equals("플래티넘")) {
                        memberBase.showPanel("SpecialOffer");
                    } else {
                        memberBase.showPanel("NameAgeInput");
                        NameAgeInputPanel nameAgeInputPanel = (NameAgeInputPanel) memberBase.getMainPanel().getComponent(0);
                        nameAgeInputPanel.resetFields();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PointAssignmentPanel.this, "유효한 포인트를 입력하세요.");
                }
            }
        });

        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색
    }
}