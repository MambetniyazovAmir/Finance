package com.example.finance.data

import android.arch.persistence.room.*

@Dao
interface FinanceDao {
    @Query("SELECT * FROM contacts")
    fun getAllContacts(): List<ContactModel>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactById(id: Int): ContactModel

    @Query("SELECT * FROM contacts WHERE name= :name")
    fun check(name: String): ContactModel?

    @Query("SELECT * FROM contacts ORDER BY name")
    fun sortByName(): List<ContactModel>

    @Query("SELECT * FROM contacts ORDER BY amount DESC")
    fun sortByAmount(): List<ContactModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertToDB(model: ContactModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(model: ContactModel)

    @Delete
    fun deleteContact(model: ContactModel)
}