package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Class that brings service
 * @author Maria Fernanda Hernandez Vargas
 */
public class App {

    /**
     * Method that controlls web site
     * @param args
     */
    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Docker");
        get ("/results", (req, res) -> {
            String function = req.queryParams("user");
            DataBase.insert(function);
            return "";
        });
        get ("/consult", (req, res) -> {
            res.type("application/json");
            String resp = "{\"Lista\": [";
            resp += DataBase.consult();
            resp += "]}";
            return resp;
        });
    }

    /**
     * Method that get the port that is running the service
     * @return
     */
    private static int getPort (){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6010;
    }
}