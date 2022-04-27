import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Noeud {
    private Integer frequence;
    private Character element;
    private Noeud gauche;
    private Noeud droit;
    private String code;

    public Noeud(Integer frequence,Character element, Noeud gauche, Noeud droit) {
        this.frequence = frequence;
        this.element = element;
    }

    public Map<Character,String> parcoursProfondeur() {
        Map<Character,String> dico = new HashMap<Character,String>();
        if (gauche != null) {
            code+="0";
            gauche.parcoursProfondeur();
            dico.put(gauche.getElement(),code);
            code = "";
        }
        if (droit != null) {
            code+="1";
            droit.parcoursProfondeur();
            dico.put(droit.getElement(),code);
            code = "";
        }
        return dico;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public Character getElement() {
        return element;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public Noeud getDroit() {
        return droit;
    }
}
