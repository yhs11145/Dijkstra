import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
 
    public void dijkstra(int v){
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.
        for(int i=1;i<n+1;i++){
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화.
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
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
         
        //결과값 출력
        for(int i=1;i<n+1;i++){
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}
public class MainFrame extends JFrame {

	private JPanel contentPane;
	JLabel jb, jm;

	
	
	
	String start = "A";
	String end = "H";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		g.dijkstra(1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("images/img_ddd.png");
		ImageIcon icon2 = new ImageIcon("images/img_map.png");
		
		jb = new JLabel();
		jb.setIcon(icon);
		jb.setBounds(0, 0, getSize().width, getSize().height);
		getContentPane().add(jb);
		
		jm = new JLabel();
		jm.setIcon(icon2);
		jm.setBounds(0, 0, getSize().width, getSize().height);
		getContentPane().add(jm);
	}
	
	public String getSearch(String start, String end) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				
			}
		}
		return "완료";
		
	}
}
