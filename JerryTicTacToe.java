package jerrytictactoe;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Brianna Sorenson, Kelly Schmidt, Lauren Tibbets, Rachel Burke
 */
//Ovals and Colors
class BoardPlace {

    static int size = 50;
    public Color color;
    int x, y;

    /**
     *
     * @param x x position
     * @param y y position
     * @param c color
     */
    public BoardPlace(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        color = c;
    }

    /**
     *
     * @param c color
     */
    public void setColor(Color c) {
        color = c;
    }

    /**
     *
     * @param g graphics
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}

//Set Board Size and Draw Lines and Ovals and Text
class Board extends JPanel {

    BoardPlace[] f;
    //new

    /**
     *
     * @param f background
     */
    public Board(BoardPlace[] f) {
        setSize(500, 300);
        this.f = f;
    }

    /**
     *
     * @param g graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(60, 60, 460, 60);
        g.drawLine(160, 160, 360, 160);
        g.drawLine(60, 260, 460, 260);
        g.drawLine(60, 60, 460, 260);
        g.drawLine(60, 260, 460, 60);
        g.drawLine(60, 60, 260, 260);
        g.drawLine(260, 260, 460, 60);
        g.drawLine(260, 60, 260, 60);
        g.drawLine(260, 60, 460, 60);
        g.drawLine(60, 260, 260, 60);
        g.drawLine(260, 60, 460, 260);
        for (int i = 1; i < f.length; i++) {
            f[i].draw(g);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString("" + i + "", f[i].x + 15, f[i].y + 40);
        }
    }

    /**
     *
     * @param jLabel
     */
    private void setContentPane(JLabel jLabel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class closer extends WindowAdapter {

    /**
     *
     * @param e exit
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

public class JerryTicTacToe extends JFrame implements ActionListener {

    BoardPlace[] A;
    JButton input;
    JTextField t;
    int player;
    boolean FirstMoveSelect = true;
    Board midrow;

    /**
     *
     * @return
     */
    private boolean won() {
        if (((A[1].color == A[2].color && A[2].color == A[3].color) && (A[1].color != Color.black)) || ((A[1].color == A[5].color && A[5].color == A[9].color) && (A[9].color != Color.black)) || ((A[1].color == A[4].color && A[4].color == A[8].color) && (A[8].color != Color.black)) || ((A[2].color == A[4].color && A[4].color == A[7].color) && (A[7].color != Color.black))
                || ((A[2].color == A[6].color && A[6].color == A[9].color) && (A[2].color != Color.black)) || ((A[3].color == A[5].color && A[5].color == A[7].color) && (A[3].color != Color.black)) || ((A[3].color == A[6].color && A[6].color == A[8].color) && (A[6].color != Color.black)) || ((A[4].color == A[5].color && A[5].color == A[6].color) && (A[6].color != Color.black))
                || ((A[7].color == A[8].color && A[8].color == A[9].color) && (A[8].color != Color.black))) {
            if (player == 1) {
                t.setText("AI won.");
            } else {
                t.setText("User won.");
            }
            return true;
        }
        if (isFull(A)) {
            t.setText("Draw.");
            return true;
        }
        return false;
    }

    /**
     *
     * @param A Board
     * @return
     */
    private boolean isFull(BoardPlace[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i].color == Color.black) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == input && FirstMoveSelect) {
            int fnum = Integer.parseInt(t.getText().trim());
            if (fnum == 2) {
                AIMove();
            }
            t.setText("Type where you want to move, then hit enter. To reset, type -1 at any time.");
            FirstMoveSelect = false;
        } else if (e.getSource() == input) {
            int fnum = Integer.parseInt(t.getText().trim());
            if (fnum >= 1 && fnum < A.length && !won()) {
                A[fnum].setColor(Color.blue);
                player = 2;
            } else if (fnum == -1) {
                FirstMoveSelect = true;
                for (int t = 1; t < A.length; t++) {
                    A[t].setColor(Color.black);
                }
                t.setText("Do you want to play first(1) or second(2)? Type the number here then hit enter.");
            }
            midrow.repaint();
            if (!won() && fnum != -1) {
                AIMove();
                t.setText("Select your next move.");
                won();
            }
        }
    }

    /**
     * Creating Window, With Buttons, and Board
     */
    public JerryTicTacToe() {
        setTitle("Jerry Tac Toe");

        addWindowListener(new closer());

        setSize(600, 400);

        A = new BoardPlace[10];

        int i = 1;
        A[i++] = new BoardPlace(0 + 60, 0 + 40, Color.black);
        A[i++] = new BoardPlace(200 + 55, 0 + 40, Color.black);
        A[i++] = new BoardPlace(400 + 50, 0 + 40, Color.black);
        A[i++] = new BoardPlace(100 + 60, 100 + 40, Color.black);
        A[i++] = new BoardPlace(200 + 55, 100 + 40, Color.black);
        A[i++] = new BoardPlace(300 + 50, 100 + 40, Color.black);
        A[i++] = new BoardPlace(0 + 60, 200 + 40, Color.black);
        A[i++] = new BoardPlace(200 + 55, 200 + 40, Color.black);
        A[i++] = new BoardPlace(400 + 50, 200 + 40, Color.black);

        Container bag = getContentPane();
        bag.setLayout(new BorderLayout());

        input = new JButton("Enter");
        input.addActionListener(this);

        t = new JTextField("Do you want to play first(1) or second(2)? Type the number here then hit enter.");

        JPanel txtbut = new JPanel();
        midrow = new Board(A);
        txtbut.add(t, "Center");
        txtbut.add(input, "West");
        bag.add(midrow, "Center");
        bag.add(txtbut, "South");

        JLabel background = new JLabel(new ImageIcon("prof.jpg"));
        add(background);
        background.setLayout(new FlowLayout());

        setVisible(true);
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
            throws IOException {
        JerryTicTacToe J = new JerryTicTacToe();
    }
    //POSSIBLE POSITIONS WITH SCORES
    //Evaluating Line Scores

    /**
     *
     * @param pos Positon
     * @param A Board
     * @return score
     */
    private int lines(int pos, BoardPlace[] A) {
        int[] Q = new int[3];
        if (pos == 1) {
            Q[0] = evaluateline(A, 1, 2, 3);
            Q[1] = evaluateline(A, 1, 4, 8);
            Q[2] = evaluateline(A, 1, 5, 9);
        } else if (pos == 2) {
            Q[0] = evaluateline(A, 2, 1, 3);
            Q[1] = evaluateline(A, 2, 4, 7);
            Q[2] = evaluateline(A, 2, 6, 9);
        } else if (pos == 3) {
            Q[0] = evaluateline(A, 3, 2, 1);
            Q[1] = evaluateline(A, 3, 5, 7);
            Q[2] = evaluateline(A, 3, 6, 8);
        } else if (pos == 4) {
            Q[0] = evaluateline(A, 4, 2, 7);
            Q[1] = evaluateline(A, 4, 5, 6);
            Q[2] = evaluateline(A, 4, 1, 8);
        } else if (pos == 5) {
            Q[0] = evaluateline(A, 5, 4, 6);
            Q[1] = evaluateline(A, 5, 1, 9);
            Q[2] = evaluateline(A, 5, 3, 7);
        } else if (pos == 6) {
            Q[0] = evaluateline(A, 6, 2, 9);
            Q[1] = evaluateline(A, 6, 3, 8);
            Q[2] = evaluateline(A, 6, 5, 4);
        } else if (pos == 7) {
            Q[0] = evaluateline(A, 7, 8, 9);
            Q[1] = evaluateline(A, 7, 4, 2);
            Q[2] = evaluateline(A, 7, 5, 3);
        } else if (pos == 8) {
            Q[0] = evaluateline(A, 8, 4, 1);
            Q[1] = evaluateline(A, 8, 6, 3);
            Q[2] = evaluateline(A, 8, 7, 9);
        } else if (pos == 9) {
            Q[0] = evaluateline(A, 9, 8, 7);
            Q[1] = evaluateline(A, 9, 5, 1);
            Q[2] = evaluateline(A, 9, 6, 2);
        }
        int score = 0;
        for (int i = 0; i < Q.length; i++) {
            if (Q[i] == 10) {
                score = Q[i];
                System.out.println(score);
                return score;
            } else if (Q[i] == -4) {
                score = Q[i];
                System.out.println(score);
                return score;
            } else {
                score += Q[i];
            }
        }
        System.out.println("");
        return score;
    }

    /**
     *
     * @param A Board
     * @param a Line place 1
     * @param b Line place 2
     * @param c Line place 3
     * @return score
     */
    private int evaluateline(BoardPlace[] A, int a, int b, int c) {
        int[] S = new int[3];

        int score = 0;

        S[0] = a;
        S[1] = b;
        S[2] = c;

        for (int i = 0; i < S.length; i++) {
            if (A[S[i]].color.equals(Color.red)) {
                score += 5;
            } else if (A[S[i]].color.equals(Color.blue)) {
                score -= 2;
            } else if (A[S[i]].color.equals(Color.black)) {
                score += 0;
            }
        }
        return score;
    }

    /**
     * AI 
     */
    private void AIMove() {
        int count = 0;
        int b = 0;

        for (int i = 1; i < A.length; i++) {//NUMBER OF BLACK SPACES
            if (A[i].color.equals(Color.black)) {
                count++;
            }
        }

        int[] nextMoves = new int[count];
        for (int i = 1; i < A.length; i++) {
            if (A[i].color.equals(Color.black)) {//WHICH CIIRCLES ARE OPEN
                nextMoves[b] = i;
                b++;
            }
        }

        int move = 0;
        int bestScore = -3;

        //Plays if AI has Win
        for (int i = 0; i < nextMoves.length; i++) {
            int score = lines(nextMoves[i], A);
            if (score == 10) {
                bestScore = score;
                move = nextMoves[i];
            }
        }

        //Blocks User Wins
        if (bestScore == -3) {
            for (int i = 0; i < nextMoves.length; i++) {
                int score = lines(nextMoves[i], A);
                if (score == -4) {
                    bestScore = score;
                    move = nextMoves[i];
                }
            }
        }

        //Plays in "highest" line option
        if (bestScore == -3) {
            for (int i = 0; i < nextMoves.length; i++) {
                int score = lines(nextMoves[i], A);
                if (score > bestScore) {
                    bestScore = score;
                    move = nextMoves[i];
                }
            }
        }
        A[move].setColor(Color.red);
        player = 1;
        midrow.repaint();
    }
}
