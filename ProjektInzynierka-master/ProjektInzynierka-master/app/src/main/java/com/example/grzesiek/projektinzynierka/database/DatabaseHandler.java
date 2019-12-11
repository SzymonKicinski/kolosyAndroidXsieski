package com.example.grzesiek.projektinzynierka.database;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.grzesiek.projektinzynierka.CircuitChart;
import com.example.grzesiek.projektinzynierka.CircuitChart2;
import com.example.grzesiek.projektinzynierka.WeightChart;
import com.example.grzesiek.projektinzynierka.activities.CirciutListActivity;
import com.example.grzesiek.projektinzynierka.activities.CircuitActivity;
import com.example.grzesiek.projektinzynierka.activities.InformationActivity;
import com.example.grzesiek.projektinzynierka.activities.MainActivity;
import com.example.grzesiek.projektinzynierka.activities.WeightActivity;
import com.example.grzesiek.projektinzynierka.activities.WeightListActivity;
import com.example.grzesiek.projektinzynierka.domain.Circuit;
import com.example.grzesiek.projektinzynierka.domain.Information;
import com.example.grzesiek.projektinzynierka.domain.Weight;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "databaseApp";

    private static final String TABLE_INFORMATION = "information";

    private static final String INF_ID = "id";
    private static final String INF_NAME = "name";
    private static final String INF_HEIGHT = "height";
    private static final String INF_WEIGHT = "weight";
    private static final String INF_TARGETWEIGHT = "targetWeight";
    private static final String INF_AGE = "age";

    private static final String TABLE_WEIGHT = "weight";

    private static final String WG_ID = "id";
    private static final String WG_YEAR = "year";
    private static final String WG_MONTH = "month";
    private static final String WG_DAY = "day";
    private static final String WG_WEIGHT = "weight";

    private static final String TABLE_CIRCUIT = "circuit";

    private static final String OB_ID = "id";
    private static final String OB_YEAR = "year";
    private static final String OB_MONTH = "month";
    private static final String OB_DAY = "day";
    private static final String OB_CHEST = "chest";
    private static final String OB_WAIST = "waist";


    public DatabaseHandler(MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public DatabaseHandler(InformationActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(WeightActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(CircuitActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public DatabaseHandler(CirciutListActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(WeightListActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(WeightChart context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(CircuitChart context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(CircuitChart2 context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INFROMATION_TABLE = "CREATE TABLE " + TABLE_INFORMATION + "("
                + INF_ID + " INTEGER PRIMARY KEY," + INF_NAME + " TEXT,"
                + INF_HEIGHT + " INT," + INF_WEIGHT + " REAL,"
                + INF_TARGETWEIGHT + " REAL," + INF_AGE + " INT" + ")";

        String CREATE_WEIGHT_TABLE = "CREATE TABLE " + TABLE_WEIGHT + "("
                + WG_ID + " INTEGER PRIMARY KEY," + WG_YEAR + " INT," + WG_MONTH + " INT," + WG_DAY + " INT,"
                + WG_WEIGHT + " REAL" + ")";

        String CREATE_OB_TABLE = "CREATE TABLE " + TABLE_CIRCUIT + "("
                + OB_ID + " INTEGER PRIMARY KEY," + OB_YEAR + " INT," + OB_MONTH + " INT," + OB_DAY + " INT,"
                + OB_CHEST + " REAL," + OB_WAIST + " REAL" + ")";



        db.execSQL(CREATE_INFROMATION_TABLE);
        db.execSQL(CREATE_WEIGHT_TABLE);
        db.execSQL(CREATE_OB_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFORMATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CIRCUIT);

        onCreate(db);
    }

// CRUD operation (Create, Read, Update, Delete)

    //adding new Information
    public void addInformation(Information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(INF_NAME, information.getName());
        values.put(INF_HEIGHT, information.getHeight());
        values.put(INF_WEIGHT, information.getWeight());
        values.put(INF_TARGETWEIGHT, information.getTargetWeight());
        values.put(INF_AGE, information.getAge());
        db.insert(TABLE_INFORMATION, null, values);
        db.close();
    }

    public void addWeight (Weight weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WG_YEAR, weight.getYear());
        values.put(WG_MONTH, weight.getMonth());
        values.put(WG_DAY, weight.getDay());
        values.put(WG_WEIGHT, weight.getWeight());
        db.insert(TABLE_WEIGHT, null, values);
        db.close();
    }

    public void addCircuit(Circuit circuit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OB_YEAR, circuit.getYear());
        values.put(OB_MONTH, circuit.getMonth());
        values.put(OB_DAY, circuit.getDay());
        values.put(OB_CHEST, circuit.getChest());
        values.put(OB_WAIST, circuit.getWaist());
        db.insert(TABLE_CIRCUIT, null, values);
        db.close();
    }


    //getting single information
    public Information getInformation(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_INFORMATION, new String[]{INF_ID, INF_NAME,
                        INF_HEIGHT, INF_WEIGHT, INF_TARGETWEIGHT, INF_AGE},
                INF_ID + "=?",new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Information information = new Information(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                Double.parseDouble(cursor.getString(3)), Double.parseDouble(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)));
        return information;
    }

    public Weight getWeight(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_WEIGHT, new String[]{WG_ID, WG_YEAR, WG_MONTH, WG_DAY, WG_WEIGHT},
                WG_ID + "=?", new String[] {String.valueOf(id)},
                null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Weight weight = new Weight(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                Double.parseDouble(cursor.getString(4)));
        return weight;
    }

    public Circuit getCircuit(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CIRCUIT, new String[]{OB_ID, OB_YEAR, OB_MONTH, OB_DAY, OB_CHEST, OB_WAIST},
                OB_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Circuit circuit = new Circuit(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),
                Double.parseDouble(cursor.getString(4)), Double.parseDouble(cursor.getString(5)));
        return circuit;
    }


    //getting all information
    public List<Information> getAllInformation() {
        List<Information> informationList = new ArrayList<Information>();
        String selectQuery = "SELECT * FROM " + TABLE_INFORMATION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Information information = new Information();
                information.setId(Integer.parseInt(cursor.getString(0)));
                information.setName(cursor.getString(1));
                information.setHeight(Integer.parseInt(cursor.getString(2)));
                information.setWeight(Double.parseDouble(cursor.getString(3)));
                information.setTargetWeight(Double.parseDouble(cursor.getString(4)));
                information.setAge(Integer.parseInt(cursor.getString(5)));
                informationList.add(information);
            } while (cursor.moveToNext());
        }
        return informationList;
    }

    public List<Weight> getAllWeight() {
        List<Weight> weightList = new ArrayList<Weight>();
        String selectQuery = "SELECT * FROM " + TABLE_WEIGHT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do {
                Weight weight = new Weight();
                weight.setId(Integer.parseInt(cursor.getString(0)));
                weight.setYear(Integer.parseInt(cursor.getString(1)));
                weight.setMonth(Integer.parseInt(cursor.getString(2)));
                weight.setDay(Integer.parseInt(cursor.getString(3)));
                weight.setWeight(Double.parseDouble(cursor.getString(4)));
                weightList.add(weight);
            } while (cursor.moveToNext());
        }
        return weightList;
    }

    public List<Circuit> getAllCircuit(){
        List<Circuit> circuitList = new ArrayList<Circuit>();
        String selectQuery = "SELECT * FROM " + TABLE_CIRCUIT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                Circuit circuit = new Circuit();
                circuit.setId(Integer.parseInt(cursor.getString(0)));
                circuit.setYear(Integer.parseInt(cursor.getString(1)));
                circuit.setMonth(Integer.parseInt(cursor.getString(2)));
                circuit.setDay(Integer.parseInt(cursor.getString(3)));
                circuit.setChest(Double.parseDouble(cursor.getString(4)));
                circuit.setWaist(Double.parseDouble(cursor.getString(5)));
                circuitList.add(circuit);
            } while (cursor.moveToNext());
        }
        return circuitList;
    }


    //updating single Information
    public int updateInformation(Information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(INF_NAME, information.getName());
        values.put(INF_HEIGHT, information.getHeight());
        values.put(INF_WEIGHT, information.getWeight());
        values.put(INF_TARGETWEIGHT, information.getTargetWeight());
        values.put(INF_AGE, information.getAge());
        //updating row
        return db.update(TABLE_INFORMATION, values, INF_ID + " = ?",
                new String[]{String.valueOf(information.getId())});
    }

    public int updateWeight(Weight weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(WG_YEAR, weight.getYear());
        values.put(WG_MONTH, weight.getMonth());
        values.put(WG_DAY, weight.getDay());
        values.put(WG_WEIGHT, weight.getWeight());

        return db.update(TABLE_WEIGHT, values, WG_ID + " = ?",
                new String[]{String.valueOf(weight.getId())});
    }


    public int updateCircuit(Circuit circuit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OB_YEAR, circuit.getYear());
        values.put(OB_MONTH, circuit.getMonth());
        values.put(OB_DAY, circuit.getDay());
        values.put(OB_CHEST, circuit.getChest());
        values.put(OB_WAIST, circuit.getWaist());
        return db.update(TABLE_CIRCUIT, values, OB_ID + " = ?",
                new String[]{String.valueOf(circuit.getId())});
    }


    //Deleting single Information
    public void deleteInformation(Information information) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INFORMATION, INF_ID + " = ?",
                new String[]{String.valueOf(information.getId())});
        db.close();
    }

    public void deleteWeight(Weight weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WEIGHT, WG_ID + " = ?",
                new String[] {String.valueOf(weight.getId())});
        db.close();
    }


    public void deleteCircuit(Circuit circuit) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CIRCUIT, OB_ID + "= ?",
                new String[]{String.valueOf(circuit.getId())});
        db.close();
    }

}
