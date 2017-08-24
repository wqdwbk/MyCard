package com.tallto.card;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.tallto.card.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        makeActionOverflowMenuShown();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<CardItem> arrayList = new ArrayList<>();

        arrayList.add(new CardItem("abc"));
        arrayList.add(new CardItem("spdb"));
        arrayList.add(new CardItem("icbc"));
        binding.recyclerView.setAdapter(new ExpandableRecyclerViewAdapter(arrayList));
    }

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

        switch (id){
            case R.id.action_material:
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_circles:
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_water_drop:
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ring:
                Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    private void makeActionOverflowMenuShown() {
//        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
//        try {
//            ViewConfiguration config = ViewConfiguration.get(this);
//            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
//            if (menuKeyField != null) {
//                menuKeyField.setAccessible(true);
//                menuKeyField.setBoolean(config, false);
//            }
//        } catch (Exception e) {
//
//        }
//    }
}
