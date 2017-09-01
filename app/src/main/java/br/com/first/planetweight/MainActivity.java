package br.com.first.planetweight;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final String planetJson = "{\n" +
            "  \"planetas\": [\n" +
            "   {\n" +
            "      \"nome\": \"Mercúrio\",\n" +
            "      \"forca_gravitacional\" : 3.7,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#858585\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Vênus\",\n" +
            "      \"forca_gravitacional\" : 8.87,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#c18425\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Terra\",\n" +
            "      \"forca_gravitacional\" : 9.807,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#2f3a89\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Marte\",\n" +
            "      \"forca_gravitacional\" : 3.711,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#c75147\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Júpiter\",\n" +
            "      \"forca_gravitacional\" : 24.79,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#c38951\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Saturno\",\n" +
            "      \"forca_gravitacional\" : 10.44,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#ffe0b2\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Urano\",\n" +
            "      \"forca_gravitacional\" : 8.69,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#add4d9\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Netuno\",\n" +
            "      \"forca_gravitacional\" : 11.15,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#4474fe\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"nome\": \"Plutão\",\n" +
            "      \"forca_gravitacional\" : 0.62,\n" +
            "      \"imagem\" : \"\",\n" +
            "      \"cor\": \"#bb9c82\"\n" +
            "    }\n" +
            "    \n" +
            " ]\n" +
            "}";

    public JSONArray planetArray;
    public JSONObject thePlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mercuryBtn).setOnClickListener(this);
        findViewById(R.id.venusBtn).setOnClickListener(this);
        findViewById(R.id.earthBtn).setOnClickListener(this);
        findViewById(R.id.marsBtn).setOnClickListener(this);
        findViewById(R.id.jupiterBtn).setOnClickListener(this);
        findViewById(R.id.saturnBtn).setOnClickListener(this);
        findViewById(R.id.uranusBtn).setOnClickListener(this);
        findViewById(R.id.neptuneBtn).setOnClickListener(this);
        findViewById(R.id.plutoBtn).setOnClickListener(this);

        try {
            JSONObject planetObj = new JSONObject(planetJson);
            planetArray = planetObj.getJSONArray("planetas");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.mercuryBtn) {
            thePlanet = planetArray.optJSONObject(0);
        } else if (id == R.id.venusBtn) {
            thePlanet = planetArray.optJSONObject(1);
        } else if (id == R.id.earthBtn) {
            thePlanet = planetArray.optJSONObject(2);
        } else if (id == R.id.marsBtn) {
            thePlanet = planetArray.optJSONObject(3);
        } else if (id == R.id.jupiterBtn) {
            thePlanet = planetArray.optJSONObject(4);
        } else if (id == R.id.saturnBtn) {
            thePlanet = planetArray.optJSONObject(5);
        } else if (id == R.id.uranusBtn) {
            thePlanet = planetArray.optJSONObject(6);
        } else if (id == R.id.neptuneBtn) {
            thePlanet = planetArray.optJSONObject(7);
        } else if (id == R.id.plutoBtn) {
            thePlanet = planetArray.optJSONObject(8);
        }

        double weightFinal = calculateWeight(thePlanet.optDouble("forca_gravitacional"));
        String nameFinal = thePlanet.optString("nome");

        Builder builder = new Builder(this);
        builder.setMessage(weightFinal + "N");
        builder.setTitle("Seu peso em " + nameFinal);
        builder.show();

    }

    public double calculateWeight(double gravity){
        EditText editText = (EditText) findViewById(R.id.editText);
        double aDouble = Double.parseDouble(editText.getText().toString());

        return Math.round(aDouble * gravity);
    }
}

