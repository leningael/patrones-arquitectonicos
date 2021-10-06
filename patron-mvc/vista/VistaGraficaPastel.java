package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Observador;
import modelo.Sujeto;

public class VistaGraficaPastel implements Observador{
    Sujeto modelo;
    Controlador controlador;
    JFrame ventana;
    JPanel panel;

    public VistaGraficaPastel(Controlador controlador, Sujeto modelo) {
        this.modelo = modelo;
        this.controlador = controlador;
        modelo.registrarObservador((Observador)this);
    }

    public void inicializarVista(){
        ventana = new JFrame();
        ventana.setSize(800,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("GraficaDeBarras");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        inicializarComponentes();
        ventana.setVisible(true);
    }

    public void inicializarComponentes(){
        colocarPanel();
        colocarBotones();
    }

    public void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);
    }

    public void colocarBotones(){
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(600, 500, 150, 50);
        panel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new VistaVotaciones(controlador, modelo).inicializarVista();
                ventana.dispose();
            }
        });
    }

	@Override
	public void actualizacion(String nombre) {
		// TODO Auto-generated method stub
		
	}
}
