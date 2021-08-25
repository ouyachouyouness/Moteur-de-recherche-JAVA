package moteurrecherche;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.TreeSet;

public class DescriteurColeur {

    private double[] VcteureCouleurV;
    private double[] VcteureCouleurS;
    private double[] VcteureCouleurH;
    private double[] VcteureCouleurR;
    private double[] VcteureCouleurG;
    private double[] VcteureCouleurB;
    private BufferedImage image;
    TreeSet<Double> liste = new TreeSet<>();
    TreeSet<Double> listRGB = new TreeSet<>();
    double[] DescripteureCouleure = new double[256 * 3];
    private double S = 0, V = 0, H = 1;

    public DescriteurColeur(BufferedImage image) {
        this.image = image;
        nbttp = 256;
        VcteureCouleurV = new double[nbttp];
        VcteureCouleurS = new double[nbttp];
        VcteureCouleurH = new double[nbttp];
        VcteureCouleurR = new double[nbttp];
        VcteureCouleurG = new double[nbttp];
        VcteureCouleurB = new double[nbttp];
        récupérerRVB();

    }
    private int nbttp;

    public void récupérerRVB() {
        Raster trame = image.getRaster();
        int[] rgb = new int[3];
        for (int x =0; x < image.getHeight(); x++) {
            for (int y =0; y < image.getWidth(); y++) {
                trame.getPixel(x, y, rgb);
                VcteureCouleurR[rgb[0]]++;
                VcteureCouleurG[rgb[1]]++;
                VcteureCouleurB[rgb[2]]++;
            }
        }
        for (int x = 0; x < 256; x++) {
            listRGB.add((double) VcteureCouleurR[x]);
            listRGB.add((double) VcteureCouleurG[x]);
            listRGB.add((double) VcteureCouleurB[x]);
            listRGB.descendingSet();
            V = listRGB.last();
            if (V == 0) {
                S = 0;
                H = 0;
            } else {
                S = (V - listRGB.first()) / V;
                if (V == rgb[0]) {
                    H = (rgb[1] - rgb[2]) / (V - listRGB.first());
                } else if (V == rgb[1]) {
                    H = 2 + ((rgb[2] - rgb[0]) / (V - listRGB.first()));
                } else if (V == rgb[2]) {
                    H = 4 + ((rgb[0] - rgb[1]) / (V - listRGB.first()));
                }
                VcteureCouleurV[x] = V;
                VcteureCouleurS[x] = S;
                VcteureCouleurH[x] = H;
            }
        }
        //***************************   Partie de normalisation    **********************************************

        int compt = 0;
        for (int j = 0; j < 256; j++) {
            DescripteureCouleure[compt] = VcteureCouleurV[j];
            compt++;
        }
        for (int j = 0; j < 256; j++) {
            DescripteureCouleure[compt] = VcteureCouleurS[j];
            compt++;
        }
        for (int j = 0; j < 256; j++) {
            DescripteureCouleure[compt] = VcteureCouleurH[j];
            compt++;
        }
        for (int i = 0; i < DescripteureCouleure.length; i++) {
            liste.add(DescripteureCouleure[i]);
        }
        liste.descendingSet();
        for (int i = 0; i < DescripteureCouleure.length; i++) {
            DescripteureCouleure[i] = (DescripteureCouleure[i] - liste.first()) / (liste.last() - liste.first());
        }

    }

    public double[] getVecteureCouleur() {
        return DescripteureCouleure;
    }

    public int getSize() {
        return DescripteureCouleure.length;
    }
}
