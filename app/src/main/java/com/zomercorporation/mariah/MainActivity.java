package com.zomercorporation.mariah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView id;
    private TextView login;
    private TextView url;
    private TextView type;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        nome = (TextView)findViewById(R.id.formulario_nome);
        id = (TextView)findViewById(R.id.formulario_id);
        login = (TextView)findViewById(R.id.formulario_login);
        url = (TextView)findViewById(R.id.formulario_url);
        type = (TextView)findViewById(R.id.formulario_type);

        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, Pessoa> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Pessoa doInBackground(Void... params) {
            Conversor util = new Conversor();
            return util.getInformacao("https://api.github.com/users/teste1");
        }

        @Override
        protected void onPostExecute(Pessoa pessoa){

                nome.setText(pessoa.getNome());
                id.setText(pessoa.getId());
                login.setText(pessoa.getLogin());
                url.setText(pessoa.getUrl());
                type.setText(pessoa.getType());
                load.dismiss();



            }
        }
    }