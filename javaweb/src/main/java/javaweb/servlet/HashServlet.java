package javaweb.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javaweb.utils.Hash;
import static javaweb.utils.Hash.getHash;
import static javaweb.utils.Hash.getSalt;
/**
 * 網址: /hash?password=1234
 * 得到: 
 * 		1.hashPassword(不含鹽)
 * 		2.salt + hashPassword(password+salt)(含鹽)
 * */
@WebServlet("/hash")
public class HashServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String hash = getHash(password);
		resp.getWriter().println("hash:" + hash);
		String salt = getSalt();
		resp.getWriter().println("salt:" + salt);
		String hashSalt = getHash(password, salt);
		resp.getWriter().println("hashSalt:" + hashSalt);
	}
	
	// 產生含鹽雜湊
	private String getHash(String password, String salt) {
		try {
			// 加密演算法: SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// 加鹽
			md.update(salt.getBytes());
			// 進行加密
			byte[] bytes = md.digest(password.getBytes());
			//System.out.println(Arrays.toString(bytes));
			// 將 byte[] 透過 Base64 編碼方便儲存
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 產生鹽
	private String getSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	// 產生雜湊
	private String getHash(String password) {
		try {
			// 加密演算法: SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			// 進行加密
			byte[] bytes = md.digest(password.getBytes());
			//System.out.println(Arrays.toString(bytes));
			// 將 byte[] 透過 Base64 編碼方便儲存
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}