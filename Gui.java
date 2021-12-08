import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui implements ActionListener{

	private boolean descrizione=false;
	private boolean finito=false;
	private int count = 1;
	private Gioco g;
	private JLabel label;
	private JLabel descr;
	private JFrame frame;
	private JButton button;
	private JButton descrButton;
	private JButton finalButton;
	private JButton storiaButton;
	private JPanel panel;
	private JTextField chi;
	private JTextField con;
	private JTextField cosa;
	private JTextField dove;
	private JTextField perche;

	public Gui() {
		g = new Gioco();
		frame = new JFrame();

		//bottoni
		button = new JButton("STORIA FINITA");
		button.addActionListener(this);
		finalButton = new JButton("GIOCATORI FINITI");
		finalButton.addActionListener(this);
		storiaButton = new JButton("PROSSIMA STORIA");
		storiaButton.addActionListener(this);
		descrButton = new JButton("INIZIA IL GIOCO");
		descrButton.addActionListener(this);


		//spazio
		chi = new JTextField();
		con = new JTextField();
		cosa = new JTextField();
		dove = new JTextField();
		perche = new JTextField();
		chi.setBounds(50,50,80,25);
		con.setBounds(50,70,80,25);
		cosa.setBounds(50,80,80,25);
		dove.setBounds(50,100,80,25);
		perche.setBounds(50,120,80,25);

		//titoli

		label = new JLabel("Giocatore 1"); 
		String descrizione = "<html>Crea le tue storie con i tuoi amici! <br/>Inserire nei riquadri:<br/>"
				+ "| 1) CHI | 2) CON CHI | 3) COSA FANNO | 4) DOVE | 5) PERCHE' |</html>";
		descr = new JLabel(descrizione); 


		label.setBounds(10,20,80,25);
		label.setForeground(Color.red);
		descr.setBounds(5,80,100,50);
		descr.setForeground(Color.darkGray);

		//panel
		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(50, 50 ,20 ,50));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label);
		panel.add(descr);
		panel.add(chi);
		panel.add(con);
		panel.add(cosa);
		panel.add(dove);
		panel.add(perche);
		panel.add(button);
		panel.add(finalButton);
		panel.add(storiaButton);
		panel.add(descrButton);

		button.setVisible(false);
		finalButton.setVisible(false);
		chi.setVisible(false);
		con.setVisible(false);
		cosa.setVisible(false);
		dove.setVisible(false);
		perche.setVisible(false);
		label.setVisible(false);
		storiaButton.setVisible(false);


		frame.setSize(200,200);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("STORIE!");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(!descrizione) {
			descr.setVisible(false);
			descrButton.setVisible(false);
			button.setVisible(true);
			finalButton.setVisible(true);
			chi.setVisible(true);
			con.setVisible(true);
			cosa.setVisible(true);
			dove.setVisible(true);
			perche.setVisible(true);
			label.setVisible(true);

			descrizione=true;

		}
		else {
			//tasto prossimo giocatore
			if(!chi.getText().equals("") && !finito) {

				g.addChi(chi.getText());
				g.addCon(con.getText());
				g.addCosa(cosa.getText());
				g.addDove(dove.getText());
				g.addPerche(perche.getText());
				chi.setText("");
				con.setText("");
				cosa.setText("");
				dove.setText("");
				perche.setText("");

				count++;
				label.setText("Giocatore " + count);
			}
			else{
				finito=true;
				if(count>1) {
					button.setVisible(false);
					finalButton.setVisible(false);
					storiaButton.setVisible(true);

					ArrayList<String> s = g.storia();
					label.setText("STORIA!"); 
					chi.setText(s.get(0));
					con.setText(s.get(1));
					cosa.setText(s.get(2));
					dove.setText(s.get(3));
					perche.setText(s.get(4));

					count--;

				}
				else {
					JOptionPane.showMessageDialog(frame, "GRAZIE PER AVER GIOCATO!");
					descr.setForeground(Color.BLUE);
					descr.setText("CODE WITH <3 BY FILIPPO RENAI ┌∩┐(◣_◢)┌∩┐");
					descr.setVisible(true);
					button.setVisible(false);
					finalButton.setVisible(false);
					chi.setVisible(false);
					con.setVisible(false);
					cosa.setVisible(false);
					dove.setVisible(false);
					perche.setVisible(false);
					label.setVisible(false);
					storiaButton.setVisible(false);
				}
			}
		}

	}

}
