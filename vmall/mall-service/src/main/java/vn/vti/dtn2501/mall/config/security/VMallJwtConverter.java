package vn.vti.dtn2501.mall.config.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class VMallJwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new JwtAuthenticationToken(jwt, extractAuthorities(jwt), jwt.getClaimAsString("sub"));
    }

    @SuppressWarnings("unchecked")
    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        // Xử lý trường hợp claim không tồn tại
        if (!jwt.hasClaim("authorities")) {
            return Collections.emptyList();
        }

        // Convert từ dạng JSON array sang collection GrantedAuthority
        return ((List<Map<String, String>>) jwt.getClaim("authorities"))
            .stream()
            .map(roleEntry -> new SimpleGrantedAuthority(roleEntry.get("role")))
            .collect(Collectors.toList());
    }
}
