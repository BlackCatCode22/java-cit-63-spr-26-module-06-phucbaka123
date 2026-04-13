package Animal;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
public class Lion extends Animal{
    protected String species = "Lion";
    protected int prideSize;
    enum role{
        male,
        female
    }
    protected role role;
    protected double mane_length;
    protected double hunt_success_rate;
    List<String> lionSounds = List.of("Roar", "Roooar", "Rawr", "Grrr-roar", "Raaah");
    String Date = LocalDate.now().toString();

    //Since I don't know what is going to appear in the arrivingAnimal.txt and animalNames.txt, so I gonna create my own
    //my own file for it
    public Lion(String name, int age, int weight, String species, String gender, String birth_season, String color,
                String park, String country){
        super(name, age, weight, species, gender, birth_season, color,
                park, country);

        if (gender == "male"){
            this.role = role.male;
        } else if (gender == "female") {
            this.role = role.female;
        }
        this.prideSize = 1;
        this.mane_length = 0.0;
        this.hunt_success_rate = 0;
        getLaugh();
    }
    public Lion(Animal a){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);
        if (gender == "male"){
            this.role = role.male;
        } else if (gender == "female") {
            this.role = role.female;
        }
        this.prideSize = 1;
        this.mane_length = 0.0;
        this.hunt_success_rate = 0;
        getLaugh();
    }
    public Lion(Animal a, String Random){
        super(a.name, a.age, a.weight, a.species, a.gender, a.birth_season, a.color,
                a.park, a.country);

        if(Random == "Random"){
            setRole();
            setHunt_success_rate();
            setMane_length();
            setPrideSize();
        }
        else {
            if (gender == "male") {
                this.role = role.male;
            } else if (gender == "female") {
                this.role = role.female;
            }
            this.prideSize = 1;
            this.mane_length = 0.0;
            this.hunt_success_rate = 0;
        }
        getLaugh();
    }

    public String getLaugh(){
        this.laugh =  lionSounds.get(
                ThreadLocalRandom.current().nextInt(lionSounds.size())
        );
        return laugh;
    }
    public void setPrideSize(int size){
        this.prideSize = size;
    }
    public void setPrideSize(){
        int size = ThreadLocalRandom.current().nextInt(1, 21);
        this.prideSize = size;
    }

    public void setRole(String gender){
        if(gender == "male"){
            this.role = role.male;
        } else if (gender == "female") {
            this.role = role.female;
        }
    }
    public void setRole(){
        int index = ThreadLocalRandom.current().nextInt(1, 21);
        if(index%2 == 0){
            this.role = role.male;
        } else {
            this.role = role.female;
        }
    }

    public void setMane_length(double length){
        this.mane_length = length;
    }
    public void setMane_length(){
        double size = ThreadLocalRandom.current().nextDouble(4.0, 10.0);
        this.mane_length = size;
    }

    public void setHunt_success_rate(double rate){
        if(rate >= 0 && rate<=100){
            this.hunt_success_rate = rate;
        }
        else{
            this.hunt_success_rate = 0;
        }
    }
    public void setHunt_success_rate(){
        double rate = ThreadLocalRandom.current().nextDouble(1.0, 100.0);
        this.hunt_success_rate = rate;
    }

    public String getPrideSize() {
        if (this.prideSize == 1) {
            return this.prideSize + "lion";
        } else {
            return this.prideSize + "lions";
        }
    }

    public String getRole(){
        return this.role.toString();
    }

    public String getMane_length(){
        return this.mane_length + "inches";
    }

    public String getHunt_success_rate(){
        return this.hunt_success_rate + "%";
    }

    @Override
    public String Information(){
        if(birth_season == "unknown"){
            return "; " + name + "; " + age + " years old; unknown birth season" + "; "+ "BirthDate: " + birthDate + "; "  + color + "; "
                    + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                    + "\n" + "Pride size: " + prideSize + "; mane length: " + mane_length + "; role: " + gender
                    + "; hunting success rate: " + hunt_success_rate + "; Arrived " + Date + ".\n";
        }
        return "; " + name + "; " + age + " years old; born in " + birth_season + "; "+ "BirthDate: " + birthDate + "; "  + color + "; "
                + gender + "; Roar: " + laugh + "; " + weight + " pounds; from " + park + "; " + country + "."
                + "\n" + "Pride size: " + prideSize + "; mane length: " + mane_length + "; role: " + gender
                + "; hunting success rate: " + hunt_success_rate + "; Arrived " + Date + ".\n";
    }
}
