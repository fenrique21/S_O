
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Hilolist extends Thread {

    private ArrayList<Hilo> datos, copia;
    private JList mostar;
    private boolean band = false, terminado;
    private JTextField proceso;
    private JList posicion, uno;
    private int valor = 0;
    private DefaultListModel model1 = new DefaultListModel();
    int cont = 0;

    public void run() {
        while (true) {
            if (band) {
                cont = 0;
                for (int i = 0; i < copia.size(); i++) {
                    if (copia.get(i).getestado()) {
                        proceso.setText(String.valueOf(copia.get(i).getName()));
                        restarquantun(i);
                        eliminar();
                    }
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilolist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminar() {
        //Eliminar el dato cuando el tiempo es = 0
        DefaultListModel m1 =(DefaultListModel)uno.getModel();
        m1.clear();
        valor = 0;
        for (int i = 0; i < copia.size(); i++){
            if(copia.get(i).getestado()){
                m1.add(valor, copia.get(i).getName());
                valor++;
            }else{
                if(!copia.get(i).getestado() && !copia.get(i).getterminado()){
                    m1.add(valor, copia.get(i).getName());
                    valor++;
                }
            }
        }
        uno.setModel(m1);
    }

    public void quitartiempo(JList mostar, ArrayList<Hilo> datos, boolean band, JTextField proceso, JList uno, ArrayList<Hilo> datos1) throws InterruptedException {
        this.datos = datos;
        this.mostar = mostar;
        this.band = band;
        this.proceso = proceso;
        this.uno = uno;
        this.copia = datos1;
    }

    private void actualizar(JList mostar, ArrayList<Hilo> datos) {
        //actualizar el tiempo de ejecucion, hace que se muestre el cambio en jlist
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < datos.size(); i++) {
            model.add(i, datos.get(i).gettiempo());
        }
        mostar.setModel(model);
    }

    private void restarquantun(int valor) {
        //Ingresar el tiempo del quantun que se va restar y le damos un segundo para que se valla restando
        for (int j = 0; j < 5; j++) {
            try {
                datos.get(valor).saltar();
                actualizar(mostar, datos);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilolist.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
