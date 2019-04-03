package app.Extra;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EletronicBallot extends JFrame {

    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;

    private Object[][] data = { { "15", "Daniel" }, { "75", "Jean" }, { "0", "Voto em branco" }, { "1", "Voto nulo" } };
    private String[] columns = { "Código", "Candidato" };

    private Integer voteDaniel = 0;
    private Integer voteJean = 0;
    private Integer invalidVote = 0;
    private Integer blankVote = 0;
    private Integer quantityVotes = 0;

    public EletronicBallot() {
        super("Contatos");
        this.createTable();
        this.vote();
    }

    private void vote() {
        Integer vote = 1;
        try {
            vote = Integer.parseInt(JOptionPane.showInputDialog("Informe seu voto"));
        } catch (Exception e) {
            System.out.println(e);
        }
        this.organizeVote(vote);
    }

    private void organizeVote(Integer vote) {
        this.quantityVotes += 1;
        switch (vote) {
        case 15:
            this.voteDaniel += 1;
            break;
        case 75:
            this.voteJean += 1;
            break;
        case 0:
            this.invalidVote += 1;
            break;
        case 1:
            this.blankVote += 1;
            break;
        default:
            this.blankVote += 1;
            break;
        }

        this.requestIfContinue();

    }

    private void requestIfContinue() {
        String continueVoting = JOptionPane
                .showInputDialog("Existe mais alguem para votar ? Responda com 'SIM' ou 'NAO'");
        if (continueVoting.equals("SIM") || continueVoting.equals("sim")) {
            this.vote();
        } else {
            this.showResponse();
        }
    }

    private void showResponse() {
        if(this.quantityVotes == 0 || this.isInvalidAndBlankWins()){
            
        }
    }

    private boolean isInvalidAndBlankWins() {
        return false;
    }

    public void createTable() {
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 1));
        this.table = new JTable(this.data, this.columns);
        this.scrollPane = new JScrollPane(this.table);
        this.panel.add(this.scrollPane);

        getContentPane().add(this.panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }
}