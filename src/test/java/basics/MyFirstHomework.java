package basics;

import org.junit.jupiter.api.Test;

public class MyFirstHomework {
    public double carRouteDistance(double carConsumption, double distance){
        return ((distance / 100) * carConsumption);


    }

    @Test
    public void test (){
         double distance = 550d;
         double petrolPrice = 1.497d;
         double a = carRouteDistance(7.5, distance);
         String fuelPrice = String.format ("%.2f",(petrolPrice * a));

         System.out.println("Чтобы проехать: "  + distance + " км");
         System.out.println("Понадобится: " + a + " литров топлива");
         System.out.println("На бензин вы потратите: " + (fuelPrice) +  " евро");
    }
}
