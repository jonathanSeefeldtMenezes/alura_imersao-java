import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        String json = ObterFilmesJSON();
        
        List<Filme> listaFilmes = ConverterJSONEmListaFilme(json);

        System.out.println(listaFilmes.size());

    }

    private static String ObterFilmesJSON(){

        URI urlApi = URI.create("https://api.mocki.io/v2/549a5d8b");
        
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(urlApi).GET().build();
        
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());    
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }

    }

    private static List<Filme> ConverterJSONEmListaFilme(String json){

        var jsonParser = new JsonParser();
        List<Map<String,String>> filmesJson = jsonParser.parse(json);

        List<Filme> listaFilmes = new ArrayList<>();

        for(Map<String, String> filmeJson : filmesJson){
            listaFilmes.add(
                new Filme(filmeJson.get("title"),
                          filmeJson.get("image"),
                          Float.parseFloat(filmeJson.get("imDbRating")))
            );
        }

        return listaFilmes;

    }
}
