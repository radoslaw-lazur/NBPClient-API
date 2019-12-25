package com.crud.nbpclient.service.jsonreader;

import com.crud.nbpclient.domain.eur.DtoEur;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NoArgsConstructor
public class JsonReaderEur {
    private DtoEur eur = new DtoEur();

    public DtoEur prepareEurToDb(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("rates");
            String code = jsonObject.getString("code");
            String date = "";
            double mid = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                date = jsonArray.getJSONObject(i).getString("effectiveDate");
                mid = (double) jsonArray.getJSONObject(i).get("mid");
            }
            eur.setName(code);
            eur.setDate(date);
            eur.setMidPLN(mid);
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return eur;
    }
}
