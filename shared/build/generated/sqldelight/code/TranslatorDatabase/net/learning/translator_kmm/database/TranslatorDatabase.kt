package net.learning.translator_kmm.database

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import net.learning.translator_kmm.database.shared.newInstance
import net.learning.translator_kmm.database.shared.schema
import net.learning.translatorkmm.database.TranslatorQueries

public interface TranslatorDatabase : Transacter {
  public val translatorQueries: TranslatorQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = TranslatorDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): TranslatorDatabase =
        TranslatorDatabase::class.newInstance(driver)
  }
}
