public abstract class Mammal extends Animal implements Walkable {
    protected Mammal(double weight) {
        super(weight);
    }


    @Override
    public void breathe() {
        System.out.println("Mammal breath");
    }


    public void growHair() {
        System.out.println(getClass().getSimpleName() + " hair");
    }


    @Override
    public void walk() {
        System.out.println("Mammal is walking...");
    }
}