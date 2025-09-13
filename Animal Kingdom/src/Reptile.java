public abstract class Reptile extends Animal implements Walkable, Swimmable {
    protected Reptile(double weight) {
        super(weight);
    }


    @Override
    public void breathe() {
        System.out.println("Reptile breath");
    }


    public void baskInSun() {
        System.out.println(getClass().getSimpleName() + " bask");
    }


    @Override
    public void walk() {
        System.out.println("Reptile is walking...");
    }


    @Override
    public void swim() {
        System.out.println("Reptile is swimming...");
    }
}