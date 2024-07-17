package membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JButton previousButton;
    private JButton nextButton;
    private JButton saveLoadButton;
    private MemberBase memberBase;

    public ControlPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new BorderLayout());
        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        previousButton = new JButton("이전");
        nextButton = new JButton("다음");
        saveLoadButton = new JButton("저장/불러오기");

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(previousButton);
        leftPanel.setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(nextButton);
        rightPanel.setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(saveLoadButton);
        centerPanel.setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberBase.showPreviousPanel();
            }
        });

        saveLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberBase.showPanel("SaveLoad");
            }
        });
    }

    public void setNextAction(ActionListener actionListener) {
        for (ActionListener al : nextButton.getActionListeners()) {
            nextButton.removeActionListener(al);
        }
        nextButton.addActionListener(actionListener);
    }
}