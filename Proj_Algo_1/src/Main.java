import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //renseigner le chemin du texte a compresser
        Occurence f1 = new Occurence("C:\\Users\\theo1\\Desktop\\cours\\Java\\Proj_Algo_1\\text\\textesimple.txt");

        //ajoute chaques lignes du texte dans un liste
        f1.getText();

        //permet de n'avoir plus qu'ne chaine de caractere dans la liste
        f1.concatene();

        //rentre dans un dictionnaire chaques caracteres avec son occurence
        Map<Character,Integer> d1 = f1.occurence();

        //crée une liste de feuille avec chaques elements du dictionnaire
        List<Noeud> l1 = Huffman.creationFeuille(d1);
            //trier liste en fonction des fréquences

        //crée l'arbre suivant l'algorithme de HUffman
        while (l1.size()!=1){
            l1.add(Huffman.creationArbre(l1));
            //trier liste en fonction des fréquences
        }

        //crée un arbre avec le noeud final
        Arbre a1 = new Arbre(l1.get(0));

        //crée un dictionnaire avec les caracteres et le code binaire associé
        Map<Character,String> d2 = a1.getRacine().parcoursProfondeur();
        

    }

}
