package z;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import checkBox.JCheckBoxTest3;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.ScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OrderMain extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JTable table; //구입한 상품 표
	private DefaultTableModel model; //표를 담기 위한 모델
	private JTextField txtNum; //주문수량
	private JTextField txtSum; //주문금액
	private JTextField textField;
	//private CardLayout card=new CardLayout();
	
	//재료 이미지 보여줄 패널
	private JLabel lblmake[]=new JLabel[10];
	//선택할 수 있는 재료 이름
	private JCheckBox chkmake[]=new JCheckBox[10];
	private String makeName[]= {"번 (+3000원)", "패티 (+1000원)", "베이컨 (+700원)",	"계란후라이 (+600원)", "치즈 (+500원)",
			"양상추 (+600원)","양파 (+400원)","버섯 (+500원)", "토마토 (+500원)", "피클 (+400원)"};
	private ImageIcon icon[]=new ImageIcon[10];
	//선택취소 버튼, 
	private JButton btnckdel, btnAlldel, btnCash, bntCard;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMain frame = new OrderMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderMain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 100	, 100);
		setSize(620	, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel ppick = new JPanel();
		panel_2.add(ppick, BorderLayout.CENTER);
		ppick.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		ppick.add(panel_15, BorderLayout.EAST);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		btnckdel = new JButton("\uC120\uD0DD \uCDE8\uC18C");
		panel_15.add(btnckdel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_15.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("\uC218\uB7C9 \uC120\uD0DD");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		panel_1.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setEnabled(false);
		panel_1.add(spinner);
		
		JPanel panel_16 = new JPanel();
		ppick.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_16.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setShowVerticalLines(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"No.", "메뉴", "수량", "가격"
			}
		));
		table_1.setPreferredScrollableViewportSize(new Dimension(200,130));
		scrollPane.setViewportView(table_1);
		
		JPanel pbuy = new JPanel();
		panel_2.add(pbuy, BorderLayout.SOUTH);
		pbuy.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		pbuy.add(panel_9, BorderLayout.WEST);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uBB38\uC218\uB7C9 : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_1);
		
		txtNum = new JTextField();
		panel_9.add(txtNum);
		txtNum.setColumns(10);
		
		JLabel label = new JLabel("\uC8FC\uBB38\uAE08\uC561 : ");
		label.setHorizontalAlignment(SwingConstants.CENTER); 
		panel_9.add(label);
		
		txtSum = new JTextField();
		txtSum.setColumns(10);
		panel_9.add(txtSum);
		
		JPanel panel_10 = new JPanel();
		pbuy.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnAlldel = new JButton("\uC804\uCCB4\uCDE8\uC18C");
		panel_10.add(btnAlldel);
		
		btnCash = new JButton("\uD604\uAE08\uACB0\uC81C");
		panel_10.add(btnCash);
		
		bntCard = new JButton("\uCE74\uB4DC\uACB0\uC81C");
		panel_10.add(bntCard);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("세트메뉴", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel pset = new JPanel();
		pset.setBackground(Color.ORANGE);
		panel_3.add(pset, BorderLayout.CENTER);
		pset.setLayout(new GridLayout(0, 3, 5, 5));
		
		JLabel lblset1 = new JLabel("");
		lblset1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("qkqh");
			}
		});
		
		lblset1.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSet/set1.png")));
		lblset1.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblset1);
		
		JLabel lblset2 = new JLabel("");
		lblset2.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSet/set2.png")));
		lblset2.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblset2);
		
		JLabel lblset3 = new JLabel("");
		lblset3.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSet/set3.png")));
		lblset3.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblset3);
		
		JLabel lblset4 = new JLabel("");
		lblset4.setIcon(new ImageIcon(OrderMain.class.getResource("/imgBanner/\uC81C\uBAA9 \uC5C6\uC74C-1.jpg")));
		lblset4.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblset4);
		
		JLabel lblset5 = new JLabel("New label");
		lblset5.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblset5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		pset.add(lblNewLabel_7);
		
		JPanel phambuger = new JPanel();
		tabbedPane.addTab("햄버거", null, phambuger, null);
		phambuger.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_26 = new JPanel();
		phambuger.add(panel_26, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u25C0 \uC774\uC804");
		panel_26.add(button);
		
		JButton button_1 = new JButton("\uB2E4\uC74C \u25B6");
		panel_26.add(button_1);
		
		JPanel pside = new JPanel();
		tabbedPane.addTab("사이드", null, pside, null);
		
		JPanel pdrink = new JPanel();
		tabbedPane.addTab("음료", null, pdrink, null);
		
		JPanel psigniture = new JPanel();
		tabbedPane.addTab("시그니처", null, psigniture, null);
		psigniture.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		psigniture.add(panel_12, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("\uC6D0\uD558\uB294 \uC7AC\uB8CC\uB97C \uC120\uD0DD\uD558\uC138\uC694");
		panel_12.add(label_1);
		
		//재료 선택하는 화면
		JPanel pckeck = new JPanel();
		psigniture.add(pckeck, BorderLayout.EAST);
		pckeck.setLayout(new GridLayout(0, 2, 0, 0));
		//첫번째 패널에 체크박스  add
		for(int i=0;i<chkmake.length;i++) {
		//체크박스 객체 생성해서 배열에 담기
		chkmake[i]=new JCheckBox(makeName[i]);
		//생성된 체크박스를 패널에  add
		panel.add(chkmake[i]);
		//JLabel 객체 생성해서 배열에 담기
		lblmake[i]=new JLabel();
		icon[i]=new ImageIcon(OrderMain.class.getResource("/imgSig/"+makeName[i]+".png"));
		
		JPanel panel_14 = new JPanel();
		psigniture.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imgBunTop = new JLabel("");
		imgBunTop.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSig/Bun-Top.png")));
		imgBunTop.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(imgBunTop);
		
		JLabel img1 = new JLabel("");
		img1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img1);
		
		JLabel img2 = new JLabel("");
		img2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img2);
		
		JLabel img3 = new JLabel("");
		img3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img3);
		
		JLabel img4 = new JLabel("");
		img4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img4);
		
		JLabel img5 = new JLabel("");
		img5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img5);
		
		JLabel img6 = new JLabel("");
		img6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img6);
		
		JLabel img7 = new JLabel("");
		img7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img7);
		
		JLabel img8 = new JLabel("");
		img8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img8);
		
		JLabel img9 = new JLabel("");
		img9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(img9);
		
		JLabel imgBunBottom = new JLabel("");
		imgBunBottom.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSig/Bun-Bottom.png")));
		imgBunBottom.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(imgBunBottom);
		
		JPanel panel_17 = new JPanel();
		psigniture.add(panel_17, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\uC9C4\uD589 \uAE08\uC561 : ");
		panel_17.add(lblNewLabel);
		
		textField = new JTextField();
		panel_17.add(textField);
		textField.setColumns(10);
		
		JButton btmmake = new JButton("\uC644\uC131");
		panel_17.add(btmmake);
		
		JPanel panel_20 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_20, null);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_20.add(panel_21, BorderLayout.NORTH);
		
		JPanel panel_22 = new JPanel();
		panel_20.add(panel_22, BorderLayout.WEST);
		panel_22.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(OrderMain.class.getResource("/imgSig/Bun-Top.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_12);
		
		JPanel panel_23 = new JPanel();
		/*//메인 지정
		panel_23.setLayout(card);
		//붙일 패널
		panel_23.add(panel_23,"23");
		//바뀐거 보여주기
		card.show(panel_23, "23");*/
		panel_20.add(panel_23, BorderLayout.CENTER);
		
		JPanel ptitle = new JPanel();
		ptitle.setForeground(Color.LIGHT_GRAY);
		contentPane.add(ptitle, BorderLayout.NORTH);
		
		JLabel lbltitle = new JLabel("\uBC84\uAC70 \uC564 \uC790\uBC14");
		lbltitle.setFont(new Font("굴림", Font.BOLD, 18));
		ptitle.add(lbltitle);
		
		JPanel pbanner = new JPanel();
		contentPane.add(pbanner, BorderLayout.SOUTH);
		pbanner.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_25 = new JPanel();
		pbanner.add(panel_25, BorderLayout.SOUTH);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_25.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_25.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		panel_25.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(OrderMain.class.getResource("/imgBanner/banner1.png")));
		pbanner.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("     ");
		pbanner.add(lblNewLabel_3, BorderLayout.NORTH);
		
		String columnNames[]= {"메뉴","수량","가격"}; //=> 목록명 줌
		model=new DefaultTableModel(columnNames,0);
		table = new JTable();
		table.setModel(model); //=> 사용함을 선언함
		}
	}//end OrderMain() 생성자

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}//end void actionPerformed
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox check=(JCheckBox) e.getItem();
		
		for(int i=0;i<10;i++) {
			if(check==(chkmake[i])) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					lblmake[i].setIcon(icon[i]);
				else
					lblmake[i].setIcon(null);
			}
		}
	}//end void itemStateChanged
}
