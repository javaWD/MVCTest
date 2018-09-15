package bFindTheAnswer.helloRestful;

import bFindTheAnswer.signatureTest.SignatureAlgorithm;
import bFindTheAnswer.signatureTest.SignatureUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by drudg on 2017/5/18.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetingRestful")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public boolean receiveRequest(HttpServletRequest request) {

//        Map<String,String[]> map=request.getParameterMap();


        InputStream is = null;
        String contentStr = "";
        try {
            is = request.getInputStream();
            contentStr = IOUtils.toString(is, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(contentStr);

        String privateStr = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYoMhmKtP4j2culGu5IHHWXwIi1OZQ7fbUAdR84CrfcSWqRgq8SaRsildTzDESF5lwoAIQ74YWMUw/K3Tu6Stvrc4cgmFt6ulQYfSpP/ypxNx7RtHqd5fcTzuxxzUEThAF5LLyC+wMFunehgE/luBg2mEStEmFRgoOUXIbdU9p0CpvtfKMoDpUMH61OPKoo2ERzIsSkkkjpiQyzAJNWoqC1htfK/gNdXlW9KhYQiceNDkiL8JCAsuX6Xoeon7r8YHzh99wPy1NUST71aVVqQfa5k3BQ39R5aqX4zk0r3CfSyG9OAlSV8dR5yhdHso5+90mtYq2+2qbN8gbi1VnGB1VAgMBAAECggEAe5pp8GNqunbX5t8HxirCRgs3HaIwywWLyPGadW7NCZsGF7kVZJp27/ew9Qn+C1rVRmIuiiyP+FUAHIBC+GAYbx7gNjJYWL3PKOvLSW2qXoowzBz0Tt9/OkloXHapNs1JKJynVmHVTY0Y5L69MBQtrgHsb0tV5vprlmDa+eWs5FEH08TLQqYi64v7k5BPDCVdGR4umc+fN8KbbjZlpI6x0OSVQwQ1wIcqrE7M0jgNX+873axMQB9T6bhwcY7LCuaHK9g0iVtPfMPROCCXAx3RshbEY18frvSECSbSzuqHrCHXiNVYbxtNVwxR3KlBKy1EGIQuFIJLa9H/SaD0OmqVWQKBgQD/w3KEhcAwhH6i4B3y5+Pbww+ubl/Na96z4sIZ/ZGBGdiaQyEVh+vxkqR4R9FQudRaLNbE7pE6ixmJfOC3rO0gv2RPOrIRRRMZRODPy5zXS0wqAvVV/4cHEfBmC3tbMtDbQemKUl8YgvZI6vEtIBhBLPRLVx3ZAwgVNQhCJDxaVwKBgQCYxOr7YrxlI96MJDrelaw2FbflI+5LQTqi6B9/eV8aLa3b1Lww+fOhgeClDpgQUmPE7Tlgg3BjttPif8jCgFkZN3Xg6F32A2wZpSOz9bP+ZcBoF09fMJDifX5jCUQG9beGb/oW1JS1tEdLi2ZC2itPAQSFr/2siakvyA45EggSMwKBgQDwywzU8auYwhULuR7ZIzLmIwZvfeDaYLVh/JorqAxGVJQV4B+Uysv7Osl3qH3Ll7jyUQa+j7DRQkZ/p79VjgwOacLByQv+sF6jyrIxUIxQMcb6QqDCH3n70QrYt/SiTvxNgQejv5tiU2IWEoOPrYjIS8+P4uvp9S218aDdzIm5rwKBgAmCuN5Nl0z0nrY6yy9wQfhcAcbSJdOpi+z4Zn2ZIMKQdXJqHA0wgmpbm5CrB+x8NJnd6uSHSkfq6eX/7o+tTd60BTKrRK48KE6waTia40nDK+dPDDHw5BQ1m9iuiv2j7nkAH6GsOlXVk1qwov0md+vDNHTeL/y91TqUSc5jwPzhAoGAOt/cXkS3HXRzsKtcmqLPKVu585PnTpIOowjmhvKhx4r+oEsbxdGg+MXjjS85sPYIGGL8xpyR6RQLZDaNHXDYg/GZgGgKWLRgk1t6G19CedtTrrECgYqkNu4wxI313H3zwMcOM0Dnb9UfRFx+OJXvETazlleGb00caqr1ThjAavg=";
        String publicStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmKDIZirT+I9nLpRruSBx1l8CItTmUO321AHUfOAq33ElqkYKvEmkbIpXU8wxEheZcKACEO+GFjFMPyt07ukrb63OHIJhberpUGH0qT/8qcTce0bR6neX3E87scc1BE4QBeSy8gvsDBbp3oYBP5bgYNphErRJhUYKDlFyG3VPadAqb7XyjKA6VDB+tTjyqKNhEcyLEpJJI6YkMswCTVqKgtYbXyv4DXV5VvSoWEInHjQ5Ii/CQgLLl+l6HqJ+6/GB84ffcD8tTVEk+9WlVakH2uZNwUN/UeWql+M5NK9wn0shvTgJUlfHUecoXR7KOfvdJrWKtvtqmzfIG4tVZxgdVQIDAQAB";


        try {
            PrivateKey privateKey = SignatureUtils.getRsaPkcs8PrivateKey(Base64.decodeBase64(privateStr));

            PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64.decodeBase64(publicStr));

            byte[] sign = SignatureUtils.sign(SignatureAlgorithm.SHA1WithRSA, privateKey, contentStr);
            String sign64 = Base64.encodeBase64String(sign);//报文中的sign
            System.out.println(sign64);

            boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, contentStr, sign);
            System.out.println(b);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
