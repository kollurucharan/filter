package com.charan;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/self.jsp")
public class testFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// HttpSession s = req.getSession();
		String key = request.getParameter("key");
		String key2 = res.getHeader("first");
		System.out.println("key2" + key2);
		// String key1 = (String) s.getAttribute("key");
		System.out.println(key + "sss" + key2);
		if (key2.equals(key)) {

			chain.doFilter(request, response);

		} else if (key == null) {
			chain.doFilter(request, response);
		} else {
			System.out.println("errorr");
		}

	}

}
