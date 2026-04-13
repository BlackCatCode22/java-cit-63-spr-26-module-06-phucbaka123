package Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Hyena extends Animal {
    protected int scavenging_efficiency;
    protected int clanSize;
    protected double biteForce;
    protected int cooperation_level;
    List<String> hyenaLaughs = List.of("Hehehee", "Cackle", "Giggle-growl", "Yip-yip", "Hah-hah-hah");
    String Date = LocalDate.now().toString();
    public Hyena(String name, int age, int weight, String species, String gender, String birth_season, String color,
                 String park, String country){
        super(name, age, weight, species, gender, birth_season, color,
                park, country);
        this.scavenging_efficiency = 0;
        this.clanSize = 0;
        this.biteForce = 0;
        this.cooperation_level = 0;
        getLaugh();
    }
    public Hyena(Animal a) {
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);
        this.scavenging_efficiency = 0;
        this.clanSize = 0;
        this.biteForce = 0;
        this.cooperation_level = 0;
        getLaugh();
    }
    public Hyena(Animal a, String Random){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);

        if(Random == "Random"){
            setBiteForce();
            setClanSize();
            setCooperation_level();
            setScavenging_efficiency();
        }
        else {
            this.scavenging_efficiency = 0;
            this.clanSize = 0;
            this.biteForce = 0;
            this.cooperation_level = 0;
        }
        getLaugh();
    }

    public String getLaugh(){
        this.laugh =  hyenaLaughs.get(
                ThreadLocalRandom.current().nextInt(hyenaLaughs.size())
        );
        return laugh;
    }



    public String getBiteForce() {
        return biteForce + "lbs";
    }
    public String getClanSize() {
        return clanSize + "individuals";
    }
    public String getScavenging_efficiency() {
        return scavenging_efficiency + "points";
    }
    public String getCooperation_level(){
        return cooperation_level + "points";
    }




    public void setBiteForce(double index){
        this.biteForce = index;
    }
    public void setBiteForce(){
        double index = ThreadLocalRandom.current().nextDouble(1000,1501);
        this.biteForce = index;
    }

    public void setClanSize(int index){
        this.clanSize = index;
    }
    public void setClanSize(){
        int index = ThreadLocalRandom.current().nextInt(10,31);
        this.clanSize = index;
    }

    public void setScavenging_efficiency(int index){
        this.scavenging_efficiency = index;
    }
    public void setScavenging_efficiency(){
        int index = ThreadLocalRandom.current().nextInt(0,101);
        this.scavenging_efficiency = index;
    }

    public void setCooperation_level(int index){
        this.cooperation_level = index;
    }
    public void setCooperation_level(){
        int index = ThreadLocalRandom.current().nextInt(0,101);
        this.cooperation_level = index;
    }


    @Override
    public String Information(){
        if(birth_season == "unknown"){
            return "; " + name + "; " + age + " years old; unknown birth season" + "; "+ "BirthDate: " + birthDate + "; " + color + "; "
                    + gender + "; laugh: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                    + "\n" + "Scavenging efficiency: " + scavenging_efficiency + "; Clan size: " + clanSize + "; Bite force: " + biteForce
                    + "; Cooperation level: " + cooperation_level + "; Arrived " + Date + ".\n" ;
        }
        return "; " + name + "; " + age + " years old; born in " + birth_season + "; "+ "BirthDate: " + birthDate + "; "  + color + "; "
                + gender + "; laugh: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                + "\n" + "Scavenging efficiency: " + scavenging_efficiency + "; Clan size: " + clanSize + "; Bite force: " + biteForce
                + "; Cooperation level: " + cooperation_level + "; Arrived " + Date + ".\n" ;
    }
}
