package AnimalShelter;

import java.util.LinkedList;

public class AnimalShelterQueue {

    private final int size;
	private int arrivalCounter;

    private final LinkedList<Animal> dogs;
    private final LinkedList<Animal> cats;

    private enum Type { DOG, CAT }

	private record Animal(Type type, int queuePosition) {
		@Override
		public String toString() {
			return type + "(" + queuePosition + ")";
		}
	}

    public AnimalShelterQueue (int size) {
        this.size = size;
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
        this.arrivalCounter = 0;
        System.out.println("The queue has been created with the size of: " + size);
    }

    public boolean isEmpty(){
        return dogs.isEmpty() && cats.isEmpty();
    }

    public boolean isFull() {
        return (dogs.size() + cats.size()) >= size;
    }

    public void enqueueDog() {
        if (isFull()) {
            System.out.println("Shelter is full, cannot enqueue dog");
            return;
        }
        dogs.addLast(new Animal(Type.DOG, arrivalCounter++));
    }

    public void enqueueCat() {
        if (isFull()) {
            System.out.println("Shelter is full, cannot enqueue cat");
            return;
        }
        cats.addLast(new Animal(Type.CAT, arrivalCounter++));
    }

    Animal dequeueAny() {
        if (isEmpty()) {
            System.out.println("The shelter is empty");
            return null;
        }
        if (dogs.isEmpty()) return cats.removeFirst();
        if (cats.isEmpty()) return dogs.removeFirst();

        Animal oldestDog = dogs.peekFirst();
        Animal oldestCat = cats.peekFirst();
        if (oldestDog.queuePosition <= oldestCat.queuePosition) {
            return dogs.removeFirst();
        } else {
            return cats.removeFirst();
        }
    }

    Animal dequeueDog() {
        if (dogs.isEmpty()) {
            System.out.println("No dogs available for adoption");
            return null;
        }
        return dogs.removeFirst();
    }

    Animal dequeueCat() {
        if (cats.isEmpty()) {
            System.out.println("No cats available for adoption");
            return null;
        }
        return cats.removeFirst();
    }

    Animal peek() {
        if (isEmpty()) return null;
        if (dogs.isEmpty()) return cats.peekFirst();
        if (cats.isEmpty()) return dogs.peekFirst();
        Animal dog = dogs.peekFirst();
        Animal cat = cats.peekFirst();
        return (dog.queuePosition <= cat.queuePosition) ? dog : cat;
    }

	@Override
	public String toString() {
		return "AnimalShelterQueue {" +
				"size = " + size +
				", dogs = " + dogs +
				", cats = " + cats +
				" }";
	}
}
