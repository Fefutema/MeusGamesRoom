package fiap.com.br.meusgamesroom;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fiap.com.br.meusgamesroom.dao.BancoDeDados;
import fiap.com.br.meusgamesroom.model.Game;

/**
 * Created by logonrm on 24/01/2018.
 */

public class NovoGameDialog extends DialogFragment {

    private AlertDialog.Builder builder;
    private EditText etGame, etPlataforma;

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.novo_game_dialog, null);
        etGame = (EditText) v.findViewById(R.id.etGame);
        etPlataforma =
                (EditText)v.findViewById(R.id.etPlataforma);
        builder.setView(v);
        builder.setTitle("Novo Game");
        builder.setPositiveButton("Adicionar", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        BancoDeDados db =
                                BancoDeDados.getDatabase(getActivity().getApplicationContext());
                        Game game = new Game(etGame.getText().toString(),
                                etPlataforma.getText().toString());
                        if(!game.getNome().equalsIgnoreCase(""))
                            new InsertAsyncTask(db).execute(game);
                    }
                });
        builder.setNegativeButton("Cancelar", null);
        return builder.create();
    }
    private class InsertAsyncTask extends AsyncTask<Game, Void,
                Void> {
        private BancoDeDados db;
        InsertAsyncTask(BancoDeDados appDatabase) {
            db = appDatabase;
        }
        @Override
        protected Void doInBackground(final Game... params) {
            db.gameDAO().inserir(params[0]);
            return null;
        }
    }
}

