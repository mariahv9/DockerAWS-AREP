package httpServer;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import org.bson.Document;

import javax.print.Doc;
import java.util.*;

public class DataBase {
    public static void insert (String user) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("Users");
        Date date = new Date();
        Document document1 = new Document("Usuario", user).append("Fecha", date.toString());
        List<Document> list = new ArrayList<Document>();
        list.add(document1);
        collection.insertMany(list);
    }

    public static String consult (){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = database.getCollection("Users");
        FindIterable <Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        String ans = "";
        while (it.hasNext()) {
            ans += "{";
            Document var = (Document) it.next();
            ans += "\"Usuario\": \"" + var.get("Usuario")+"\",";
            ans += " \"Fecha\": \"" + var.get("Fecha")+"\"";
            ans += "}";
            if (it.hasNext())
                ans += ",";
        }
        return ans;
    }
}