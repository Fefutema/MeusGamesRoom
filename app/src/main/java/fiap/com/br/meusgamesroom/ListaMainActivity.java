package fiap.com.br.meusgamesroom;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import fiap.com.br.meusgamesroom.model.Game;

public class ListaMainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView rvGames;
    private GameAdapter adapter;
    private List<Game> games;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        rvGames = (RecyclerView) findViewById(R.id.rvGames);
        games = new ArrayList<>();
        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//Abre o dialog para adicionar um novo jogo
                NovoGameDialog dialog = new NovoGameDialog();
                dialog.show(getFragmentManager(), "CriarJogo");
            }
        });
        mostrarDados();
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GameAdapter(games);
        rvGames.setAdapter(adapter);
    }

    private void mostrarDados() {
//of() — indica a activity ou Fragment em que o ViewModel será utilizado
//get() — indica o ViewModel que será utilizado.
        ViewModelProviders.of(this)
                .get(ListaGamesViewModel.class)
                .getGames()
                .observe(this, new Observer<List<Game>>() {
                    @Override
                    public void onChanged(@Nullable List<Game>
                                                  tarefas) {
                        adapter.setList(tarefas);
                        rvGames.getAdapter().notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

