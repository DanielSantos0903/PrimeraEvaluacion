package ejemplo1.com.evaluacion;

import android.os.Parcelable;

public class Estudiante {
    public String Nlista;
    public String nombre;
    public String codigo;
    public String materia;
    public String parcial1;
    public String parcial2;
    public String parcial3;


    public Estudiante(String Nlista,String nombre, String codigo, String materia, String p1, String  p2, String p3) {
        this.Nlista=Nlista;
        this.nombre=nombre;
        this.codigo = codigo;
        this.materia = materia;
        this.parcial1 = p1;
        this.parcial2 = p2;
        this.parcial3 = p3;
    }

    public double Promedio() {

        double Prom;

        Double p1 = Double.parseDouble(parcial1);
        Double p2 = Double.parseDouble(parcial2);
        Double p3 = Double.parseDouble(parcial3);

        Prom = ((p1*0.30)+(p2*0.30)+(p3*0.40));
        return Prom ;
    }
}
