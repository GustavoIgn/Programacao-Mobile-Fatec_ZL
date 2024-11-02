package br.edu.fateczl.ex_13;

/*
@author:<Gustavo da Silva Ignacio 1110482313006>
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            carregaFragment(bundle);
        }
    }
        private void carregaFragment(Bundle bundle) {
            String tipoAtleta = bundle.getString("tipoAtleta");
            if (tipoAtleta != null) {
                if (tipoAtleta.equals("Atleta Juvenil")) {
                    fragment = new AtletaJuvenilFragment();
                } else if (tipoAtleta.equals("Atleta Senior")) {
                    fragment = new AtletaSeniorFragment();
                } else if (tipoAtleta.equals("Outro Atleta")) {
                    fragment = new OutroAtletaFragment();
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.commit();
            }
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            Bundle bundle = new Bundle();
            Intent intent = new Intent(this, MainActivity.class);

            if (id == R.id.menu_juvenil) {
                bundle.putString("tipoAtleta", "Atleta Juvenil");

                intent.putExtras(bundle);
                this.startActivity(intent);
                this.finish();
                return true;
            }
            if (id == R.id.menu_senior) {
                bundle.putString("tipoAtleta", "Atleta Senior");

                intent.putExtras(bundle);
                this.startActivity(intent);
                this.finish();
                return true;

            }
            if (id == R.id.menu_outro) {
                bundle.putString("tipoAtleta", "Outro Atleta");

                intent.putExtras(bundle);
                this.startActivity(intent);
                this.finish();
                return true;

            }
            return super.onOptionsItemSelected(item);

        }
    }