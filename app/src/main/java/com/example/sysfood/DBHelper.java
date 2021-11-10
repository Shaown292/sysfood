package com.example.sysfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sysfood.model.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db" ;
    final static int DBVersion = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL(
               "create table orders(" +
                       "id integer primary key autoincrement," +
                       "price int," +
                       "image int," +
                       "description text," +
                       "foodname text," +
                       "quantity int )"
       );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);

    }
    public boolean insertOrder (int price, int image, String desc, String foodname, int qiu){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodname);
        values.put("quantity", qiu);
        long id = database.insert("orders", null, values);
        if (id <=0){
            return false;
        }
        else return true;
    }
//    public ArrayList <OrderModel> getOrder (){
//        ArrayList<OrderModel> orders = new ArrayList<>();
//        SQLiteDatabase database = this.getWritableDatabase();
//        Cursor cursor = database.rawQuery("Select id,  price,  image, foodname from orders", null);
//
//        if (cursor.moveToFirst()) {
//
//            while (cursor.moveToNext()) {
//           OrderModel model = new OrderModel();
//           model.setOrderNumber(cursor.getInt(0)+"");
//           model.setPrice(cursor.getInt(1)+ "");
//           model.setImageURL(cursor.getInt(2));
////           model.setSoldItemName(cursor.getString(4));
//           orders.add(model);
//
//            }
//
//
//        }
//
//
//        cursor.close();
//        database.close();
//        return orders;
//
//
//    }
}
