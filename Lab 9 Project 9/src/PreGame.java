import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreGame extends JFrame {
	int gameDifficulty;//Will hold the difficulty of the game
	int gameSize;//Will hold the size of the game
	boolean close=false;
	private JPanel contentPane;
	private LandscapeDisplay ld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreGame frame = new PreGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreGame() {
		System.out.println("Pregame");
		this.ld = ld;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHuntTheWumpus = new JLabel("Hunt the Wumpus");
		lblHuntTheWumpus.setBounds(165, 34, 263, 50);
		lblHuntTheWumpus.setFont(new Font("Blackadder ITC", Font.PLAIN, 40));
		contentPane.add(lblHuntTheWumpus);
		
		JLabel lblGameDifficulty = new JLabel("Game Difficulty");
		lblGameDifficulty.setBounds(47, 105, 137, 31);
		lblGameDifficulty.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblGameDifficulty);
		
		JSlider slider = new JSlider();
		slider.setValue(5);
		slider.setMaximum(10);
		slider.setBounds(360, 105, 200, 26);
		contentPane.add(slider);
		
		JLabel lblGridSize = new JLabel("Game Size");
		lblGridSize.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGridSize.setBounds(60, 183, 137, 17);
		contentPane.add(lblGridSize);
		
		
		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new HuntTheWumpus(slider.getValue());

			}
			
		});
		btnStartGame.setBounds(210, 274, 192, 61);
		contentPane.add(btnStartGame);
		
		this.setVisible(true);
	}
	
	public int getDifficulty(){
		return this.gameDifficulty;
	}
	public int getGameSize(){
		return this.gameSize;
	}
}
