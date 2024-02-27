import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputMerci extends JFrame{
	private static final long serialVersionUID = 1L;
	private TrenoGUI treno;
	private JTextField tfMatricola;
    private JTextField tfLunghezza;
    private JTextField tfPeso;
    private JTextField tfMaxPesoMerci;
    private JTextField tfPesoAtualeMerci;
    private JButton btnInvio;
    
    public InputMerci(TrenoGUI trenoGUI) {
        super("Input Valori Vagone Merci");
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
        
        pannello.add(new JLabel("Peso Massimo delle Merci:"));
        tfMaxPesoMerci = new JTextField();
        pannello.add(tfMaxPesoMerci);
        
        pannello.add(new JLabel("Peso Attuale delle Merci presenti:"));
        tfPesoAtualeMerci = new JTextField();
        pannello.add(tfPesoAtualeMerci);
        
        btnInvio = new JButton("Invio");
        pannello.add(btnInvio);
        btnInvio.addActionListener(new InvioDati());
    }
    public class InvioDati implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String matricola = tfMatricola.getText();
	        String lunghezza = tfLunghezza.getText();
	        String peso = tfPeso.getText();
	        String maxPesoMerci = tfMaxPesoMerci.getText();
	        String pesoAttualeMerci = tfPesoAtualeMerci.getText();
    	    treno.addVagoneMerci(matricola, Integer.valueOf(lunghezza), Double.valueOf(peso), Double.valueOf(maxPesoMerci), Double.valueOf(pesoAttualeMerci));
    	    dispose();
    	}
    }
}
