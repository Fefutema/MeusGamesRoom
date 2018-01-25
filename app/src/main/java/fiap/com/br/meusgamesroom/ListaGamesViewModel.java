package fiap.com.br.meusgamesroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import fiap.com.br.meusgamesroom.dao.BancoDeDados;
import fiap.com.br.meusgamesroom.model.Game;

/**
 * Created by logonrm on 24/01/2018.
 */

public class ListaGamesViewModel extends AndroidViewModel{

    private LiveData<List<Game>> games;
    private BancoDeDados bd;

    public ListaGamesViewModel(Application application) {
        super(application);
        bd = BancoDeDados.getDatabase(application.getApplicationContext());
        carregarDados();
    }
    public LiveData<List<Game>> getGames() {
        return games;
    }
    private void carregarDados() {
//Carregar os dados da nossa Base de dados e armazenar no LiveData
                games = bd.gameDAO().lerGames();
    }

}
