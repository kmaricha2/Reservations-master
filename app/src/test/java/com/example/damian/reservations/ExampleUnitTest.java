package com.example.damian.reservations;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void Convertir_hora_correcto() throws Exception {

        assertEquals("1 AM", Metodos.ConvertirHora(1));
    }
    @Test
    public void Convertir_hora_INcorrecto() throws Exception {
        assertNotEquals("1 PM", Metodos.ConvertirHora(1));
    }
    @Test
    public void Convertir_hora_cancha_reserva_correcto() throws Exception {
        Cancha_Reserva a = new Cancha_Reserva();
        assertEquals("12 PM", a.ConvertirHora(12));
    }

    @Test
    public void Convertir_hora_cancha_reserva_incorrecto() throws Exception {
        Cancha_Reserva a = new Cancha_Reserva();
        assertNotEquals("12 PM", a.ConvertirHora(1));
    }
    @Test
    public void Convertir_hora_cancha_reserva_fecha_correcto() throws Exception {
        Cancha_Reserva a = new Cancha_Reserva();
        assertEquals("Diciembre 12 de 2017", a.ConvertirFecha("12/12/2017"));
    }

    @Test
    public void traducir_mensaje_correcto_email_errado() throws Exception {
        assertTrue(Metodos.TraducirMensaje("The email address is badly formatted.")==2131165258);
    }
    @Test
    public void traducir_mensaje_incorrecto_email_errado() throws Exception {
        assertFalse(Metodos.TraducirMensaje("The email address is badly formatted.")==21165258);
    }    @Test
    public void traducir_mensaje_correcto_contraseña_corta() throws Exception {
        assertTrue(Metodos.TraducirMensaje("The given password is invalid. [ Password should be at least 6 characters ]")==2131165243);
    }    @Test
    public void traducir_mensaje_incorrecto_contraseña_corta() throws Exception {
         assertFalse(Metodos.TraducirMensaje("The given password is invalid. [ Password should be at least 6 characters ]")==21315243);
    }    @Test
    public void traducir_mensaje_correcto_usuario_registardo() throws Exception {
        assertTrue(Metodos.TraducirMensaje("The email address is already in use by another account.")==2131165246);
    }    @Test
    public void traducir_mensaje_incorrecto_usuario_registardo() throws Exception {

        assertFalse(Metodos.TraducirMensaje("The email address is already in use by another account.")==21315243);
    }

}