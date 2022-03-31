package com.example.ifsul_progmov1_acts_s4_2022;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Actividad7_Estudiantes_DDBB extends SQLiteOpenHelper {
    public static final String nametag = "sql";
    public static final String file_ddbb = "students_list.sqlite";
    public static final int version_no = 1;

    // When extending SQLiteOpenHelper, these method overrides and constructor are needed: onCreate() and onUpgrade()

    public Actividad7_Estudiantes_DDBB(Context c) {
        super(c, file_ddbb, null, version_no);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(nametag,"Creating DDBB...");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS students (idno INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,pwd TEXT,course TEXT);");
        Log.d(nametag,"DDBB was created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Not implemented yet.
    }

    public long register_data(Actividad7_Estudiantes a7e){
        long idno = a7e.getIdno();
        SQLiteDatabase ddbb = getWritableDatabase();
        try{
            ContentValues cvs = new ContentValues();

            cvs.put("name",a7e.getName());
            cvs.put("email",a7e.getEmail());
            cvs.put("pwd",a7e.getPwd());
            cvs.put("course",a7e.getCourse());

            if(idno!=0){
                // UPDATE

                String id2s = String.valueOf(a7e.getIdno());
                // Array for WHERE conditionals.
                String[] where_conditionals = new String[]{id2s};

                int update_reg = ddbb.update("students",cvs,"idno=?",where_conditionals);

                return update_reg;
            }
            else{
                // INSERT

                idno = ddbb.insert("students","",cvs);

                return idno;
            }
        }
        finally {
            ddbb.close();
        }
    }
    public List<Actividad7_Estudiantes> list_students(){
        SQLiteDatabase ddbb_ro = getReadableDatabase();

        try{
            Cursor crs = ddbb_ro.rawQuery("SELECT * FROM students;",null);
            return return_list(crs);
        }
        finally {
            ddbb_ro.close();
        }
    }

    @SuppressLint("range")
    public List<Actividad7_Estudiantes> return_list(Cursor i_crs){
        List<Actividad7_Estudiantes> students_listing = new ArrayList<Actividad7_Estudiantes>();

        if(i_crs.moveToNext()){
            do{
                Actividad7_Estudiantes a7e_obj = new Actividad7_Estudiantes();
                a7e_obj.setIdno(i_crs.getInt((i_crs.getColumnIndex("idno"))));
                a7e_obj.setName(i_crs.getString((i_crs.getColumnIndex("name"))));
                a7e_obj.setEmail(i_crs.getString((i_crs.getColumnIndex("email"))));
                a7e_obj.setPwd(i_crs.getString((i_crs.getColumnIndex("pwd"))));
                a7e_obj.setCourse(i_crs.getString((i_crs.getColumnIndex("course"))));

                students_listing.add(a7e_obj);
            }while (i_crs.moveToNext());
        }

        return students_listing;
    }
}
