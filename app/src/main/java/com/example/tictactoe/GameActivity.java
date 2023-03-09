package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity {

    int[] viewArray = new int[]{
            R.id.imageButton,
            R.id.imageButton1,
            R.id.imageButton2,
            R.id.imageButton3,
            R.id.imageButton4,
            R.id.imageButton5,
            R.id.imageButton6,
            R.id.imageButton7,
            R.id.imageButton8

    };
    int size = viewArray.length;

    final boolean[] state = {true};

    boolean[] clicked = new boolean[9];

    final int[] clickCount = {0};

    int[][] board = new int[3][3];

    String player1Name;
    String player2Name;

    TextView player1Points;
    TextView player2Points;
    int player1Score = 0;
    int player2Score = 0;

    boolean singlePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_table);

        player1Name = getIntent().getStringExtra("player1_name");
        player2Name = getIntent().getStringExtra("player2_name");

        ((TextView) findViewById(R.id.player1_name)).setText(player1Name);
        ((TextView) findViewById(R.id.player2_name)).setText(player2Name);

        player1Points = findViewById(R.id.player1_points);
        player2Points = findViewById(R.id.player2_points);

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, ProfileActivity.class));
            }
        });

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, QuitActivity.class));
            }
        });

        for (int i = 0; i < size; i++) {
            clicked[i] = false;
        }

        for (int i = 0; i < size; i++) {
            ImageButton imgbtn = (ImageButton) findViewById(viewArray[i]);
            if (imgbtn != null) {
                int finalI = i;
                imgbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!clicked[finalI] && state[0]) {
                            clicked[finalI] = true;
                            int row = finalI / 3;
                            int col = finalI % 3;

                            clickCount[0]++;
                            imgbtn.setImageResource(R.drawable.x);
                            board[row][col] = 1;
                            state[0] = false;

                            checkForWinner(row, col);
                            reset(clickCount[0], viewArray);

                            if (singlePlayer) {
                                aiPlay();
                            }
                        }
                    }

                });
            }
        }

        singlePlayer = "AI".equals(player1Name);
    }



    public void reset(int count, int[] arr) {
        if (count >= 9) {
            ((TextView) findViewById(R.id.player1_points)).setText("1");
            //Toast.makeText(getApplicationContext(), "You Won! PLAYER1", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkForWinner(int row, int col) {
        int sumRow = 0;
        int sumCol = 0;
        int sumDiag1 = 0;
        int sumDiag2 = 0;

        for (int i = 0; i < 3; i++) {
            sumRow += board[row][i];
            sumCol += board[i][col];
            sumDiag1 += board[i][i];
            sumDiag2 += board[i][2 - i];
        }
        if (Math.abs(sumRow) == 3 || Math.abs(sumCol) == 3 || Math.abs(sumDiag1) == 3 || Math.abs(sumDiag2) == 3) {
            if (state[0]) { // Player 2 (O) wins
                Toast.makeText(getApplicationContext(), player2Name + " (O) Wins!", Toast.LENGTH_SHORT).show();
                player2Score++;
                updateScore();
            } else { // Player 1 (X) wins
                Toast.makeText(getApplicationContext(), player1Name + " (X) Wins!", Toast.LENGTH_SHORT).show();
                player1Score++;
                updateScore();
            }

            resetGame();
        } else if (clickCount[0] == 9) {
            Toast.makeText(getApplicationContext(), "It's a draw!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    public void updateScore() {
        player1Points.setText(String.valueOf(player2Score));
        player2Points.setText(String.valueOf(player1Score));
    }

    public void resetGame() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < viewArray.length; i++) {
                    ((ImageButton) findViewById(viewArray[i])).setImageResource(0);
                }
                for (int i = 0; i < size; i++) {
                    clicked[i] = false;
                }
                clickCount[0] = 0;
                state[0] = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j] = 0;
                    }
                }
            }
        }, 3000);
    }

    private void aiPlay() {
        if (!singlePlayer || state[0]) {
            return;
        }

        int[] bestMove = findBestMove(board);

        int aiMove = bestMove[0] * 3 + bestMove[1];
        ImageButton imgbtn = (ImageButton) findViewById(viewArray[aiMove]);
        clicked[aiMove] = true;
        int row = aiMove / 3;
        int col = aiMove % 3;

        clickCount[0]++;
        imgbtn.setImageResource(R.drawable.o);
        board[row][col] = -1;
        state[0] = true;

        checkForWinner(row, col);
        reset(clickCount[0], viewArray);

        state[0] = true;
    }

    private int[] findBestMove(int[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = new int[]{-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = -1;
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = 0;

                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimax(int[][] board, int depth, boolean isMax) {
        int score = evaluate(board);

        if (score == 10) {
            return score;
        }

        if (score == -10) {
            return score;
        }

        if (!isMovesLeft(board)) {
            return 0;
        }

        if (isMax) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = -1;
                        best = Math.max(best, minimax(board, depth + 1, !isMax));
                        board[i][j] = 0;
                    }
                }
            }

            return best;
        } else {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        best = Math.min(best, minimax(board, depth + 1, !isMax));
                        board[i][j] = 0;
                    }
                }
            }

            return best;
        }
    }

    private boolean isMovesLeft(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private int evaluate(int[][] board) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                if (board[row][0] == -1) {
                    return 10;
                } else if (board[row][0] == 1) {
                    return -10;
                }
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                if (board[0][col] == -1) {
                    return 10;
                } else if (board[0][col] == 1) {
                    return -10;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == -1) {
                return 10;
            } else if (board[0][0] == 1) {
                return -10;
            }
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == -1) {
                return 10;
            } else if (board[0][2] == 1) {
                return -10;
            }
        }

        return 0;
    }

    private int checkGameState(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (Math.abs(board[i][0] + board[i][1] + board[i][2]) == 3) {
                return board[i][0];
            }
            if (Math.abs(board[0][i] + board[1][i] + board[2][i]) == 3) {
                return board[0][i];
            }
        }

        if (Math.abs(board[0][0] + board[1][1] + board[2][2]) == 3) {
            return board[0][0];
        }
        if (Math.abs(board[0][2] + board[1][1] + board[2][0]) == 3) {
            return board[0][2];
        }

        return 0;
    }


}
