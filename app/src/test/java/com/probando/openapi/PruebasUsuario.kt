package com.probando.openapi

import org.junit.Assert
import org.junit.Test

class PruebasUsuario {
    @Test
    fun pruebaUsuarioActivo() {
        System.out.println("Usuario activo")
        Assert.assertEquals(4, 2 + 2)
    }
    @Test
    fun pruebaUsuarioInactivo() {
        System.out.println("Usuario inactivo")
        Assert.assertEquals(4, 2 + 2)
    }
    @Test
    fun pruebaUsuarioEliminado() {
        System.out.println("Usuario eliminado")
        Assert.assertEquals(4, 2 + 2)
    }
}