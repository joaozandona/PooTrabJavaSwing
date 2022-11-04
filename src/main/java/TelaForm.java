import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaForm extends JFrame{

    protected JPanel pnlTela;
    protected JTable pnlGrid;

    protected JButton btnAdicionar;

    protected JLabel lblNomeTarefa;
    protected JTextField fldNomeTarefa;

    ArrayList<String> tarefas = new ArrayList();

    public TelaForm() {
        this.inicializar();
    }

    public void inicializar() {

        this.setTitle("Tarefas");
        this.setSize(640, 480);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getPnlTela(), BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane painelComRolagem = new JScrollPane();
        painelComRolagem.setViewportView(pnlGrid);
        this.getContentPane().add(painelComRolagem, BorderLayout.PAGE_END);
    }

    public JTable getTableTela() {

        pnlGrid = new JTable(new DefaultTableModel());

        return pnlGrid;

    }

    public JPanel getPnlTela() {
        pnlTela = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdicionar = new JButton("Adicionar tarefa na lista");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tarefas.add(fldNomeTarefa.getText());
                listarTarefas();
                pnlTela.revalidate();
                pnlTela.repaint();
            }

        });
        lblNomeTarefa = new JLabel("Nome da Tarefa");
        fldNomeTarefa = new JTextField(20);

        pnlTela.add(lblNomeTarefa);
        pnlTela.add(fldNomeTarefa);
        pnlTela.add(btnAdicionar);

        return pnlTela;
    }

    public void listarTarefas(){
        for (int i=0; i<tarefas.size(); i++) {
            JLabel jl = new JLabel(tarefas.get(i));
            jl.setLocation(320 - (tarefas.size()*2), 20 * i);
            pnlTela.add(new JLabel(tarefas.get(i)));
        }
    }



}