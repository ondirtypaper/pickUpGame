package membership;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MemberListPanel extends JPanel {
    private JList<Member> memberList;
    private DefaultListModel<Member> listModel;
    private MemberBase memberBase;

    public MemberListPanel(MemberBase memberBase) {
        this.memberBase = memberBase;
        listModel = new DefaultListModel<>();
        memberList = new JList<>(listModel);
        memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);  // Set background color to green
        add(new JScrollPane(memberList), BorderLayout.CENTER);
    }

    public void refreshMemberList(List<Member> members) {
        listModel.clear();
        for (Member member : members) {
            listModel.addElement(member);
        }
    }

    public Member getSelectedMember() {
        return memberList.getSelectedValue();
    }
}