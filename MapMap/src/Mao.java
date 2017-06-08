import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mao extends JFrame implements ActionListener{
	
	JPanel contentPane;
	JPanel pan;
	JPanel jp;//패널 초기화
	JButton jb;//버튼 최고하
	JLabel jl1;//jl1의 최기화
	JLabel jl2;//jl2의 초기화
	JLabel jm1;
	JLabel jm2;
	JLabel jm3;
	JTextField tf1;
	JTextField tf2;
	ImageIcon icon;
    ImageIcon icon2;

	
	public Mao(){
		super("Mao"); // JFrame의 생성자에 값을 입력하면 윈도창에 해당 값이 입력됩니다.
		setBounds(100, 100, 800, 640);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		pan = new JPanel();
		jp=new JPanel();//패널 초기화
		jb=new JButton("경로찾기");//버튼 최고하
		jl1=new JLabel("경로의 시작점을 입력하세요.");//jl1의 최기화
		jl2=new JLabel("경로의 도착점을 입력하세요.");//jl2의 초기화
		jm1=new JLabel();
		jm2=new JLabel();
		jm3=new JLabel();
		tf1=new JTextField(2);
		tf2=new JTextField(2);
		icon = new ImageIcon("images/img_ddd.png");
	    icon2 = new ImageIcon("images/img_map.png");
		
		/*jp.add(jl1);
		jp.add(tf1); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jl2);
		jp.add(tf2);
		jm1.setIcon(icon);
	    jm1.setBounds(0, 0, getSize().width, getSize().height);
	    pan.add(jm1);
	    jm2.setIcon(icon2);
	    jm2.setBounds(0, 0, getSize().width, getSize().height);
	    pan.add(jm2);
		jm3.setBounds(0, 0, getSize().width, getSize().height);
		getContentPane().add(pan);
	    getContentPane().add(jm3);

		
		
		add(jp); // JFrame에 jp라는 패널 추가
*/	    
		jb.addActionListener(this);
		jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
	    jm1.setIcon(icon);
	    jm1.setBounds(0, 0, getSize().width, getSize().height);
	    getContentPane().add(jm1);
	    
	    jm2.setIcon(icon2);
	    jm2.setBounds(0, 0, getSize().width, getSize().height);
	    getContentPane().add(jm2);
		
	    jp.add(jl1);
		jp.add(tf1); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jl2);
		jp.add(tf2);
		jp.add(jb);
		jp.setBounds(0, 0, 800, 100);
		
		jm3.setBounds(0, 600, 100, 80);
		jm3.setText("염병");
		getContentPane().add(jp);
		getContentPane().add(jm3);
		
		setVisible(true); // 창을 보여줄떄 true, 숨길때 false
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼을 눌렀을때 종료
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graph g=new Graph(10);
		g.input(1, 3, 2);
		g.input(3, 2, 1);
		g.input(3, 4, 2);
		g.input(2, 6, 3);
		g.input(2, 7, 5);
		g.input(7, 6, 4);
		g.input(7, 8, 2);
		g.input(8, 4, 3);
		g.input(8, 9, 3);
		g.input(4, 5, 1);
		g.input(5, 9, 4);
		g.input(9, 10, 6);
		int start=Integer.parseInt(tf1.getText());
		int end=Integer.parseInt(tf2.getText());
		if(start>10||end>10)
		{
			JOptionPane.showMessageDialog(jp,"잘못 입력했습니다. 다시입력하세요.");
		}
		jm3.setText("최단거리 : " + g.dijkstra(start,end));
		
		//System.out.println(start);
	}

	public  static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mao frame = new Mao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}




