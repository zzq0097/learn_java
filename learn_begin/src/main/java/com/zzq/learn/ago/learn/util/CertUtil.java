package com.zzq.learn.ago.learn.util;


import javax.net.ssl.HttpsURLConnection;
import java.io.FileInputStream;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertUtil {

    public X509Certificate fromDomain(String domain) throws Exception {
        URL url = new URL(domain);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.connect();
        Certificate[] certificates = connection.getServerCertificates();
        connection.disconnect();
        if (certificates.length > 0) {
            return (X509Certificate) certificates[0];
        }
        return null;
    }

    public X509Certificate fromFile(String path) throws Exception {
        CertificateFactory fact = CertificateFactory.getInstance("X.509");
        return (X509Certificate) fact.generateCertificate(new FileInputStream(path));
    }
}
