package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controlador.Controlador;
import modelo.Observador;
import modelo.Sujeto;

public class VistaVotaciones implements Observador{
    Sujeto modelo;
    Controlador controlador;
    JFrame ventana;
    JPanel panel;
    JRadioButton radioBtn1;
    JRadioButton radioBtn2;
    JRadioButton radioBtn3;
    JLabel contador1;
    JLabel contador2;
    JLabel contador3;
    ButtonGroup grupoRadioBotones;

    public VistaVotaciones(Controlador controlador, Sujeto modelo) {
        this.modelo = modelo;
        this.controlador = controlador;
        modelo.registrarObservador((Observador)this);
    }

    public void inicializarVista(){
        ventana = new JFrame();
        ventana.setSize(800,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Votaciones");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        inicializarComponentes();
        ventana.setVisible(true);
    }

    public void inicializarComponentes(){
        colocarPanel();
        colocarEtiquetasTitulo();
        colocarRadioBotones();
        colocarEtiquetasContador();
        colocarBotones();
    }

    public void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);
    }

    public void colocarEtiquetasTitulo(){
        JLabel titulo = new JLabel("Encuesta de productos");
        titulo.setBounds(225, 30, 350, 50);
        titulo.setFont(new Font("impact", 1, 35));
        JLabel descripcion = new JLabel("Selecciona tu favorito");
        descripcion.setBounds(300, 70, 350, 50);
        descripcion.setFont(new Font("tahoma", 1, 20));
        panel.add(titulo);
        panel.add(descripcion);
    }

    public void colocarRadioBotones(){
        radioBtn1 = new JRadioButton(modelo.getNombreCandidato(0));
        radioBtn1.setBounds(50, 200, 250, 30);
        radioBtn1.setFont(new Font("tahoma", 1, 20));
        panel.add(radioBtn1);
        radioBtn2 = new JRadioButton(modelo.getNombreCandidato(1));
        radioBtn2.setBounds(325, 200, 250, 30);
        radioBtn2.setFont(new Font("tahoma", 1, 20));
        panel.add(radioBtn2);
        radioBtn3 = new JRadioButton(modelo.getNombreCandidato(2));
        radioBtn3.setBounds(600, 200, 250, 30);
        radioBtn3.setFont(new Font("tahoma", 1, 20));
        panel.add(radioBtn3);
        grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radioBtn1);
        grupoRadioBotones.add(radioBtn2);
        grupoRadioBotones.add(radioBtn3);
        radioBtn1.setActionCommand(radioBtn1.getText());
        radioBtn2.setActionCommand(radioBtn2.getText());
        radioBtn3.setActionCommand(radioBtn3.getText());
    }

    public void colocarEtiquetasContador(){
        contador1 = new JLabel("Num. votos: 0");
        contador1.setBounds(60, 230, 250, 30);
        contador1.setFont(new Font("tahoma", 0, 20));
        contador2 = new JLabel("Num. votos: 0");
        contador2.setBounds(335, 230, 250, 30);
        contador2.setFont(new Font("tahoma", 0, 20));
        contador3 = new JLabel("Num. votos: 0");
        contador3.setBounds(610, 230, 250, 30);
        contador3.setFont(new Font("tahoma", 0, 20));
        panel.add(contador1);
        panel.add(contador2);
        panel.add(contador3);
    }

    public void colocarBotones(){
        JButton btnVotar = new JButton("Votar ahora");
        btnVotar.setBounds(325, 300, 150, 50);
        JButton btnGrafica1 = new JButton("Gráfica Barras");
        btnGrafica1.setBounds(325, 375, 150, 50);
        JButton btnGrafica2 = new JButton("Gráfica Pastel");
        btnGrafica2.setBounds(325, 450, 150, 50);
        panel.add(btnVotar);
        panel.add(btnGrafica1);
        panel.add(btnGrafica2);
        btnVotar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                controlador.aumentar(grupoRadioBotones.getSelection().getActionCommand());
            }
        });
        btnGrafica1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new VistaGraficaBarras(controlador, modelo).inicializarVista();
                ventana.dispose();
            }
        });
        btnGrafica2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new VistaGraficaPastel(controlador, modelo).inicializarVista();
                ventana.dispose();
            }
        });
    }

    public void actualizacion(String nombre) {
        int numVotos = modelo.getNumVotos(nombre);
        if(nombre.equals(radioBtn1.getText()))
            contador1.setText("Num. votos: " + numVotos);
        if(nombre.equals(radioBtn2.getText()))
            contador2.setText("Num. votos: " + numVotos);
        if(nombre.equals(radioBtn3.getText()))
            contador3.setText("Num. votos: " + numVotos);
    }
}
