package httpServer;

import static spark.Spark.get;
import static spark.Spark.port;

//logservice
public class App {
    public static void main(String[] args) {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker");
        get ("index", (req, res) -> {
            String function = req.queryParams("user");
            DataBase.insert(function);
            return "";
        });
        get ("consult", (req, res) -> {
            res.type("application/json");
            String resp = "{";
            resp += DataBase.consult();
            resp += "}";
            return resp;
        });
    }

    private static int getPort (){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}