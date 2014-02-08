package com.subirtupagina.diversioneskavier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;

public class Handler_sqlite extends SQLiteOpenHelper{
	
	final static int rank = 10;
	
	public Handler_sqlite(Context ctx)
	{
		super(ctx, "hangman", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String query = "CREATE TABLE user ("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
				"name TEXT, score INTEGER);";
		db.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int version_ant, int version_nue)
	{
		db.execSQL("DROP TABLE IF EXISTS user");
		onCreate(db);
	}

	public void insertReg(String name, int score)
	{
		ContentValues values = new ContentValues();
		values.put("name", name); 
		values.put("score", score);
		this.getWritableDatabase().insert("user",null, values);
	}

	public int scan(String name[], String score[])
	{
		String columns[]= {_ID,"name","score"};
		Cursor c = this.getReadableDatabase().query("user", columns, null, null,null, null, "score DESC");

		int in,is;
		
		in = c.getColumnIndex("name");
		is = c.getColumnIndex("score");
		int count=0;
		for(c.moveToFirst();!c.isAfterLast() && count<10;c.moveToNext())
		{
			name[count] = c.getString(in);
			score[count]=Integer.toString(c.getInt(is));
			count++;
		}

		return count;
	}

	public void openDB()
	{
		this.getWritableDatabase();

	}

	public void closeDB()
	{
		this.close();
	}
	
}
