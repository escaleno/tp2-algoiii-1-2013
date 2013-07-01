package navalgo.dibujables;

import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class ImagensParteBarcos extends MiImagen {
	private BufferedImage normal;
	private BufferedImage daniado;
	private BufferedImage hundido;
	public ImagensParteBarcos(String nomberImagen, ObjetoPosicionable posicionable)
			throws IOException {
		super(ImagensParteBarcos.class.getResource("/res/" +  nomberImagen + ".png"), posicionable);
		this.normal = ImageIO.read(ImagensParteBarcos.class.getResource("/res/" + nomberImagen + ".png"));
		this.daniado = ImageIO.read(ImagensParteBarcos.class.getResource("/res/Daniado/" + nomberImagen + ".png"));
		this.hundido = ImageIO.read(ImagensParteBarcos.class.getResource("/res/Hundido/" + nomberImagen + ".png"));
	}
	
	public void setEstado(int estado){
		switch (estado) {
		case 0:
			this.setImagen(this.normal);
			break;
		case 1:
			this.setImagen(this.daniado);
			break;
		case 2:
			this.setImagen(this.hundido);
			break;
		default:
			break;
		}
	}
}
