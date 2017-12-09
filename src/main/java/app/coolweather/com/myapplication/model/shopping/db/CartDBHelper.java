package app.coolweather.com.myapplication.model.shopping.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Administrator on 2017/11/11.
 */

public class CartDBHelper extends SQLiteOpenHelper {
    //数据库名
    private static final String NAME = "shopping_cart.db3";
    //数据库版本号
    private static final int VERSION = 1;
    //上下文
    private static Context mContext;
    //自定义帮助类
    private static CartDBHelper dbHelper;

    //初始化、
    private void init(Context mContext){
        this.mContext = mContext ;
    }

    public static CartDBHelper getInstance(){
        if(dbHelper == null){
            dbHelper = new CartDBHelper();
        }
        return dbHelper;
    }


    public CartDBHelper() {

        super(mContext, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE shopping_cart (id integer primary key autoincrement, price varchar(20), age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE person ADD phone VARCHAR(12)");
    }

}
