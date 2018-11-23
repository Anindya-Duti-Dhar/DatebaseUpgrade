package duti.com.databaseupgrade.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static duti.com.databaseupgrade.database.FieldConstants.DATABASE_VERSION;
import static duti.com.databaseupgrade.database.FieldConstants.DB_NAME;
import static duti.com.databaseupgrade.database.FieldConstants.TABLE_STATEMENT_ALL_STUDENT;
import static duti.com.databaseupgrade.database.FieldConstants.TABLE_STATEMENT_ALL_STUDENT_V2;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("duti", "--- onCreate database ---");
        // statement for create table
        db.execSQL(TABLE_STATEMENT_ALL_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("duti", "--- onUpgrade database ---");
        int upgradeTo = oldVersion + 1;
        while (upgradeTo <= newVersion)
        {
            switch (upgradeTo)
            {
                case 2:
                    db.execSQL(TABLE_STATEMENT_ALL_STUDENT_V2);
                    break;
            }
            upgradeTo++;
        }
    }

    //https://stackoverflow.com/questions/805363/how-do-i-rename-a-column-in-a-sqlite-database-table
    //http://www.sqlitetutorial.net/sqlite-alter-table/
    //https://umeshsaravane.wordpress.com/2015/12/29/new-blog/
    //http://experiments-on-android.blogspot.com/2013/05/insert-new-column-in-table-of-sqlite.html
    //https://medium.com/@elye.project/android-sqlite-database-migration-b9ad47811d34

}
