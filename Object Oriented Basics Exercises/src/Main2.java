public class Main2 {
    public static void main(String[] args){
        Tamagotchi pet = new Tamagotchi("Wilbur");

    }
}

class Tamagotchi{
    private int hunger, happiness, discipline, age;
    private String name;

    // constructor
    public Tamagotchi(String name){
        this.name = name;
        age = 0;
        hunger = 50;
        happiness = 50;
        discipline = 50;
    }

    // methods
    public void age(){
        age += 1;
        happiness = Math.max(0, happiness-1);
        discipline = Math.max(0, discipline-1);
        hunger = Math.min(100, hunger+1);
    }
    public void feed(){
        hunger = Math.max(0, hunger - 10);
    }
    public void play(){
        happiness = Math.max(100, happiness + 10);
    }
    public void scold(){
        discipline = Math.min(100, discipline + 10);
    }
    @Override
    public String toString(){
        String[] hunDes = {"So stuffed!", "Feeling good", "", "Peckish", "Starving", "FEED ME ... please."};
        String[] hapDes = {"There is only one way out.", "The world is so cold.", "meh", "", "I'm a pretty Pokemon", "Every second is the better than the last."};
        String[] disDes = {"I should scold YOU!", "Matches are fun to play with!", "You are not the boss of me", "", "Good day to you.", "Can I help you with something?", "Rules are fun!"};

        int hu = hunger/20;               // I want 100 to be special
        int ha = (happiness + 19)/20;     // I want 0 to be special
        int di = (discipline + 19)/20;    // I want 0 to be special

        int days = age / (60 * 24);
        int hours = age / 60 % 24;
        int minutes = age % 60;
        String out = "%s - Age: %d days %d hours %d minutes - %s %s %s";

        return String.format(out, name, days, hours, minutes, hunDes[hu], hapDes[ha], disDes[di]);
    }
}