package pl.edu.agh.tai.application.security;

public class SecurityConstants {
    static final long EXPIRATION_TIME = 86_400_000; // 1 day in millis
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static final String LOGIN_URL = "/login";
    static final String AUTHORITIES_CLAIM = "authorities";
}
