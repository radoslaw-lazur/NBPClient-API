package com.crud.nbpclient.service.jsonreader;

import com.crud.nbpclient.domain.eur.DtoEur;
import com.crud.nbpclient.domain.gbp.DtoGbp;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NoArgsConstructor
public class JsonReaderGbp {
    private DtoGbp gbp = new DtoGbp();

    public DtoGbp prepareGbpToDb(String jsonString) {
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
            gbp.setName(code);
            gbp.setDate(date);
            gbp.setMidPLN(mid);
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return gbp;
    }
}
