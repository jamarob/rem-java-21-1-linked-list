package de.neuefische.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalListItemTest {

    @Test
    public void testInitialListItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));

        // When
        Animal actual = head.getValue();

        // Then
        assertEquals(new Animal("Dog"), actual);
    }

    @Test
    public void testAdd(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Capibara"));

        // When
        Animal secondAnimal = head.getNext().getValue();
        Animal thirdAnimal = head.getNext().getNext().getValue();

        // Then
        assertEquals(new Animal("Cat"), secondAnimal);
        assertEquals(new Animal("Capibara"), thirdAnimal);
    }

    @Test
    public void testToString(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Capibara"));

        // When
        String actual = head.toString();

        // Then
        assertEquals("Dog -> Cat -> Capibara", actual);
    }
}