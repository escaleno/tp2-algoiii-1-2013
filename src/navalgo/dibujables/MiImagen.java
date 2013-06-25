package navalgo.dibujables;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class MiImagen implements ObjetoDibujable {

    private BufferedImage imagen;
    private ObjetoPosicionable posicionable;

    public MiImagen(URL imagenUrl, ObjetoPosicionable posicionable) throws IOException {
		this.imagen = ImageIO.read(imagenUrl);
		this.posicionable = posicionable;
    }
    
    public void setImagen(BufferedImage imagen){
		this.imagen = imagen;
	}
	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(),null);
	}

	public ObjetoPosicionable getPosicionable() {
		return posicionable;
	}

}