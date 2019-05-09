package com.example.finance.data

import android.arch.persistence.room.*

@Dao
interface FinanceDao {
    @Query("SELECT * FROM contacts")
    fun getAllContacts(): List<ContactModel>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactById(id: Int): ContactModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertToDB(model: ContactModel)

    @Update
    fun updateContacts(model: ContactModel)

    @Delete
    fun deleteContact(model: ContactModel)
}