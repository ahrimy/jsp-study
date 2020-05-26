package oliveYoung;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class StoreListPanel extends JPanel implements ActionListener {
	JButton back;
	Item item;
	JLabel title;
	JLabel searchTitle;
	JButton searchBtn;
	JTextField searchArea;
	JLabel[] list;
	ArrayList<Store> storeList;

	public StoreListPanel(Item item) {
		setLayout(null);
		this.item = item;
		back = new JButton("X");
		back.setBounds(1300, 50, 50, 50);
		back.setBackground(Color.LIGHT_GRAY);
		back.addActionListener(this);
		add(back);

		title = new JLabel("���� ���� ���� Ȯ��");
		title.setBounds(600, 50, 700, 50);
		title.setFont(new Font("", Font.BOLD, 30));
		title.setForeground(Color.black);
		add(title);

		searchTitle = new JLabel("Ȯ���ϰ� ���� ���ø� �Է�");
		searchTitle.setBounds(600, 100, 700, 50);
		searchTitle.setForeground(Color.GREEN);
		add(searchTitle);

		searchBtn = new JButton();
		searchArea = new JTextField();

		LineBorder lineBorder = new LineBorder(new Color(153, 255, 51), 3, true);
		searchArea.setBorder(lineBorder);
		searchArea.setBounds(600, 150, 700, 50);
		searchArea.setBackground(null);
		add(searchArea);
		searchBtn.setBounds(385, 8, 35, 35);
		searchBtn.setBackground(Color.white);
		searchBtn.setBorder(null);
		searchArea.add(searchBtn);
		try {
			Image img = new ImageIcon("./src/images/ico_search21x212.png").getImage().getScaledInstance(35, 35,
					Image.SCALE_SMOOTH);
			searchBtn.setIcon(new ImageIcon(img));

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			Main.frame.setContentPane(new ItemDetailedPanel(item));
			Main.frame.revalidate();
		} else if (e.getSource() == searchBtn) {
			String data = searchArea.getText();
			storeList = StoreManager.instance.storeList.get(data);

		}
	}

}