package com.example.simpleshoppingcartexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.load.model.ByteArrayLoader;
import com.example.simpleshoppingcartexample.Adapter.ProductAdapter;
import com.example.simpleshoppingcartexample.Model.ProductModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addProduct();
        productAdapter = new ProductAdapter(arrayList, this,  this);
        productRecyclerView = findViewById(R.id.product_recycler_view);


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);

//                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        productRecyclerView.setLayoutManager(layoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }


    private void addProduct() {
        ProductModel productModel = new ProductModel("Bag", "10", "20", R.drawable.bag);
        arrayList.add(productModel);
        ProductModel productModel1 = new ProductModel("Shoe", "20", "10", R.drawable.shoe);
        arrayList.add(productModel1);
        ProductModel productModel2 = new ProductModel("Springroll", "30", "10", R.drawable.springrolls);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("burger", "40", "20", R.drawable.burger);
        arrayList.add(productModel3);
        ProductModel productModel12 = new ProductModel("chicken", "50", "10", R.drawable.chicken);
        arrayList.add(productModel12);
        ProductModel productModel23 = new ProductModel("colddrink", "60", "10", R.drawable.colddrink);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("momos", "70", "20", R.drawable.momos);
        arrayList.add(productModel4);
        ProductModel productModel14 = new ProductModel("noodles", "80", "10", R.drawable.noodles);
        arrayList.add(productModel14);
        ProductModel productModel25 = new ProductModel("pizza", "90", "10", R.drawable.pizza);
        arrayList.add(productModel25);

        ProductModel productModel5 = new ProductModel("roll", "100", "20", R.drawable.roll);
        arrayList.add(productModel5);
        ProductModel productModel16 = new ProductModel("sandwich", "200", "10", R.drawable.sandwich);
        arrayList.add(productModel16);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }



    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }
}
