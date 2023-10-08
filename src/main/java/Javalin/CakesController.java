package Javalin;

import io.javalin.http.Context;

import java.util.ArrayList;

public class CakesController {

    private CakesController() {
    }


    private static ArrayList<CakeDTO> cakes = new ArrayList<>();


    private static ArrayList<CakeDTO> loadMenu() {
        if (!cakes.isEmpty()) {
            return cakes;
        }
        cakes.add(new CakeDTO("Chocolate Cake"));
        cakes.add(new CakeDTO("Cheese Cake"));
        cakes.add(new CakeDTO("Carrot Cake"));
        cakes.add(new CakeDTO("Banana Cake"));
        cakes.add(new CakeDTO("Strawberry Cake"));
        cakes.add(new CakeDTO("Red Velvet Cake"));
        return cakes;
    }


//http://Esport.com/LeagueOfLegends/{team}/history/specificGame?date=27/03

    public static void getAllCakes(Context context) {
        ArrayList<CakeDTO> cakes = loadMenu();


        context.json(cakes);


    }

    public static void getSpecialCake(Context context) {
        ArrayList<CakeDTO> cakes = loadMenu();
        String specialCake = context.pathParam("specialCake");


        for (CakeDTO cake : cakes) {

            if (cake.name().toLowerCase().contains(specialCake.toLowerCase())) {
                context.json(cake);
                return;
            } else {
                context.json(new String("cake not found :c"));
            }
        }
    }

    public static void createNewCake(Context context) {
        String newCake = context.queryParam("name");
        CakeDTO cake = new CakeDTO(newCake);

        String topping = context.queryParam("topping");

        if (!cakes.contains(cake)) {
            cakes.add(cake);
            context.json(cake);

        } else {
            context.json(new String("cake already exists :c"));

        }


    }
}
