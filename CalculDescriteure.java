
package moteurrecherche;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class CalculDescriteure {
    DescripteursVisuels objetimage;//est une class posséde les signatures de l'image
    DescripteurForm form;
    DescriteurColeur couleur;
    ArrayList<DescripteursVisuels> listdesc = new ArrayList<>();
    ArrayList<DescripteursVisuels> listdescripteurs = new ArrayList<>();
    NoeudesIntern racine = new NoeudesIntern();
     String lienimage;
     boolean ajouter;
      Mtree_struct  str;
      String[][] lien=new String[100][12];
    public CalculDescriteure(boolean ajout) {
        ajouter=ajout;
        str=new Mtree_struct();
        int compt=0;
             for(int i=0;i<80;i++){
        for(int j=0;j<12;j++){
             lien[i][j]="C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/obj"+(i+1)+"__"+compt+".png";
        compt=compt+5;}compt=0;
             }
         /*        for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            System.err.println(lien[i][j]);        
             }}*/
        
    }
public void CalculeDescripteurs(){
    
    BufferedImage image=null;
    int compt=0,id=0;   
            try {
              if(!ajouter){  for(int i=0;i<80;i++){
        for(int j=0;j<12;j++){
         if(lien[i][j]!=null){image=ImageIO.read( new File(lien[i][j]));}
                couleur=new DescriteurColeur(image);
                form=new DescripteurForm(image);
                form.CalculZernikeMoments(20,14);
                objetimage=new DescripteursVisuels(couleur.getVecteureCouleur(), form.getVecteurMoments(),"obj"+(i+1)+"__"+compt+".png");               
                listdescripteurs.add(objetimage);
                str.InsertionObjet(racine, objetimage);
                compt=compt+5;        
        }
        compt=0;
    } 
              for(NoeudesIntern noeud: str.getStructureM_tree()){
          for(int j=0;j<noeud.getlistObjets().size();j++){
              WriteinfileMtree(noeud.getlistObjets().get(j), noeud.getgetNoeudId());
          }
    }
                       }else{
            
              image=ImageIO.read( new File(lienimage));
                couleur=new DescriteurColeur(image);
                form=new DescripteurForm(image);
                form.CalculZernikeMoments(20,14);
                objetimage=new DescripteursVisuels(couleur.getVecteureCouleur(), form.getVecteurMoments(),lienimage);               
                listdescripteurs.add(objetimage);    
                WriteinfileSequencile(objetimage);
                WriteinfileMtree(objetimage,0);
              }              
                  } catch (IOException ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            }
    
}
public void setInserer(String l){   
    lienimage=l;
}
     public void WriteinfileMtree(DescripteursVisuels desc,int id) throws IOException{
        String couleur="",forme="",nom=desc.getId_image();
        for(int i=0;i<desc.getCouleure().length;i++){
            couleur+=desc.getCouleure()[i]+",";
        }
         for(int i=0;i<desc.getForme().length;i++){
            forme+=desc.getForme()[i]+",";
        }
        FileWriter file=new FileWriter(new File("C:\\Users\\Lenovo\\Desktop/Baseindex1.csv"), true);
        BufferedWriter bw=new BufferedWriter(file);
        PrintWriter pw=new PrintWriter(bw);
       if(!ajouter){ pw.println(id+","+nom+","+couleur+"/"+forme);}
       else{pw.println(378+","+nom+","+couleur+"/"+forme);}
        pw.flush();
        pw.close();
    }
     public void WriteinfileSequencile(DescripteursVisuels desc) throws IOException{
        String couleur="",forme="",nom=desc.getId_image();
        for(int i=0;i<desc.getCouleure().length;i++){
            couleur+=desc.getCouleure()[i]+",";
        }
         for(int i=0;i<desc.getForme().length;i++){
            forme+=desc.getForme()[i]+",";
        }
        FileWriter file=new FileWriter(new File("C:\\Users\\Lenovo\\Desktop/BaseindexSequenciel1.csv"), true);
        BufferedWriter bw=new BufferedWriter(file);
        PrintWriter pw=new PrintWriter(bw);
        pw.println(nom+","+couleur+"/"+forme);
        pw.flush();
        pw.close();
    }
     public void Insertion(String insert){
        FileWriter file=null;
        try {
            file = new FileWriter(new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt"), true);
            BufferedWriter bw=new BufferedWriter(file);
            PrintWriter pw=new PrintWriter(bw);
          /*  int compt=0;
             for(int i=0;i<80;i++){
                for(int j=0;j<12;j++){
                pw.println("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100/obj"+(i+1)+"__"+compt+".png");
                compt=compt+5;}
                compt=0;
            }*/
            pw.println(insert);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
     public void Suppression(String img){
        try {
            File f=new File("C:\\Users\\Lenovo\\Desktop/base.txt");
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);     
            // pw.write("");
            FileReader fr=new FileReader(new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt"));
            BufferedReader br=new BufferedReader(fr);
            Scanner sc=new Scanner(br);
            String ligne;
            while(sc.hasNext()){
                ligne=sc.nextLine();
               
                if(!img.equals(ligne)){
                   pw.println(ligne);
                   
                }
            }           
            sc.close();
            pw.close();
            reconstruit();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void reconstruit(){
         FileWriter fw=null;File f=null;
        try {
            f=new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt");
            fw = new FileWriter(f);
            BufferedWriter bw =new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);  
            //pw.write("");
            FileReader fr=new FileReader(new File("C:\\Users\\Lenovo\\Desktop/base.txt"));
            BufferedReader br=new BufferedReader(fr);
            Scanner sc=new Scanner(br);
            String ligne;
            while(sc.hasNext()){
                ligne=sc.nextLine();
                    pw.println(ligne);
            }
            pw.close();
            pw.flush();
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       // f.delete();
     }
     
     public boolean retrouver(String insert){boolean rep =false;
         FileReader fr=null;
        try {
            fr = new FileReader(new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt"));
            BufferedReader br=new BufferedReader(fr);
            Scanner sc=new Scanner(br);
            while(sc.hasNext()){
                String ligne=sc.nextLine();
                  if(insert.equals(ligne)) rep= true; 
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rep;
     }
     
     
     public void ListeLiens(){
         ArrayList<String> list=new ArrayList<>();
         FileWriter fr=null;
        try {
            fr = new FileWriter(new File("C:\\Users\\Lenovo\\Desktop/basevertuel.txt"));
            BufferedWriter br=new BufferedWriter(fr);
            PrintWriter pw=new PrintWriter(br);
            int compt=0;
            for(int i=0;i<80;i++){
                for(int j=0;j<12;j++){
                    pw.println("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100\\obj"+(i+1)+"__"+compt+".png");
                    compt=compt+5;
                }
                compt=0;
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculDescriteure.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
     }
     
public static void main(String[] args){
    CalculDescriteure c=new CalculDescriteure(false);
   //c.CalculeDescripteurs();
     //System.err.println( c.retrouver("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100\\obj1__0.png"));;
     //c.Suppression("C:\\Users\\Lenovo\\Desktop\\Base images\\coil-100\\obj1__0.png");
     c.ListeLiens();
     //c.reconstruit();
}
}

