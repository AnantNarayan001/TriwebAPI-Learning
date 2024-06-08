//java concepts
//exception handling, inheritance,encapsulation

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void specificDogBehavior() {
        System.out.println("Dog wags its tail");
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Dog myDog = new Dog();

        myAnimal.sound();  // Output
        myDog.sound();     // Output

        // Demonstrate try, catch, throw, and finally
        try {
            testException();
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        } finally {
            System.out.println("This is the finally block, it always executes.");
        }
    }

    static void testException() throws CustomException {
        boolean someCondition = true; 
        if (someCondition) {
            throw new CustomException("Something went wrong!");
        }
    }
}
