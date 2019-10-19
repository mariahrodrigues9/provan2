package com.zomercorporation.mariah;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conversor {


    public Pessoa getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        Pessoa retorno = parseJson(json);
        return retorno;
    }

    private Pessoa parseJson(String json){
        try {
            Pessoa pessoa = new Pessoa();

            JSONObject obj = new JSONObject(json);

            pessoa.setNome(obj.getString("name"));
            pessoa.setLogin(obj.getString("login"));
            pessoa.setUrl(obj.getString("url"));
            pessoa.setType(obj.getString("type"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;

    }

}
