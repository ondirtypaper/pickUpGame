package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameAgeInputPanel extends JPanel {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton submitButton;
    private MemberBase memberBase;

    public NameAgeInputPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // 필드 간격을 줄이기 위해 Insets 값 조정
        gbc.ipadx = 10;  // 내부 패딩 값 조정
        gbc.ipady = 10;

        Font labelFont = new Font("맑은 고딕", Font.BOLD, 18);

        JLabel idLabel = new JLabel("아이디:");
        idLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(idLabel, gbc);

        idField = new JTextField(15);
        idField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(idField, gbc);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        passwordField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passwordField, gbc);

        JLabel emailLabel = new JLabel("이메일:");
        emailLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(emailLabel, gbc);

        emailField = new JTextField(15);
        emailField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailField, gbc);

        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameLabel, gbc);

        nameField = new JTextField(15);
        nameField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameField, gbc);

        JLabel ageLabel = new JLabel("나이:");
        ageLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(ageLabel, gbc);

        ageField = new JTextField(15);
        ageField.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(ageField, gbc);

        submitButton = new JButton("제출");
        submitButton.setFont(labelFont);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                String name = nameField.getText();
                int age;
                try {
                    age = Integer.parseInt(ageField.getText());
                    Member member = new Member(id, password, email, name, age);
                    memberBase.setMember(member);
                    memberBase.showPanel("MemberInfo");

                    // MemberInfoPanel 업데이트
                    MemberInfoPanel memberInfoPanel = (MemberInfoPanel) memberBase.getMainPanel().getComponent(1);
                    memberInfoPanel.updateMemberInfo(member);

                    // ControlPanel의 다음 버튼 동작 설정
                    ControlPanel controlPanel = memberBase.getControlPanel();
                    controlPanel.setNextAction(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            memberBase.showPanel("PointAssignment");
                        }
                    });
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(NameAgeInputPanel.this, "유효한 나이를 입력하세요.");
                }
            }
        });

        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색
    }

    public void resetFields() {
        idField.setText("");
        passwordField.setText("");
        emailField.setText("");
        nameField.setText("");
        ageField.setText("");
    }
}
