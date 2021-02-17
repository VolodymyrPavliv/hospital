package ua.mushroom.hospital.filter;

import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherFilter implements Filter {
    private static final Map<String, String> PROTECTED_URIS = new HashMap<>();

    private static final List<String> GUEST = new ArrayList<>();

    static{
        GUEST.add(PathConstants.LOGIN);
        GUEST.add(PathConstants.REGISTER);

        PROTECTED_URIS.put(PathConstants.ADMIN_PAGE,"ADMIN");
        PROTECTED_URIS.put(PathConstants.USER_DETAILS_PAGE,"ADMIN");
        PROTECTED_URIS.put(PathConstants.ADMIN_RECORD_PAGE,"ADMIN");
        PROTECTED_URIS.put(PathConstants.DOCTOR_PAGE,"DOCTOR");
        PROTECTED_URIS.put(PathConstants.DOCTOR_RECORD_PAGE,"DOCTOR");
        PROTECTED_URIS.put(PathConstants.NURSE_PAGE,"NURSE");
        PROTECTED_URIS.put(PathConstants.NURSE_RECORD_PAGE,"NURSE");
        PROTECTED_URIS.put(PathConstants.PATIENT_PAGE,"PATIENT");
        PROTECTED_URIS.put(PathConstants.PATIENT_RECORD_PAGE,"PATIENT");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        String currentRole = PROTECTED_URIS.get(uri);
        String sessionRole = (String) session.getAttribute("role");

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");

        if(GUEST.contains(uri) && sessionRole != null) {
            servletRequest.getRequestDispatcher(ViewConstants.FORBIDDEN_PAGE)
                    .forward(servletRequest, servletResponse);
            return;
        }

        if(PROTECTED_URIS.containsKey(uri)) {
            if(sessionRole == null) {
                servletRequest.getRequestDispatcher(PathConstants.HOME_PAGE)
                        .forward(servletRequest, servletResponse);
            }
            if(!currentRole.equals(sessionRole)) {
                servletRequest.getRequestDispatcher(ViewConstants.FORBIDDEN_PAGE)
                        .forward(servletRequest, servletResponse);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
