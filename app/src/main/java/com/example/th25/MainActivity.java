package com.example.th25;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtDishName;
    private Spinner spinnerThumbnail;
    private CheckBox chkPromotion;
    private Button btnAddDish;
    private GridView gridViewDishes;

    private List<Dish> dishList;
    private DishAdapter dishAdapter;
    private ThumbnailType selectedThumbnail = ThumbnailType.Thumbnail1; // Mặc định

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtDishName = findViewById(R.id.edtDishName);
        spinnerThumbnail = findViewById(R.id.spinnerThumbnail);
        chkPromotion = findViewById(R.id.chkPromotion);
        btnAddDish = findViewById(R.id.btnAddDish);
        gridViewDishes = findViewById(R.id.gridViewDishes);

        // Danh sách món ăn
        dishList = new ArrayList<>();
        dishAdapter = new DishAdapter(this, dishList);
        gridViewDishes.setAdapter(dishAdapter);

        // Thiết lập Adapter cho Spinner
        ArrayAdapter<ThumbnailType> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, ThumbnailType.values()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThumbnail.setAdapter(adapter);

        // Xử lý sự kiện khi chọn thumbnail từ Spinner
        spinnerThumbnail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedThumbnail = (ThumbnailType) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedThumbnail = ThumbnailType.Thumbnail1;
            }
        });

        // Xử lý sự kiện khi nhấn nút "ADD A NEW DISH"
        btnAddDish.setOnClickListener(v -> {
            String dishName = edtDishName.getText().toString().trim();
            boolean isPromotion = chkPromotion.isChecked();

            if (dishName.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a dish name", Toast.LENGTH_SHORT).show();
                return;
            }

            // Thêm món ăn vào danh sách
            Dish newDish = new Dish(dishName, selectedThumbnail.getImg(), isPromotion);
            dishList.add(newDish);
            dishAdapter.notifyDataSetChanged(); // Cập nhật danh sách món ăn

            // Xóa dữ liệu nhập vào
            edtDishName.setText("");
            chkPromotion.setChecked(false);
            spinnerThumbnail.setSelection(0);
        });
    }

}
