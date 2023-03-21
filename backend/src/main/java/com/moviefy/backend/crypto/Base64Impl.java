package com.moviefy.backend.crypto;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Impl implements Base64_ {

    @Override
    public String encode(byte[] bytes) {
        String base64Encoded = Base64.getEncoder().encodeToString(bytes);
        return base64Encoded;
    }

    @Override
    public byte[] decode(String message) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.getDecoder().decode(message);
        return decodedBytes;
    }
}
