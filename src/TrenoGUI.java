import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrenoGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private Treno treno;
    private JButton jbAggiungiVagoneM;
    private JButton jbAggiungiVagoneP;
    private JButton jbVagoneMerci;
    private JButton jbVagonePassegeri;
    private JButton jbReset;
    private JPanel pannello;
    private JPanel pannelloIMG;
    private JPanel bottoni;
    private JTextArea jtaLista;
    private JTextArea jtaLunghezza;
    private JTextArea jtaPeso;
    private JLabel titolo;
    private JLabel imgLabel;

    public TrenoGUI() {
        super("TRENO");
        creaGUI();
    }

    public void creaGUI() {
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pannello = new JPanel();
        pannelloIMG = new JPanel();
        bottoni = new JPanel();
        treno = new Treno();
        jbAggiungiVagoneM = new JButton("Aggiungi Vagone Merci Manualmente");
        jbAggiungiVagoneP = new JButton("Aggiungi Vagone Passegeri Manualmente");
        jbVagoneMerci = new JButton("Aggiungi Vagone Merci");
        jbVagonePassegeri = new JButton("Aggiungi Vagone Passegeri");
        jbReset = new JButton("Reset Vagoni Treno");
        jtaLista = new JTextArea();
        jtaLunghezza = new JTextArea();
        jtaPeso = new JTextArea();
        titolo = new JLabel();
        imgLabel = new JLabel();

        this.add(pannello);

        titolo.setFont(new Font("Courier New", Font.BOLD, 50));
        jtaLista.setFont(new Font("Courier New", Font.PLAIN, 15));
        jtaLista.setEditable(false);
        jtaLunghezza.setFont(new Font("Courier New", Font.PLAIN, 20));
        jtaPeso.setFont(new Font("Courier New", Font.PLAIN, 20));

        bottoni.setBackground(Color.white);
        pannello.setBackground(Color.WHITE);

        pannello.setLayout(new FlowLayout());

        // pannello --> pannello con tutte gli elementi del frame e qui essi vengono
        // aggiunti
        pannello.add(titolo);
        pannello.add(bottoni);
        pannello.add(jtaLista);
        pannello.add(jtaLunghezza);
        pannello.add(jtaPeso);
        pannello.add(pannelloIMG);

        // bottoni --> pannello con tutti i bottoni e qui li aggiungo tutti lì
        bottoni.add(jbAggiungiVagoneM);
        bottoni.add(jbAggiungiVagoneP);
        bottoni.add(jbVagoneMerci);
        bottoni.add(jbVagonePassegeri);
        bottoni.add(jbReset);

        titolo.setText("TRENO");
        titolo.setFont(new Font("Courier New", Font.BOLD, 50));

        pannelloIMG.setLayout(new FlowLayout(FlowLayout.LEFT));

        JScrollPane scroll = new JScrollPane(pannelloIMG);
        scroll.setPreferredSize(new Dimension(1150, 150));
        pannello.add(scroll);

        imgLabel = new JLabel(new ImageIcon("locomotiva.png"));
        pannelloIMG.add(imgLabel);

        treno.addVagone(new VagoneMerci());
        imgLabel = new JLabel(new ImageIcon("vagoneMerci.PNG"));
        pannelloIMG.add(imgLabel);

        treno.addVagone(new VagonePassegeri());
        imgLabel = new JLabel(new ImageIcon("vagonePassegeri.PNG"));
        pannelloIMG.add(imgLabel);
        
        aggiornaGUI();

        jbAggiungiVagoneM.addActionListener(new AggiungiVagone(true, this));
        jbAggiungiVagoneP.addActionListener(new AggiungiVagone(false, this));
        jbVagoneMerci.addActionListener(new addVagone(true));
        jbVagonePassegeri.addActionListener(new addVagone(false));
        jbReset.addActionListener(new AscoltaReset());

        this.setVisible(true);
    }

    public class AggiungiVagone implements ActionListener {
        private boolean isMerce;
        private TrenoGUI trenoGUI;

        public AggiungiVagone(boolean isMerce, TrenoGUI trenoGUI) {
            this.isMerce = isMerce;
            this.trenoGUI = trenoGUI;
        }

        public void actionPerformed(ActionEvent e) {
            if (isMerce) {
                InputMerci jfInput = new InputMerci(trenoGUI);
                jfInput.setVisible(true);
            } else {
                InputPassegeri jfInput = new InputPassegeri(trenoGUI);
                jfInput.setVisible(true);
            }
        }
    }
    
    public void addVagoneMerci(String matricola, int lunghezza, double peso, double pesoMassimoMerci, double pesoAttualeMerci) {
    	treno.addVagone(new VagoneMerci(matricola, lunghezza, peso, pesoMassimoMerci, pesoAttualeMerci));
    	imgLabel = new JLabel(new ImageIcon("vagoneMerci.PNG"));
        pannelloIMG.add(imgLabel);
        aggiornaGUI();
    }
    
    public void addVagonePassegeri(String matricola, int lunghezza, double peso, int numMaxPassegeri, int numAttualePassegeri) {
    	treno.addVagone(new VagonePassegeri(matricola, lunghezza, peso, numMaxPassegeri, numAttualePassegeri));
    	imgLabel = new JLabel(new ImageIcon("vagoneMerci.PNG"));
        pannelloIMG.add(imgLabel);
        aggiornaGUI();
    }

    public class addVagone implements ActionListener {
        private boolean isMerce;
        public addVagone(boolean isMerce) {
            this.isMerce = isMerce;
        }
        public void actionPerformed(ActionEvent e) {
            if (isMerce) {
                treno.addVagone(new VagoneMerci());
                imgLabel = new JLabel(new ImageIcon("vagoneMerci.PNG"));
                pannelloIMG.add(imgLabel);
            } else {
                treno.addVagone(new VagonePassegeri());
                imgLabel = new JLabel(new ImageIcon("vagonePassegeri.PNG"));
                pannelloIMG.add(imgLabel);
            }
            aggiornaGUI();
        }
    }

    public class AscoltaReset implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            treno.resetTreno();
            pannelloIMG.removeAll();
            imgLabel = new JLabel(new ImageIcon("locomotiva.png"));
            pannelloIMG.add(imgLabel);
            pannelloIMG.revalidate();
            pannelloIMG.repaint();
            jtaLista.setText("");
            jtaLunghezza.setText("");
            jtaPeso.setText("");
        }
    }

    public void aggiornaGUI() {
        pannelloIMG.revalidate();
        pannelloIMG.repaint();
        jtaLista.setText("\n\nLista Vagoni del Treno:\n" + treno.vagoniList());
        jtaLunghezza.setText("Il treno è lungo " + treno.getLunghTot() + " cm\t");
        jtaPeso.setText("Il treno pesa " + treno.getPesoTot() + " quintali");
    }

    public static void main(String[] args) {
        new TrenoGUI();
    }
}
