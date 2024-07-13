package membership;

import javax.swing.*;
import java.awt.*;

public class MemberInfoPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel gradeLabel;
    private MemberBase memberBase;

    public MemberInfoPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new GridLayout(3, 1));
        setBackground(Color.GREEN);

        nameLabel = new JLabel();
        ageLabel = new JLabel();
        gradeLabel = new JLabel();

        add(nameLabel);
        add(ageLabel);
        add(gradeLabel);
    }

    public void updateMemberInfo(Member member) {
        nameLabel.setText("이름: " + member.getName());
        ageLabel.setText("나이: " + member.getAge());
        gradeLabel.setText("등급: " + member.getGrade());
    }
}