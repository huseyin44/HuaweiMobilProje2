package com.hdsturkey.yalovabsm404.firstassignment.data.local.type_converters

import androidx.room.TypeConverter
import com.hdsturkey.yalovabsm404.firstassignment.data.model.Products
import org.json.JSONObject

class NameTypeConverter {
    @TypeConverter
    fun fromSource(name: Products): String {
        return JSONObject().apply {
            put("name", name.name)
            put("options", name.options)
            put("price", name.price)
            put("note", name.note)
            put("piece", name.piece)
            put("image", name.image)
        }.toString()
    }

    @TypeConverter
    fun toSource(nameJson: String): Products {
        val json = JSONObject(nameJson)
        return Products(
            json.getString("name"),
            json.getString("options"),
            json.getInt("price"),
            json.getString("note"),
            json.getInt("piece"),
            json.getString("image")
        )
    }
}