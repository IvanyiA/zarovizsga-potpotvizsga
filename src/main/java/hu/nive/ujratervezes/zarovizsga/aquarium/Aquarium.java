package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();

        for (Fish act : fishes) {
            result.add(act.status());
        }
        return result;
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish() {
        Iterator<Fish> iterator = fishes.iterator();

        while (iterator.hasNext()) {

            if (iterator.next().getWeight() >= 11) {
                iterator.remove();
            }
        }
    }


}
