package es.jujoru.u2_controlesejercicio3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spMasa;
    TextView tvResultadoMasa, tvResultadoIngredientes, tvResultadoTamano;
    CheckBox cbQueso, cbPollo, cbPeperoni, cbJamon, cbTomate, cbBacon;
    RadioGroup rgTamano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultadoMasa=(TextView)findViewById(R.id.tv_resultado_masa);
        spMasa =(Spinner)findViewById(R.id.sp_masa);

        cbBacon = (CheckBox)findViewById(R.id.cb_bacon);
        cbQueso = (CheckBox)findViewById(R.id.cb_queso);
        cbPollo = (CheckBox)findViewById(R.id.cb_pollo);
        cbPeperoni = (CheckBox)findViewById(R.id.cb_peperoni);
        cbJamon = (CheckBox)findViewById(R.id.cb_jamon);
        cbTomate = (CheckBox)findViewById(R.id.cb_tomate);
        tvResultadoIngredientes=(TextView)findViewById(R.id.tv_resultado_ingredientes);

        rgTamano = (RadioGroup)findViewById(R.id.rg_tamano);
        tvResultadoTamano=(TextView)findViewById(R.id.tv_resultado_tamano);


        String [] masas ={"Selecciona","Fina","Normal","Borde queso","Calzone"};
        ArrayAdapter<String> adaptadorMasa = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, masas);
        spMasa.setAdapter(adaptadorMasa);


    }//FIN ONCREATE

    public void clickTamano(View view){
        int id = rgTamano.getCheckedRadioButtonId();

        if(id!=-1){
            RadioButton copiaRadioSeleccionado = (RadioButton)findViewById(id);
            String tamano=copiaRadioSeleccionado.getText().toString();

            tvResultadoTamano.setText("Tamaño "+tamano);
        }else{
            Toast.makeText(getApplicationContext(), "Debes de seleccionar una tamaño",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void clickIngredientes(View view){

        boolean estaCheckeado=false; //Por defecto no hay nada checkeck

        String ingredientes="";
        if(cbBacon.isChecked()){
            ingredientes+=cbBacon.getText().toString()+" ";
            estaCheckeado=true;
        }
        if(cbQueso.isChecked()){
            ingredientes+=cbQueso.getText().toString()+" ";
            estaCheckeado=true;
        }
        if(cbPollo.isChecked()){
            ingredientes+=cbPollo.getText().toString()+" ";
            estaCheckeado=true;
        }
        if(cbPeperoni.isChecked()){
            ingredientes+=cbPeperoni.getText().toString()+" ";
            estaCheckeado=true;
        }
        if(cbJamon.isChecked()){
            ingredientes+=cbJamon.getText().toString()+" ";
            estaCheckeado=true;
        }
        if(cbTomate.isChecked()){
            ingredientes+=cbTomate.getText().toString()+" ";
            estaCheckeado=true;
        }

        if(estaCheckeado){
            tvResultadoIngredientes.setText("Ingredientes: "+ingredientes);
        }else{
            Toast.makeText(getApplicationContext(), "Debes de seleccionar al menos un ingrediente",
                    Toast.LENGTH_LONG).show();
        }


    }

    public void clickMasa(View view){
        //Recoger la masa que esté selccionada en el SP de masas y mostrarlo en el TV
        //Validaremos que esté seleccionada alguna masa.

        String masaSeleccionada = spMasa.getSelectedItem().toString();

        if(masaSeleccionada.equals("Selecciona")){
            Toast.makeText(getApplicationContext(), "Debes de seleccionar una masa",
                    Toast.LENGTH_LONG).show();
            spMasa.setBackgroundColor(Color.RED); //Poner el Spinner en rojo si no esta sleccionado
        }else{
            tvResultadoMasa.setText("Masa: "+masaSeleccionada);
            spMasa.setBackgroundColor(Color.TRANSPARENT); //Volver al color original
        }
    }

}//FIN MAIN
