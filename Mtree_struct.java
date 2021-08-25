package moteurrecherche;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Mtree_struct {

    ArrayList<Double> Couleur = new ArrayList<>(), Form = new ArrayList<>();
    ArrayList<NoeudesIntern> listNoeuds;
    ArrayList<String> listNoms = new ArrayList<>();
    ArrayList<Integer> listnombres = new ArrayList<>();
    ArrayList<DescripteursVisuels> ImagesResultats = new ArrayList<>();

    public Mtree_struct() {
        listNoeuds = new ArrayList<>();
    }
    Distance d = new Distance();

    public void InsertionObjet(NoeudesIntern node, DescripteursVisuels objet) {

        if (listNoeuds.isEmpty()) {
            NoeudesIntern noeud = new NoeudesIntern();
            noeud.setRayon(0.2);
            noeud.getlistObjets().add(objet);
            listNoeuds.add(noeud);
        }else {
            NoeudesIntern courant = new NoeudesIntern();
            courant = listNoeuds.get(0);
            int i = 0;
            while (i <= listNoeuds.size()) {
                if (d.CalculeDistance(objet, courant.getlistObjets().get(0)) < courant.getRayon() && courant.getlistObjets().size() < 21 && !listNoms.contains(objet.getId_image())) {
                    courant.getlistObjets().add(objet);
                    listNoms.add(objet.getId_image());

                } else if (courant.getPointure() == null && !listNoms.contains(objet.getId_image())) {
                    Splite(courant, objet);
                } else {
                    courant = courant.getPointure();
                }

                i++;
            }
        }
    }

    public ArrayList<NoeudesIntern> getStructureM_tree() {
        return listNoeuds;
    }

    public void Splite(NoeudesIntern noeud, DescripteursVisuels objet) {
        NoeudesIntern nouveaunoeud = new NoeudesIntern();
        nouveaunoeud.setRayon(0.2);
        noeud.setPointure(nouveaunoeud);
        nouveaunoeud.getlistObjets().add(objet);
        listNoeuds.add(nouveaunoeud);
        listNoms.add(objet.getId_image());
    }

    public void RangQeuries(DescripteursVisuels query, double distance) throws FileNotFoundException {
        ArrayList<DescripteursVisuels> Resultat = new ArrayList<>();
        ArrayList<DescripteursVisuels> listpertinet = new ArrayList<>();
        listpertinet.addAll(Readfile(query,distance));
        ArrayList<String> Resnom = new ArrayList<>();
        ArrayList<Double> Res = new ArrayList<>();
        double[] combine;
        int compt;
            compt = 0;
            
                for (DescripteursVisuels descr :listpertinet) {
                    double value = d.CalculeDistance(listpertinet.get(compt), query);
                    if (value < distance) {
                        Resultat.add(descr);
                        Res.add(value);
                    }
                    compt++;
                }
        combine = new double[Res.size()];
        for (int i = 0; i < Res.size() - 1; i++) {
            combine[i] = Res.get(i);
        }
        Boolean trie = false;
        while (!trie) {
            for (int x = 0; x < combine.length - 1; x++) {
                double c = combine[x];
                if (combine[x] > combine[x + 1]) {
                    combine[x] = combine[x + 1];
                    combine[x + 1] = c;
                }
            }
            int v = 0;
            for (int j = 0; j < combine.length - 1; j++) {
                if (combine[j] <= combine[j + 1]) {
                    v++;
                }
            }
            if (v >= combine.length - 1) {
                trie = true;
            }
        }
        for (int i = 0; i < combine.length; i++) {
            for (DescripteursVisuels desc : Resultat) {
                if (d.CalculeDistance(desc, query) == combine[i]) {
                    if (!Resnom.contains(desc.getId_image())) {
                        ImagesResultats.add(desc);
                        Resnom.add(desc.getId_image());
                    }
                }
            }
        }if(d.CalculeDistance(query, ImagesResultats.get(0))!=0) ImagesResultats.clear();
    }

    public ArrayList<DescripteursVisuels> getListImagesResultats() {
        return ImagesResultats;
    }

    public ArrayList<DescripteursVisuels> Readfile(DescripteursVisuels requet,double distance) throws FileNotFoundException { 
        ArrayList<DescripteursVisuels> listobjetpertinat = new ArrayList<>();
        ArrayList<Integer> listNonpertinet = new ArrayList<>();
        File file = new File("C:\\Users\\Lenovo\\Desktop/Baseindex1.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Scanner scn = new Scanner(br);
        boolean rep = false;
        int c = 0, f = 0;
        String line;
        String[] separ;
        while (scn.hasNext()) {
            int id = 0;
            String idimage = "";
            line = scn.nextLine();
            String[] array = line.split(",");
            idimage = array[1];
            id = (parseInt(array[0]));
            
  if(!listNonpertinet.contains((int)id)){
            for (int i = 2; i < 770; i++) {
                String value = array[i];
                Couleur.add(parseDouble(value.replace(",", ".")));
            }
            for (int i = 770; i < 1050; i++) {
                String value = array[i];
                if (value.contains("/")) {
                    value = value.replace('/', ' ');
                }
                Form.add(parseDouble(value.replace(",", ".")));
            }
            double[] col = new double[Couleur.size()], form = new double[Form.size()];
            for (int x = 0; x < Couleur.size(); x++) {
                col[x] = Couleur.get(x);
            }
            for (int x = 0; x < Form.size(); x++) {
                form[x] = Form.get(x);
            }
            DescripteursVisuels desc = new DescripteursVisuels(col, form, idimage);
           if(d.CalculeDistance(desc, requet)<distance+0.1){
               listobjetpertinat.add(desc);
           }else{
               listNonpertinet.add(id);
           }
         }
            line = "";
            Couleur.clear();
            Form.clear();
        }  
        return listobjetpertinat;
    }
    
      public ArrayList<DescripteursVisuels> RechercheSequenciel( ) throws FileNotFoundException { 
          ArrayList<DescripteursVisuels> listObjetsimages=new ArrayList<>();
        File file = new File("C:\\Users\\Lenovo\\Desktop/BaseindexSequenciel1.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Scanner scn = new Scanner(br);
        boolean rep = false;
        int c = 0, f = 0;
        String line;
        String[] separ;
        while (scn.hasNext()) {
 
            String idimage = "";
            line = scn.nextLine();
            String[] array = line.split(",");
            idimage = array[0];
            for (int i = 1; i < 769; i++) {
                String value = array[i];
                Couleur.add(parseDouble(value.replace(",", ".")));
            }
            for (int i = 769; i < 1049; i++) {
                String value = array[i];
                if (value.contains("/")) {
                    value = value.replace('/', ' ');
                }
                Form.add(parseDouble(value.replace(",", ".")));
            }
            double[] col = new double[Couleur.size()], form = new double[Form.size()];
            for (int x = 0; x < Couleur.size(); x++) {
                col[x] = Couleur.get(x);
            }
            for (int x = 0; x < Form.size(); x++) {
                form[x] = Form.get(x);
            }
            DescripteursVisuels desc = new DescripteursVisuels(col, form, idimage);
            listObjetsimages.add(desc);
            line = "";
            Couleur.clear();
            Form.clear();
        }
        return listObjetsimages;
    }
      
      public void RechercheparSequenciel(DescripteursVisuels query,double distance){
          ArrayList<DescripteursVisuels> list = new ArrayList<>();
           ArrayList<DescripteursVisuels> listReslt = new ArrayList<>();
   
        try {
            list.addAll(RechercheSequenciel());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mtree_struct.class.getName()).log(Level.SEVERE, null, ex);
        }
          ArrayList<DescripteursVisuels> Resultat = new ArrayList<>();        
        ArrayList<String> Resnom = new ArrayList<>();
        ArrayList<Double> Res = new ArrayList<>();
        double[] combine;
        int compt;
 
            compt = 0;
            
                for (DescripteursVisuels descr :list) {
                    double value = d.CalculeDistance(list.get(compt), query);
                    if (value < distance) {
                        Resultat.add(descr);
                        Res.add(value);
                    }
                    compt++;
                }      
        combine = new double[Res.size()];
        for (int i = 0; i < Res.size() - 1; i++) {
            combine[i] = Res.get(i);
        }
        Boolean trie = false;
        while (!trie) {
            for (int x = 0; x < combine.length - 1; x++) {
                double c = combine[x];
                if (combine[x] > combine[x + 1]) {
                    combine[x] = combine[x + 1];
                    combine[x + 1] = c;
                }
            }
            int v = 0;
            for (int j = 0; j < combine.length - 1; j++) {
                if (combine[j] <= combine[j + 1]) {
                    v++;
                }
            }
            if (v >= combine.length - 1) {
                trie = true;
            }
        }
        for (int i = 0; i < combine.length; i++) {
            for (DescripteursVisuels desc : Resultat) {
                if (d.CalculeDistance(desc, query) == combine[i]) {
                    if (!Resnom.contains(desc.getId_image())) {
                        ImagesResultats.add(desc);
                        Resnom.add(desc.getId_image());
                    }
                }
            }
        } if(d.CalculeDistance(query, ImagesResultats.get(0))!=0) ImagesResultats.clear();
      }
      
     public static void main(String[] args){
          DescripteurForm form=null;
          DescriteurColeur couleur=null;
          DescripteursVisuels objetimage=null;
        try {
            Mtree_struct c=new Mtree_struct();
              BufferedImage image = ImageIO.read( new File("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/obj4__5.png"));
            couleur=new DescriteurColeur(image);
            form=new DescripteurForm(image);
              try {
                  form.CalculZernikeMoments(20,14);
              } catch (Exception ex) {
                  Logger.getLogger(Mtree_struct.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            objetimage=new DescripteursVisuels(couleur.getVecteureCouleur(), form.getVecteurMoments(),"obj"+(0)+"__"+70+".png");
            c.RangQeuries(objetimage,  0.0009);
            for(int i=0;i<c.getListImagesResultats().size();i++){
          System.err.println( c.getListImagesResultats().get(i).getId_image());
            }
        } catch (IOException ex) {
            Logger.getLogger(Mtree_struct.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
