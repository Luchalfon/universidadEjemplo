package validacion;


public class ValidacionDeIngresos {
     public static boolean validarEntero(String ingreso){
        try {
            int x = Integer.parseInt(ingreso);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean validarDouble(String ingreso){
        try {
            double x = Double.parseDouble(ingreso);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
