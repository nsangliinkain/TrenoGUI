import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPassegeri extends JFrame{
	private static final long serialVersionUID = 1L;
	private TrenoGUI treno;
	private JTextField tfMatricola;
    private JTextField tfLunghezza;
    private JTextField tfPeso;
    private JTextField tfMaxPassegeri;
    private JTextField tfAttualePassegeri;
    private JButton btnInvio;
    
    public InputPassegeri(TrenoGUI trenoGUI) {
        super("Input Valori Vagone Passegeri");
        this.treno = trenoGUI;
        creaGUI();
    }
    
    public void creaGUI() {
    	setSize(350, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel pannello = new JPanel(new GridLayout(0,1));
        add(pannello);

        pannello.add(new JLabel("Matricola:"));
        tfMatricola = new JTextField();
        pannello.add(tfMatricola);

        pannello.add(new JLabel("Lunghezza:"));
        tfLunghezza = new JTextField();
        pannello.add(tfLunghezza);

        pannello.add(new JLabel("Peso:"));
        tfPeso = new JTextField();
        pannello.add(tfPeso);
        
        pannello.add(new JLabel("Numero Massimo di Passegeri:"));
        tfMaxPassegeri = new JTextField();
        pannello.add(tfMaxPassegeri);
        
        pannello.add(new JLabel("Numero Attuale di Passegeri Presenti:"));
        tfAttualePassegeri = new JTextField();
        pannello.add(tfAttualePassegeri);
        
        btnInvio = new JButton("Invio");
        pannello.add(btnInvio);
        btnInvio.addActionListener(new InvioDati());
    }
    public class InvioDati implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String matricola = tfMatricola.getText();
	        String lunghezza = tfLunghezza.getText();
	        String peso = tfPeso.getText();
	        String maxPassegeri = tfMaxPassegeri.getText();
	        String attualePassegeri = tfAttualePassegeri.getText();
    	    treno.addVagonePassegeri(matricola, Integer.valueOf(lunghezza), Double.valueOf(peso), Integer.valueOf(maxPassegeri), Integer.valueOf(attualePassegeri));
    	    dispose();
    	}
    }
}
