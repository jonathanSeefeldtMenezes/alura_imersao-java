public class Conteudo {

    private final String titulo;
    private final String urlImagem;

    public Conteudo(String titulo, String imagem){
        this.titulo = titulo;
        this.urlImagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagem() {
        return urlImagem;
    }

}
