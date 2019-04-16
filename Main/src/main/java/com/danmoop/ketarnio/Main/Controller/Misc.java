package com.danmoop.ketarnio.Main.Controller;

import com.google.gson.Gson;
import org.json.JSONObject;

class Misc
{
    private static Gson gson = new Gson();

    static JSONObject getJSON(Object object)
    {
        String json = gson.toJson(object);

        return new JSONObject(json);
    }
}