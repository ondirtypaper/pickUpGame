package membership;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MemberBase extends JFrame {
    private static MemberBase instance;
    private List<Member> memberList;
    private Member currentMember;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Stack<String> panelHistory;
    private ControlPanel controlPanel;

    public static MemberBase getInstance() {
        if (instance == null) {
            instance = new MemberBase();
        }
        return instance;
    }

    private MemberBase() {
        memberList = new ArrayList<>();
        setTitle("회원 관리 시스템");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        panelHistory = new Stack<>();

        // 패널들 생성
        NameAgeInputPanel nameAgeInputPanel = new NameAgeInputPanel(this);
        MemberInfoPanel memberInfoPanel = new MemberInfoPanel(this);
        PointAssignmentPanel pointAssignmentPanel = new PointAssignmentPanel(this);
        SpecialOfferPanel specialOfferPanel = new SpecialOfferPanel(this);
        SaveLoadPanel saveLoadPanel = new SaveLoadPanel(this);
        MemberListPanel memberListPanel = new MemberListPanel(this);

        // 패널들을 메인 패널에 추가
        mainPanel.add(nameAgeInputPanel, "NameAgeInput");
        mainPanel.add(memberInfoPanel, "MemberInfo");
        mainPanel.add(pointAssignmentPanel, "PointAssignment");
        mainPanel.add(specialOfferPanel, "SpecialOffer");
        mainPanel.add(saveLoadPanel, "SaveLoad");
        mainPanel.add(memberListPanel, "MemberList");

        // ControlPanel 추가
        controlPanel = new ControlPanel(this);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(controlPanel, BorderLayout.SOUTH);
        wrapperPanel.add(mainPanel, BorderLayout.CENTER);

        add(wrapperPanel);

        // 처음에는 NameAgeInput 패널을 표시
        showPanel("NameAgeInput");
    }

    public void showPanel(String panelName) {
        if (!panelHistory.isEmpty() && !panelHistory.peek().equals(panelName)) {
            panelHistory.push(panelName);
        } else if (panelHistory.isEmpty()) {
            panelHistory.push(panelName);
        }
        cardLayout.show(mainPanel, panelName);
    }

    public void showPreviousPanel() {
        if (panelHistory.size() > 1) {
            panelHistory.pop();
            cardLayout.show(mainPanel, panelHistory.peek());
        }
    }

    public void setCurrentMember(Member member) {
        this.currentMember = member;
    }

    public Member getCurrentMember() {
        return currentMember;
    }

    public void saveMemberData() {
        if (currentMember != null && !memberList.contains(currentMember)) {
            memberList.add(currentMember);
        }
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}