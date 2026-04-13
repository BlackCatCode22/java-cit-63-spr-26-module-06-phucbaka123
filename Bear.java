package Animal;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
public class Bear extends Animal{
    protected int hibernate_duration;
    protected double claw_length;
    protected int salmon_hunting_skill;
    List<String> bearSounds = List.of("Grrr", "Rumbble", "Huff", "Rooaarr", "Snort");
    String Date = LocalDate.now().toString();

    enum WinterActivityLevel {
        LOW,
        HIGH
    };
    protected WinterActivityLevel winteractivity;



    public Bear(String name, int age, int weight, String species, String gender, String birth_season, String color,
                String park, String country){
        super(name, age, weight, species, gender, birth_season, color,
                park, country);

        this.hibernate_duration = 0;
        this.claw_length = 0;
        this.salmon_hunting_skill = 0;
        this.winteractivity = WinterActivityLevel.LOW;
        getLaugh();

    }
    public Bear(Animal a){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);
        this.hibernate_duration = 0;
        this.claw_length = 0;
        this.salmon_hunting_skill = 0;
        this.winteractivity = WinterActivityLevel.LOW;
        getLaugh();
    }
    public Bear(Animal a, String Random){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);

        if(Random == "Random"){
            setClawlength();
            setHibernate_duration();
            setWinteractivity();
            setRanSalmon_hunting_skill();
        }
        else {
            this.hibernate_duration = 0;
            this.claw_length = 0;
            this.salmon_hunting_skill = 0;
            this.winteractivity = WinterActivityLevel.LOW;
        }
        getLaugh();
    }
    public String getLaugh(){
        this.laugh =  bearSounds.get(
                ThreadLocalRandom.current().nextInt(bearSounds.size())
        );
        return laugh;
    }

    public String getHibernate_duration() {
        return hibernate_duration + "days";
    }
    public String getClaw_length(){
        return claw_length + "inches";
    }
    public String getSalmon_hunting_skill(){
        return salmon_hunting_skill + "point";
    }
    public String getWinteractivity(){
        return "Winter activity: " + winteractivity.toString();
    }





    public void setHibernate_duration(int day){
        this.hibernate_duration = day;
    }
    public void setHibernate_duration(){
        int period = ThreadLocalRandom.current().nextInt(30,91);
        this.hibernate_duration = period;
    }

    public void setClaw_length(double length){
        this.claw_length = length;
    }
    public void setClawlength(){
        double length = ThreadLocalRandom.current().nextDouble(2.0, 6.0);
        this.claw_length = length;
    }

    public void setWinteractivity(WinterActivityLevel level){
        this.winteractivity = level;
    }
    public void setWinteractivity(){
        int point = ThreadLocalRandom.current().nextInt(0,101);
        if(point > 50){
            this.winteractivity = WinterActivityLevel.HIGH;
        }
        else{
            this.winteractivity = WinterActivityLevel.LOW;
        }
    }

    public void setSalmon_hunting_skill(int skill){
        this.salmon_hunting_skill = skill;
    }
    public void setRanSalmon_hunting_skill(){
        int point = ThreadLocalRandom.current().nextInt(0,101);
        this.salmon_hunting_skill = point;
    }

    public String Information(){
        if(birth_season == "unknown"){
            return "; " + name + "; " + age + " years old; unknown birth season" + "; " + "BirthDate: " + birthDate + "; " + color + "; "
                    + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                    + "\n" + "Hibernate duration: " + hibernate_duration + "; Claw length: " + claw_length + "; Salmon hunting skill: " + salmon_hunting_skill
                    + "; Winter activity: " + winteractivity + "; Arrived " + Date + ".\n";
        }
        return "; " + name + "; " + age + " years old; born in " + birth_season + "; "+ "BirthDate: " + birthDate + "; " + color + "; "
                + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                + "\n" + "Hibernate duration: " + hibernate_duration + "; Claw length: " + claw_length + "; Salmon hunting skill: " + salmon_hunting_skill
                + "; Winter activity: " + winteractivity + "; Arrived " + Date + ".\n";
    }
}
