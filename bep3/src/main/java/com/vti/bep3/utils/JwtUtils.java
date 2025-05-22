package com.vti.bep3.utils;

import com.vti.bep3.entity.Staff;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JwtUtils {
    private static final long EXPIRATION_TIME = 864000000; // 10 days, thời hạn của token
    private static final String SECRET = "123456"; // Chữ ký bí mật

    public static String createToken(Staff account, HttpServletRequest httpServletRequest) {
        // Tạo giá trị thời hạn token ( bằng thời gian hiện tại + 10 ngày hoặc tuỳ theo )
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        return Jwts.builder()
                .setId(String.valueOf(account.getId())) //set giá trị Id
                .setSubject(account.getUserName()) // set giá trị subject
                .setIssuedAt(new Date())
                .setIssuer("VTI")
                .setExpiration(expirationDate) // set thời hạn của token
                .signWith(SignatureAlgorithm.HS512, SECRET) // khai báo phương thức mã hoá token và chữ ký bí mật
                .claim("role", account.getRole().name()) // thêm trường authorities để lưu giá trị phân quyền
                .claim("user-Agent", httpServletRequest.getHeader("User-Agent")).compact(); // Thông tin trình duyệt đang sử dụng
    }

    public static UsernamePasswordAuthenticationToken checkToken(String token, HttpServletRequest httpServletRequest) {
        try {
            if (StringUtils.isBlank(token)) { // token bị trống -> lỗi
                System.out.println("Không có token!");
                return null;
            }
            Claims claims = Jwts.parser() // Đối tượng giải mã token
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token).getBody();
            // Lấy ra các thông tin -> phục vụ các bước tiếp theo (xác thưucj và phân quyền)
            Date expirationDate = claims.getExpiration();
            long expirationLong = expirationDate.getTime();
            long nowLong = new Date().getTime();
            if (expirationLong < nowLong){
                System.err.println("Token đã hết hạn");
                return null;
            }
            String userName = claims.getSubject();
            Staff.Role role = Staff.Role.valueOf(claims.get("role").toString());
            String userAgent = claims.get("user-Agent").toString(); // Thông tin trình duyệt đăng nhập từ trước
            String userAgentNow = httpServletRequest.getHeader("User-Agent"); // Thong tin trình duyệt đang đăng nhập

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(role);
            return new UsernamePasswordAuthenticationToken(userName, null, authorities);

        } catch (Exception e) {
            System.err.println("Token không hợp lệ");
            e.printStackTrace();
            return null;
        }
    }
}
