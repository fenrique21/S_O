
public class Hilo extends Thread {
    private int tiempo = 0;
    private boolean bandera = true,terminado=true;
    private String memoria;

    public void run() {
    }

    public void iniciartiempo() {
        tiempo = (int) (Math.random() * 10 + 1);
    }

    public int gettiempo() {
        return tiempo;
    }

    public void saltar(){
        //vamos restando el tiempo uno en uno, y si es menor a cero le pones cero y pones
        //la bandera en falso;
        tiempo -= 1;
        System.out.println();
        if (bandera && tiempo > 0) {
        } else {
            bandera = false;
            tiempo = 0;
        }
    }

    public boolean getestado() {
        return bandera;
    }

    public void bloquear(boolean bandera) {
        this.bandera = bandera;
    }

    public void setmemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getmemoria() {
        return memoria;
    }

    public void generarmemoria() {
        //generamos la direccion de memoria simulada
        String memoria = "";
        for (int i = 0; i < 6; i++){
            memoria += String.valueOf((int) (Math.random() * 9));
        }
        setmemoria(memoria);
    }
    public void setterminado(boolean terminado){
        this.terminado = terminado;
    }
    public boolean getterminado(){return terminado;}
}
