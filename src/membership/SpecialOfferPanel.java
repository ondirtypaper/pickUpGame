package membership;

import javax.swing.*;
import java.awt.*;

public class SpecialOfferPanel extends JPanel {
    private JLabel specialOfferLabel;
    private JButton backButton;
    private MemberBase memberBase;

    public SpecialOfferPanel(MemberBase memberBase) {
        this.memberBase = memberBase;

        setLayout(new BorderLayout());
        setBackground(Color.GREEN);  // Set background color to green

        specialOfferLabel = new JLabel("축하합니다! 플레티넘에 당첨되었습니다. 특별한 상품을 드립니다!", SwingConstants.CENTER);
        backButton = new JButton("다시 입력");

        add(specialOfferLabel, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            memberBase.showPanel("NameAgeInput");
            NameAgeInputPanel nameAgeInputPanel = (NameAgeInputPanel) memberBase.getMainPanel().getComponent(0);
            nameAgeInputPanel.resetFields();
        });
    }
}