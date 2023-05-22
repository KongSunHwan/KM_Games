package ac.kmgames.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class WebUtil{
    public static void responseRedirect(HttpServletResponse response, String text, String script){
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        try{
            response.getWriter().println(
                "<script>" +
                    "alert('" + text + "');" +
                    script + ";" +
                "</script>"
            );
        }catch(IOException ignored){}
    }
}
