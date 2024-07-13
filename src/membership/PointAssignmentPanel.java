package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointAssignmentPanel extends JPanel {
    private JTextField pointsField;
    private JButton submitButton;
    private JLabel gradeLabel;  // 등급을 표시할 라벨 추가
    private MemberBase memberBase;

    public PointAssignmentPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new GridLayout(3, 2));
        setBackground(Color.GREEN);

        pointsField = new JTextField();
        submitButton = new JButton("포인트 제출");
        gradeLabel = new JLabel();  // 등급을 표시할 라벨 생성

        add(new JLabel("포인트:"));
        add(pointsField);
        add(submitButton);
        add(gradeLabel);  // 등급을 표시할 라벨 추가

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int points = Integer.parseInt(pointsField.getText());
                    Member currentMember = memberBase.getCurrentMember();
                    if (currentMember != null) {
                        currentMember.setPoints(points);
                        memberBase.showPanel("SpecialOffer");
                        gradeLabel.setText("현재 등급: " + currentMember.getGrade());  // 등급을 표시
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PointAssignmentPanel.this, "유효한 포인트를 입력하세요.");
                }
            }
        });
    }
}