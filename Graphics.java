import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.List;



public class Graphics {

	private JFrame frame;
	private JTextField textField;
	public static SonnetConcordance concord;
	private static int totalS=0;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		concord=new SonnetConcordance();
		totalS=concord.TotalSonnets;
		System.out.println(concord.TotalSonnets);
		System.out.println(totalS);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics window = new Graphics();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Graphics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Marker Felt", Font.PLAIN, 19));
		textField.setBounds(209, 128, 66, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 42, 191, 230);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String word=textField.getText();
				textArea.setText(concord.Perform(word));
			}
		});
		btnNewButton.setBounds(209, 181, 66, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblOccurencesList = new JLabel("Appearences:");
		lblOccurencesList.setFont(new Font("Heiti SC", Font.BOLD, 12));
		lblOccurencesList.setBounds(6, 15, 112, 19);
		frame.getContentPane().add(lblOccurencesList);
		
		JLabel lblNewLabel = new JLabel("Shakespearean Concordance");
		lblNewLabel.setFont(new Font("Optima", Font.BOLD, 17));
		lblNewLabel.setBounds(102, 3, 225, 34);
		frame.getContentPane().add(lblNewLabel);
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(294, 42, 150, 230);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane2);

		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(294, 42, 150, 230);
		frame.getContentPane().add(textArea_1);
		scrollPane2.setViewportView(textArea_1);


	
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		comboBox.setBounds(326, 10, 118, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTypeInA = new JLabel("Type in a");
		lblTypeInA.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblTypeInA.setBounds(209, 44, 66, 16);
		frame.getContentPane().add(lblTypeInA);
		
		JLabel lblWordToSee = new JLabel("word to see");
		lblWordToSee.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblWordToSee.setBounds(209, 59, 73, 16);
		frame.getContentPane().add(lblWordToSee);
		
		JLabel lblToSeeHow = new JLabel("to see how");
		lblToSeeHow.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblToSeeHow.setBounds(209, 72, 68, 16);
		frame.getContentPane().add(lblToSeeHow);
		
		JLabel lblTimesIt = new JLabel("times it");
		lblTimesIt.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblTimesIt.setBounds(209, 87, 61, 16);
		frame.getContentPane().add(lblTimesIt);
		
		JLabel lblAppears = new JLabel("appears");
		lblAppears.setFont(new Font("Heiti SC", Font.PLAIN, 13));
		lblAppears.setBounds(209, 100, 61, 16);
		frame.getContentPane().add(lblAppears);
		for(int x=1;x<totalS;x++) {
			comboBox.addItem(x);
		}
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int x=(int)comboBox.getSelectedItem();
				List<String> arr=concord.sonnets.get(x-1).lines;
				String fullS="";
				for(int i=0;i<arr.size();i++) {
					fullS+=arr.get(i);
					fullS+="\n";
				}
				textArea_1.setText(fullS);
			}
		});
	}
}
