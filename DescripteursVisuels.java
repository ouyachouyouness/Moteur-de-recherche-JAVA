
package moteurrecherche;



import java.io.Serializable;
import static java.lang.System.out;

public class DescripteursVisuels implements Serializable{
    private double[] Couleure;
    private double[] Forme;
    private String id_image;
    private int id_parent;
    public DescripteursVisuels(double []Couleur,double[] Forme,String id_image){
        this.Couleure=Couleur;
        this.Forme=Forme;
        this.id_image=id_image;
    }
    public double[] getCouleure(){
        return Couleure;
    }
    public double[] getForme(){
        return Forme;
    }
    public String getId_image(){
        return id_image;
    }
    public void setId_Parent(int id){
        this.id_parent=id;
    }
    public double affichecouleur(){
        for(int i=0;i<Couleure.length;i++)
            out.println( Couleure[i]);
        return 0;
    }
    public String toString(){
        return "id_desc :"+this.id_image+"\n couleure"+affichecouleur();
    }
}

