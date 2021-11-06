import org.junit.jupiter.api.Test;

public class MyFirstHomework {
    public MyFirstHomework() {
    }

    public double carRouteDistance(double carConsumption, double distance) {
        return distance / 100.0D * carConsumption;
    }

    @Test
    public void test() {
        double distance = 550.0D;
        double petrolPrice = 1.497D;
        double a = this.carRouteDistance(7.5D, distance);
        String fuelPrice = String.format("%.2f", petrolPrice * a);
        System.out.println("Чтобы проехать: " + distance + " км");
        System.out.println("Понадобится: " + a + " литров топлива");
        System.out.println("На бензин вы потратите: " + fuelPrice + " евро");
    }
}
