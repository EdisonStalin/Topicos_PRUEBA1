package com.example.e_jumbo_prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;


public class MainActivity extends AppCompatActivity {

    private TextView tgrafica;
    private EditText tvNombre, tvCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = (EditText)findViewById(R.id.Nombre);
        tvCodigo = (EditText)findViewById(R.id.Codigo);


        RelativeLayout layout1= (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);

    }



    public void verificar(View v){
        String clave = tvCodigo.getText().toString();
        String nombre = tvNombre.getText().toString();
        if(clave.length()==0){
            Toast notificar = Toast.makeText(this,"La clave no debe quedar vacia", Toast.LENGTH_LONG);
            notificar.show();
        }if(nombre.length()==0){
            Toast notificar = Toast.makeText(this,"El nombre no debe quedar vacio", Toast.LENGTH_LONG);
            notificar.show();
        }if(clave.length()>0 && nombre.length()>0 ){
            Toast notificar = Toast.makeText(this,"Los datos se guardaron exitosamente", Toast.LENGTH_LONG);
            notificar.show();
        }
    }

    public void acticar (View view){
        tgrafica = (TextView) findViewById(R.id.grafica);
        tgrafica.setText(".");
    }


    class Lienzo extends View{
        public Lienzo(Context context){
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();
            Paint pincell = new Paint();
            pincell.setARGB(255,0,0,0);
            canvas.drawPoint(ancho/4, alto/8, pincell);
        }
    }

}