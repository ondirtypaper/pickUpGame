package membership;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MemberBase extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private ControlPanel controlPanel;
    private Member member;
    private List<Member> memberList;

    public MemberBase() {
        setTitle("회원 관리");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 회원 목록 초기화
        memberList = new ArrayList<>();

        // 패널 추가
        mainPanel.add(new NameAgeInputPanel(this), "NameAgeInput");
        mainPanel.add(new MemberInfoPanel(this), "MemberInfo");
        mainPanel.add(new PointAssignmentPanel(this), "PointAssignment");
        mainPanel.add(new SpecialOfferPanel(this), "SpecialOffer");
        mainPanel.add(new SaveLoadPanel(this), "SaveLoad");
        mainPanel.add(new MemberListPanel(this), "MemberList");

        // ControlPanel 추가
        controlPanel = new ControlPanel(this);
        controlPanel.setBackground(new Color(200, 0, 0));
        controlPanel.setSize(800, 100);
        controlPanel.setLocation(0, 500);

        add(mainPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // 프레임 중앙에 위치
        setLocationRelativeTo(null);
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void showPreviousPanel() {
        cardLayout.previous(mainPanel);
    }

    public void showNextPanel() {
        cardLayout.next(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void saveMemberData() {
        if (member != null) {
            memberList.add(member);
        }
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MemberBase.getInstance().setVisible(true);
            }
        });
    }

    private static MemberBase instance;

    public static MemberBase getInstance() {
        if (instance == null) {
            instance = new MemberBase();
        }
        return instance;
    }
}