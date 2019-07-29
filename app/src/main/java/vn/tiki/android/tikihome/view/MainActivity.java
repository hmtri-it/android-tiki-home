package vn.tiki.android.tikihome.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import vn.tiki.android.tikihome.R;
import vn.tiki.android.tikihome.adapter.ProductAdapter;
import vn.tiki.android.tikihome.adapter.SalesViewPagerAdapter;
import vn.tiki.android.tikihome.model.Product;
import vn.tiki.android.tikihome.model.Sale;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "keywords.json";
    private ViewPager viewPagerSale;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        intView();
        initSaleAdapter();
        initProductAdapter();
    }

    /**
     * Init View
     */
    private void intView() {
        setContentView ( R.layout.activity_main );
        recyclerView = findViewById ( R.id.recyclerProduct );
        viewPagerSale = findViewById ( R.id.viewPagerProduct );
    }

    /**
     * Init SaleAdapter
     */
    private void initSaleAdapter() {
        SalesViewPagerAdapter salesViewPagerAdapter = new SalesViewPagerAdapter(imageTikiSales(), this);
        viewPagerSale.setAdapter(salesViewPagerAdapter);
        viewPagerSale.setPadding(20, 0, 150, 0);
        salesViewPagerAdapter.notifyDataSetChanged();

    }

    /**
     * Pares List image Sale
     *
     * @return
     */
    private List<Sale> imageTikiSales() {
        int[] myImageList = new int[]{R.drawable.tiki_watch, R.drawable.tiki_phone, R.drawable.tiki_xemay, R.drawable.tiki_diengiadung};
        List<Sale> sales = new ArrayList<>();
        for (int imgsale : myImageList) {
            Sale sale = new Sale();
            sale.setImgSale(imgsale);
            sales.add(sale);
        }
        return sales;
    }

    /**
     * Init ProductAdapter
     */
    private void initProductAdapter() {
        ProductAdapter productAdapter = new ProductAdapter(this, parseDataFromAsset ());
        recyclerView.setAdapter(productAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setClipToPadding(false);
        recyclerView.setNestedScrollingEnabled(true);
        productAdapter.notifyDataSetChanged();
    }

    /**
     * Parse data
     *
     * @return
     */
    private List<Product> parseDataFromAsset() {
        String data = loadDataFromAsset();
        List<Product> products = new ArrayList<> ();
        String[] arr = data.substring(2, data.length() - 3).split(",\n");
        for (String keyword : arr) {
            keyword = keyword.substring(1, keyword.length() - 1);
            int len = keyword.length(), index = -1, val = len;
            for (int i = 0; i < len; i++) {
                if (keyword.charAt(i) == ' '){
                    if (val > Math.abs(len - 2*i-1)){
                        val = Math.abs(len - 2*i-1);
                        index = i;
                    }
                }
            }

            if (index > -1)
                products.add(new Product(keyword.substring(0, index) + "\n" + keyword.substring(index + 1) + "\n"));
            else
                products.add(new Product(keyword));

        }
        return products;
    }

    /**
     * Load Data from Asset
     *
     * @return data
     */
    private String loadDataFromAsset() {
        String data = null;
        try {
            InputStream is = getApplicationContext().getAssets().open(FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            data = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}
