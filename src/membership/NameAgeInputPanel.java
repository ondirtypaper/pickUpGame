package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameAgeInputPanel extends JPanel {
    private JTextField nameField;
    private JTextField ageField;
    private JButton submitButton;
    private MemberBase memberBase;
    private JLabel gradeLabel;  // 등급을 표시할 라벨 추가

    public NameAgeInputPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new GridLayout(4, 2));
        setBackground(Color.GREEN);

        nameField = new JTextField();
        ageField = new JTextField();
        submitButton = new JButton("제출");
        gradeLabel = new JLabel();  // 등급을 표시할 라벨 생성

        add(new JLabel("이름:"));
        add(nameField);
        add(new JLabel("나이:"));
        add(ageField);
        add(submitButton);
        add(gradeLabel);  // 등급을 표시할 라벨 추가

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String ageText = ageField.getText();
                try {
                    int age = Integer.parseInt(ageText);
                    Member member = new Member(name, age);
                    memberBase.setCurrentMember(member);
                    memberBase.saveMemberData();
                    memberBase.showPanel("MemberInfo");
                    MemberInfoPanel memberInfoPanel = (MemberInfoPanel) memberBase.getMainPanel().getComponent(1);
                    memberInfoPanel.updateMemberInfo(member);
                    gradeLabel.setText("현재 등급: " + member.getGrade());  // 등급을 표시
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(NameAgeInputPanel.this, "유효한 나이를 입력하세요.");
                }
            }
        });
    }

    public void resetFields() {
        nameField.setText("");
        ageField.setText("");
        gradeLabel.setText("");  // 등급 라벨 초기화
    }
}