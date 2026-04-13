package Animal;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
public class Tiger extends Animal{
    protected int stealth_level;
    protected int stripeCount;
    protected double territory_range;
    protected double ambush_success_rate;
    List<String> tigerSounds = List.of("Grrrowl", "Rrraow", "Snarl", "Raaawr", "Chuff");
    String Date = LocalDate.now().toString();

    public Tiger(String name, int age, int weight, String species, String gender, String birth_season, String color,
                 String park, String country){
        super(name, age, weight, species, gender, birth_season, color,
                park, country);
        this.stealth_level = 0;
        this.stripeCount = 0;
        this.territory_range = 0;
        this.ambush_success_rate = 0;
        getLaugh();
    }


    public Tiger(Animal a){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);
        this.stealth_level = 0;
        this.stripeCount = 0;
        this.territory_range = 0;
        this.ambush_success_rate = 0;
        getLaugh();
    }
    public Tiger(Animal a, String Random){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);

        if(Random == "Random"){
            setAmbush_success_rate();
            setStealth_level();
            setStripeCount();
            setTerritory_range();
        }
        else {
            this.stealth_level = 0;
            this.stripeCount = 0;
            this.territory_range = 0;
            this.ambush_success_rate = 0;
        }
        getLaugh();
    }
    public String getLaugh(){
        this.laugh =  tigerSounds.get(
                ThreadLocalRandom.current().nextInt(tigerSounds.size())
        );
        return laugh;
    }


    public void setStealth_level(int index){this.stealth_level = index;}
    public void setStealth_level(){
        int index = ThreadLocalRandom.current().nextInt(1, 11);
        this.stealth_level = index;
    }

    public void setStripeCount(int count){this.stripeCount = count;}
    public void setStripeCount(){
        int index = ThreadLocalRandom.current().nextInt(70, 111);
        this.stripeCount = index;
    }

    public void setTerritory_range(double area){this.territory_range = area;}
    public void setTerritory_range(){
        double area = ThreadLocalRandom.current().nextDouble(1, 101);
        this.territory_range = area;
    }

    public void setAmbush_success_rate(double rate){this.ambush_success_rate = rate;}
    public void setAmbush_success_rate(){
        double rate = ThreadLocalRandom.current().nextDouble(1, 101.0);
        this.ambush_success_rate = rate;
    }

    public String getStealth_level(){
        return this.stealth_level + "point";
    }
    public String getStripeCount(){
        return this.stripeCount + "stripe";
    }
    public String getTerritory_range(){
        return this.territory_range + "square feet";
    }
    public String getAmbush_success_rate(){
        return this.ambush_success_rate + "%";
    }

    @Override
    public String Information(){
        if(birth_season == "unknown"){
            return "; " + name + "; " + age + " years old; unknown birth season" + "; " + "BirthDate: " + birthDate + "; " + color + "; "
                    + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                    + "\n" + "Stealth level: " + stealth_level + "; Stripe count: " + stripeCount + "; Territory range: " + territory_range
                    + "; Ambush success rate: " + ambush_success_rate + "; Arrived " + Date + ".\n";
        }
        return "; " + name + "; " + age + " years old; born in " + birth_season + "; " + "BirthDate: " + birthDate + "; " + color + "; "
                + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                + "\n" + "Stealth level: " + stealth_level + "; Stripe count: " + stripeCount + "; Territory range: " + territory_range
                + "; Ambush success rate: " + ambush_success_rate + "; Arrived " + Date + ".\n";
    }
}
