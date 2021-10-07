package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import modelo.FilePrinter;
import modelo.Observador;
import modelo.Sujeto;

public class VistaGraficaBarras implements Observador{
    Sujeto modelo;
    JFrame ventana;
    JPanel panel;
    DefaultCategoryDataset datos;
    FilePrinter filePrinter = new FilePrinter();

    public VistaGraficaBarras(Sujeto modelo) {
        this.modelo = modelo;
        modelo.registrarObservador((Observador)this);
    }

    public void inicializarVista(){
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        ventana = new JFrame();
        ventana.setSize(500,500);
        ventana.setTitle("GraficaDeBarras");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        inicializarComponentes();
        ventana.setVisible(true);
    }

    public void inicializarComponentes(){
        colocarPanel();
        colocarGrafica();
        colocarBotones();
    }

    public void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);
    }

    public void colocarGrafica(){
        //Panel
        JPanel panelGrafica = new JPanel();
        panelGrafica.setBounds(25, 40,450, 300);
        panel.add(panelGrafica);
        //Grafica
        datos = new DefaultCategoryDataset();
        String nombre;
        nombre = modelo.getNombreCandidato(0);
        datos.setValue(modelo.getNumVotos(nombre), nombre, "");
        nombre = modelo.getNombreCandidato(1);
        datos.setValue(modelo.getNumVotos(nombre),nombre, "");
        nombre = modelo.getNombreCandidato(2);
        datos.setValue(modelo.getNumVotos(nombre),nombre, "");
        JFreeChart grafica = ChartFactory.createBarChart3D("Conteo de votos", "Productos" , "Votos" ,datos, PlotOrientation.VERTICAL, true ,true, false);
        ChartPanel graficaPanel = new ChartPanel(grafica);
        graficaPanel.setMouseWheelEnabled(true);
        graficaPanel.setPreferredSize(new Dimension(450, 300));
        panelGrafica.add(graficaPanel);
        panel.add(panelGrafica);
    }

    public void colocarBotones(){
        JButton btnRegresar = new JButton("Cerrar");
        btnRegresar.setBounds(175, 400, 150, 50);
        panel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
                ventana.dispose();
            }
        });
    }

	@Override
	public void actualizacion(String nombre) {
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
		int numVotos = modelo.getNumVotos(nombre);
        String key;
        key = (String)datos.getRowKey(0);
        if(nombre.equals(key))
            datos.setValue(numVotos, nombre, "");
        key = (String)datos.getRowKey(1);
        if(nombre.equals(key))
            datos.setValue(numVotos, nombre, "");
        key = (String)datos.getRowKey(2);
        if(nombre.equals(key))
            datos.setValue(numVotos, nombre, "");
	}
}
