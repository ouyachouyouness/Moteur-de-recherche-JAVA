/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Similarité {


    private DescriteurColeur col1, col2;
    private DescripteurForm for1, for2;
    private BufferedImage image1, image2;
    ArrayList<DescripteursVisuels> list = new ArrayList<>();
    // StructureMTree s = new StructureMTree();
    Distance d=new Distance();
    public Similarité(int ordermoment, int repetitionmoment) {
        try {
            image2 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/obj1__0.png"));
            image1 = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/obj1__5.png"));
            col1 = new DescriteurColeur(image1);
            for1 = new DescripteurForm(image1);  
            for1.CalculZernikeMoments(ordermoment, repetitionmoment);               
           col2 = new DescriteurColeur(image2);
           for2 = new DescripteurForm(image2);
           for2.CalculZernikeMoments(ordermoment, repetitionmoment);
           DescripteursVisuels dec=new DescripteursVisuels(col1.getVecteureCouleur(), for1.getVecteurMoments(), "");
           DescripteursVisuels dec1=new DescripteursVisuels(col2.getVecteureCouleur(), for2.getVecteurMoments(), "");
            System.err.println("resultat   :*"+d.CalculeDistance(dec1, dec));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    DescripteursVisuels Query;

    public void CalculeSimilarit() {
        int compt = 0, compt1 = 0;
        double somme = 0, Resultat = 0, somme2 = 0, DistanceC = 0, DistanceF = 0;
        for (int x = 0; x < col1.getSize(); x++) {
            somme += Math.pow(col1.getVecteureCouleur()[x] - col2.getVecteureCouleur()[x], 2);
        }
        for (int x = 0; x <for2.getVecteurMoments().length ; x++) {
            somme2 += Math.pow(for1.getVecteurMoments()[x]- for2.getVecteurMoments()[x],2);
        }
        DistanceC = (double) Math.sqrt(somme)/2;
        DistanceF = (double) Math.sqrt(somme2)/2;
        Resultat = (double) (DistanceF+DistanceC);
        System.err.println("Resultat: " +DistanceF);
    }

    public BufferedImage getImage1() {
        return image1;
    }

    public BufferedImage getImage2() {
        return image2;
    }

    public static void main(String[] args) {
        new Similarité(20,14);
    }
}
