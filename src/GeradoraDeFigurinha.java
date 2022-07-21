import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinha {
    
    public void cria(Conteudo filme){

        BufferedImage imagemOriginal = lerImagem(filme);
       
        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();

        BufferedImage novaImagem = criaNovaImagem(largura, altura + 40);
        Graphics2D novaImagemGrafico = (Graphics2D) novaImagem.getGraphics();
        novaImagemGrafico.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF,Font.BOLD,20);
        novaImagemGrafico.setFont(fonte);

        novaImagemGrafico.setColor(Color.yellow);
        var texto = obterTexto(new Random().nextInt(5));
        novaImagemGrafico.drawString(texto, 10, altura + 30);

        try {
            ImageIO.write(novaImagem, "png", new File("img/" + filme.getTitulo() + ".png"));    
        } catch (Exception e) {
            System.out.println("Erro ao criar imagem : " + filme.getTitulo());
        }
        
    }

    private BufferedImage lerImagem(Conteudo filme){
        try {
            return ImageIO.read(new URL(filme.getImagem()).openStream());    
        } catch (Exception e) {
            System.out.println("Erro ao ler imagem" + filme.getTitulo());
            return null;
        }
    } 

    private BufferedImage criaNovaImagem(int largura, int altura){
        return new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);
    }

    private String obterTexto(int numero){
        switch(numero){
            case 1: return "TopZera";
            case 2: return "Esse vale!";
            case 3: return "Valeu ein!";
            case 4: return "Top D+";
            case 5: return "Bombando";
            default: return "Dai sim!";
        } 

    }
}
