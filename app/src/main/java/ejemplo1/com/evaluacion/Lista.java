package ejemplo1.com.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import static  ejemplo1.com.evaluacion.Principal.adaptadorEstudiante;

public class Lista extends AppCompatActivity {

    private  ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        
        this.lista = findViewById(R.id.lstEstudiantes);

        if(adaptadorEstudiante!= null){
            lista.setAdapter(adaptadorEstudiante);
        }


    }
}
