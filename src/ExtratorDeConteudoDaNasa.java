import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements IExtratorDeConteudo{

    @Override
    public List<Conteudo> extraiConteudos(String json) {
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> listaDeConteudos = new ArrayList<>();

        for(Map<String,String> atributo : listaDeAtributos){
            String titulo = atributo.get("title");
            String urlImagem  = atributo.get("url");

            listaDeConteudos.add(new Conteudo(titulo,urlImagem));
        }
        
        return listaDeConteudos;
    }
    
}
