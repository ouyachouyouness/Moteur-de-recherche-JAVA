/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Distance {
    public Distance(){
    }
    public double CalculeDistance(DescripteursVisuels vect1, DescripteursVisuels vect2){
                
        double somme1=0,somme2=0;
    double[] Couleure1=vect1.getCouleure(),Couleure2=vect2.getCouleure();
    double[] Forme1=vect1.getForme(),Forme2=vect2.getForme();
        for(int i=0;i<Couleure1.length;i++){
            somme1+=pow(Couleure1[i]-Couleure2[i], 2);
        }
        for(int j=0;j<Forme2.length;j++){
            somme2+=pow(Forme1[j]-Forme2[j], 2);
        }
        return (sqrt(somme1*0.0001)/8+sqrt(somme2*1000));
    }
}

