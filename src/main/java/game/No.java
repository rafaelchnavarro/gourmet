package game;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class No
{
    private JFrame parent;
    private String pergunta;
    private No parentNode;
    private No sim;
    private No nao;
    private boolean isYesNode;
    
    public No(final JFrame parent) {
        this.parent = parent;
    }
    
    public void pergunta() {
        final boolean response = JOptionPane.showConfirmDialog(this.parent, this.pergunta, "Confirm", 0) == 0;
        if (response) {
            this.sim.pergunta();
        }
        else {
            this.nao.pergunta();
        }
    }
    
    public String getQuestion() {
        return this.pergunta;
    }
    
    public void setQuestion(final String question) {
        this.pergunta = question;
    }
    
    public No getYes() {
        return this.sim;
    }
    
    public void setYes(final No sim) {
        (this.sim = sim).setParentNode(this, true);
    }
    
    public No getNo() {
        return this.nao;
    }
    
    public void setNo(final No nao) {
        (this.nao = nao).setParentNode(this, false);
    }
    
    public JFrame getParent() {
        return this.parent;
    }
    
    protected No getParentNode() {
        return this.parentNode;
    }
    
    protected void setParentNode(final No parentNode, final boolean isYesNode) {
        this.parentNode = parentNode;
        this.isYesNode = isYesNode;
    }
    
    protected boolean isYesNode() {
        return this.isYesNode;
    }
}
