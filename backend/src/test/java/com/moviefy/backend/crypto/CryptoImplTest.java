package com.moviefy.backend.crypto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CryptoImplTest {

    private CryptoImpl crypto = new CryptoImpl();

    @BeforeEach
    void setUp() {
        crypto = new CryptoImpl();
    }

    @Test
    void test() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        KeyPair key = crypto.createKeys("abc");
        byte[] nwm = crypto.encrypt("Mateusz", key.getPublic());
        String mwn = crypto.decrypt(nwm, key.getPrivate());

        assertEquals("Mateusz", mwn);
    }
}