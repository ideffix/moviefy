package com.moviefy.backend.crypto;

import java.io.UnsupportedEncodingException;

public interface Base64_ {
    String encode(byte[] bytes);

    byte[] decode(String message) throws UnsupportedEncodingException;
}
