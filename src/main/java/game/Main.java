package game;

import javax.swing.Box;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main extends JFrame {
    private static final long serialVersionUID = -1195617528474947903L;
    private Noh rootNode;

    public static void main(final String[] args) {
        Main main = new Main();
        main.CriarJogo();
    }

    private void CriarJogo() {
        this.setTitle("Jogo Gourmet");
        this.setDefaultCloseOperation(3);

        JButton botao = this.criarBotao("OK");
        JLabel pergunta = this.criarPergunta("Pense em um prato que gosta!");
        JPanel painel = this.criarPainel();

        painel.add(pergunta);
        painel.add(botao);

        this.setContentPane(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        final NohFinal endNodeSim = new NohFinal(this);
        endNodeSim.setPrato("Lasanha");

        final NohFinal noNode = new NohFinal(this);
        noNode.setPrato("Bolo de Chocolate");

        (this.rootNode = new Noh((JFrame) this)).setPergunta("O prato que você pensou é massa?");
        this.rootNode.setSimNoh((Noh) endNodeSim);
        this.rootNode.setNaoNoh((Noh) noNode);
    }

    public JPanel criarPainel(){
        final JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        jPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 50, 50));
        jPanel.add(Box.createRigidArea(new Dimension(10, 10)));

        return jPanel;
    }

    public JLabel criarPergunta(String pergunta){
        final JLabel jLabel = new JLabel(pergunta);
        jLabel.setAlignmentX(0.5f);

        return jLabel;
    }

    public JButton criarBotao(String label){
        JButton jButton = new JButton(label);
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                Main.this.iniciarJogo();
            }
        });
        jButton.setAlignmentX(0.5f);

        return jButton;
    }
    private void iniciarJogo() {
        this.rootNode.pergunta();
    }
}