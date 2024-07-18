package membership;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MemberListPanel extends JPanel {
    private JTextArea memberListArea;    
    private MemberBase memberBase;

    public MemberListPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new BorderLayout());
        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색
        
        memberListArea = new JTextArea();
        memberListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(memberListArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateMemberList(List<Member> members) {
        StringBuilder listContent = new StringBuilder();
        for (Member member : members) {
            listContent.append("이름: ").append(member.getName())
                    .append(", 나이: ").append(member.getAge())
                    .append(", 등급: ").append(member.getGrade())
                    .append("\n");
        }
        memberListArea.setText(listContent.toString());
    }
}