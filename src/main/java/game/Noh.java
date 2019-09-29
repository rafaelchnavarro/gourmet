package game;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Noh
{
    private JFrame parent;
    private String pergunta;
    private Noh parentNode;
    private Noh simNoh;
    private Noh naoNoh;
    private boolean isVerdadeito;
    
    public Noh(final JFrame parent) {
        this.parent = parent;
    }
    
    public void pergunta() {
        switch (JOptionPane.showConfirmDialog(this.parent, this.pergunta, "Confirm", 0)) {
            case 0:
                this.simNoh.pergunta();
                break;
            case 1:
                this.naoNoh.pergunta();
                break;
        }
    }
    
    public String getPergunta() {
        return this.pergunta;
    }
    
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
    public Noh getSimNoh() {
        return this.simNoh;
    }
    
    public void setSimNoh(Noh simNoh) {
        (this.simNoh = simNoh).setParentNode(this, true);
    }
    
    public Noh getNaoNoh() {
        return this.naoNoh;
    }
    
    public void setNaoNoh(Noh naoNoh) {
        (this.naoNoh = naoNoh).setParentNode(this, false);
    }
    
    public JFrame getParent() {
        return this.parent;
    }
    
    protected Noh getParentNode() {
        return this.parentNode;
    }
    
    protected void setParentNode(final Noh parentNode, final boolean isVerdadeiro) {
        this.parentNode = parentNode;
        this.isVerdadeito = isVerdadeiro;
    }
    
    protected boolean isVerdadeiro() {
        return this.isVerdadeito;
    }
}
