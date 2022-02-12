package com.runescape.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

public class NetworkConstants {

    public static final BigInteger RSA_MODULUS;
    public static final BigInteger RSA_EXPONENT;

    static {
        try (final PemReader pemReader = new PemReader(new BufferedReader(new InputStreamReader(Objects.requireNonNull(NetworkConstants.class.getClassLoader().getResourceAsStream("rsa-public.pem")))))) {
            final PemObject pem = pemReader.readPemObject();
            final X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pem.getContent());
            Security.addProvider(new BouncyCastleProvider());
            final KeyFactory factory = KeyFactory.getInstance("RSA", "BC");
            final RSAPublicKey publicKey = (RSAPublicKey) factory.generatePublic(keySpec);
            RSA_MODULUS = publicKey.getModulus();
            RSA_EXPONENT = publicKey.getPublicExponent();
        } catch (final Exception exception) {
            throw new ExceptionInInitializerError(new IOException("Error parsing rsa-public.pem", exception));
        }
    }

    private NetworkConstants() {

    }



}
