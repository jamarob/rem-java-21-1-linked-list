package de.neuefische.linkedlist;

public class AnimalListItem {

    private Animal value;
    private AnimalListItem next;

    public AnimalListItem(Animal value) {
        this.value = value;
    }

    public Animal getValue() {
        return value;
    }

    public void add(Animal animal) {
        if(value == null){
            value = animal;
        }
        if(next == null){
            next = new AnimalListItem(animal);
        }else {
            next.add(animal);
        }
    }

    public AnimalListItem getNext() {
        return next;
    }

    @Override
    public String toString() {
        if(next == null){
            return value.toString();
        }else {
            return value.toString() + " -> " + next.toString();
        }
    }
}
