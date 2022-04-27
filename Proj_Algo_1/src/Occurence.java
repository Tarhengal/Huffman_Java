import java.util.*;
import  java.io.*;


public class Occurence {

    private String cheminFichier;
    private List<String> lignes = new ArrayList<>();
    private Character carac;
    private Map<Character,Integer> dico = new HashMap<Character,Integer>();
    private Map<Character, Integer> dictionnaire = new HashMap<Character, Integer>();


    public Occurence(String nomFichier) {
        this.cheminFichier = nomFichier;
    }

    public void getText(){
        File file = new File(this.cheminFichier);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                lignes.add(st);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String toString(){
        return this.lignes.toString();
    }

    public void concatene(){
        while(lignes.size()>1){
            lignes.set(0,lignes.get(0)+"\n"+lignes.get(1));
            lignes.remove(1);
        }
    }

    public Map occurence(){
        for(int i=0;i<lignes.get(0).length();i++) {
            carac=lignes.get(0).charAt(i);
            if (!dictionnaire.containsKey(carac)) dictionnaire.put(carac, 1);
            else dictionnaire.put(carac, dictionnaire.get(carac) + 1);
        }
        dico = trieDico(dictionnaire);
        return dico;
    }

    public static Map trieDico(Map<Character,Integer> map){
        Map<Character, Integer> dictionnaireTriee = new HashMap<Character,Integer>();
        while (map.size()>0) {
            Character key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            Integer value = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
            //System.out.println(key+"="+value);
            dictionnaireTriee.put(key, value);
            map.remove(key,value);
        }
        return dictionnaireTriee;
    }

}
