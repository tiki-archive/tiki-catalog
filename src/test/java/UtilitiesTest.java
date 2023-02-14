/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in root directory.
 */

import com.mytiki.l0_index.utilities.B64;
import com.mytiki.l0_index.utilities.Decode;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.codec.Utf8;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilitiesTest {

    @Test
    public void Test_Decode_BigInt_Success(){
        byte[] enc1 = B64.decode("xow7");
        byte[] enc2 = B64.decode("Aw==");
        byte[] enc3 = B64.decode("_Q==");
        byte[] enc4 = B64.decode("Bys1dpH3Ozk=");

        BigInteger bg1 = Decode.bigInt(enc1);
        BigInteger bg2 = Decode.bigInt(enc2);
        BigInteger bg3 = Decode.bigInt(enc3);
        BigInteger bg4 = Decode.bigInt(enc4);

        assertEquals(BigInteger.valueOf(-3765189L), bg1);
        assertEquals(BigInteger.valueOf(3L), bg2);
        assertEquals(BigInteger.valueOf(-3L), bg3);
        assertEquals(BigInteger.valueOf(516565365635365689L), bg4);
    }

    @Test
    public void Test_Decode_CompactSize_Success(){
        String val1 = "hello world";
        String val2 = "hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world hello world";

        byte[] enc1 = B64.decode("C2hlbGxvIHdvcmxk");
        byte[] enc2 = B64.decode("_dMBaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQgaGVsbG8gd29ybGQ");

        int size1 = Decode.decodeCompactSize(enc1);
        int size2 = Decode.decodeCompactSize(enc2);

        assertEquals(Utf8.encode(val1).length, size1);
        assertEquals(Utf8.encode(val2).length, size2);
    }
}
