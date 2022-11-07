package br.com.lucascerqueira.factorymethod;


interface Pet {
}

class Dog implements Pet {
}

class Cat implements Pet {
}


interface Person {
    Pet getPet();

    default void play() {
        System.out.println("I'm playing with a " + getPet().getClass().getSimpleName());
    }
}


class DogLover implements Person {
    private final Dog dog = new Dog();

    public Pet getPet() {
        return dog;
    }
}

class CatLover implements Person {
    private final Cat cat = new Cat();

    public Pet getPet() {
        return cat;
    }
}


public class FactoryMethodSample {
    public static void call(Person person) {
        person.play();
    }

    public static void main(String[] args) {
        call(new DogLover());
        call(new CatLover());
    }
}
