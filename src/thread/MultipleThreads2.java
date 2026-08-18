package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class MultipleThreads2 {
    private static final int PRINT_NUMBER = 5;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < PRINT_NUMBER; i++) {
            String[] score = in.next().split(",");
            String user = score[1].trim();
            int scoreValue = new Integer(score[0].trim());
            scores.add(new Score(scoreValue, user));
        }

        MultipleThreads2 solution = new MultipleThreads2();
        solution.solve(scores);
    }

    public void solve(List<Score> scores) {
        ScoresBoard scoresBoard = new ScoresBoard();
        List<Thread> threads = processAllScores(scoresBoard, scores);
        waitForThreads(threads);
        printResult(scoresBoard);
    }

    private void printResult(ScoresBoard scoresBoard) {
        for (int i = 0; i < scoresBoard.getScoresBoardSize(); i++) {
            Score scoreAtPosition = scoresBoard.getScoreAtPosition(i);
            System.out.println(scoreAtPosition.getUser() + " " + scoreAtPosition.getScoreValue());
        }
    }

    private void waitForThreads(List<Thread> threads) {
        try {
            for (final Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException ignored) {
        }
    }

    private List<Thread> processAllScores(ScoresBoard scoresBoard, List<Score> scores) {
        final List<Thread> threads = new ArrayList<>();
        for (final Score score : scores) {
            final Runnable runnable = () -> scoresBoard.addScore(score);
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }
        return threads;
    }

    static class ScoresBoard {
        private List<Score> scores = new ArrayList<>();

        public void addScore(Score score) {
            // Write your code here
            synchronized (scores) {
                if (scores.size() == 0) {
                    scores.add(score);
                } else {
                    int index = 0;
                    for (Score s : scores) {
                        if (score.scoreValue < s.scoreValue) {
                            break;
                        } else if (score.scoreValue == s.scoreValue && score.user.compareTo(s.user) == -1) {
                            index++;
                            break;
                        }
                        index++;
                    }
                    scores.add(score);
                }
            }
        }

        public Score getScoreAtPosition(int position) {
            return this.scores.get(position);
        }

        public int getScoresBoardSize() {
            return scores.size();
        }
    }

    static class Score {
        private final int scoreValue;
        private final String user;

        Score(final int scoreValue, final String user) {
            this.scoreValue = scoreValue;
            this.user = user;
        }

        public int getScoreValue() {
            return scoreValue;
        }

        public String getUser() {
            return user;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            final Score score = (Score) o;
            return scoreValue == score.scoreValue && Objects.equals(user, score.user);
        }

        @Override
        public int hashCode() {
            return Objects.hash(scoreValue, user);
        }
    }
}