package ejemplo1.com.evaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {


    public AdaptadorEstudiante(Context context, List<Estudiante> objects) {
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obteniendo el dato
        Estudiante estudiante= getItem(position);

        double a= estudiante.Promedio();
        String Promedio =Double.toString(a);

        //odo inicializando el layout correspondiente al item (estudiante)
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estudiante,parent,false);
        }
        TextView txtContar = convertView.findViewById(R.id.txtContar);
        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        TextView txtCodigo = convertView.findViewById(R.id.txtCodigo);
        TextView txtMateria = convertView.findViewById(R.id.txtMateria);
        TextView txtPromedio = convertView.findViewById(R.id.txtPromedio);

        txtContar.setText(estudiante.Nlista);
        txtNombre.setText(estudiante.nombre);
        txtCodigo.setText(estudiante.codigo);
        txtMateria.setText(estudiante.materia);
        txtPromedio.setText(Promedio);


        return convertView;
    }
}
