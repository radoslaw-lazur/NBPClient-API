package com.crud.nbpclient.service.jsonreader;

import com.crud.nbpclient.domain.chf.DtoChf;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NoArgsConstructor
public class JsonReaderChf {
    private DtoChf chf = new DtoChf();

    public DtoChf prepareChfToDb(String jsonString) {
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
            chf.setName(code);
            chf.setDate(date);
            chf.setMidPLN(mid);
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return chf;
    }
}
