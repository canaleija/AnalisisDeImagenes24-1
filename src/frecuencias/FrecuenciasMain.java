package frecuencias;

import java.awt.Image;
import java.awt.image.BufferedImage;

import espacial.OperacionesBasicas;
import gui.JFrameImg;
import herramientas.HerramientasImagen;

public class FrecuenciasMain {
    public static void main(String[] args) {
        // obtenemos la imagen original
        Image imagenOriginal = HerramientasImagen.abrirImagen();
        // cponvertimos a grises
        Image grises = OperacionesBasicas.escalaDeGrises(imagenOriginal);
        // mostramos la imagen original
        JFrameImg frame1 = new JFrameImg(grises);
        // Gestor para el calculo del espectro de las frecuencias
        GestorGrises gestor = new GestorGrises();

        // obtenemos el buffer para el calculo del espectro
        BufferedImage bImage = HerramientasImagen.toBufferedImage(grises);

        // convertimos a matriz de numeros complejos
        NumeroComplejo[][] aux = gestor.obtenerDatos(bImage);

        BufferedImage biFrecuencias = gestor.obtenerImagenFrecuencias(aux,
                bImage.getWidth(),
                bImage.getHeight(), true);

        // mostramos la imagen original
        JFrameImg frame2 = new JFrameImg(HerramientasImagen.toImage(biFrecuencias));

        // obtenemos la imagen resultante de aplicar la FFT inversa

        BufferedImage resultante = gestor.obtenerImagenEspacial();

        // mostramos la imagen original
        JFrameImg frame3 = new JFrameImg(HerramientasImagen.toImage(resultante));

    }
}
