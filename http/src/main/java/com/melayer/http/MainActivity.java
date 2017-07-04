package com.melayer.http;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.melayer.http.domain.Article;
import com.melayer.http.domain.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();

        loadNews();
    }

    private void loadNews() {

        final List<String> news = new ArrayList<>();

        final ProgressDialog pd = ProgressDialog.show(this,"","");

        ((App) getApplication()).q().add(new StringRequest(
                "https://newsapi.org/v1/articles?source=techcrunch&apiKey=553e53687a894c809099c75ee122b8de",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        News nws = gson.fromJson(response, News.class);
                        for (Article article : nws.getArticles()) {
                            news.add(article.getTitle()+"\n"+article.getDescription());
                        }
                        populateList(news);

                        pd.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                    }
                }
        ));
    }

    private void populateList(List<String> dataSet) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
    }
}
