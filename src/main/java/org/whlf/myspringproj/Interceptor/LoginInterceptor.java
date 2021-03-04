//package org.whlf.myspringproj.Interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class LoginInterceptor  implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        try {
//            String l = (String) request.getSession().getAttribute("l");
//            if(l != null){
//                return true;
//            }
//            response.sendRedirect(request.getContextPath()+"/");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//    //    @Override
////    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object han)throws  Exception{
////    try {
////        Admin admin = (Admin) request.getSession().getAttribute("admin");
////        if(admin == null){
////            return true;
////        }
////        response.sendRedirect(request.getContextPath()+"/adminLogin");
////    }catch (IOException e){
////        e.printStackTrace();
////    }
////    return false;
////}
//
//}
