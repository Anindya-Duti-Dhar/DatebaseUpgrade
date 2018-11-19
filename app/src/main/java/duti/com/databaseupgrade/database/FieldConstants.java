package duti.com.databaseupgrade.database;


public class FieldConstants {

    public static final String DB_NAME = "database_upgrade";
    public static final int DATABASE_VERSION = 2;

    // table field Information
    public static final String TABLE_ALL_STUDENT = "student";

    public static final String mRecordId = "RecordId" ;
    public static final String mStudentId = "StudentId";
    public static final String mStudentName = "StudentName";
    public static final String mStudentAddress = "StudentAddress";

    public static final String TABLE_STATEMENT_ALL_STUDENT = "CREATE TABLE IF NOT EXISTS " + TABLE_ALL_STUDENT + "("
            + mRecordId + " INTEGER PRIMARY KEY," +
            mStudentId + " INTEGER," +
            mStudentName + " TEXT" +
            ")";

    public static final String TABLE_STATEMENT_ALL_STUDENT_V2 = "ALTER TABLE "+ TABLE_ALL_STUDENT +" ADD COLUMN "+ mStudentAddress +" TEXT DEFAULT ''";

}
