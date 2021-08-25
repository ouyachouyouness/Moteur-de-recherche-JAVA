/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.read;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.CANCEL_OPTION;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class APP3 extends JFrame {
         BufferedImage imagerequet=null;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APP3 frame = new APP3();
					frame.setVisible(true);
					frame.setTitle("Moteur de recherche (Indexatation et recherche d'image par la forme et la couleur) " );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        String chemin="";
        int methodemtree=0;
         ArrayList<JLabel> labels=new ArrayList<>();
         JLabel lblDur = new JLabel("0 ms");
	public APP3() {
                 setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 889, 502);
		setSize(1100,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(373, 69, 3, 592);
		contentPane.add(panel_1);
                
		 JPanel panel_2 = new JPanel();
                panel_2.setBounds(375, 73, 710, 500);
                panel_2.setLayout(new GridLayout(2, 3));
                JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
                label1=new JLabel();
                label2=new JLabel();
                label3=new JLabel();
                label4=new JLabel();
                label5=new JLabel();
                label6=new JLabel();
               
                panel_2.add(label1);
                panel_2.add(label2);
                panel_2.add(label3);
                panel_2.add(label4);
                panel_2.add(label5);
                panel_2.add(label6);
                
                labels.add(label1);
                labels.add(label2);
                labels.add(label3);
                labels.add(label4);
                labels.add(label5);
                labels.add(label6);
                contentPane.add(panel_2);
		JLabel label = new JLabel("Dur\u00E9\u00E9");
		label.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/Time-Sandglass-icon.png"));
		label.setBounds(740, 594, 46, 39);
		contentPane.add(label);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(47, 79, 79));
		panel_13.setBounds(0, 69, 373, 592);
		contentPane.add(panel_13);
		panel_13.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 240, 292, 190);
		panel_13.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(10, 0, -1, 4);
		panel.add(label_2);
		
		JLabel AjouterImage = new JLabel("");
		AjouterImage.setBounds(0, 0, 292, 190);
		panel.add(AjouterImage);
		
		JButton btnChercher = new JButton("");
		btnChercher.setBounds(227, 460, 53, 49);
		panel_13.add(btnChercher);
		btnChercher.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/search-icon.png"));
                btnChercher.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         if(methodemtree==0){showMessageDialog(null,"s'il vous plait il faut choisir la méthode de recherche");}
                         else   RechercheImage();
                     }
                 });
		
		JButton button_3 = new JButton("");
		button_3.setBounds(63, 463, 53, 46);
		panel_13.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 JFileChooser filechooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("image", "jpg", "png", "gif");
                    filechooser.addChoosableFileFilter(filter);
                    int result = filechooser.showSaveDialog(null);
                    if (result == APPROVE_OPTION) {
                        try {
                            File fileSelected = filechooser.getSelectedFile();
                            chemin = fileSelected.getAbsolutePath();
                            imagerequet = ImageIO.read(fileSelected);
                            Image dimg = imagerequet.getScaledInstance(280, 200, SCALE_SMOOTH);
                            AjouterImage.setIcon(new ImageIcon(dimg));
                        } catch (IOException ex) {

                        }
                    } 
                    
                }
			}
                        );
		button_3.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/addImage.png"));
               
		
		JLabel lblChercher = new JLabel("Chercher");
		lblChercher.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblChercher.setForeground(new Color(255, 255, 255));
		lblChercher.setBackground(new Color(47, 79, 79));
		lblChercher.setBounds(227, 520, 71, 14);
		panel_13.add(lblChercher);
		
		JLabel lblAjouter = new JLabel("Ajouter\r\n");
		lblAjouter.setForeground(Color.WHITE);
		lblAjouter.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblAjouter.setBackground(new Color(47, 79, 79));
		lblAjouter.setBounds(63, 520, 71, 14);
		panel_13.add(lblAjouter);
		
		JLabel label_1 = new JLabel("Methode de recherche ");
		label_1.setBounds(35, 61, 263, 23);
		panel_13.add(label_1);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Arial Black", Font.BOLD, 19));
		JRadioButton radioButton_1 = new JRadioButton("S\u00E9quenciel\r\n");
		JRadioButton radioButton = new JRadioButton("M-Tree\r\n");
		radioButton.setBounds(63, 111, 109, 23);
		panel_13.add(radioButton);
		radioButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		radioButton.setForeground(new Color(192, 192, 192));
		radioButton.setBackground(new Color(47, 79, 79));
		radioButton.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         methodemtree=1;
                         radioButton_1.setSelected(false);
                     }
                 });
           
		radioButton_1.setBounds(63, 144, 145, 23);
		panel_13.add(radioButton_1);
		radioButton_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		radioButton_1.setForeground(new Color(192, 192, 192));
		radioButton_1.setBackground(new Color(47, 79, 79));
		radioButton_1.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                       methodemtree=-1;   
                     radioButton.setSelected(false);
                     }
                 });
		JLabel lblImageRequte = new JLabel("Image requ\u00EAte");
		lblImageRequte.setForeground(Color.WHITE);
		lblImageRequte.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblImageRequte.setBounds(100, 195, 263, 23);
		panel_13.add(lblImageRequte);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 140, 0));
		panel_14.setBounds(-60, 0, 1139, 73);
		contentPane.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_3 = new JLabel("Indexatation et recherche d'image par le contenu par la forme et la couleur ");
		label_3.setBounds(342, 23, 589, 21);
		panel_14.add(label_3);
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		JLabel lblFacultDesSciences = new JLabel("Facult\u00E9 des sciences et t\u00E9chniques Errachidia");
		lblFacultDesSciences.setBounds(379, 0, 463, 25);
		panel_14.add(lblFacultDesSciences);
		lblFacultDesSciences.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblFacultDesSciences.setForeground(new Color(255, 255, 255));
		
		JLabel label_4 = new JLabel("Moteur de recherche");
		label_4.setBounds(456, 48, 497, 14);
		panel_14.add(label_4);
		label_4.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(47, 79, 79));
		panel_15.setBounds(373, 579, 711, 82);
		contentPane.add(panel_15);
		panel_15.setLayout(null);
		
		JButton button = new JButton("");
		button.setBounds(33, 11, 53, 44);
		panel_15.add(button);
		button.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/NExt.png"));
		
		JLabel lblRechercher = new JLabel("Suivant");
		lblRechercher.setForeground(Color.WHITE);
		lblRechercher.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblRechercher.setBackground(new Color(47, 79, 79));
		lblRechercher.setBounds(33, 57, 85, 14);
		panel_15.add(lblRechercher);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/Button-Close-icon.png"));
		button_1.setBounds(192, 11, 53, 49);
		panel_15.add(button_1);
                button_1.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         for( JLabel label:labels){
                             label.setIcon(null);
                         }
                         AjouterImage.setIcon(null);
                         lblDur.setText("0 ms");
                     }
                 });
		
		JLabel lblFermer = new JLabel("Effacer\r\n");
		lblFermer.setForeground(Color.WHITE);
		lblFermer.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblFermer.setBackground(new Color(47, 79, 79));
		lblFermer.setBounds(192, 57, 85, 14);
		panel_15.add(lblFermer);
		
		
		lblDur.setForeground(Color.WHITE);
		lblDur.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblDur.setBackground(new Color(47, 79, 79));
		lblDur.setBounds(367, 57, 102, 14);
		panel_15.add(lblDur);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Basedimagee b =new Basedimagee();
				b.setVisible(true);
				b.setLocationRelativeTo(null);
                                fermer();
			}
		});
		button_2.setBounds(548, 11, 53, 46);
		panel_15.add(button_2);
		button_2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/data-info-icon.png"));
		
		JLabel lblBaseDesImages = new JLabel("Base des images\r\n");
		lblBaseDesImages.setForeground(Color.WHITE);
		lblBaseDesImages.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblBaseDesImages.setBackground(new Color(47, 79, 79));
		lblBaseDesImages.setBounds(528, 58, 125, 14);
		panel_15.add(lblBaseDesImages);
		
	}
        DescripteurForm for1=null;
        DescriteurColeur col1=null;
        DescripteursVisuels Query=null;
    public void RechercheImage() {
        long start = System.currentTimeMillis();
        try {
            if (imagerequet == null) {
                showMessageDialog(null, "il faut séléctionner une image ");
            }
            ArrayList<DescripteursVisuels> Resultat = new ArrayList<>();
            Mtree_struct structuremtree = new Mtree_struct();
            col1 = new DescriteurColeur(imagerequet);
            for1 = new DescripteurForm(imagerequet);
            for1.CalculZernikeMoments(20, 14);
            Query = new DescripteursVisuels(col1.getVecteureCouleur(), for1.getVecteurMoments(), "");
            if (methodemtree == 1) {
                structuremtree.RangQeuries(Query, 0.0030);
            } else if (methodemtree == -1) {
                structuremtree.RechercheparSequenciel(Query, 0.003);
            } else {
                showMessageDialog(null, "vous avez pas choisir la méthode de recherche");
            }
            Resultat.addAll(structuremtree.getListImagesResultats());
            if (Resultat.isEmpty()) {
                showMessageDialog(null, "Malheureusement aucun image similaire à cette requête");
            } else if (methodemtree == 1 || methodemtree == -1) {
                BufferedImage resultat = null;
                int ord = 8;
                if (Resultat.size() < 8) {
                    ord = Resultat.size();
                }
                for (int j = 0; j < ord; j++) {
                    if (Resultat.get(j).getId_image().length() < 20) {
                        resultat = read(new File("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/" + Resultat.get(j).getId_image()));
                    } else {
                        resultat = read(new File(Resultat.get(j).getId_image()));
                    }
                    labels.get(j).setIcon(new ImageIcon(resultat.getScaledInstance(170, 150, SCALE_SMOOTH)));
                    labels.get(j).repaint();

                }

            }
        } catch (Exception ex) {

        }
        lblDur.setText(" :" + (System.currentTimeMillis() - start) + " ms");
    }
    public void fermer(){
        dispose();
    }
}

