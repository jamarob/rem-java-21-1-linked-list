package de.neuefische.linkedlist;

import java.util.Objects;

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
        if (value == null) {
            value = animal;
        }
        if (next == null) {
            next = new AnimalListItem(animal);
        } else {
            next.add(animal);
        }
    }

    public AnimalListItem getNext() {
        return next;
    }

    public void remove(Animal animal) {
        while (Objects.equals(value, animal)) {
            if (next != null) {
                value = next.value;
                next = next.next;
            } else {
                value = null;
                next = null;
            }
        }


        AnimalListItem current = this;

        while (current.next != null) {
            if (Objects.equals(current.next.value, animal)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        if (next == null) {
            return value.toString();
        } else {
            return value.toString() + " -> " + next.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalListItem that = (AnimalListItem) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
