package de.neuefische.linkedlist;

import org.junit.jupiter.api.DisplayName;
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


    @Test
    @DisplayName("Dog -> Cat -> Capibara  | remove Cat | Dog -> Capibara ")
    public void removeMiddleItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Capibara"));

        //WHEN
        head.remove(new Animal("Cat"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Dog"));
        expected.add(new Animal("Capibara"));
        assertEquals(expected, head);

    }

    @Test
    @DisplayName("Dog -> Cat -> Capibara  | remove Capibara | Dog -> Cat ")
    public void removeLastItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Capibara"));

        //WHEN
        head.remove(new Animal("Capibara"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Dog"));
        expected.add(new Animal("Cat"));
        assertEquals(expected, head);

    }


    @Test
    @DisplayName("Dog -> Cat -> Capibara  | remove Dog |  Cat -> Capibara ")
    public void removeFirstItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Capibara"));

        //WHEN
        head.remove(new Animal("Dog"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Cat"));
        expected.add(new Animal("Capibara"));
        assertEquals(expected, head);

    }


    @Test
    @DisplayName("Dog -> Cat -> Dog  | remove Dog |  Cat  ")
    public void removeFirstAndLastItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Dog"));

        //WHEN
        head.remove(new Animal("Dog"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Cat"));
        assertEquals(expected, head);

    }

    @Test
    @DisplayName("Dog -> Dog -> Cat  | remove Dog |  Cat  ")
    public void removeFirstTwo(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Dog"));
        head.add(new Animal("Cat"));

        //WHEN
        head.remove(new Animal("Dog"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Cat"));
        assertEquals(expected, head);

    }

    @Test
    @DisplayName("Dog -> Cat -> Dog  | remove Bird |  Dog -> Cat -> Dog   ")
    public void removeNoItem(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Dog"));

        //WHEN
        head.remove(new Animal("Bird"));

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Dog"));
        expected.add(new Animal("Cat"));
        expected.add(new Animal("Dog"));

        assertEquals(expected, head);

    }


    @Test
    @DisplayName("Dog   | remove Dog |  null  ")
    public void removeAllItems(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));


        //WHEN
        head.remove(new Animal("Dog"));

        //THEN
        AnimalListItem expected = new AnimalListItem(null);

        assertEquals(expected, head);

    }

    @Test
    @DisplayName("Dog  -> Cat -> Dog   | remove null |  Dog  -> Cat -> Dog  ")
    public void removeNoItemWhenNull(){
        // Given
        AnimalListItem head = new AnimalListItem(new Animal("Dog"));
        head.add(new Animal("Cat"));
        head.add(new Animal("Dog"));

        //WHEN
        head.remove(null);

        //THEN
        AnimalListItem expected = new AnimalListItem(new Animal("Dog"));
        expected.add(new Animal("Cat"));
        expected.add(new Animal("Dog"));
        assertEquals(expected, head);

    }

}
