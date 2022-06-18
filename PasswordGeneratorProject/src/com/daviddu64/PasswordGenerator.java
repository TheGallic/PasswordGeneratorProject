package com.daviddu64;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class PasswordGenerator extends JFrame {

	private JPanel contentPane;
	private JTextField txfPassword;
	private JSpinner spinnerWordLenght;
	private JCheckBox cbxSimilarLetters;
	public String tempPassword = "";// Mot de passe temporaire
	public List<String> tempLetter = new ArrayList<String>();// Sert a stocker les charactères déjà utilisé
	public List<String> tempList = new ArrayList<String>();// Sert à stocker toutes les listes séléctionner
	public List<String> listNumber = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
	public List<String> listAlphabetLower = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
			"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
	public List<String> listAlphabetUpper = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
	public List<String> listSpecial = Arrays.asList("~", "{", "}", "(", ")", "[", "]", "/", "_", "-", "=", "+", "<",
			">", ":", ";", ".");
	public List<String> listSymbole = Arrays.asList("#", "*", "@", "€", "$", "?", "&", "%");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordGenerator frame = new PasswordGenerator();
					frame.setLocationRelativeTo(null);
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
	public PasswordGenerator() {
		setResizable(false);
		setTitle("Générateur de mots de passe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Longueur du mot de passe:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 238, 22);
		contentPane.add(lblNewLabel);

		JLabel lblInclureDesSymbole = new JLabel("Inclure des symboles:");
		lblInclureDesSymbole.setForeground(Color.BLUE);
		lblInclureDesSymbole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInclureDesSymbole.setBounds(10, 44, 238, 22);
		contentPane.add(lblInclureDesSymbole);

		JLabel lblIncluresDesNombres = new JLabel("Inclure des nombres:");
		lblIncluresDesNombres.setForeground(Color.BLUE);
		lblIncluresDesNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIncluresDesNombres.setBounds(10, 77, 238, 22);
		contentPane.add(lblIncluresDesNombres);

		JLabel lblInclureDesCharactres = new JLabel("Inclure des charactères minuscules");
		lblInclureDesCharactres.setForeground(Color.BLUE);
		lblInclureDesCharactres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInclureDesCharactres.setBounds(10, 110, 238, 22);
		contentPane.add(lblInclureDesCharactres);

		JLabel lblInclureDesCharactres_1 = new JLabel("Inclure des charactères majuscules:");
		lblInclureDesCharactres_1.setForeground(Color.BLUE);
		lblInclureDesCharactres_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInclureDesCharactres_1.setBounds(10, 143, 238, 22);
		contentPane.add(lblInclureDesCharactres_1);

		JLabel lblInclureDesCharactres_1_1 = new JLabel("Exclure les charactères similaires:");
		lblInclureDesCharactres_1_1.setForeground(Color.BLUE);
		lblInclureDesCharactres_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInclureDesCharactres_1_1.setBounds(10, 176, 238, 22);
		contentPane.add(lblInclureDesCharactres_1_1);

		JLabel lblInclureDesCharactres_1_2 = new JLabel("Exclure les charactères ambigue:");
		lblInclureDesCharactres_1_2.setForeground(Color.BLUE);
		lblInclureDesCharactres_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInclureDesCharactres_1_2.setBounds(10, 209, 238, 22);
		contentPane.add(lblInclureDesCharactres_1_2);

		spinnerWordLenght = new JSpinner();
		spinnerWordLenght.setBackground(new Color(0, 128, 0));
		spinnerWordLenght.setForeground(new Color(0, 128, 0));
		spinnerWordLenght.setModel(new SpinnerNumberModel(8, 8, 250, 2));
		spinnerWordLenght.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinnerWordLenght.setBounds(268, 14, 177, 20);
		contentPane.add(spinnerWordLenght);

		JCheckBox cbxSymbole = new JCheckBox("( par exemple, @#$% )");
		cbxSymbole.setForeground(new Color(0, 128, 0));
		cbxSymbole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSymbole.setBounds(264, 46, 258, 23);
		contentPane.add(cbxSymbole);

		JCheckBox cbxNumber = new JCheckBox("( par exemple, 123456 )");
		cbxNumber.setSelected(true);
		cbxNumber.setForeground(new Color(0, 128, 0));
		cbxNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxNumber.setBounds(264, 79, 258, 23);
		contentPane.add(cbxNumber);

		JCheckBox cbxLowerLetters = new JCheckBox("( par exemple, abcdefgh )");
		cbxLowerLetters.setSelected(true);
		cbxLowerLetters.setForeground(new Color(0, 128, 0));
		cbxLowerLetters.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxLowerLetters.setBounds(264, 112, 258, 23);
		contentPane.add(cbxLowerLetters);

		JCheckBox cbxUpperLetters = new JCheckBox("( par exemple, ABCDEFGH )");
		cbxUpperLetters.setForeground(new Color(0, 128, 0));
		cbxUpperLetters.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxUpperLetters.setBounds(264, 145, 258, 23);
		contentPane.add(cbxUpperLetters);

		cbxSimilarLetters = new JCheckBox("( par exemple, i, l, 1, L, o, 0, O )");
		cbxSimilarLetters.setForeground(new Color(0, 128, 0));
		cbxSimilarLetters.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxSimilarLetters.setBounds(264, 178, 258, 23);
		contentPane.add(cbxSimilarLetters);

		JCheckBox cbxAmbigue = new JCheckBox("( { } [ ] ( ) / \\ ' \" ` ~ , ; : . < > )");
		cbxAmbigue.setSelected(true);
		cbxAmbigue.setForeground(new Color(0, 128, 0));
		cbxAmbigue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxAmbigue.setBounds(264, 211, 258, 23);
		contentPane.add(cbxAmbigue);

		JButton btnGenerate = new JButton("Créer un mot de passe");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On verifie que un chois a été fait, sinon une boite de dialogue apparait
				if (cbxSymbole.isSelected() == false && cbxNumber.isSelected() == false
						&& cbxLowerLetters.isSelected() == false && cbxUpperLetters.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Vous devez sélèctionner une option");
				}

				// On efface la liste temporaire
				tempList.clear();
				// puis on creer la liste temporaire suivant les options selectionné
				if (cbxSymbole.isSelected() == true) {
					tempList.addAll(listSymbole);
				}
				if (cbxNumber.isSelected() == true) {
					tempList.addAll(listNumber);
				}
				if (cbxLowerLetters.isSelected() == true) {
					tempList.addAll(listAlphabetLower);
				}
				if (cbxUpperLetters.isSelected() == true) {
					tempList.addAll(listAlphabetUpper);
				}
				if (cbxAmbigue.isSelected() == false) {
					tempList.addAll(listSpecial);
				}
				// On vérifie que que la liste temporaire sois plus grande que la longueur du
				// mot de passe
				// si c'est pas le cas on desactive l'option
				if (tempList.size() < Integer.parseInt(spinnerWordLenght.getValue().toString())
						&& cbxSimilarLetters.isSelected() == true) {
					JOptionPane.showMessageDialog(null,
							"Le mot de passe est plus grand que la liste des options séléctionner!! \n L'option 'Exclure les charactères similaires' a été désactivée !!");
					cbxSimilarLetters.setSelected(false);
				}

				// On génére le mot à partir de la liste (tempList) créer
				generateWord();
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerate.setBounds(58, 251, 190, 33);
		contentPane.add(btnGenerate);

		JButton btnCopy = new JButton("Copier dans le presse papier");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On copie dans le presse papier
				StringSelection ss = new StringSelection(txfPassword.getText());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			}
		});
		btnCopy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCopy.setBounds(268, 251, 217, 33);
		contentPane.add(btnCopy);

		txfPassword = new JTextField();
		txfPassword.setToolTipText("Votre nouveau mot de passe apparaîtra ici.");
		txfPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txfPassword.setEditable(false);
		txfPassword.setBounds(58, 298, 427, 33);
		contentPane.add(txfPassword);
		txfPassword.setColumns(10);
	}

	public void generateWord() {
		Random random = new Random();
		int rdm;
		tempPassword = "";
		tempLetter.clear();
		// On fait une boucle pour chaque lettres demander

		for (int index = 1; index <= Integer.parseInt(spinnerWordLenght.getValue().toString()); index++) {
			rdm = random.nextInt(0, tempList.size());

			// Si on ne veut pas de charactère en double
			if (cbxSimilarLetters.isSelected() == true) {
				while (tempLetter.contains(tempList.get(rdm))) {
					rdm = random.nextInt(0, tempList.size());
				}
				// On ajoute le charactere a la liste des charactere deja utilisé
				tempLetter.add(String.valueOf(tempList.get(rdm)));
			}
			// On concateiner les lettres du mot de passe
			tempPassword = tempPassword + tempList.get(rdm);
		}
		txfPassword.setText(tempPassword);
	}
}
