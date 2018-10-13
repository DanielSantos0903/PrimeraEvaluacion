package ejemplo1.com.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Principal;

public class Nuevo extends AppCompatActivity {

    private static int cont=1;
    private Button Guarda;
    private EditText Nombre;
    private EditText Codigo;
    private EditText Materia;
    private EditText P1;
    private  EditText P2;
    private  EditText P3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        //this.Contador = findViewById(R.id.btnNuevo);
        this.Guarda = findViewById(R.id.btnGuardar);
        this.Nombre = findViewById(R.id.lblNombre);
        this.Codigo = findViewById(R.id.lblCodigo);
        this.Materia = findViewById(R.id.lblMateria);
        this.P1 = findViewById(R.id.lblParcial1);
        this.P2 = findViewById(R.id.lblParcial2);
        this.P3 = findViewById(R.id.lblParcial3);

        Guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //si alguno de los dos campos estan vacios
                if(Nombre.getText().toString().isEmpty() || Codigo.getText().toString().isEmpty() ||
                        Materia.getText().toString().isEmpty() || P1.getText().toString().isEmpty() ||
                        P2.getText().toString().isEmpty() || P3.getText().toString().isEmpty()){
                    Toast.makeText(Nuevo.this,"Inserta los datos del estudiante",Toast.LENGTH_SHORT).show();
                }else{//de lo contrario los campos estan llenos
                    //envio los datos al MainActivity

                    Intent resultIntent = new Intent();
                    // TODO envio los datos mediante el intent
                    resultIntent.putExtra("NLISTA",String.valueOf(cont++));
                    resultIntent.putExtra("NOMBRE",Nombre.getText().toString());
                    resultIntent.putExtra("CODIGO",Codigo.getText().toString());
                    resultIntent.putExtra("MATERIA",Materia.getText().toString());
                    resultIntent.putExtra("P1",P1.getText().toString());
                    resultIntent.putExtra("P2",P2.getText().toString());
                    resultIntent.putExtra("P3",P3.getText().toString());
                    setResult(1,resultIntent);
                    finish();

                }

            }
        });
    }
}
