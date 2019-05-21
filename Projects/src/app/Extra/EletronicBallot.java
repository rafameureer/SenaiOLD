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

    private Object[][] data = { { "15", "Daniel" }, { "75", "Jean" }, { "0", "Voto em branco" },
            { "Outros valores", "Voto nulo" } };
    private String[] columns = { "Código", "Candidato" };

    private Integer voteDaniel = 0;
    private Integer voteJean = 0;
    private Integer nullVote = 0;
    private Integer blankVote = 0;
    private Integer quantityVotes = 0;

    public EletronicBallot() {
        super("Contatos");
        this.createTable();
        this.vote();
    }

    private void vote() {
        Integer vote = 1;
        Boolean exception = false;
        do {
            try {
                vote = Integer.parseInt(JOptionPane.showInputDialog("Informe seu voto"));
                exception = false;
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Você precisa informar um numero");
                exception = true;
            }
        } while (exception);
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
            this.blankVote += 1;
            break;
        default:
            this.nullVote += 1;
            break;
        }

        this.requestIfContinue();

    }

    private void requestIfContinue() {
        String continueVoting = "";
        do {
            try {
                continueVoting = JOptionPane
                        .showInputDialog("Existe mais alguem para votar ? Responda com 'SIM' ou 'NAO'");
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (continueVoting.equals(""));

        if (continueVoting.equals("SIM") || continueVoting.equals("sim")) {
            this.vote();
        } else if (continueVoting.equals("NAO") || continueVoting.equals("nao")) {
            this.showResponse();
        } else {
            this.requestIfContinue();
        }
    }

    private void showResponse() {
        System.out.println("Daniel: " + this.voteDaniel);
        System.out.println("Jean: " + this.voteJean);
        System.out.println("Em branco: " + this.blankVote);
        System.out.println("Nulo: " + this.nullVote);

        if (this.quantityVotes == 0 || this.nullAndBlankIsWinner()) {
            JOptionPane.showMessageDialog(null, "Eleição cancelada");
        } else if (this.voteDaniel == this.voteJean) {
            JOptionPane.showMessageDialog(null, "Empate");
        } else if (this.voteDaniel > this.voteJean) {
            JOptionPane.showMessageDialog(null,
                    "O candidato Daniel ganhou a eleição com " + this.voteDaniel + " votos");
        } else if (this.voteJean > this.voteDaniel) {
            JOptionPane.showMessageDialog(null, "O candidato Jean ganhou a eleição com " + this.voteJean + " votos");
        }

        System.exit(0);
    }

    private boolean nullAndBlankIsWinner() {
        return this.nullVote + this.blankVote > this.voteDaniel + this.voteJean;
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