/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;

import com.sun.org.apache.xerces.internal.util.MessageFormatter;
import com.sun.webkit.ContextMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.read;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.CANCEL_OPTION;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.filechooser.FileNameExtensionFilter;

   public class DesigneMoteur extends JFrame {

    private BufferedImage imagerequet;
    String chemin = "", nom = "";
    ArrayList<JLabel> listLabels = new ArrayList<>();
    Panel panelcontenir, panelNord, panelOuest, panelCenter, panelSoud, panelBoutons, panelcontenirlabels;
    JButton boutonRecherche, boutonCharger, boutonEffacer, boutonsuivant;
    JLabel label = new JLabel();
    int methodemtree;
    JLabel dateRecherche;
    ArrayList<String> listeImagesajouter = new ArrayList();
    BufferedImage image;

    public DesigneMoteur() {

        JLabel labelimagerequet = new JLabel("");
        JMenuBar menubar = new JMenuBar();
        menubar.setPreferredSize(new Dimension(this.getWidth(), 50));
        JMenu test = new JMenu("Type de Recherche");
        JMenu manipulation = new JMenu("Anserer images");
        manipulation.setForeground(Color.BLUE);
        manipulation.setFont(new Font("Arial", Font.BOLD, 16));
        test.setForeground(Color.BLUE);
        test.setFont(new Font("Arial", Font.BOLD, 16));
        JRadioButtonMenuItem b1 = new JRadioButtonMenuItem("Recherche avec Mtree");
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setForeground(Color.blue);
        JRadioButtonMenuItem b2 = new JRadioButtonMenuItem("Recherche séquentiel");
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setForeground(Color.blue);
        JRadioButtonMenuItem b3 = new JRadioButtonMenuItem("Insertion d'images");
        b3.setFont(new Font("Arial", Font.BOLD, 16));
        b3.setForeground(Color.blue);
        JRadioButtonMenuItem b4 = new JRadioButtonMenuItem("Recherche d'images");
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setForeground(Color.blue);

        manipulation.add(b3);
        manipulation.add(b4);
        test.add(b1);
        test.add(b2);
        menubar.add(test);
        menubar.add(manipulation);
        menubar.setBackground(new Color(255,0,255));
        setJMenuBar(menubar);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodemtree = 1;
                label.setText("Type de Recherche :avec M-tree");
                panelcontenirlabels.setBounds(0, 0, 960, 350);
                panelcontenir.setBounds(0, 0, 1300, 700);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodemtree = -1;
                label.setText("Type de Recherche :Séqunciel");
                panelcontenirlabels.setBounds(0, 0, 960, 350);
                panelcontenir.setBounds(0, 0, 1300, 700);
            }
        });
            
        panelNord = new Panel();
        panelNord.setBounds(330, 0, 770, 100);
        panelNord.setBackground(Color.CYAN);
        panelNord.setLayout(new GridLayout(3, 1));
        panelBoutons = new Panel();
        panelCenter = new Panel();
        panelCenter.setBounds(300, 140, 960, 400);
        panelCenter.setBackground(Color.white);
        panelCenter.setLayout(null);
        panelcontenirlabels = new Panel();
        panelcontenirlabels.setBounds(0, 0, 960, 350);
        panelcontenirlabels.setBackground(Color.white);
        panelcontenirlabels.setLayout(new GridLayout(2, 4));
        panelOuest = new Panel();
        panelOuest.setLayout(null);
        panelOuest.setBackground(new Color(0, 255, 255));
        panelOuest.setBounds(0, 140, 280, 400);
        panelSoud = new Panel();
        panelSoud.setBounds(0, 0, 1300, 770);
        panelSoud.setBackground(Color.CYAN);
        panelSoud.setLayout(null);
        panelcontenir = new Panel();
        panelcontenir.setLayout(null);
        panelcontenir.setLayout(null);
        panelcontenir.setBounds(0, 0, 1300, 700);
        panelcontenir.add(panelOuest);
        panelcontenir.add(panelCenter);
        panelCenter.add(panelcontenirlabels);
        panelcontenir.add(panelNord);
        panelcontenir.setBackground(new Color(192,192,192));
        boutonRecherche = new JButton();
        boutonCharger = new JButton();
        boutonsuivant = new JButton();
        boutonEffacer = new JButton();
        for (int i = 0; i < 8; i++) {
            lab = new JLabel();
            listLabels.add(lab);
        }
        for (int i = 0; i < 8; i++) {
            panelcontenirlabels.add(listLabels.get(i));
        }
        try {
            Image ig1 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img6.jpg"));
            Image igd1 = ig1.getScaledInstance(90, 50, SCALE_SMOOTH);
            Icon ic1 = new ImageIcon(igd1);
            boutonRecherche.setIcon(ic1);
            boutonRecherche.setBounds(170, 350, 90, 50);

            Image ig = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img5.jpg"));
            Image igd = ig.getScaledInstance(90, 50, SCALE_SMOOTH);
            Icon ic = new ImageIcon(igd);
            boutonCharger.setBounds(30, 350, 90, 50);
            boutonCharger.setIcon(ic);

            boutonCharger.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser filechooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("image", "jpg", "png", "gif");
                    filechooser.addChoosableFileFilter(filter);
                    int result = filechooser.showSaveDialog(null);
                    if (result == APPROVE_OPTION) {
                        try {
                            File fileSelected = filechooser.getSelectedFile();
                            nom = fileSelected.getAbsolutePath();
                            imagerequet = read(fileSelected);
                            Image dimg = imagerequet.getScaledInstance(280, 200, SCALE_SMOOTH);
                            labelimagerequet.setIcon(new ImageIcon(dimg));
                        } catch (IOException ex) {

                        }
                    } else {
                        if (result == CANCEL_OPTION) {
                            showMessageDialog(null, "aucune image choisie !!!!");
                        }
                    }
                }
            });

            boutonCharger.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    boutonCharger.setToolTipText("charger image");
                }
            });
            boutonRecherche.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RechercheImage();
                }
            });
            boutonRecherche.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    boutonRecherche.setToolTipText("Rechercher d'images similaires");
                }
            });
            boutonsuivant.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    boutonsuivant.setToolTipText("images similair suivants");
                }
            });
            boutonEffacer.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    boutonEffacer.setToolTipText("effacer les images similaires");
                }
            });
            Image ig5 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img4.jpg"));
            Image igd5 = ig5.getScaledInstance(90, 50, SCALE_SMOOTH);
            Icon ic5 = new ImageIcon(igd5);
            boutonEffacer.setBounds(850, 350, 90, 50);
            boutonEffacer.setIcon(ic5);
            boutonEffacer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    labelimagerequet.setIcon(null);
                    imagerequet = null;
                    dateRecherche.setText("Durée de Recherche :" + 0 + " ms");
                    for (int i = 0; i < 8; i++) {
                        listLabels.get(i).setIcon(null);
                    }
                }
            });
            Image ig6 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img7.jpg"));
            Image igd6 = ig6.getScaledInstance(90, 50, SCALE_SMOOTH);
            Icon ic6 = new ImageIcon(igd6);
            boutonsuivant.setBounds(10, 350, 90, 50);
            boutonsuivant.setIcon(ic6);
            
           
        } catch (IOException ex) {
            Logger.getLogger(DesigneMoteure.class.getName()).log(Level.SEVERE, null, ex);
        }

        //***************les composants de la partie NORD**********************
        JLabel label1 = new JLabel("Faculté des Sciences et Techniques Errachidia");
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setForeground(Color.BLUE);
        panelNord.add(label1);

        JLabel label2 = new JLabel("Département d'Informatique");
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setForeground(Color.BLUE);
        panelNord.add(label2);

        JLabel label3 = new JLabel("Mouteur de Recherche d'images par le contenu");
        label3.setFont(new Font("Arial", Font.BOLD, 14));
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setForeground(Color.BLUE);
        panelNord.add(label3);
        DesigneMoteur p = this;
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelcontenirlabels.setBounds(0, 0, 960, 350);
                panelcontenir.setBounds(0, 0, 1300, 700);
                panelNord.setBounds(330, 50, 770, 70);
                panelcontenir.add(panelNord);
                p.setContentPane(panelcontenir);
                panelCenter.setBounds(300, 160, 960, 400);
                panelOuest.setBounds(0, 160, 280, 400);

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcontenirlabels.setBounds(0, 20, 960, 350);
                panelNord.setBounds(330, 100, 770, 100);
                panelSoud.add(panelNord);
                p.setContentPane(panelSoud);

            }
        });
        //*************lescomposants de la partie gauche*****************
        label = new JLabel("Type de Recherche :......");
        label.setBounds(-10, 10, 300, 100);
        panelOuest.add(label);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel labe2 = new JLabel("Image Requête ");
        labe2.setBounds(40, 90, 180, 50);
        panelOuest.add(labe2);
        labe2.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        labe2.setHorizontalAlignment(JLabel.CENTER);

        panelBoutons.setBounds(0, 140, 280, 190);
        labelimagerequet.setIcon(null);
        panelBoutons.add(labelimagerequet);
        panelBoutons.setBackground(Color.white);
        panelOuest.add(panelBoutons);
        panelOuest.add(boutonCharger);
        panelOuest.add(boutonRecherche);
        panelCenter.add(boutonEffacer);
        panelCenter.add(boutonsuivant);

        //*********composants de la partie soud************
        dateRecherche = new JLabel("Durée de recheche : ... ms");
        dateRecherche.setBounds(500, 530, 300, 100);
        dateRecherche.setFont(new Font("Arial", Font.BOLD, 18));
        dateRecherche.setHorizontalAlignment(JLabel.CENTER);
        dateRecherche.setForeground(Color.BLUE);

        panelcontenir.add(dateRecherche);
        JButton bouton3 = new JButton();
        JButton bouton4 = new JButton();
        JButton bouton5 = new JButton();
        JButton bouton6 = new JButton();
        Panel imageinserer = new Panel();
        imageinserer.setBackground(Color.white);
        imageinserer.setLayout(new GridLayout(1, 1));
        JLabel imageentrer = new JLabel();
        imageinserer.add(imageentrer);
        imageinserer.setBounds(520, 340, 280, 200);
        bouton3.setBounds(400, 380, 70, 50);
        bouton4.setBounds(400, 450, 70, 50);
        bouton5.setBounds(840, 450, 70, 50);
        bouton6.setBounds(840, 380, 70, 50);
        JLabel label4 = new JLabel(" Partie utilisateur pour inserer des images");
        label4.setFont(new Font("Arial", Font.BOLD, 18));
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setForeground(Color.BLUE);
        label4.setBounds(290, 260, 700, 70);
        try {
            Image ig4 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img5.jpg"));
            Image igd1 = ig4.getScaledInstance(90, 50, SCALE_SMOOTH);
            Icon ic4 = new ImageIcon(igd1);
            bouton3.setIcon(ic4);
            Image ig7 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img2.jpg"));
            Image igd7 = ig7.getScaledInstance(90, 40, SCALE_SMOOTH);
            Icon ic7 = new ImageIcon(igd7);
            bouton4.setIcon(ic7);
            Image ig8 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/down.jfif"));
            Image igd8 = ig8.getScaledInstance(90, 40, SCALE_SMOOTH);
            Icon ic8 = new ImageIcon(igd8);
            bouton5.setIcon(ic8);
            Image ig9 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/img4.jpg"));
            Image igd9 = ig9.getScaledInstance(90, 40, SCALE_SMOOTH);
            Icon ic9 = new ImageIcon(igd9);
            bouton6.setIcon(ic9);
            bouton6.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    bouton6.setToolTipText("effacer l'image");
                }
            });
            bouton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!listeImagesajouter.isEmpty()) {
                        listeImagesajouter.remove(listeImagesajouter.size() - 1);
                    }
                    imageentrer.setIcon(null);
                }
            });
            bouton5.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    bouton5.setToolTipText("enregistrer comme nouveau liste d'images");
                }
            });
            bouton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listeImagesajouter.isEmpty()) {
                        showMessageDialog(null, "vous n'avez pas choisir sucune image");
                    }
                    CalculDescriteure c = new CalculDescriteure(true);
                    c.setInserer(listeImagesajouter);
                    c.CalculeDescripteurs();
                    System.err.println(listeImagesajouter.get(0));
                }
            });
            bouton4.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    bouton4.setToolTipText("ajouter à la liste d'insertion");
                }
            });
            bouton3.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
                    bouton3.setToolTipText("charger l'image à inserer");
                }
            });
            bouton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chemin == null) {
                        showMessageDialog(null, "vous n'avez pas choisir aucune image");
                    }
                    listeImagesajouter.add(chemin);
                }
            });
            bouton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelNord.setBounds(330, 60, 770, 70);
                    imageinserer.setBounds(520, 340, 280, 200);
                    bouton3.setBounds(400, 380, 70, 50);
        bouton4.setBounds(400, 450, 70, 50);
        bouton5.setBounds(840, 450, 70, 50);
        bouton6.setBounds(840, 380, 70, 50);
                    JFileChooser filechooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("image", "jpg", "png", "gif");
                    filechooser.addChoosableFileFilter(filter);
                    int result = filechooser.showSaveDialog(null);
                    if (result == APPROVE_OPTION) {
                        try {
                            File fileSelected = filechooser.getSelectedFile();
                            chemin = fileSelected.getAbsolutePath();
                            image = read(fileSelected);
                            Image dimg = image.getScaledInstance(280, 200, SCALE_SMOOTH);
                            imageentrer.setIcon(new ImageIcon(dimg));
                        } catch (IOException ex) {

                        }
                    } else {
                        if (result == CANCEL_OPTION) {
                            showMessageDialog(null, "vous n'avez pas choisir aucune image");
                        }
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(DesigneMoteure.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelSoud.add(label4);
        panelSoud.add(bouton3);
        panelSoud.add(bouton4);
        panelSoud.add(bouton5);
        panelSoud.add(bouton6);
        panelSoud.add(imageinserer);

        try {
            panelSoud.setLayout(null);
            JLabel bac1=new JLabel();bac1.setBounds(0, 0, 1300, 700);
             JLabel bac=new JLabel();bac.setBounds(0, 0, 1300, 700);
            panelcontenir.add(bac);panelSoud.add(bac1);
            Image ig9 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop/icon9.jpg"));
            Image igd9 = ig9.getScaledInstance(1300, 700, SCALE_SMOOTH);
            Icon ic9 = new ImageIcon(igd9);
            bac.setIcon(ic9);bac1.setIcon(ic9);
        } catch (IOException ex) {
        }

        this.setResizable(true);
        add(panelcontenir);
        setTitle("Moteure de Recherche d'images par le contenu  ::::");
        setBounds(0, 0, 1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JLabel lab;
    private String noom = "";
    DescriteurColeur col1 = null;
    DescripteurForm for1 = null;
    DescripteursVisuels Query = null, objetimage = null;

    public void RechercheImage() {
        long start = System.currentTimeMillis();
        try {
            if (imagerequet == null) {
                showMessageDialog(null, "aucun image sélictioner");
            }
            ArrayList<DescripteursVisuels> Resultat = new ArrayList<>();
            Mtree_struct structuremtree = new Mtree_struct();
            col1 = new DescriteurColeur(imagerequet);
            for1 = new DescripteurForm(imagerequet);
            for1.CalculZernikeMoments(20, 14);
            Query = new DescripteursVisuels(col1.getVecteureCouleur(), for1.getVecteurMoments(), nom);
            if (methodemtree == 1) {
                structuremtree.RangQeuries(Query, 0.0009);
            } else if (methodemtree == -1) {
                structuremtree.RechercheparSequenciel(Query, 0.5);
            } else {
                showMessageDialog(null, "vous avez pas choisir la méthode de recherche");
            }
            Resultat.addAll(structuremtree.getListImagesResultats());
            if (Resultat.isEmpty()) {
                showMessageDialog(null, "Malheureusement aucun image similaire à cette requet");
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
                    listLabels.get(j).setIcon(new ImageIcon(resultat.getScaledInstance(170, 150, SCALE_SMOOTH)));
                    listLabels.get(j).repaint();

                }

            }
        } catch (Exception ex) {

        }
        dateRecherche.setText("Durée de Recherche :" + (System.currentTimeMillis() - start) + " ms");
    }

    public static void main(String[] args) {
        DesigneMoteur m = new DesigneMoteur();

    }
}
