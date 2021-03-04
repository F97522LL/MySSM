//package org.whlf.myspringproj.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.whlf.myspringproj.Interceptor.LoginInterceptor;
//
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry)  {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
//        interceptorRegistration.addPathPatterns("/**");
//        interceptorRegistration.excludePathPatterns(
//                "/",
//                "/login",
//                "/text",
//                "/user_register",
//                "/*/**.html",
//                "/*/*/**.js",
//                "/*/**.css",
//                "/*/**.fonts",
//                "/*/**.js",
//                "/*/**.jpg",
//                "/*/**.png",
//                "/*/**.ttf",
//                "/*/**.woff"
//        );
//    }
//
//
//}
