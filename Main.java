import Animal.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Array;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.*;
public class Main {
    static void main(String[] args){
        HashMap<String, Integer> TrackNum = new HashMap<>();
        ArrayList<String> TrackSpecies = new ArrayList<>();

        //Using array to track animal each species
        ArrayList<String> Lion = new ArrayList<>();
        ArrayList<String> Hyena = new ArrayList<>();
        ArrayList<String> Bear= new ArrayList<>();
        ArrayList<String> Tiger = new ArrayList<>();

        String name_line;
        String Hyena_name = "";
        String Lion_name = "";
        String Bear_name = "";
        String Tiger_name = "";

        //Elements in previous array will become key for this hashmap,
        //it will return information for each individual

        HashMap<String, String> Information = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/phil/IdeaProjects/Zoo/src/arrivingAnimals.txt"));
            String line;

            BufferedReader readname = new BufferedReader(new FileReader("/home/phil/IdeaProjects/Zoo/src/animalNames.txt"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(("/home/phil/IdeaProjects/Zoo/src/newAnimals.txt")));
            //Get the name string from the AnimalNames

            while((name_line = readname.readLine()) != null){
                if(name_line.isEmpty()){
                    continue;
                }
                if(name_line.contains("Lion")){
                    Lion_name = readname.readLine();
                    Lion_name = readname.readLine();
                    continue;
                }
                if(name_line.contains("Hyena")){
                    Hyena_name = readname.readLine();
                    Hyena_name = readname.readLine();
                    continue;
                }
                if(name_line.contains("Bear")){
                    Bear_name = readname.readLine();
                    Bear_name = readname.readLine();
                    continue;
                }
                if(name_line.contains("Tiger")){
                    Tiger_name = readname.readLine();
                    Tiger_name = readname.readLine();
                    continue;
                }
            }
            String info;

            String[] name;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                if(line.contains("lion")){
                    String nextID = getNextID(Lion, "Li");
                    Lion.add(nextID);
                    name = Lion_name.split(",");
                    Animal a;
                    a = Animal.parseAnimal(line, name[ThreadLocalRandom.current().nextInt(1, name.length)]);
                    Lion lion = new Lion(a, "Random");

                    info = nextID + lion.Information();

                    if(Information.get("Lion habitat:") == null){
                        Information.put("Lion habitat:", info);
                    }
                    else{
                        Information.put("Lion habitat:", Information.get("Lion habitat:") + info);
                    }
                    continue;
                }

                if(line.contains("hyena")){
                    String nextID = getNextID(Hyena, "Hy");
                    Hyena.add(nextID);
                    name = Hyena_name.split(",");
                    Animal a;
                    a = Animal.parseAnimal(line, name[ThreadLocalRandom.current().nextInt(1, name.length)]);
                    Hyena hyena = new Hyena(a, "Random");
                    info = nextID + hyena.Information();
                    if(Information.get("Hyena habitat:") == null){
                        Information.put("Hyena habitat:", info);
                    }
                    else{
                        Information.put("Hyena habitat:", Information.get("Hyena habitat:") + info);
                    }
                    continue;
                }

                if(line.contains("bear")){
                    String nextID = getNextID(Bear, "Be");
                    Bear.add(nextID);
                    name = Bear_name.split(",");
                    Animal a = Animal.parseAnimal(line, name[ThreadLocalRandom.current().nextInt(1, name.length)]);
                    Bear bear = new Bear(a, "Random");
                    info = nextID + bear.Information();
                    if(Information.get("Bear habitat:") == null){
                        Information.put("Bear habitat:", info);
                    }
                    else{
                        Information.put("Bear habitat:", Information.get("Bear habitat:") + info);
                    }
                    continue;
                }

                if(line.contains("tiger")){
                    String nextID = getNextID(Tiger, "Ti");
                    Tiger.add(nextID);
                    name = Tiger_name.split(",");

                    Animal a = Animal.parseAnimal(line, name[ThreadLocalRandom.current().nextInt(1, name.length)]);
                    Tiger tiger = new Tiger(a, "Random");
                    info = nextID + tiger.Information();
                    if(Information.get("Tiger habitat:") == null){
                        Information.put("Tiger habitat:", info);
                    }
                    else{
                        Information.put("Tiger habitat:", Information.get("Tiger habitat:") + info);
                    }
                    continue;
                }
            }
            writer.write("Lion habitat:" + "\n");
            writer.write(Information.get("Lion habitat:") + "\n");
            writer.write("Hyena habitat:" + "\n");
            writer.write(Information.get("Hyena habitat:") + "\n");
            writer.write("Bear habitat:" + "\n");
            writer.write(Information.get("Bear habitat:") + "\n");
            writer.write("Tiger habitat:" + "\n");
            writer.write(Information.get("Tiger habitat:") + "\n");
            reader.readLine();
            reader.close();
            readname.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Information);


    }

    //This function is used to update new ID for array
    static String getNextID(List<String> ids, String prefix){
        int max = 0;
        Pattern p = Pattern.compile("^" +prefix+ "(\\d+)$");

        for (String id : ids){
            Matcher m = p.matcher(id);
            if(m.find()){
                int num = Integer.parseInt(m.group(1));
                if (num > max) {
                    max = num;
                }
            }
        }
        return String.format("%s%02d", prefix, max + 1);
    }
}
