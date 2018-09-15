package bFindTheAnswer.signatureTest;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SignatureUtilsTest {

//商户验存管通同理
	@Test
	public void testmd1() throws Exception {

		// 1.生成密钥对
		KeyPair keyPair = SignatureUtils.generateRsaKeyPair(2048);
		// 2.生成公私钥匙base64
		String privateStr = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());// 商户留着签名
		String publicStr = Base64.encodeBase64String(keyPair.getPublic().getEncoded());// 发给存管通

		//String publicStr="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsM713rBMVatBUsUjRQ+cFJre4WPnHAers3jUXRHZ3AikgSYVNUrYvN/kL5yskhS7CLwoCh0G673cbZZ8vZ7yxvr6RZ3ybGFLEd7Ga91tzWyH64i2ftP2T5IuLPeomW7+NNnXPHRxLmDFoLpbmMlIOnP/EuU+It7Ai/Z34kyq+K/wWcEbz1T4An+Mrs3Bk4AKhXWLdTkwt+mVcetekc6tFUGyITde3xLBkaTXI9YE6Cwdd7jAXTlkYpZ1PonNt8qCZKRlPkDuOX0IgLhql4028vDQ461Ty0oj/GTM9Awe2Nh07V+5YIINZlQAOicN2BaLMS+jepTTnU3Ns6mtA2JhvQIDAQAB";
		//String privateStr="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCwzvXesExVq0FSxSNFD5wUmt7hY+ccB6uzeNRdEdncCKSBJhU1Sti83+QvnKySFLsIvCgKHQbrvdxtlny9nvLG+vpFnfJsYUsR3sZr3W3NbIfriLZ+0/ZPki4s96iZbv402dc8dHEuYMWguluYyUg6c/8S5T4i3sCL9nfiTKr4r/BZwRvPVPgCf4yuzcGTgAqFdYt1OTC36ZVx616Rzq0VQbIhN17fEsGRpNcj1gToLB13uMBdOWRilnU+ic23yoJkpGU+QO45fQiAuGqXjTby8NDjrVPLSiP8ZMz0DB7Y2HTtX7lggg1mVAA6Jw3YFosxL6N6lNOdTc2zqa0DYmG9AgMBAAECggEAHrAdTsSMy0XJNcOPxpnZ/l2PF9HOODhAngr32RuTE7TQULY6ciCGk+nMYlMwRL6iY/a8gFzfaaVvj/nRttvSyaSgMdsjS5prfDONfwVU3JXc1Y3KFyNVGiSGLTnjIpZ4OtYgnJadWm5jfu05nsA48CRX/oCZk1XUV7a0wiuKdVVSUnEh7d3HN5ZnvmIkhDwXFU6Kv46A4aN4hKFDtzoDw+4ewyPic1Zz77BTyjbkf0lSXzfgY+euDRWodbMA3mwdVg1GYImQm/IXanPrHMmMFulU7AI0otYtBritbmi/EGI+BJAP5y58sViIat+MoBv/qtvrmv2tfH7PQI3y/nCCYQKBgQDfVo/5zRMyAPnjJv9ZV7eLgqHhKZgYlJV79YhVmzzjh8kcKCQxPd/rYpDH3/Sxv8vMnzDp7lTTi8tG4Nd0qJjg+FmhKbP/nM6jhHvuMJF/x1sUBtRQAPZ9UDTc3nJ1TvRq6xU1H3CGqduYhhkMZ9e/lrobmVuZzBRmX6v+9r3kSQKBgQDKqmXDzQP4s905QV3cBAvCBgIuzjkWJ4GxMXLNt7e7VJRo1/RsJRr/Rpc1/CPKQLVwdDIONOrHPXhkxrgp/aPUMRD8FAL+G1lQyR5n6AmU6BTaP0isLO106k8gg6Xqx3V7qoSR/+I+vrF7/oDuEaQB71BopOcGaSy3WXSKo7Xp1QKBgHhxRz3Q8Ywi6KAutMBqxKow7bnu435GCwOJm1eHW2PdI4DSyQnhM3POeQPBbEW7iF22b/uIMyjOl/aGZMsd7SxN4pA+XDr6Rpn6ZZdDjAPb7+sx76ehjUxxR8DhGdrXlIpgctRuOxH0Yl+z2ahODBTfZUhjAPpFC69V4vyh9jA5AoGAMgNc+7XjTgOtC00bSYliEW6EKWLQ6au0MLMgPq4g1ETqHvl0IyABCpA0Dql7d5UCcY7rL2BVs/dyd4QmvI4QWPQG2f5iQq0jHHGVZFT50Fp5kuZdG8g2jUypXD/AuTChyHPrJVB9V7idehjzXkzSKXwSXtCbBpT76P9VaEVARkUCgYA7tEmOjbjZRGdWp3ViQ1hzeOjKRDyrZdHOEjDxH+IrIse67P2xNfyZWr+tz3zpb0d97CUifVIdiA0ei9d7ExRzBR7Y45SFGNuIgs1kfkgRI3u+vDNWDJGu83X5GzGfFOejwPVIwQsmo/iEIpVEtsAmCdNhRJIWFqH22U1t/HUA8Q==";

		System.out.println("privatekey:"+privateStr);
		System.out.println("publickey:"+publicStr);

		// 3.公私钥匙生成
		PrivateKey privateKey = SignatureUtils.getRsaPkcs8PrivateKey(Base64.decodeBase64(privateStr));
		PublicKey publicKey = SignatureUtils.getRsaX509PublicKey(Base64.decodeBase64(publicStr));

		System.out.println("privatekey:"+privateKey);
		System.out.println("publickey:"+publicKey);
		
		//签名
		String content = "{\"platformUserNo\":\"123\",\"requestNo\":\"34234234\",\"realName\":\"陈少聪\",\"idCardType\":\"G2_IDCARD\",\"userRole\":\"20150312135520\",\"idCardNo\":\"220102199203120812\",\"mobile\":\"18611936074\",\"bankcardNo\":\"6228480402564890018\",\"callbackUrl\":\"http://requestb.in/1jaym0m1\",\"notifyUrl\":\"http://requestb.in/ojkzvdoj\",\"timestamp\":\"20151112134411\"}";
		byte[] sign = SignatureUtils.sign(SignatureAlgorithm.SHA1WithRSA, privateKey, content);
		String sign64 = Base64.encodeBase64String(sign);//报文中的sign
		System.out.println(sign64);

		//存管通根据商户发来的公钥验签
		boolean b = SignatureUtils.verify(SignatureAlgorithm.SHA1WithRSA, publicKey, content, sign);
		System.out.println("验签结果："+b);
	}

	@Test
	public void testSign() throws Exception{
		String privateStr ="";
		PrivateKey privateKey = SignatureUtils.getRsaPkcs8PrivateKey(Base64.decodeBase64(privateStr));

		String content = "{\"platformUserNo\":\"123\",\"requestNo\":\"34234234\",\"realName\":\"陈少聪\",\"idCardType\":\"G2_IDCARD\",\"userRole\":\"20150312135520\",\"idCardNo\":\"220102199203120812\",\"mobile\":\"18611936074\",\"bankcardNo\":\"6228480402564890018\",\"callbackUrl\":\"http://requestb.in/1jaym0m1\",\"notifyUrl\":\"http://requestb.in/ojkzvdoj\",\"timestamp\":\"20151112134411\"}";
		byte[] sign = SignatureUtils.sign(SignatureAlgorithm.SHA1WithRSA, privateKey, content);
		String sign64 = Base64.encodeBase64String(sign);//报文中的sign
		System.out.println(sign64);

	}

	public String testAddTrans(String str){


		return "";
	}
}
