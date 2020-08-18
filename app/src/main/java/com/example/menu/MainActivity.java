package com.example.menu;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.graphics.Color.BLUE;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    Button btnClick1;
    RelativeLayout manHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.btn_Click);
        btnClick1 = findViewById(R.id.btn_Click1);
        manHinh = findViewById(R.id.manHinh);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
        registerForContextMenu(btnClick1);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        menu.setHeaderTitle("Chọn màu");
        menu.setHeaderIcon(R.drawable.ic_launcher_background);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    //Context Menu
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuYellow:
                manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuRed:
                manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuBlue:
                manHinh.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuBlack:
                manHinh.setBackgroundColor(Color.BLACK);
                break;
        }
        return super.onContextItemSelected(item);
    }
    //Popupmenu
    private void showMenu() {
       PopupMenu popupMenu = new PopupMenu(MainActivity.this,btnClick);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuSearch:
                        Toast.makeText(MainActivity.this,"3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuShare:
                        Toast.makeText(MainActivity.this,"2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuSetting:
                        Toast.makeText(MainActivity.this,"1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuContact:
                        Toast.makeText(MainActivity.this,"4", Toast.LENGTH_SHORT).show();
                        break;}
                return false;
            }
        });
        popupMenu.show();
    }
}