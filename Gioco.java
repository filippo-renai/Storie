import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gioco {

	//variabile
	private ArrayList<String> chi;
	private ArrayList<String> con;
	private ArrayList<String> cosa;
	private ArrayList<String> dove;
	private ArrayList<String> perche;
	private Random random;
	private String s;
	private Scanner tastiera;

	//costruttore
	public Gioco() {
		chi = new ArrayList<>();
		con = new ArrayList<>();
		cosa = new ArrayList<>();
		dove = new ArrayList<>();
		perche = new ArrayList<>();
		random = new Random();
		tastiera = new Scanner(System.in);
	}
	
	public void addChi(String s) {
		chi.add(s);
	}
	
	public void addCon(String s) {
		con.add(s);
	}
	
	public void addCosa(String s) {
		cosa.add(s);
	}
	
	public void addDove(String s) {
		dove.add(s);
	}

	public void addPerche(String s) {
		perche.add(s);
	}
	
	
	public ArrayList<String> storia(){
		ArrayList<String> s = new ArrayList<>();
		
		s.add(chi.remove(random.nextInt(chi.size())));
		s.add(con.remove(random.nextInt(con.size())));
		s.add(cosa.remove(random.nextInt(cosa.size())));
		s.add(dove.remove(random.nextInt(dove.size())));
		s.add(perche.remove(random.nextInt(perche.size())));
		
		return s;
	}
}
