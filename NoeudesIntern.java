/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moteurrecherche;

import java.io.Serializable;
import java.util.ArrayList;
class NoeudesIntern implements Serializable {
                private static int id_Noeudtot=1;
                private int id_noeud;
                private  ArrayList<DescripteursVisuels> listObjets;
                private double rayon;
                private double DistanceP;
                private NoeudesIntern pointureSubTree;
                public NoeudesIntern(){
                    id_noeud=id_Noeudtot;                   
                    listObjets=new ArrayList<>();
                 
                    this.rayon=0;
                    this.DistanceP=0;
                    pointureSubTree=null;
                    id_Noeudtot++;
                }  
    public ArrayList<DescripteursVisuels> getlistObjets(){
          return listObjets;
              }
    public void setPointure(NoeudesIntern p){
    this.pointureSubTree=p;
    }
    public void setRayon(double rayon){
    this.rayon=rayon;
    }
    public void setDistance(double d){
    this.DistanceP=d;
    }
    public boolean isLeaf(){
        if(pointureSubTree!=null)return false;
        else return true;
    }
    public double getRayon(){
        return rayon;
    }
    public int getgetNoeudId(){
        return id_noeud;
    }
    public void setNoeudid(int id){
        this.id_noeud=id;
    }
    public NoeudesIntern getPointure(){
        return pointureSubTree;
    }

}