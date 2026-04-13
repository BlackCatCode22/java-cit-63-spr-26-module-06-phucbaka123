package Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {
    protected String name;
    protected int age;
    protected String species;
    protected String gender;
    protected String park;
    protected String country;
    protected String color;
    protected String birth_season;
    protected String laugh;
    protected int weight;
    protected String birthDate;

    //Since I don't know what is going to appear in the arrivingAnimal.txt and animalNames.txt, so I gonna create my own
    //myown file for it
    //And this constructor will ask for name, age and species
    public Animal(String name, int age, int weight, String species, String gender, String birth_season, String color,
                  String park, String country){
        this.name = name;
        this.age = age;
        this.species = species;
        this.gender = gender;
        this.park = park;
        this.country = country;
        this.color = color;
        this.birth_season = birth_season;
        this.weight = weight;
        getBirthDay();
    }


    public String getBirthDay(){
        int currentyear = LocalDate.now().getYear();
        int year = currentyear - age;

        int date = ThreadLocalRandom.current().nextInt(1, 32);
        int month;

        if ("spring".equals(this.birth_season)){
            month = ThreadLocalRandom.current().nextInt(1, 4);
            if (month == 2){
                date = ThreadLocalRandom.current().nextInt(1, 29);
            }
        } else if ("summer".equals(this.birth_season)) {
            month = ThreadLocalRandom.current().nextInt(4, 7);
        } else if ("fall".equals(this.birth_season)){
            month = ThreadLocalRandom.current().nextInt(7, 10);
        } else if ("winter".equals(this.birth_season)){
            month = ThreadLocalRandom.current().nextInt(10, 12);
        } else {
            month = LocalDate.now().getMonthValue();
        }

        this.birthDate = year + "-" + month + "-" + date ;
        return birthDate;
    }
    public String getName(){
        return name;
    }
    public double getAge(){
        return age;
    }
    public String getSpecies(){
        return species;
    }
    public String getGender(){return gender;}
    public String getPark(){return park;}
    public String getCountry(){return country;}
    public String getColor(){return color;}
    public String getBirth_season(){return birth_season;}
    public String getLaugh(){return laugh;}
    public int getWeight(){return weight;}
    public String Information(){
        if(birth_season == "unknown"){
            return "; " + name + "; " + age + " years old; unknown birth season" + "; " + "BirthDate: " + birthDate + "; " + color + "; "
                    + gender + "; " + weight + " pounds; from " + park + "; " + country + ".\n";
        }
        return "; " + name + "; " + age + " years old; born in " + birth_season + "; " + "BirthDate: " + birthDate + "; " + color + "; "
                + gender + "; " + weight + " pounds; from " + park + "; " + country + ".\n";
    }


    public void setName(String newname){
        name = newname;
    }
    public void setAge(int newage){
        age = newage;
    }
    public void setSpecies(String newspecies){
        species = newspecies;
    }
    public static Animal parseAnimal(String line, String name){
        String[] parts = line.split(", ");

        int age = 0;
        String species = "";
        String gender = "";
        String park = "";
        String country = "";
        String color = "";
        String birth_season = "";

        int weight = 0;

        Pattern age_gender = Pattern.compile("(\\d+)\\s+year old\\s+(male|female)\\s+(\\w+)");
        Matcher part1 = age_gender.matcher(parts[0].trim());
        if (part1.find()){
            age = Integer.parseInt(part1.group(1));
            gender = part1.group(2);
            species = part1.group(3);
        }

        Pattern season = Pattern.compile("born in\\s+(\\w+)");
        Matcher part2 = season.matcher(parts[1].trim());
        if (part2.find()){
            birth_season = part2.group(1);
        }
        else{
            birth_season = "unknown";
        }

        Pattern Color = Pattern.compile("(.+?)\\s+color");
        Matcher part3 = Color.matcher(parts[2].trim());
        if(part3.find()){
            color = part3.group(0);
        }

        Pattern Weight = Pattern.compile("(\\d+)\\s+pounds");
        Matcher part4 = Weight.matcher(parts[3].trim());
        if(part4.find()){
            weight = Integer.parseInt(part4.group(1));
        }

        Pattern Park = Pattern.compile("from+\\s+(\\w+)+(\\w+)");
        Matcher part5 = Park.matcher(parts[4].trim());
        if(part5.find()){
            park = part5.group(1) + part5.group(2);
        }

        country = parts[5];

        Animal a = new Animal(name, age, weight, species, gender, birth_season, color,
                park, country);

        return a;

    }
}
