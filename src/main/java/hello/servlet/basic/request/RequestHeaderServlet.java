package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - START ---");

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));

        request.getHeader("host");

        System.out.println("--- Headers - END ---");
    }

    private void printStartLine(HttpServletRequest request) {
        String method = request.getMethod(); // HTTP 메소드를 가져옴
        String protocol = request.getProtocol(); // 프로토콜 (HTTP 1.1 등)
        String scheme = request.getScheme(); // http
        StringBuffer requestURL = request.getRequestURL(); // http://localhost:8080/request-header
        String requestURI = request.getRequestURI(); // /request-header
        String queryString = request.getQueryString(); // username=hello
        boolean secure = request.isSecure(); // false

        System.out.println("--- REQUEST-LINE - START ---");
        System.out.println("method = " + method);
        System.out.println("protocol = " + protocol);
        System.out.println("scheme = " + scheme);
        System.out.println("requestURL = " + requestURL);
        System.out.println("requestURI = " + requestURI);
        System.out.println("queryString = " + queryString);
        System.out.println("secure = " + secure);
        System.out.println("--- REQUEST-LINE - END ---");
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " +
                request.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
