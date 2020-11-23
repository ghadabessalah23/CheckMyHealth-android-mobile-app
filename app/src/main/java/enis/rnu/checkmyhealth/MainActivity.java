package enis.rnu.checkmyhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText poids;
    EditText age;
    EditText taille;
    RadioGroup sexe;
    RadioButton homme;
    RadioButton femme;
    Button calcul;
    ImageButton imageButton;
    TextView resultat;
    ImageButton maigre;
    ImageButton graisse;
    ImageButton normale;
    ImageButton accueil;
    void init(){
        poids=(EditText) findViewById(R.id.poids);
        age=(EditText) findViewById(R.id.age);
        taille=(EditText) findViewById(R.id.taille);
        sexe=(RadioGroup) findViewById(R.id.radio_group);
        homme=(RadioButton)findViewById(R.id.radioButton_homme);
        femme=(RadioButton)findViewById(R.id.radioButton_femme);
        calcul=(Button) findViewById(R.id.calculer);
        resultat=(TextView) findViewById(R.id.resultat);
    }
    void ecoute_btn_calcul() {
        calcul.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View calcul) {
                int s=1;
                if(femme.isChecked())
                {s=0;}
                if(poids==null || age==null || taille==null)
                {Toast toast = Toast.makeText(MainActivity.this, "Saisie Incorrecte ",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    double poids_value = Double.parseDouble(poids.getText().toString());
                    double age_value = Double.parseDouble(age.getText().toString());
                    double taille_value = Double.parseDouble(taille.getText().toString());




                    double img = (1.2 * poids_value / (taille_value * taille_value) + (0.23 * age_value) - (10.83 * s) - 5.4);


                    if (s == 1) {




                        if (img < 0.10) {
                            resultat.setTextColor(Color.rgb(255, 0, 0));
                            resultat.setText("trop maigre");
                            maigre = (ImageButton) findViewById(R.id.normale);
                            maigre.setImageResource(R.drawable.maigre);

                        }
                        if (img > 0.10 && img < 0.25) {
                            resultat.setText("normal");
                            normale = (ImageButton) findViewById(R.id.normale);

                        }
                        if (img > 0.25) {
                            resultat.setTextColor(Color.rgb(255, 0, 0));
                            resultat.setText("trop de graisse");
                            graisse = (ImageButton) findViewById(R.id.normale);
                            graisse.setImageResource(R.drawable.graisse);
                        }
                    } else {
                        if (img < 0.15) {
                            resultat.setTextColor(Color.rgb(255, 0, 0));
                            resultat.setText("trop maigre");
                            maigre = (ImageButton) findViewById(R.id.normale);
                            maigre.setImageResource(R.drawable.maigre);
                        }
                        if (img > 0.15 && img < 0.30) {

                            resultat.setText("normal");
                            normale = (ImageButton) findViewById(R.id.normale);
                        }
                        if (img > 0.30) {
                            resultat.setTextColor(Color.rgb(255, 0, 0));
                            resultat.setText("trop de graisse");
                            graisse = (ImageButton) findViewById(R.id.normale);
                            graisse.setImageResource(R.drawable.graisse);
                        }
                    }
                }
            }
        });
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accueil=(ImageButton)findViewById(R.id.imageButton_accueil);
        accueil.setOnClickListener(new ImageButton.OnClickListener()
        {
            @Override
            public void onClick(View accueil) {
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });


        init();
        ecoute_btn_calcul();
    }
}
