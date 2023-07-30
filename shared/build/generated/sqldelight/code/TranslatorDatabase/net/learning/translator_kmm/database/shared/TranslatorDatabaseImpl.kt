package net.learning.translator_kmm.database.shared

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass
import net.learning.translator_kmm.database.TranslatorDatabase
import net.learning.translatorkmm.database.HistoryEntity
import net.learning.translatorkmm.database.TranslatorQueries

internal val KClass<TranslatorDatabase>.schema: SqlDriver.Schema
  get() = TranslatorDatabaseImpl.Schema

internal fun KClass<TranslatorDatabase>.newInstance(driver: SqlDriver): TranslatorDatabase =
    TranslatorDatabaseImpl(driver)

private class TranslatorDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), TranslatorDatabase {
  public override val translatorQueries: TranslatorQueriesImpl = TranslatorQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE historyEntity(
          |    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    fromLanguageCode TEXT NOT NULL,
          |    fromText TEXT NOT NULL,
          |    toLanguageCode TEXT NOT NULL,
          |    toText TEXT NOT NULL,
          |    timestamp INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class TranslatorQueriesImpl(
  private val database: TranslatorDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), TranslatorQueries {
  internal val getHistory: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> getHistory(mapper: (
    id: Long,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ) -> T): Query<T> = Query(1794100201, getHistory, driver, "translator.sq", "getHistory", """
  |SELECT *
  |FROM historyEntity
  |ORDER BY timestamp DESC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getString(4)!!,
      cursor.getLong(5)!!
    )
  }

  public override fun getHistory(): Query<HistoryEntity> = getHistory { id, fromLanguageCode,
      fromText, toLanguageCode, toText, timestamp ->
    HistoryEntity(
      id,
      fromLanguageCode,
      fromText,
      toLanguageCode,
      toText,
      timestamp
    )
  }

  public override fun insertHistoryEntity(
    id: Long?,
    fromLanguageCode: String,
    fromText: String,
    toLanguageCode: String,
    toText: String,
    timestamp: Long
  ): Unit {
    driver.execute(2096134195, """
    |INSERT OR REPLACE
    |INTO historyEntity(
    |    id,
    |    fromLanguageCode,
    |    fromText,
    |    toLanguageCode,
    |    toText,
    |    timestamp
    |)
    |VALUES(?, ?, ?, ?, ?, ?)
    """.trimMargin(), 6) {
      bindLong(1, id)
      bindString(2, fromLanguageCode)
      bindString(3, fromText)
      bindString(4, toLanguageCode)
      bindString(5, toText)
      bindLong(6, timestamp)
    }
    notifyQueries(2096134195, {database.translatorQueries.getHistory})
  }
}
