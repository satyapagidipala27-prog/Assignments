
interface Coffee {

    double getCost();

    String getDescription();
}

class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 50.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
}

class CaramelDecorator extends CoffeeDecorator {

    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }
}

public class Main {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        System.out.println(coffee.getDescription());
        System.out.println("Cost: Rs." + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        coffee = new CaramelDecorator(coffee);

        System.out.println("\nFinal Order:");
        System.out.println(coffee.getDescription());
        System.out.println("Total Cost: Rs." + coffee.getCost());
    }
}
