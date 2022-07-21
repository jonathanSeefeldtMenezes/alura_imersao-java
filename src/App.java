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
     
        //var extrator = new ExtratorDeConteudoDaNasa();
        //var url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";

        var extrator = new ExtratorDeConteudoDoIMDB();
        var url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        System.out.println("Obter filmes JSON");
        
        var clienteHttp = new ClienteHttp();
        String json = clienteHttp.buscaDados(url);

        System.out.println("Converter JSON em lista de conteúdos");
        
        List<Conteudo> listaDeConteudo = extrator.extraiConteudos(json);

        System.out.println("Total de conteúdos : " + listaDeConteudo.size());
        var geradoraDeFigurinha = new GeradoraDeFigurinha();

        System.out.println("Gerando as figurinhas");
        for(Conteudo conteudo : listaDeConteudo){
            geradoraDeFigurinha.cria(conteudo);
        }

        System.out.println("Rotina finalizada");
    }

}
