package app.Challenge;

import javax.swing.JOptionPane;

public class Challenge {
    private String[][] gameBoard = new String[3][3];
    private boolean winnerIsDefine = false;
    private Integer winner = 0;

    public Challenge() {
        this.init();
    }

    private void init() {
        this.initGameBoard();
        do {
            for (int i = 0; i < 2; i++) {
                this.playerMove(i);
                this.checkIfWinnerDefine();
                if (this.winnerIsDefine) {
                    this.winner = i + 1;
                    break;
                }
            }
        } while (!this.winnerIsDefine);
        JOptionPane.showMessageDialog(null, "O jogador numero " + this.winner + " ganhou");
    }

    private void checkIfWinnerDefine() {
        this.winnerIsDefine = this.checkLines();
        if (!this.winnerIsDefine) {
            this.winnerIsDefine = this.checkColumns();
            if (!this.winnerIsDefine) {
                this.winnerIsDefine = this.checkDiagonal();
            }
        }
    }

    private boolean checkDiagonal() {
        Boolean winnerIsDefine = false;

        if (this.gameBoard[0][0] != "" && this.gameBoard[0][0].equals(this.gameBoard[1][1])
                && this.gameBoard[0][0].equals(this.gameBoard[2][2])) {
            winnerIsDefine = true;
        } else if (this.gameBoard[0][2] != "" && this.gameBoard[0][2].equals(this.gameBoard[1][1])
                && this.gameBoard[0][2].equals(this.gameBoard[2][0])) {
            winnerIsDefine = true;
        }

        return winnerIsDefine;
    }

    private Boolean checkColumns() {
        Boolean winnerIsDefine = false;

        if (this.gameBoard[0][0] != "" && this.gameBoard[0][0].equals(this.gameBoard[1][0])
                && this.gameBoard[0][0].equals(this.gameBoard[2][0])) {
            winnerIsDefine = true;
        } else if (this.gameBoard[0][1] != "" && this.gameBoard[0][1].equals(this.gameBoard[1][1])
                && this.gameBoard[0][1].equals(this.gameBoard[2][1])) {
            winnerIsDefine = true;
        } else if (this.gameBoard[0][2] != "" && this.gameBoard[0][2].equals(this.gameBoard[1][2])
                && this.gameBoard[0][2].equals(this.gameBoard[2][2])) {
            winnerIsDefine = true;
        }
        return winnerIsDefine;
    }

    private Boolean checkLines() {
        Boolean winnerIsDefine = false;

        if (this.gameBoard[0][0] != "" && this.gameBoard[0][0].equals(this.gameBoard[0][1])
                && this.gameBoard[0][0].equals(this.gameBoard[0][2])) {
            winnerIsDefine = true;
        } else if (this.gameBoard[1][0] != "" && this.gameBoard[1][0].equals(this.gameBoard[1][1])
                && this.gameBoard[1][0].equals(this.gameBoard[1][2])) {
            winnerIsDefine = true;
        } else if (this.gameBoard[2][0] != "" && this.gameBoard[2][0].equals(this.gameBoard[2][1])
                && this.gameBoard[2][0].equals(this.gameBoard[2][2])) {
            winnerIsDefine = true;
        }

        return winnerIsDefine;
    }

    private void playerMove(int playerNumber) {
        Integer positionNumber = Integer.parseInt(JOptionPane
                .showInputDialog("Informe uma posição utilizando numeros de 1 a 9 como um teclado numerico"));

        if (positionNumber >= 1 && positionNumber <= 9) {
            if (this.isEmptyPosition(positionNumber)) {
                this.setPosition(positionNumber, playerNumber);
            } else {
                JOptionPane.showMessageDialog(null, "Você informou uma posição que já está preenchida");
                this.playerMove(playerNumber);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você informou uma posição invalida");
            this.playerMove(playerNumber);
        }
        this.printGameBoard();
    }

    private void setPosition(Integer positionNumber, int playerNumber) {
        String symbol = "";
        if (playerNumber == 1) {
            symbol = "X";
        } else {
            symbol = "O";
        }

        switch (positionNumber) {
        case 1:
            this.gameBoard[0][0] = symbol;
            break;
        case 2:
            this.gameBoard[0][1] = symbol;
            break;
        case 3:
            this.gameBoard[0][2] = symbol;
            break;
        case 4:
            this.gameBoard[1][0] = symbol;
            break;
        case 5:
            this.gameBoard[1][1] = symbol;
            break;
        case 6:
            this.gameBoard[1][2] = symbol;
            break;
        case 7:
            this.gameBoard[2][0] = symbol;
            break;
        case 8:
            this.gameBoard[2][1] = symbol;
            break;
        case 9:
            this.gameBoard[2][2] = symbol;
            break;
        default:
            break;
        }
    }

    private boolean isEmptyPosition(Integer position) {
        return this.getPosition(position) == "";
    }

    private void initGameBoard() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                this.gameBoard[i][j] = "";
                System.out.print(this.gameBoard[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("---------");
        }
    }

    private void printGameBoard() {
        for (int i = 0; i < 20; i++) {
            System.out.println(" ");
        }
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                System.out.print(this.gameBoard[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("-----------");
        }
    }

    private String getPosition(int i) {
        String position = "";
        switch (i) {
        case 1:
            position = this.gameBoard[0][0];
            break;
        case 2:
            position = this.gameBoard[0][1];
            break;
        case 3:
            position = this.gameBoard[0][2];
            break;
        case 4:
            position = this.gameBoard[1][0];
            break;
        case 5:
            position = this.gameBoard[1][1];
            break;
        case 6:
            position = this.gameBoard[1][2];
            break;
        case 7:
            position = this.gameBoard[2][0];
            break;
        case 8:
            position = this.gameBoard[2][1];
            break;
        case 9:
            position = this.gameBoard[2][2];
            break;
        default:
            break;
        }
        return position;
    }
}