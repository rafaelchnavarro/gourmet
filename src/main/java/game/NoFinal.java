package game;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class NoFinal extends No {
    private String prato;

    public NoFinal(final JFrame parent) {
        super(parent);
    }

    public void pergunta() {
        final boolean response = JOptionPane.showConfirmDialog(this.getParent(), "O prato que voc\u00ea pensou \u00e9 " + this.prato + "?", "Confirm", 0) == 0;
        if (response) {
            JOptionPane.showMessageDialog(this.getParent(), "Acertei de novo!", "Jogo Gourmet", 1);
        } else {
            final No newNode = new No(this.getParent());
            final String prato = JOptionPane.showInputDialog(this.getParent(), "Qual prato voc\u00ea pensou?", "Desisto", 3);
            String sugestao = JOptionPane.showInputDialog(this.getParent(), prato + " \u00e9 _______ mas " + this.prato + " n\u00e3o.", "Complete", 3);
            sugestao = "O prato que você pensou é " + sugestao + "?";
            final NoFinal newEndNode = new NoFinal(this.getParent());
            newEndNode.setPrato(prato);
            if (this.isYesNode()) {
                this.getParentNode().setYes(newNode);
            } else {
                this.getParentNode().setNo(newNode);
            }
            newNode.setQuestion(sugestao);
            newNode.setYes((No) newEndNode);
            newNode.setNo((No) this);
        }
    }

    public String getPrato() {
        return this.prato;
    }

    public void setPrato(final String prato) {
        this.prato = prato;
    }
}