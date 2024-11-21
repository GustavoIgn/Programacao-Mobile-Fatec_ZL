package br.edu.fateczl.ex_16;

/*
@author:<Gustavo da Silva Ignácio 1110482313006>
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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
	
	private Fragment fragment;

     @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets)->{
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
		// Carrega o fragmento baseado nos dados do Bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            carregaFragment(bundle);
        }
    }

    private void carregaFragment(Bundle bundle) {
        String tipoItem = bundle.getString("tipoItem");
        if (tipoItem != null) {
            if (tipoItem.equals("Livro")) {
                //fragment = new FragmentLivros();
            } else if (tipoItem.equals("Revista")) {
                //fragment = new FragmentRevistas();
            } else if (tipoItem.equals("Aluno")) {
                fragment = new FragmentAluno();
            } else if (tipoItem.equals("Aluguel")) {
				fragment = new FragmentAluguel();
			}

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, fragment);
            fragmentTransaction.commit();
        }
    }

     @ Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

     @ Override
    public boolean onOptionsItemSelected( @ NonNull MenuItem item) {
        int id = item.getItemId();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if (id == R.id.menu_livro) {
            bundle.putString("tipoItem", "Livro");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if (id == R.id.menu_revista) {
            bundle.putString("tipoItem", "Revista");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
        if (id == R.id.menu_aluno) {
            bundle.putString("tipoItem", "Aluno");

            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        }
		if (id == R.id.menu_aluguel) {
			bundle.putString("tipoItem", "Aluguel");
			
			intent.putExtras(bundle);
			this.startActivity(intent);
			this.finish();
			return true;
		}
		
        return super.onOptionsItemSelected(item);
    }
}