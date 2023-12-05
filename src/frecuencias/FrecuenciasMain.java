package frecuencias;

import java.awt.Image;
import java.awt.image.BufferedImage;

import espacial.OperacionesBasicas;
import gui.JFrameImg;
import herramientas.HerramientasImagen;

public class FrecuenciasMain {
    public static void main(String[] args) {
        Image imagenOriginal = HerramientasImagen.abrirImagen();

        Image grises = OperacionesBasicas.escalaDeGrises(imagenOriginal);
        // mostramos la imagen original
        JFrameImg frame1 = new JFrameImg(imagenOriginal);

        Gestor gestor = new Gestor();

        // obtenemos el buffer con el espectro de frecuencias
        BufferedImage bImage = HerramientasImagen.toBufferedImage(imagenOriginal);
        // convertimos a matriz de numeros complejos
        NumeroComplejo[][] aux = gestor.obtenerDatosPorCanal(bImage, HerramientasColor.CanalColor.VERDE);


        BufferedImage biFrecuencias = gestor.obtenerImagenFrecuencias(aux,
                                                                         bImage.getWidth(),
                                                                          bImage.getHeight(), true);

        // mostramos la imagen original
        JFrameImg frame2 = new JFrameImg(HerramientasImagen.toImage(biFrecuencias));

        
    }
}
