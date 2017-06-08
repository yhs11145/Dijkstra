import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Graph{
	private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
        this.n = n;
        maps = new int[n+1][n+1];
         
    }
    public void input(int i,int j,int w){
        maps[i][j] = w;
        maps[j][i] = w;
    }
 
    public void dijkstra(int first,int end){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[first] =0;
        check[first] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[first][i] !=0){
                distance[i] = maps[first][i];
            }
        }
         
         
        for(int a=0;a<n-1;a++){
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;
             
            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    
                    }
                }
            }
 
        }
        
        System.out.println("최단거리 : "+distance[end]);//시작점에서부터 종료점까지의 최단거리 출력
         
        //결과값 출력
       /* for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         */
    }
}
public class Mao extends JFrame implements ActionListener{
	
	JPanel jp=new JPanel();//패널 초기화
	JButton jb=new JButton("경로찾기");//버튼 최고하
	JLabel jl1=new JLabel("경로의 시작점을 입력하세요.");//jl1의 최기화
	JLabel jl2=new JLabel("경로의 도착점을 입력하세요.");//jl2의 초기화
	JLabel jm1=new JLabel();
	JLabel jm2=new JLabel();
	JTextField tf1=new JTextField(2);
	JTextField tf2=new JTextField(2);
	ImageIcon icon = new ImageIcon("images/img_ddd.png");
    ImageIcon icon2 = new ImageIcon("images/img_map.png");

	
	public Mao(){
		super("Mao"); // JFrame의 생성자에 값을 입력하면 윈도창에 해당 값이 입력됩니다.
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		jp.add(jl1);
		jp.add(tf1); // jp라는 패널에 tf라는 텍스트필드 추가
		jp.add(jl2);
		jp.add(tf2);
		jm1.setIcon(icon);
	    jm1.setBounds(0, 0, getSize().width, getSize().height);
	    getContentPane().add(jm1);
	    jm2.setIcon(icon2);
	    jm2.setBounds(0, 0, getSize().width, getSize().height);
	     getContentPane().add(jm2);

		jb.addActionListener(this);
		jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
		
		
		add(jp); // JFrame에 jp라는 패널 추가
	
		setSize(1500, 700); // 윈도우의 크기 가로x세로
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
		g.dijkstra(start,end);
		//System.out.println(start);
	}

	public  static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mao();

	}
}




