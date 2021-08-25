/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.UIManager;
import javax.swing.event.MouseInputAdapter;

public class Basedimagee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basedimagee frame = new Basedimagee();
					frame.setVisible(true);
					frame.setTitle("Moteur de recherche (Indexatation et recherche d'image par la forme et la couleur) " );
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
        String lienimage="";
        JLabel ImageAjouter = new JLabel("");
        int objet=0,img=0,numeroimagesuppimer=0,numobjet=0;boolean next=false;
        String[] liens=new String[12];
        ArrayList<JLabel> labels=new ArrayList<>();
         ArrayList<String> list=new ArrayList<>();
	public Basedimagee() {
            
                   
            try {
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100,20, 889, 502);
                setSize(1100,700);
       
               contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);
                JPanel panel = new JPanel();
                panel.setBackground(Color.RED);
                panel.setBounds(358, 75, 4, 589);
                contentPane.add(panel);
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(Color.RED);
                panel_1.setBounds(0, 71, 1090, 6);
                contentPane.add(panel_1);
                
                JPanel panel_2 = new JPanel();
                panel_2.setBounds(363, 73, 710, 570);
                panel_2.setLayout(new GridLayout(3, 4));
                JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12;
                label1=new JLabel();
                label2=new JLabel();
                label3=new JLabel();
                label4=new JLabel();
                label5=new JLabel();
                label6=new JLabel();
                label7=new JLabel();
                label8=new JLabel();
                label9=new JLabel();
                label10=new JLabel();
                label11=new JLabel();
                label12=new JLabel();
                panel_2.add(label1);
                panel_2.add(label2);
                panel_2.add(label3);
                panel_2.add(label4);
                panel_2.add(label5);
                panel_2.add(label6);
                panel_2.add(label7);
                panel_2.add(label8);
                panel_2.add(label9);
                panel_2.add(label10);
                panel_2.add(label11);
                panel_2.add(label12);
                labels.add(label1);
                labels.add(label2);
                labels.add(label3);
                labels.add(label4);
                labels.add(label5);
                labels.add(label6);
                labels.add(label7);
                labels.add(label8);
                labels.add(label9);
                labels.add(label10);
                labels.add(label11);
                labels.add(label12);
                contentPane.add(panel_2);
                label1.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=1;Cast(label1.getIcon());;  }});
                label2.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=2;Cast(label4.getIcon());;  }});
                label3.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=3;Cast(label3.getIcon());;  }});
                label4.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=4;Cast(label4.getIcon());;  }});
                label5.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=5;Cast(label5.getIcon());;  }});
                label6.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=6;Cast(label6.getIcon());;  }});
                label7.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=7;Cast(label7.getIcon());;  }});
                label8.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=8;Cast(label8.getIcon());;  }});
                label9.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=9;Cast(label9.getIcon());;  }});
                label10.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=10; Cast(label10.getIcon());; }});
                label11.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=11;Cast(label11.getIcon());  }});
                label12.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        numeroimagesuppimer=12; Cast(label12.getIcon()); }});
                ////////////*************************
                JPanel panel_15 = new JPanel();
                panel_15.setBackground(new Color(255, 140, 0));
                panel_15.setBounds(0, 0, 1084, 72);
                contentPane.add(panel_15);
                panel_15.setLayout(null);
                JButton button_5 = new JButton("");
                button_5.setBounds(1034, 29, 50, 43);
                panel_15.add(button_5);
                button_5.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/NExt.png"));
                button_5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        next=false;                      
                        objet++;
                        affichage(0);
                    }
                });
                JLabel label = new JLabel("Facult\u00E9 des sciences et t\u00E9chniques ");
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Arial Black", Font.BOLD, 16));
                label.setBounds(389, 0, 423, 25);
                panel_15.add(label);
                JLabel lblIndexatationEtRecherche = new JLabel("Indexatation et recherche d'image par la forme et la couleur ");
                lblIndexatationEtRecherche.setForeground(Color.WHITE);
                lblIndexatationEtRecherche.setFont(new Font("Arial Black", Font.PLAIN, 14));
                lblIndexatationEtRecherche.setBounds(329, 23, 559, 21);
                panel_15.add(lblIndexatationEtRecherche);
                JLabel lblGestionDeBase = new JLabel("Gestion de Base des images");
                lblGestionDeBase.setFont(new Font("Arial Black", Font.BOLD, 18));
                lblGestionDeBase.setBounds(408, 47, 445, 25);
                panel_15.add(lblGestionDeBase);
                JPanel panel_16 = new JPanel();
                panel_16.setBackground(new Color(0, 51, 51));
                panel_16.setBounds(0, 71, 361, 589);
                contentPane.add(panel_16);
                panel_16.setLayout(null);
                JLabel lblImageRequt = new JLabel("Image requ\u00EAte");
                lblImageRequt.setBounds(68, 67, 183, 33);
                panel_16.add(lblImageRequt);
                lblImageRequt.setForeground(Color.WHITE);
                lblImageRequt.setFont(new Font("Microsoft Tai Le", Font.BOLD, 25));
                JButton button_4 = new JButton("");
                button_4.setBounds(142, 360, 56, 50);
                panel_16.add(button_4);
                button_4.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/DataSERACH.png"));
                button_4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        objet=0;  
                        list.clear();
                        list.addAll(Listeliens());
                        affichage(0);
                    }
                });
                JButton button_2 = new JButton("");
                button_2.setBounds(26, 360, 50, 50);
                panel_16.add(button_2);
                button_2.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/AjoutrtBase.png"));
                JButton button_3 = new JButton("");
                button_3.setBounds(267, 360, 56, 50);
                panel_16.add(button_3);
                button_3.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/SupprimerBaseee.png"));
                button_3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        ImageAjouter.setIcon(null);
                        CalculDescriteure c=new CalculDescriteure(true);
                        next=true;
                        if(numeroimagesuppimer==0){showMessageDialog(null, "s'il vous plait séléctioner une image");}
                        else {affichage(numeroimagesuppimer);
                        c.Suppression(liens[numeroimagesuppimer-1]);
                        list.remove(liens[numeroimagesuppimer-1]);
                        }
                        numeroimagesuppimer=0;
                    }
                });
                JLabel lblAjouterImage = new JLabel("Ajouter ");
                lblAjouterImage.setForeground(Color.WHITE);
                lblAjouterImage.setFont(new Font("Arial Black", Font.BOLD, 11));
                lblAjouterImage.setBackground(new Color(47, 79, 79));
                lblAjouterImage.setBounds(21, 421, 81, 15);
                panel_16.add(lblAjouterImage);
                JLabel lblAfficher = new JLabel("Afficher\r\n");
                lblAfficher.setForeground(Color.WHITE);
                lblAfficher.setFont(new Font("Arial Black", Font.BOLD, 11));
                lblAfficher.setBackground(new Color(47, 79, 79));
                lblAfficher.setBounds(142, 421, 71, 14);
                panel_16.add(lblAfficher);
                JLabel lblSupprimer = new JLabel("Supprimer\r\n");
                lblSupprimer.setForeground(Color.WHITE);
                lblSupprimer.setFont(new Font("Arial Black", Font.BOLD, 11));
                lblSupprimer.setBackground(new Color(47, 79, 79));
                lblSupprimer.setBounds(264, 421, 71, 14);
                panel_16.add(lblSupprimer);
                JButton button = new JButton("");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        APP3 a =new APP3();
                        a.setVisible(true);
                        a.setLocationRelativeTo(null);
                        
                    }
                });
                JPanel panel_14 = new JPanel();
                panel_14.setBounds(26, 129, 300, 184);
                panel_16.add(panel_14);
                panel_14.setBackground(Color.white);
                panel_14.setLayout(null);
                button.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Icon/Home2.png"));
                button.setBounds(142, 466, 50, 50);
                panel_16.add(button);
                
                JButton insertion = new JButton("");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        APP3 a =new APP3();
                        fermer();
                        a.setVisible(true);
                        a.setLocationRelativeTo(null);
                        
                    }
                });
                
                Image im =ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\Icon/down.jfif"));
                Image ic=im.getScaledInstance(50, 50,SCALE_SMOOTH);
                Icon ido=new ImageIcon(ic);
                insertion.setIcon(ido);
                insertion.setBounds(20, 466, 50, 50);
                panel_16.add(insertion);
                
                insertion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CalculDescriteure c = new CalculDescriteure(true);
                        if(lienimage!=""){
                            
                            if(!c.retrouver(lienimage)){
                                c.Insertion(lienimage);
                    c.setInserer(lienimage);
                    c.CalculeDescripteurs();
                        } else{
                                showMessageDialog(null, "cette image existe dijà");
                            }
                        }else{
                            showMessageDialog(null, "vous n'avez pas choisie aucune image à inserer!! s'il vous plait séléctioner une image");
                        }
                    }
                });
                
                JLabel lblinsererImage = new JLabel("inserer ");
                lblinsererImage.setForeground(Color.WHITE);
                lblinsererImage.setFont(new Font("Arial Black", Font.BOLD, 11));
                lblinsererImage.setBackground(new Color(47, 79, 79));
                lblinsererImage.setBounds(21, 520, 81, 15);
                panel_16.add(lblinsererImage);
                
                JLabel lblHome = new JLabel("Accueil");
                lblHome.setForeground(Color.WHITE);
                lblHome.setFont(new Font("Arial Black", Font.BOLD, 11));
                lblHome.setBackground(new Color(47, 79, 79));
                lblHome.setBounds(142, 527, 71, 14);
                panel_16.add(lblHome);
                ImageAjouter.setBackground(Color.BLACK);
                ImageAjouter.setBounds(0, 0, 300, 184);
                panel_14.add(ImageAjouter);
                button_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser filechooser=new JFileChooser();
                        FileNameExtensionFilter filter=new FileNameExtensionFilter("image","jpg","png","gif");
                        filechooser.addChoosableFileFilter(filter);
                        int result=filechooser.showSaveDialog(null);
                        if(result==filechooser.APPROVE_OPTION) {
                            File selectedfile=filechooser.getSelectedFile();
                            String path=selectedfile.getAbsolutePath();
                            lienimage=selectedfile.getAbsolutePath();
                            ImageIcon myImage=new ImageIcon(path);
                            java.awt.Image img=myImage.getImage();
                            java.awt.Image newImage = img.getScaledInstance(ImageAjouter.getWidth(), ImageAjouter.getHeight(), java.awt.Image.SCALE_SMOOTH);
                            ImageIcon finalImg = new ImageIcon(newImage);
                            ImageAjouter.setIcon(finalImg);
                        }
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(Basedimagee.class.getName()).log(Level.SEVERE, null, ex);
            }
               
               
               
        }          
               
               public void Cast(Icon ic){
                   ImageAjouter.setIcon(ic );
               }
             
                public void affichage(int pos){
                  
                                try {int x=0;               
                                     if(!next){ 
                                         for(JLabel label:labels){
                                           
                                    if(objet<list.size()){           Image ig1=ImageIO.read(new File(list.get(objet)));
                                                Image igd1=ig1.getScaledInstance(170, 160, SCALE_SMOOTH);
                                                Icon ic1=new ImageIcon(igd1);
                                            label.setIcon(ic1);
                                           liens[x]=list.get(objet);
                                           x++;
                                            objet++;
                                            next=false;
                                         }}}
                                      else{
                                 if(pos>0){
                                       for(int i=pos-1;i<12;i++){
                              if(x<11 && i<11)labels.get(i).setIcon(labels.get(i+1).getIcon());liens[x]=liens[x+1];x++;}
                                           if(objet<list.size()-1){
                                           Image ig1=ImageIO.read(new File(list.get(objet)));
                                                Image igd1=ig1.getScaledInstance(170, 160, SCALE_SMOOTH);
                                                Icon ic1=new ImageIcon(igd1);
                                           labels.get(labels.size()-1).setIcon(ic1);
                                           liens[liens.length-1]=list.get(objet);
                                           x++;
                                           objet++;
                                          
                                       } 
                                      
                                      }}
                                      } catch (IOException ex) {
                                                Logger.getLogger(Basedimagee.class.getName()).log(Level.SEVERE, null, ex);
                                            }
 }
           public void fermer(){
               dispose();
           }
           public ArrayList<String> Listeliens(){
              ArrayList<String> list=new ArrayList<>();
               FileReader fr=null;
            try {
                
                fr = new FileReader(new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt"));
                BufferedReader br=new BufferedReader(fr);
                Scanner sc=new Scanner(br);
                while(sc.hasNext()){
                    String ligne="";
                    ligne=sc.nextLine();
                    list.add(ligne);
                }
                sc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Basedimagee.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Basedimagee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return list;
           }
}

