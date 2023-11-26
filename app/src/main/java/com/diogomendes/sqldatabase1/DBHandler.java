package com.diogomendes.sqldatabase1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "cardsdb.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "businessCards";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our name column
    private static final String NAME_COL = "Name";

    // below variable id for our email column.
    private static final String EMAIL_COL = "Email";

    // below variable for our course description column.
    private static final String JOB_COL = "Job";

    // below variable is for our course tracks column.
    private static final String DEGREE_COL = "Degree";
    private static final String PHONE_NUMBER_COL = "Phone";

    // below variable is for our course tracks column.
    private static final String LINKEDIN_COL = "LinkedIn";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + JOB_COL + " TEXT,"
                + DEGREE_COL + " TEXT,"
                + PHONE_NUMBER_COL + " TEXT,"
                + LINKEDIN_COL + " TEXT);";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);

        boolean first = this.addNewCard("Felonious Gru", "fel_gru@gmail.com", "CEO","Master in Management" , "927135904", "https://www.linkedin.com/in/francisco-nneves/", db);
        boolean second = this.addNewCard("Kevin Minion", "min_kevin@gmail.com", "COO", "Master in Evil Sciences", "927135905", "https://www.linkedin.com/in/francisco-nneves/", db);
        boolean third = this.addNewCard("Stuart Minion", "min_stuart@gmail.com", "Assistant Regional Manager", "Bachelor in Evil Sciences", "927135909","https://www.imdb.com/title/tt2293640/", db);
        boolean fourth = this.addNewCard("Bob Minion", "min_bob@gmail.com", "Cleaning Staff","4th grade" ,"960276377", "https://www.imdb.com/title/tt2293640/", db);
        boolean fifth = this.addNewCard("Dr. Nefario", "dr_nefario@gmail.com","Founder", "Doctorate in Evil Sciences", "960276377", "https://despicableme.fandom.com/wiki/Dr._Nefario", db);
        boolean sixth = this.addNewCard("Dr. Doofenshmirtz", "dr:doof@gmail.com", "Quality Control Coordinator", "Doctorate in Evil Management", "999999999","https://phineaseferb.fandom.com/pt-br/wiki/Heinz_Doofenshmirtz", db);
    }

    // this method is use to add new course to our sqlite database.
    public boolean addNewCard(String name, String email, String job, String degree, String phoneNumber, String linkedin, SQLiteDatabase db) {
        // on below line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.

        //SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(EMAIL_COL, email);
        values.put(JOB_COL, job);
        values.put(DEGREE_COL, degree);
        values.put(PHONE_NUMBER_COL, phoneNumber);
        values.put(LINKEDIN_COL,linkedin);

        try {
            // after adding all values we are passing content values to our table.
            long result = db.insert(TABLE_NAME, null, values);
            //db.close();
            if (result == -1) {
                // Log an error message if insertion fails
                Log.e("DBHandler", "Error inserting data into the database");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            // Log any exceptions that occur during insertion
            Log.e("DBHandler", "Exception during database insertion: " + e.getMessage());
            return false;
        }

    }

        Cursor readAllData(){
            String query = "SELECT * FROM " + TABLE_NAME;
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = null;
            if(db != null){
                cursor = db.rawQuery(query, null);
            }
            return cursor;
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHandler.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

