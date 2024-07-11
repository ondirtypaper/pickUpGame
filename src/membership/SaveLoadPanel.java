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

        setLayout(new GridLayout(2, 1));
        setBackground(Color.GREEN);

        saveButton = new JButton("저장");
        loadButton = new JButton("불러오기");

        add(saveButton);
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
                memberListPanel.refreshMemberList(members);
            }
        });
    }
}