//java code for the basis of java that are known to me.
//inheritance 
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

        myAnimal.sound(); 
        myDog.sound();   

        // Demonstration try, catch, throw, and finally
        try {
            testException();
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        } finally {
            System.out.println("This is the finally block, it always executes.");
        }
    }

    static void testException() throws CustomException {
        boolean someCondition = true; // You can change this to false to see different behaviors
        if (someCondition) {
            throw new CustomException("Something went wrong!");
        }
    }
}
