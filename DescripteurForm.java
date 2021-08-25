
package moteurrecherche;
import java.awt.image.BufferedImage;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.TreeSet;
// on souhait de calcule les moments du zernike (|Anm|) avec A c'est le resultat c-a-d:VecteurMoments
public class DescripteurForm {
    TreeSet<Double> List = new TreeSet<>();
    double[] VecteurMoments;//le vectreure qui nous souhaitons affiché
    private double ro;//composant dans le polynom triangulaire;
    private BufferedImage image;
    public DescripteurForm(BufferedImage image) {
        //initialisation de l'image
        this.image = image;
    }

    public double PolynomTriangulaire(int n, int m, double ro) {
        double Rnm = 0;// le resultat de la polynom triangulaire
        for (int s = 0; s < (n - abs(m)) / 2; s++) {
            //le formulaire de la polynom
            Rnm += ((pow(-1, s) * Factoriel(n - s) * pow(ro, n - 2 * s)) / (Factoriel(s) * Factoriel(((n - abs(m)) / 2) - s) * Factoriel(((n - abs(m)) / 2) - s)));
        }
        return abs(Rnm);
    }

    public double Factoriel(double x) {
        double fact = 1;
        if (x == 0) {
            return fact;
        } else {
            for (int i = 1; i <= x; i++) {
                fact *= i;
            }
        }
        return fact;
    }
    public double ZernikeMoment(int n, int m) { 
        double Result = 0;//resultat de la polynom de zernike
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j =0; j <(image.getHeight()-8); j++) {
                ro = sqrt(i * i + j * j);//ρ = x 2 + y 2               
                Result += PolynomTriangulaire(n, m, ro) *image.getRGB(i, j);
            }
        }
        return (abs(((n + 1 )* Result)/ (PI)) );
    }
    public void CalculZernikeMoments(int n, int m) throws Exception {
        VecteurMoments = new double[n * abs(m)];//initialisation du vecteur des moments
        if (n < 0 || n - abs(m) < 0) {
            throw Exception("n ou m ne satisfont pas les conditions");
        }
        int compt = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < abs(m); y++) {
                VecteurMoments[compt] =(ZernikeMoment(x, y));
                compt++;
            }
        }
        for (int i = 0; i < VecteurMoments.length; i++) {
            List.add(VecteurMoments[i]);
        }
        List.descendingSet();
        for (int j = 0; j < VecteurMoments.length; j++) {
            VecteurMoments[j] = (VecteurMoments[j] - List.first())/((List.last())-List.first());
        }
    }
public double[] getVecteurMoments(){
    return VecteurMoments;
}
    private Exception Exception(String n) {
        throw new UnsupportedOperationException("Errure !!!!!"); //To change body of generated methods, choose Tools | Templates.
    }
}

