import spark.Request;
import spark.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static spark.Spark.*;
//round robin
//http://localhost:4567/index
//Corregir Comunicacion
//Contador
//Docker-AWS
public class SparkWebServer {
    public static void main(String[] args) {
        port(getPort());
        get("hello", (req, res) -> "Hello Docker");
        get ("index", (req, res) -> inputDataPage(req, res));
        get ("results", (req, res) -> {
            String function = req.queryParams("user");
            System.out.println(req.queryParams("user"));
            readURL("http://localhost:4567/index?user="+function);
            return inputDataPage(req, res);
        });
        get ("consult", (req, res) -> {
            res.type("application/json");
            return readURL("http://localhost:4567/consult");
        });
    }

    public static String inputDataPage (Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2> Servicio Web </h2>"
                + "<h4>A continuacion ingrese su nombre</h4>"
                + "<form action=\"/results\">"
                + "  Nombre:"
                + "  <input type=\"text\" name=\"user\" size= 10  value=\"Ana\n\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Enviar\">"
                + "  <br><br>"
                + "</form>"
                + "<form action=\"/consult\">"
                + "  <input type=\"submit\" value=\"Consultar\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    public static String readURL(String sitetoread) {
        String resData = null;
        try {
            URL siteURL = new URL(sitetoread);
            URLConnection urlConnection = siteURL.openConnection();
            System.out.println("-------message-body------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine = null;
            resData = "";
            while ((inputLine = reader.readLine()) != null) {
                resData += inputLine;
            }
        } catch (IOException x) {
            resData = "";
            System.err.println(x);
        }
        return resData;
    }

    private static int getPort (){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}