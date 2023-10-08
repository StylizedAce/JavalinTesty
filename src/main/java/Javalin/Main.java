package Javalin;

import io.javalin.Javalin;
import io.javalin.http.Handler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);

//Idempotency is when an operation can be applied multiple times without changing the result beyond the initial request.
        //GET is idempotent because if i try to get "Joe" object from database, i would get the same object every time.
        //POST is not idempotent because if i try to create "Joe" object in database, i would get a new object every time perhaps with a different ID for each.

        app.routes(() -> {
            path("/cakes", ()->{
                get("/", CakesController::getAllCakes);
                get("/{specialCake}", CakesController::getSpecialCake);
                post("/", CakesController::createNewCake);

            });
        });

    }
}