package game;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class NohFinal extends Noh {
    private String prato;

    public NohFinal(final JFrame parent) {
        super(parent);
    }

    public void pergunta() {

        switch (JOptionPane.showConfirmDialog(this.getParent(), "O prato que você pensou é " + this.prato + "?", "Confirm", 0)) {
            case 0:
                JOptionPane.showMessageDialog(this.getParent(), "Acertei de novo!", "Jogo Gourmet", 1);
                break;
            case 1: {
                Noh novoNoh = new Noh(this.getParent());
                String prato = JOptionPane.showInputDialog(this.getParent(), "Qual prato pensou?", "Falha", 3);
                String tipo = JOptionPane.showInputDialog(this.getParent(), prato + " é ____ mas " + this.prato + " não.", "Fim", 3);

                tipo = "O prato que você pensou é " + tipo + "?";

                NohFinal newEndNode = new NohFinal(this.getParent());
                newEndNode.setPrato(prato);
                novoNoh.setPergunta(tipo);

                if (this.isVerdadeiro()) this.getParentNode().setSimNoh(novoNoh); else this.getParentNode().setNaoNoh(novoNoh);

                novoNoh.setSimNoh((Noh) newEndNode);
                novoNoh.setNaoNoh((Noh) this);
                break;
            }
        }
    }

    public String getPrato() {
        return this.prato;
    }

    public void setPrato(final String prato) {
        this.prato = prato;
    }
}