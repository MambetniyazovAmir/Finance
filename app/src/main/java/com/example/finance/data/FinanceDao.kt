package com.example.finance.data

import android.arch.persistence.room.*

@Dao

interface FinanceDao {
    @Query("SELECT * FROM Contacts")
    fun getAllContacts(): List<ContactModel>

    @Query("SELECT * FROM Contacts WHERE id = :id")
    fun getContactById(id: Int): ContactModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertToDB(models: List<ContactModel>)

    @Update
    fun updateContacts(): List<ContactModel>

    @Delete
    fun deleteContact(): List<ContactModel>
}