package afvink3;

/**
 * Opdrachten zitten verwerkt in de code
 * 1) Declaratie constante
 * 2) Declaratie van Paard (niet instantiering)
 * 3) Declareer een button
 * 4) Zet breedte en hoogte van het frame
 * 5) Teken een finish streep
 * 6) Creatie van 4 paarden
 * 7) Pauzeer
 * 8) Teken 4 paarden
 * 9) Plaats tekst op de button
 * 10) Start de race, methode aanroep
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Race extends JFrame implements ActionListener {
    int lengte = 250;
    Paard h1;
    Paard h2;
    Paard h3;
    Paard h4;
    JButton button;
    
    /** declaratie van variabelen */
    /* (1) Declareer hier een constante int met de naam lengte en een waarde van 250 */
    /* (2) Declareer hier h1, h2, h3, h4 van het type Paard
     *  Deze paarden instantieer je later in het programma
     */
    /* (3) Declareer een button met de naam button van het type JButton */
    private JPanel panel;

    /** Applicatie - main functie voor runnen applicatie
     * @param args */
    public static void main(String[] args) {
        Race frame = new Race();
        frame.setSize(400,140);
        /* (4) Geef het frame een breedte van 400 en hoogte van 140 */
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) throws InterruptedException {
        panel.setBackground(Color.white);
        g.setColor(Color.red);
        /** Tekenen van de finish streep */
        /* (5) Geef de finish streep een rode kleur */
        g.fillRect(lengte, 0, 3, 100);
        /**(6) Creatie van 4 paarden
         * Dit is een instantiering van de 4 paard objecten
         * Bij de instantiering geef je de paarden een naam en een kleur mee
         * Kijk in de class Paard hoe je de paarden
         * kunt initialiseren.
         */
        /* Loop tot een paard over de finish is*/
        h1 = new Paard("Kees", Color.BLUE);
        h2 = new Paard("Tom", Color.GREEN);
        h3 = new Paard("Jade", Color.BLACK);
        h4 = new Paard("Carleen", Color.ORANGE);
        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte) {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            pauzeer(100);
            /* (7) Voeg hier een aanroep van de methode pauzeer toe zodanig
             * dat er 1 seconde pauze is. De methode pauzeer is onderdeel
             * van deze class
             */
            /* (8) Voeg hier code in om 4 paarden te tekenen die rennen
             * Dus een call van de methode tekenPaard
             */
            tekenPaard(g, h1);
            tekenPaard(g, h2);
            tekenPaard(g, h3);
            tekenPaard(g, h4);
            
        }
        /** Kijk welk paard gewonnen heeft
         */
        if (h1.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h1.getNaam() + " gewonnen!");
        }
        if (h2.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h2.getNaam() + " gewonnen!");
        }
        if (h3.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h3.getNaam() + " gewonnen!");
        }
        if (h4.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h4.getNaam() + " gewonnen!");
        }
    }

    /* Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 100));
        panel.setBackground(Color.white);
        window.add(panel);
        button = new JButton("Run!");
        /* (9) Zet hier de tekst Run! op de button */
        window.add(button);
        button.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {
        g.setColor(h.getKleur());
        g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand(), 5);
    }

    /** Actie indien de button geklikt i
     * @param event*/
    @Override
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        try {
            /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
            startRace(paper);
        } catch (InterruptedException ex) {
            Logger.getLogger(Race.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** Pauzeer gedurende x millisecond
     * @param msec*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }


}