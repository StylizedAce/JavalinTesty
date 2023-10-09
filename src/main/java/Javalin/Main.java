package Javalin;

import io.javalin.Javalin;
import io.javalin.http.Handler;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);


        //NORMAL API:
        // Is a library of tools
        // Lets you communicate between different platforms

        //ALL API'S ARE LIBRARIES BUT NOT ALL LIBRARIES ARE API's

        //WEB API:



//Idempotency is when an operation can be applied multiple times without changing the result beyond the initial request.
        //GET is idempotent because if i try to get "Joe" object from database, i would get the same object every time.
        //POST is not idempotent because if i try to create "Joe" object in database, i would get a new object every time perhaps with a different ID for each.

        app.get("/", ctx -> ctx.result("Hello World"));

        app.routes(() -> {
            path("/api/cakes", ()->{
                get("/all", CakesController::getAllCakes);
                get("/", CakesController::apiSpecialCake);
                post("/", CakesController::createNewCake);

            });
        });
    }
}