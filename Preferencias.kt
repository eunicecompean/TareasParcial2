package com.eecc.tareasp2.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.eecc.tareasp2.datastore.models.Usuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Preferencias (private val context: Context) {
    companion object PreferenciasUsuario {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        val nombre = stringPreferencesKey("nombre")
        val edad = intPreferencesKey("edad")
        val altura = floatPreferencesKey("altura")
        val monedero = floatPreferencesKey("monedero")
    }

    val userFlow: Flow<Usuario> = context.dataStore.data.map { prefs ->
        Usuario(
            nombre = prefs[nombre] ?: "",
            edad = prefs[edad] ?: 0,
            altura = prefs[altura] ?: 0f,
            monedero = prefs[monedero] ?: 0f
        )
    }

    suspend fun guardarDatos(user: Usuario) {
        context.dataStore.edit { prefs ->
            prefs[nombre] = user.nombre
            prefs[edad] = user.edad
            prefs[altura] = user.altura
            prefs[monedero] = user.monedero
        }
    }

}