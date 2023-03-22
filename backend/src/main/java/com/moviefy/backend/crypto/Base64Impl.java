package com.moviefy.backend.crypto;

import java.util.Base64;

public class Base64Impl implements Base64_ {

    @Override
    public String encode(byte[] bytes) {
        String base64Encoded = Base64.getEncoder().encodeToString(bytes);
        return base64Encoded;
    }

    @Override
    public byte[] decode(String message) {
        return Base64.getDecoder().decode(message);
    }
}
