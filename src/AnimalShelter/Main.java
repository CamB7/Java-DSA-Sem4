package AnimalShelter;

public class Main {
	public static void main(String[] args) {
		System.out.println();
		AnimalShelterQueue shelter = new AnimalShelterQueue(10);

		shelter.enqueueCat();
		shelter.enqueueDog();
		shelter.enqueueCat();
		shelter.enqueueDog();
		shelter.enqueueCat();
		shelter.enqueueDog();
		shelter.enqueueCat();

		System.out.println();
		System.out.println("Shows type and position in queue, eg: CAT(0)");
		System.out.println();
		System.out.println("Peek: " + shelter.peek());
		System.out.println("DequeueAny: " + shelter.dequeueAny());
		System.out.println("DequeueDog: " + (shelter.dequeueDog()));
		System.out.println("DequeueCat: " + (shelter.dequeueCat()));
		System.out.println();
		System.out.println(shelter);
	}
}
