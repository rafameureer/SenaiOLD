package app.Challenge;

import javax.swing.JOptionPane;

public class Challenge {
    private String[][] gameBoard = new String[3][3];
    private boolean winnerIsDefine = false;
    private Integer winner = 0;
    private String gameBoardString = "";
    private int move = 0;

    public Challenge() {
        this.init();
    }

    private void init() {
        this.initGameBoard();
        do {
            for (int i = 0; i < 2; i++) {
                this.move++;
                if (this.move <= 9) {
                    this.playerMove(i);
                    this.checkIfWinnerDefine();
                    if (this.winnerIsDefine) {
                        this.winner = i + 1;
                        break;
                    }
                }
            }
        } while (!this.winnerIsDefine && this.move <= 9);
        if (this.winnerIsDefine) {
            JOptionPane.showMessageDialog(null,
                    this.gameBoardString + "\n O jogador numero " + this.winner + " ganhou");
        } else {
            JOptionPane.showMessageDialog(null, this.gameBoardString + "\n Deu velha :(");
        }
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

        if (this.verifiPosition(0, false)) {
            winnerIsDefine = true;
        } else if (this.verifiPosition(1, false)) {
            winnerIsDefine = true;
        } else if (this.verifiPosition(2, false)) {
            winnerIsDefine = true;
        }
        return winnerIsDefine;
    }

    private Boolean checkLines() {
        Boolean winnerIsDefine = false;

        if (this.verifiPosition(0, true)) {
            winnerIsDefine = true;
        } else if (this.verifiPosition(1, true)) {
            winnerIsDefine = true;
        } else if (this.verifiPosition(2, true)) {
            winnerIsDefine = true;
        }

        return winnerIsDefine;
    }

    private boolean verifiPosition(int position, boolean isLines) {
        boolean isEquals = true;
        for (int i = 1; i < 3; i++) {
            if (isLines) {
                boolean dontEquals = !this.gameBoard[position][i].equals(gameBoard[position][0]);
                if (dontEquals || this.gameBoard[position][i] == "") {
                    isEquals = false;
                }
            } else {
                boolean dontEquals = !this.gameBoard[i][position].equals(gameBoard[0][position]);
                if (dontEquals || this.gameBoard[i][position] == "") {
                    isEquals = false;
                }
            }
        }
        return isEquals;
    }

    private void playerMove(int playerNumber) {
        Integer positionNumber = Integer.parseInt(JOptionPane.showInputDialog(
                this.gameBoardString + "\n Informe uma posição utilizando numeros de 1 a 9 como um teclado numerico"));

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
                this.gameBoardString += "  |";
                System.out.print(this.gameBoard[i][j] + " | ");
            }
            this.gameBoardString += "\n --------- \n";
            System.out.println("");
            System.out.println("---------");
        }
    }

    private void printGameBoard() {
        for (int i = 0; i < 20; i++) {
            System.out.println(" ");
        }
        this.gameBoardString = "";
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                System.out.print(this.gameBoard[i][j] + " | ");
                this.gameBoardString += this.gameBoard[i][j] + " | ";
            }
            this.gameBoardString += "\n --------- \n";
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