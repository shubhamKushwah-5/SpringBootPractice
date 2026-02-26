
//setep 1: Interface for Engine
interface Engine {
    void start();
    void stop();
    int getHorsepower();
}

//step 2: Different Engine implementations

class PetrolEngine implements Engine{
    private int horsepower;

    public PetrolEngine(int horsepower) {
        this.horsepower = horsepower;
    }


    public void start() {
        System.out.println("Petrol engine started(vroom vroom)");
    }

    public void stop() {
        System.out.println("Petrol engine stopped");
    }

    public int getHorsepower(){
        return horsepower;
    }
}

class DieselEngine implements Engine {
    private int horsepower;

    public DieselEngine(int horsepower) {
        this.horsepower = horsepower;
    }

    public void start(){
        System.out.println("Diesel engine started(chug chug");
    }

    public void stop(){
        System.out.println("Diesel engine stopped");
    }

    public int getHorsepower() {
        return horsepower;
    }
}

class ElectricEngine implements Engine {
    private int horsepower;

    public ElectricEngine(int horsepower){
        this.horsepower = horsepower;
    }

    public void start(){
        System.out.println("Electric engine started(silent!");
    }

    public void stop(){
        System.out.println("Electric engine stopped");
    }
    public int getHorsepower(){
        return horsepower;
    }
}

//step 3: Car class with constructor injection
class Car {
    private String brand;
    private Engine engine; //Dependency

    //Constructor Injection - BEST practice
    public Car(String brand, Engine engine){
        this.brand = brand;
        this.engine = engine;
        System.out.println(brand + "car created with " + engine.getClass().getSimpleName());
    }

    public void drive() {
        System.out.println("\n=== Driving " + brand + "===");
        engine.start();
        System.out.println("Driving with " + engine.getHorsepower() + " HP");
        System.out.println("Car is moving...");
    }

    public void park() {
        System.out.println("Car parked");
        engine.stop();
    }
}

//step 4: Setter injection example
class Motorcycle {
    private String brand;
    private Engine engine;
    public Motorcycle(String brand) {
        this.brand = brand;
    }

    //Setter Injection = optional dependency
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println(brand + "motorcycle engine set");
    }

    public void ride(){
        if(engine == null ){
            System.out.println("ERROR: No engine installed!");
            return;
        }
        System.out.println("\n=== Riding " + brand + " ===");
        engine.start();
        System.out.println("Motorcycle is riding...");
        engine.stop();
    }
}

public class dependencyExample {
    public static void main(String[] args) {
        System.out.println("Manual dependency injection ===\n");

        //create different engines
        Engine petrol = new PetrolEngine(150);
        Engine diesel = new DieselEngine(180);
        Engine electric = new ElectricEngine(200);

        //Constructor Injection - create cars with engines
        Car car1 = new Car("Honda",petrol);
        car1.drive();
        car1.park();

        Car car2 = new Car("Toyota", diesel);
        car2.drive();
        car2.park();

        Car car3 = new Car("Tesla", electric);
        car3.drive();
        car3.park();

        System.out.println("\n=== SETTER INJECTION");

        //setter injection - create motorcycle, then set engine
        Motorcycle bike = new Motorcycle("Harley");
        bike.ride(); //will show error - no engine

        bike.setEngine(petrol); //now inject engine via setter
        bike.ride(); //works now

        System.out.println("\n=== KEY INSIGHT ===");
        System.out.println("We created Car and Motorcycle objects");
        System.out.println("We INJECTED their dependencies (engines) from outside");
        System.out.println("This is what Spring Framework does AUTOMATICALLY!");
        System.out.println("Spring creates objects and injects dependencies for us");
    }
}
