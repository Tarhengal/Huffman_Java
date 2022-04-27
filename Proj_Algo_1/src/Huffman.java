import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Huffman {

    public static List<Noeud> creationFeuille(Map<Character,Integer> map){
        List<Noeud> noeuds = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            Character cle =entry.getKey();
            Integer frequence = entry.getValue();
            Noeud n1 = new Noeud(frequence,cle,null,null);
            noeuds.add(n1);
        }
        return noeuds;
    }

    public static Noeud creationArbre(List<Noeud> liste){
        Noeud n;
        if(liste.size()==2) {
            n = new Noeud(liste.get(0).getFrequence() + liste.get(1).getFrequence(), null, liste.get(0), liste.get(1));
            liste.remove(liste.get(0));
            liste.remove(liste.get(0));
        }
        else {
            n = new Noeud(liste.get(liste.size() - 1).getFrequence() + liste.get(liste.size() - 2).getFrequence(), null, liste.get(liste.size() - 2), liste.get(liste.size() - 1));
            liste.remove(liste.get(liste.size() - 1));
            liste.remove(liste.get(liste.size() - 2));
        }
        return n;
    }

}
