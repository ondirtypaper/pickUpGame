package membership;

import javax.swing.*;
import java.awt.*;

public class MemberInfoPanel extends JPanel {
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel pointsLabel;
    private JLabel gradeLabel;
    private Font labelFont;

    public MemberInfoPanel(MemberBase memberBase) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // 간격 조정
        gbc.fill = GridBagConstraints.HORIZONTAL; // 수평으로 확장

        // 기본 폰트 크기 설정
        labelFont = new Font("맑은 고딕", Font.BOLD, 18);

        idLabel = new JLabel("아이디: ");
        idLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(idLabel, gbc);

        passwordLabel = new JLabel("비밀번호: ");
        passwordLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(passwordLabel, gbc);

        emailLabel = new JLabel("이메일: ");
        emailLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(emailLabel, gbc);

        nameLabel = new JLabel("이름: ");
        nameLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(nameLabel, gbc);

        ageLabel = new JLabel("나이: ");
        ageLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(ageLabel, gbc);

        pointsLabel = new JLabel("포인트: ");
        pointsLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(pointsLabel, gbc);

        gradeLabel = new JLabel("등급: ");
        gradeLabel.setFont(labelFont.deriveFont(22.0f)); // 폰트 크기 키우기
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST; // 맨 왼쪽에 배치
        add(gradeLabel, gbc);

        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색
    }

    public void updateMemberInfo(Member member) {
        idLabel.setText("아이디: " + member.getId());
        passwordLabel.setText("비밀번호: " + member.getPassword());
        emailLabel.setText("이메일: " + member.getEmail());
        nameLabel.setText("이름: " + member.getName());
        ageLabel.setText("나이: " + member.getAge());
        pointsLabel.setText("포인트: " + member.getPoints());
        gradeLabel.setText("등급: " + member.getGrade());
    }
}
