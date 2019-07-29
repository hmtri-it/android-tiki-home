package vn.tiki.android.tikihome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import vn.tiki.android.tikihome.R;
import vn.tiki.android.tikihome.model.Sale;

public class SalesViewPagerAdapter extends PagerAdapter {

    private List<Sale> sales;
    private Context context;
    private ClickListener clickListener;

    public SalesViewPagerAdapter(List<Sale> sales, Context context) {
        this.sales = sales;
        this.context = context;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getCount() {
        return sales.size ();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals ( object );
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from ( container.getContext () ).inflate ( R.layout.item_sales_view_pager, container, false );
        ImageView imgSale = view.findViewById ( R.id.imgTikiSale );
        int strProduct = sales.get ( position ).getImgSale ();
        imgSale.setImageResource ( strProduct );
        container.addView ( view, 0 );
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ( (View) object );
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }
}