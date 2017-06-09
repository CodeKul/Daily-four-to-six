package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();
    }

    private void simple() {
        List<String> names = new ArrayList<>();
        names.add("Mobile");
        names.add("Mouse");
        names.add("Bullet");
        names.add("Tv");
        names.add("Bike");
        names.add("Cable");
        names.add("Phone");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        ((ListView)findViewById(R.id.listNames)).setAdapter(adapter);
    }

    private void custom() {
        final List<Item> names = new ArrayList<>();
        names.add(new Item(R.drawable.ic_alarm_black_24dp, "Alarm"));
        names.add(new Item(R.drawable.ic_beach_access_black_24dp, "Beach Access"));
        names.add(new Item(R.drawable.ic_cake_black_24dp, "Cake"));
        names.add(new Item(R.drawable.ic_cast_connected_black_24dp, "Cake"));
        names.add(new Item(R.drawable.ic_favorite_black_24dp, "Favorite"));
        names.add(new Item(R.drawable.ic_thumb_down_black_24dp, "Thumb Down"));

        CustomAdapter adapter = new CustomAdapter(this, names);
        ((ListView)findViewById(R.id.listNames)).setAdapter(adapter);
    }

    public void onAdd(View view) {
        String nm = ((EditText)findViewById(R.id.etName)).getText().toString();
        Item item = new Item(R.mipmap.ic_launcher_round, nm);
        ((CustomAdapter)((ListView)findViewById(R.id.listNames)).getAdapter()).addItem(item);
    }
}
