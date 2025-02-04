package com.example.fooddogapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fooddogapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Product1DB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRODUCTS = "Products";
    private static final String TABLE_CART = "Cart";
    public static final String COLUMN_NAME = "name";


    private Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Users(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT, username TEXT, contact TEXT, address TEXT, role TEXT,imagePath TEXT)");

        String createProductsTable = "CREATE TABLE " + TABLE_PRODUCTS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "brand TEXT, " +
                "age TEXT, " +
                "price REAL, " +
                "image TEXT, " +
                "availability INTEGER)";

        String createCartTable = "CREATE TABLE " + TABLE_CART + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "product_id INTEGER, " +
                "quantity INTEGER)";

        // Create Items Table
        db.execSQL("CREATE TABLE Items(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, price TEXT, category TEXT, description TEXT, location TEXT, contact TEXT, image_url TEXT, seller_email TEXT)");

        db.execSQL(createProductsTable);
        db.execSQL(createCartTable);

        insertInitialProducts(db);
    }

    private void insertInitialProducts(SQLiteDatabase db) {
        String insertProduct1 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Henlo Chicken And Egg Baked Dry Food','Henlo', 'Adult', 1200.00, 'done.jpg', 10)";
        String insertProduct2 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name,brand, age, price, image, availability) VALUES " +
                "('Drools Optimum Performance Adult Dog Dry Food','Drools', 'Adult', 1450.00, 'dtwo.jpg', 15)";
        String insertProduct3 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name,brand, age, price, image, availability) VALUES " +
                "('Pedigree Chicken & Milk Puppy Dog Dry Food','Pedigree', 'Puppy', 1560.00, 'dthree.jpg', 18)";
        String insertProduct4 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree Chicken & Vegetables Dog Dry Food','Pedigree', 'Adult', 1730.00, 'dfour.jpg', 18)";
        String insertProduct5 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree Chicken & Liver Chunks In Gravy Adult Dog Wet Food','Pedigree', 'Adult', 1430.00, 'dfive.jpg', 18)";
        String insertProduct6 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Drools Real Chicken & Chicken Liver Chunks In Gravy Adult Dog Wet Food','Drools', 'Adult', 1430.00, 'wet1.webp', 18)";
        String insertProduct7 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Vaterinary Diet Renal Dog Wet Food','Royal Canin', 'Adult', 1430.00, 'wet2.jpg', 18)";
        String insertProduct8 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Drools Real Chicken & Chicken Liver Chunks In Gravy Puppy Dog Wet Food','Drools', 'Puppy', 1430.00, 'wet3.jpg', 18)";
        String insertProduct9 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Bark Out Loud Immunity Multi Vitamin Chew Sticks For Adult Dog ', 'Bark Out Loud', 'Adult', 1750.00, 'wet4.webp', 20)";
        String insertProduct10 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Drools Absolute Calcium Bones Dog', 'Drools', 'Adult', 2430.00, 'wet5,jpg', 14)";
        String insertProduct11 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree Chicken & Liver Flavour Tasty Jerky Dog Treat', 'Pedigree', 'Adult', 1890.00, 't1.webp', 18)";
        String insertProduct12 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Drools Real Chicken Sausage Dog Treats', 'Drools', 'Adult', 2230.00, 't2.webp', 18)";
        String insertProduct13 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Signature Gain Zero Real Chicken, Egg & Vegetables Adult Dog', 'Signature', 'Adult', 1750.00, 't3.jpg', 20)";
        String insertProduct14 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree PRO Expert Nutrition Active Adult(18 months onward) ', 'Pedigree', 'Adult', 2430.00, 't4.jpg', 14)";
        String insertProduct15 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Drools Focus Super Premium Adult Dog Dry Food', 'Drools', 'Adult', 1890.00, 't5.jpg', 18)";
        String insertProduct16 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Mini Puppy Dog Dry Food', 'Royal Canin', 'Puppy', 2230.00, 'p1.webp', 18)";
        String insertProduct17 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Henlo Baked DRy Food For Puppies', 'Henlo', 'Puppy', 2350.00, 'p2.webp', 25)";
        String insertProduct18 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree Chicken And Milk Puppy Dog Dry Food', 'Pedigree', 'Puppy', 1630.00, 'p3.webp', 13)";
        String insertProduct19= "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Mini Starter For Small Breed Dogs & Puppies', 'Royal Canin', 'Puppy', 1890.00, 'p4.jpg', 18)";
        String insertProduct20 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Pedigree Lamb Flavour Chunks In Gravy Pupp Wet Food', 'Pedigree', 'Puppy', 1730.00, 'p5.webp', 15)";
        String insertProduct21 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Mini Adult', 'Royal Canin', 'Adult', 2350.00, 'r1.jpg', 25)";
        String insertProduct22 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin PRO Rottweiler Adult', 'Royal Canin', 'Adult', 1630.00, 'r2.webp', 13)";
        String insertProduct23= "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Labrador Puppy', 'Royal Canin', 'Puppy', 1890.00, 'r3.webp', 18)";
        String insertProduct24 = "INSERT INTO " + TABLE_PRODUCTS +
                " (name, brand, age, price, image, availability) VALUES " +
                "('Royal Canin Labrador Adult', 'Royal Canin', 'Adult', 1730.00, 'r4.webp', 15)";

        db.execSQL(insertProduct1);
        db.execSQL(insertProduct2);
        db.execSQL(insertProduct3);
        db.execSQL(insertProduct4);
        db.execSQL(insertProduct5);
        db.execSQL(insertProduct6);
        db.execSQL(insertProduct7);
        db.execSQL(insertProduct8);
        db.execSQL(insertProduct9);
        db.execSQL(insertProduct10);
        db.execSQL(insertProduct11);
        db.execSQL(insertProduct12);
        db.execSQL(insertProduct13);
        db.execSQL(insertProduct14);
        db.execSQL(insertProduct15);
        db.execSQL(insertProduct16);
        db.execSQL(insertProduct17);
        db.execSQL(insertProduct18);
        db.execSQL(insertProduct19);
        db.execSQL(insertProduct20);
        db.execSQL(insertProduct21);
        db.execSQL(insertProduct22);
        db.execSQL(insertProduct23);
        db.execSQL(insertProduct24);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Items");
        onCreate(db);
    }

    public Context getContext() {
        return context;
    }


    // Method to get the current user's email (replace with your own implementation)
    private String getCurrentUserEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user_email", null); // Ensure this value is not null
    }


    public boolean insertProduct(String name, String brand, String age, double price, String image, int availability) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("brand", brand);
        contentValues.put("age", age);
        contentValues.put("price", price);
        contentValues.put("image", image);
        contentValues.put("availability", availability);

        long result = db.insert(TABLE_PRODUCTS, null, contentValues);
        return result != -1;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String brand = cursor.getString(cursor.getColumnIndex("brand"));
                String age = cursor.getString(cursor.getColumnIndex("age"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                int availability = cursor.getInt(cursor.getColumnIndex("availability"));

                Product product = new Product(id, name, brand, age, price, image, availability);
                productList.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return productList;
    }


    public boolean updateProduct(int id, String name, String brand, String age, double price, String image, int availability) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("brand", brand);
        contentValues.put("age", age);
        contentValues.put("price", price);
        contentValues.put("image", image);
        contentValues.put("availability", availability);

        int result = db.update(TABLE_PRODUCTS, contentValues, "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return result > 0;
    }

    public boolean deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_PRODUCTS, "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return result > 0;
    }



    //User methods
    public Boolean insertData(String email, String password, String role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("role", role); // Ensure this line is present
        long result = db.insert("Users", null, contentValues);
        return result != -1;
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE email = ?", new String[]{email});
        return cursor.getCount() > 0;
    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE email = ? and password = ?", new String[]{email, password});
        return cursor.getCount() > 0;
    }

    public Cursor getUserData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Users WHERE email = ?", new String[]{email});
    }

    public boolean updateUserData(String email, String username, String contact, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("contact", contact);
        contentValues.put("address", address);
        long result = db.update("Users", contentValues, "email = ?", new String[]{email});
        return result != -1;
    }

    public boolean updateUserProfileImage(String email, String imagePath) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("image_path", imagePath); // Assuming you add an image_path column
        long result = db.update("Users", contentValues, "email = ?", new String[]{email});
        return result != -1;
    }

}