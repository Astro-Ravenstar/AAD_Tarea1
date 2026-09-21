import Frame.MenuSeleccion;

public class Main {
    public static void main(String[] args) {

        try {
            MenuSeleccion.mostrarMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}