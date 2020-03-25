package submmision.sliit.tutorial04.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="UserInfo.db";

    public DBHandler (Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIS =
                "CREATE TABLE " + UserMaster.Users.TABLE_NAME + " {" +
                        UserMaster.Users._ID + "INTEGER PRIMARY KEY," +
                        UserMaster.Users.COLUMN_NAME_USERNAME + "TEXT," +
                        UserMaster.Users.COLUMN_NAME_PASSWORD + "TEXT,";

        db.execSQL(SQL_CREATE_ENTRIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInfo(String userName, String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_USERNAME, userName);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD, password);

        long newRowId = db.insert(UserMaster.Users.TABLE_NAME, null, values);
    }
}
