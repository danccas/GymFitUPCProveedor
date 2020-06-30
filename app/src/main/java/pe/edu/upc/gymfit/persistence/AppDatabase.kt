package pe.edu.upc.gymfit.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.gymfit.models.AccountProperties
import pe.edu.upc.gymfit.models.AuthToken
import pe.edu.upc.gymfit.models.BlogPost

@Database(entities = [AuthToken::class, AccountProperties::class, BlogPost::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getAuthTokenDao(): AuthTokenDao

    abstract fun getAccountPropertiesDao(): AccountPropertiesDao

    abstract fun getBlogPostDao(): BlogPostDao

    companion object{
        val DATABASE_NAME: String = "app_db"
    }


}








