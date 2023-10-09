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
        cakes.add(new CakeDTO("Chocolate Cake", "delicious chocolate flavor"));
        cakes.add(new CakeDTO("Cheese Cake", "delicious cheese flavor"));
        cakes.add(new CakeDTO("Carrot Cake", "delicious carrot flavor"));
        cakes.add(new CakeDTO("Banana Cake", "delicious banana flavor"));
        cakes.add(new CakeDTO("Strawberry Cake", "delicious strawberry flavor"));
        cakes.add(new CakeDTO("Red Velvet Cake", "delicious red velvet flavor"));
        return cakes;
    }


//http://Esport.com/LeagueOfLegends/{team}/history/specificGame?date=27/03

    public static void getAllCakes(Context context) {
        ArrayList<CakeDTO> cakes = loadMenu();
context.header("MyfavoriteNumberToday", "42");

        context.json(cakes);


    }

    public static void getSpecialCake(Context context) {
        ArrayList<CakeDTO> cakes = loadMenu();
        String specialCake = context.pathParam("wishedCake");


        for (CakeDTO cake : cakes) {

            if (cake.name().toLowerCase().contains(specialCake.toLowerCase())) {
                context.json(cake);
                return;
            } else {
                context.json(new String("cake not found :c"));
            }
        }
    }

    public static void apiSpecialCake(Context context) {
        ArrayList<CakeDTO> cakes = loadMenu();
        String specialCake = context.queryParam("name");


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
        String desc = context.queryParam("desc");
        CakeDTO cake = new CakeDTO(newCake, desc);

        if (!cakes.contains(cake)) {
            cakes.add(cake);
            context.json(cake);

        } else {
            context.json(new String("cake already exists :c"));

        }


    }
}
