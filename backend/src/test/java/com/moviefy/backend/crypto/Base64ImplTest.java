package com.moviefy.backend.crypto;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class Base64ImplTest {

    @Test
    void test() throws UnsupportedEncodingException {
        Base64Impl base64 = new Base64Impl();
        String a = "Mateusz";
        String nwm = base64.encode(a.getBytes());
        byte[] bytes = base64.decode(nwm);

        assertArrayEquals(a.getBytes(), bytes);
    }
}