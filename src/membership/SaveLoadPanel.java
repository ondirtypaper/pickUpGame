package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SaveLoadPanel extends JPanel {
    private JButton saveButton;
    private JButton loadButton;
    private MemberBase memberBase;

    public SaveLoadPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        saveButton = new JButton("저장");
        add(saveButton);

        loadButton = new JButton("불러오기");
        add(loadButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberBase.saveMemberData();
                JOptionPane.showMessageDialog(SaveLoadPanel.this, "회원 정보가 저장되었습니다.");
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberBase.showPanel("MemberList");
                MemberListPanel memberListPanel = (MemberListPanel) memberBase.getMainPanel().getComponent(5);
                List<Member> members = memberBase.getMemberList();
                memberListPanel.updateMemberList(members);
            }
        });
    }
}