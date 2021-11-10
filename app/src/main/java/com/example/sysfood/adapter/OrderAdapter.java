package com.example.sysfood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysfood.All_Orders;
import com.example.sysfood.R;
import com.example.sysfood.model.AsianFood;
import com.example.sysfood.model.OrderModel;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{


    Context context;

    public OrderAdapter(Context context, List<OrderModel> orderModelList) {
        this.context = context;
        this.orderModelList = orderModelList;
    }

    List<OrderModel> orderModelList;





    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order_sample, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrderModel model = orderModelList.get(position);
        holder.orderImage.setImageResource(model.getImageURL());
        holder.price.setText(model.getPrice());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.soldItemName.setText(model.getSoldItemName());
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public static final class viewHolder extends RecyclerView.ViewHolder {

        ImageView orderImage;
        TextView price, orderNumber, soldItemName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.image);
            price = itemView.findViewById(R.id.as_price);
            orderNumber = itemView.findViewById(R.id.order_no);
            soldItemName = itemView.findViewById(R.id.sample_name);
        }
    }
}
