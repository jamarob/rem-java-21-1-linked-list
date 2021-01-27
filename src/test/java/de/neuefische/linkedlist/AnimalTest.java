package de.neuefische.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void testToString(){
        // Given
        Animal animal = new Animal("Capibara");

        // When
        String actual = animal.toString();

        // Then
        assertEquals("Capibara", actual);
    }

}