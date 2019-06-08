package mx.edu.tesoem.hugo4295.itics.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.Nullable;

public class DatosHelper extends SQLiteOpenHelper {
    private static DatosHelper datosHelper = null;
    private static final String NOMBRE_BD = "agendaitics7t11";
    private static final int VERSION_DB = 1;

    public static class tabladatos{
        public static String TABLA = "tbAgenda";
        public static String COLUMNA_ID ="id";
        public static String COLUMNA_NOMBRE ="nombre";
        public static String COLUMNA_EDAD ="edad";
        public static String COLUMNA_CORREO ="correo";
    }

    private static final String CONSULTA_CREAR_TABLA = "create table " +
            tabladatos.TABLA + " (" + tabladatos.COLUMNA_ID + " integer primary key autoincrement, "+
            tabladatos.COLUMNA_NOMBRE + " varchar, "+
            tabladatos.COLUMNA_EDAD + " integer, " +
            tabladatos.COLUMNA_CORREO + " varchar);";

    private static final String CONSULTA_ELIMINAR_TABLA="drop table if exists " + tabladatos.TABLA;

    public static DatosHelper getInstance(Context context){
        if (datosHelper == null){
            datosHelper = new DatosHelper(context.getApplicationContext());
        }
        return datosHelper;
    }

    public DatosHelper(Context context) {
        super(context,NOMBRE_BD, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONSULTA_ELIMINAR_TABLA);
        onCreate(db);
    }
}
