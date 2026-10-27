import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Corsi Block-Tapping Task implementation in Java Swing.
 * Displays a 3x3 grid where sequences of blocks light up and the player must repeat them.
 */
public class CorsiTask extends JFrame implements KeyListener {
    private static final int GRID_SIZE = 3;
    private static final int CELL_COUNT = GRID_SIZE * GRID_SIZE;
    private static final Color DEFAULT_COLOR = new Color(100, 120, 140);
    private static final Color HIGHLIGHT_COLOR = new Color(30, 144, 255);
    private static final Color PLAYER_COLOR = new Color(34, 197, 94);
    private static final Color ERROR_COLOR = new Color(239, 68, 68);
    private static final Color BACKGROUND_COLOR = new Color(30, 41, 59);

    private JButton[] cells = new JButton[CELL_COUNT];
    private JLabel sequenceLengthLabel;
    private JLabel highScoreLabel;
    private JLabel statusLabel;
    private JButton startButton;

    private List<Integer> sequence = new ArrayList<>();
    private List<Integer> playerInput = new ArrayList<>();
    private Random random = new Random();
    
    private Timer highlightTimer;
    private Timer delayTimer;
    private Timer resetTimer;
    
    private int currentStep = 0;
    private int highScore = 0;
    private boolean isShowingSequence = false;
    private boolean isPlayerTurn = false;
    private boolean gameOver = false;

    public CorsiTask() {
        setTitle("Corsi Block-Tapping Task");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setBackground(BACKGROUND_COLOR);
        addKeyListener(this);
        setFocusable(true);

        // Top Panel: Title and Stats
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(30, 41, 59));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Corsi Block-Tapping Task");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        statsPanel.setBackground(new Color(30, 41, 59));
        
        sequenceLengthLabel = new JLabel("Level: 0");
        sequenceLengthLabel.setFont(new Font("Arial", Font.BOLD, 14));
        sequenceLengthLabel.setForeground(new Color(96, 165, 250));
        
        highScoreLabel = new JLabel("Best: 0");
        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        highScoreLabel.setForeground(new Color(34, 197, 94));
        
        statsPanel.add(sequenceLengthLabel);
        statsPanel.add(highScoreLabel);

        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(statsPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel: Game Grid
        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE, 8, 8));
        gridPanel.setBackground(new Color(15, 23, 42));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        for (int i = 0; i < CELL_COUNT; i++) {
            final int index = i;
            cells[i] = new JButton();
            cells[i].setBackground(DEFAULT_COLOR);
            cells[i].setForeground(Color.WHITE);
            cells[i].setFont(new Font("Arial", Font.BOLD, 16));
            cells[i].setFocusPainted(false);
            cells[i].setPreferredSize(new Dimension(100, 100));
            cells[i].addActionListener(e -> handleCellClick(index));
            cells[i].setOpaque(true);
            cells[i].setBorder(BorderFactory.createRaisedBevelBorder());
            gridPanel.add(cells[i]);
        }
        add(gridPanel, BorderLayout.CENTER);

        // Bottom Panel: Status and Controls
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBackground(new Color(30, 41, 59));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        statusLabel = new JLabel("Ready to start?");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setForeground(new Color(148, 163, 184));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        controlPanel.setBackground(new Color(30, 41, 59));
        
        startButton = new JButton("Start Test");
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setPreferredSize(new Dimension(150, 40));
        startButton.setBackground(new Color(37, 99, 235));
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> startNewRound());
        controlPanel.add(startButton);

        bottomPanel.add(statusLabel, BorderLayout.NORTH);
        bottomPanel.add(controlPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void startNewRound() {
        if (isShowingSequence || isPlayerTurn) return;

        updateStartButton(true);
        cancelAllTimers();

        int currentLength = sequence.size();
        sequence.clear();
        playerInput.clear();
        gameOver = false;
        resetCellColors();

        for (int i = 0; i <= currentLength; i++) {
            int next;
            do {
                next = random.nextInt(CELL_COUNT);
            } while (i > 0 && sequence.get(i - 1) == next);
            sequence.add(next);
        }

        updateSequenceDisplay();
        updateStatus("Watch the sequence...");
        isShowingSequence = true;
        currentStep = 0;

        delayTimer = new Timer(500, e -> showSequence());
        delayTimer.setRepeats(false);
        delayTimer.start();
    }

    private void showSequence() {
        if (currentStep >= sequence.size()) {
            isShowingSequence = false;
            isPlayerTurn = true;
            updateStatus("Your turn! Click the blocks (or press 1-9)");
            return;
        }

        int index = sequence.get(currentStep);
        highlightCell(index);

        highlightTimer = new Timer(1000, e -> {
            resetCellColor(index);
            currentStep++;
            
            delayTimer = new Timer(200, e2 -> showSequence());
            delayTimer.setRepeats(false);
            delayTimer.start();
        });
        highlightTimer.setRepeats(false);
        highlightTimer.start();
    }

    private void handleCellClick(int index) {
        if (!isPlayerTurn || isShowingSequence || gameOver) return;

        playerInput.add(index);
        flashCell(index, PLAYER_COLOR);

        if (playerInput.get(playerInput.size() - 1) != sequence.get(playerInput.size() - 1)) {
            handleGameOver();
            return;
        }

        if (playerInput.size() == sequence.size()) {
            isPlayerTurn = false;
            updateHighScore(sequence.size());
            updateStatus("Correct! Next round starting...");

            delayTimer = new Timer(1500, e -> startNewRound());
            delayTimer.setRepeats(false);
            delayTimer.start();
        }
    }

    private void handleGameOver() {
        isPlayerTurn = false;
        gameOver = true;
        updateHighScore(sequence.size());
        updateStartButton(false);
        updateStatus("Game Over! Sequence length: " + sequence.size());

        for (JButton cell : cells) {
            cell.setBackground(ERROR_COLOR);
        }

        resetTimer = new Timer(1500, e -> resetCellColors());
        resetTimer.setRepeats(false);
        resetTimer.start();

        JOptionPane.showMessageDialog(this,
                "Wrong sequence!\nYou reached level: " + sequence.size() + "\nBest score: " + highScore,
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE);
        sequence.clear();
        updateStartButton(false);
    }

    private void highlightCell(int index) {
        cells[index].setBackground(HIGHLIGHT_COLOR);
    }

    private void flashCell(int index, Color color) {
        cells[index].setBackground(color);
        resetTimer = new Timer(300, e -> resetCellColor(index));
        resetTimer.setRepeats(false);
        resetTimer.start();
    }

    private void resetCellColor(int index) {
        if (!gameOver) {
            cells[index].setBackground(DEFAULT_COLOR);
        }
    }

    private void resetCellColors() {
        for (JButton cell : cells) {
            cell.setBackground(DEFAULT_COLOR);
        }
    }

    private void updateSequenceDisplay() {
        sequenceLengthLabel.setText("Level: " + sequence.size());
    }

    private void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            highScoreLabel.setText("Best: " + highScore);
        }
    }

    private void updateStatus(String message) {
        statusLabel.setText(message);
    }

    private void updateStartButton(boolean inProgress) {
        if (inProgress) {
            startButton.setText("In progress");
            startButton.setBackground(BACKGROUND_COLOR);
            startButton.setForeground(Color.BLACK);
            startButton.setBorderPainted(false);
            startButton.setEnabled(false);
        } else {
            startButton.setText("Start Test");
            startButton.setForeground(Color.BLACK);
            startButton.setBorderPainted(true);
            startButton.setEnabled(true);
        }
    }

    private void cancelAllTimers() {
        if (highlightTimer != null) {
            highlightTimer.stop();
        }
        if (delayTimer != null) {
            delayTimer.stop();
        }
        if (resetTimer != null) {
            resetTimer.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() >= '1' && e.getKeyChar() <= '9') {
            int index = e.getKeyChar() - '1';
            if (index < CELL_COUNT) {
                handleCellClick(index);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new CorsiTask();
        });
    }
}
