package com.example.narayanaraj.helloworld;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String URL = "http://127.0.0.1:3000/api/TamoUsers/1?access_token=FqwBD3LhSlIpAzPLvz0MI4y04R0mg3EVWmcW2lXoELAXT3tNrQfQ2dKxKHPHx9t3";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("rest REsponse", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("rest REsponse", error.toString());
                    }
                }

        );

        requestQueue.add(jsonObjectRequest);



        /*final TextView TextviewUserName = (TextView) findViewById(R.id.txtUserName);
        TextviewUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (TextviewUserName.getText().equals("User Name"))
                    TextviewUserName.setText("");
            }
        });

        final TextView TextviewPassword = (TextView) findViewById(R.id.txtPassword);
        TextviewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (TextviewPassword.getText().equals("password"))
                    TextviewPassword.setText("");
            }
        });*/
    }

    /*public void postData() throws IOException {
        // Create a new HttpClient and Post Header
        Log.d("TAMO","Before Call");
        String text = "";
        BufferedReader reader=null;
        final TextView TextviewUserName = (TextView) findViewById(R.id.txtUserName);
        final TextView TextviewPassword = (TextView) findViewById(R.id.txtPassword);

        String userName =  TextviewUserName.getText().toString();
        String password =  TextviewPassword.getText().toString();

        String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8");
        data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

        URL url = new URL("http://localhost:3000/api/TamoUsers/login");
        URLConnection conn = url.openConnection();

        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write( data );
        wr.flush();

        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while((line = reader.readLine()) != null)
        {
            // Append server response in string
            sb.append(line + "\n");
        }


        text = sb.toString();
        Log.d("output", text);
        reader.close();
    }
*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClickTxtUserName(View view) {
        TextView modelTextview;
        modelTextview = (TextView)findViewById(R.id.txtUserName);
//        modelTextview.setText("");
    }

    public void onClickTxtPassword(View view) {
        TextView modelTextview;
        modelTextview = (TextView)findViewById(R.id.txtPassword);
//        modelTextview.setText("");
    }

    public void Login(View view) {
        /*try {
//            postData();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
