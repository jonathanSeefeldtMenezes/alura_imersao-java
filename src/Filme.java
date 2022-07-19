public class Filme {

    private String titulo;
    private String imagem;
    private Float avaliacao;

    public Filme(String titulo, String imagem, Float avaliacao){
        this.titulo = titulo;
        this.imagem = imagem;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public Float getAvaliacao() {
        return avaliacao;
    }
}
