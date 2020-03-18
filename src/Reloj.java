import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Reloj extends Thread{
    private Date fecha;
    private JLabel jlabel;
    String formato = "kk:mm:ss";
    SimpleDateFormat formatofecha = new SimpleDateFormat(formato);
    
    public void setlabel(JLabel jlabel){
        this.jlabel = jlabel;
    }
    public void run(){
        while(true){
            try {
                fecha = new Date();
                jlabel.setText(formatofecha.format(fecha));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
