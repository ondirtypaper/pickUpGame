package membership;

import javax.swing.*;
import java.awt.*;

public class SpecialOfferPanel extends JPanel {
    private JLabel specialOfferLabel;
    private JButton backButton;
    private MemberBase memberBase;
    private Font labelFont;

    public SpecialOfferPanel(MemberBase memberBase) {
        this.memberBase = memberBase;
        
        labelFont = new Font("맑은 고딕", Font.BOLD, 18);

        setLayout(new BorderLayout());
        setBackground(new Color(231, 243, 231)); // 연한 녹색 배경색

        specialOfferLabel = new JLabel("축하합니다! 플래티넘에 당첨되었습니다. 특별한 상품을 드립니다!", SwingConstants.CENTER);
        specialOfferLabel.setFont(labelFont.deriveFont(18.0f));
        add(specialOfferLabel, BorderLayout.CENTER);

        backButton = new JButton("다시 입력");
        add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            memberBase.showPanel("NameAgeInput");
            NameAgeInputPanel nameAgeInputPanel = (NameAgeInputPanel) memberBase.getMainPanel().getComponent(0);
            nameAgeInputPanel.resetFields();
        });
    }
}