package ejemplo1.com.evaluacion;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Principal extends AppCompatActivity {

    private static String nombre;
    private int cont = 1;
    private Button Nuevo;
    private Button Lista;
    public ArrayList<Estudiante> estudianteArrayList;
    public static AdaptadorEstudiante adaptadorEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.Nuevo = findViewById(R.id.btnNuevo);
        this.Lista = findViewById(R.id.btnVer);


        estudianteArrayList = new ArrayList<>();
        adaptadorEstudiante = new AdaptadorEstudiante(this, estudianteArrayList );
        //Inicializando el listView
       // ListView listView = (ListView) findViewById(R.id.lstEstudiantes);
        //seteando el adaptador al listview
        //listView.setAdapter(adaptadorEstudiante);

        //Asigno el texto del boton a mi variable nombre de forma estatica
        nombre = Nuevo.getText().toString();

        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //preparo el activity
                Intent intent = new Intent(Principal.this,Nuevo.class);
                //inicio el activitiy y quiero como mensaje un RESULT_OK
                startActivityForResult(intent,1);

            }
        });

        Lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(Principal.this, Lista.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Nuevo.setText(nombre + " "+ cont++ );

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){

            //recibo los datos
            Estudiante e = new Estudiante(
                    data.getStringExtra("NLISTA"),
                    data.getStringExtra("NOMBRE"),
                    data.getStringExtra("CODIGO"),
                    data.getStringExtra("MATERIA"),
                    data.getStringExtra("P1"),
                    data.getStringExtra("P2"),
                    data.getStringExtra("P3")
            );

            estudianteArrayList.add(e);
            adaptadorEstudiante.notifyDataSetChanged();
        }
    }
}
