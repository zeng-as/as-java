package com.as.base.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author as
 * @date 2022/11/17
 * @desc
 */
public class MyClassLoader extends ClassLoader{
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        try{
            String fileName = name.substring(name.lastIndexOf("." )+1) + ".class";
            InputStream is = this.getClass().getResourceAsStream(fileName);
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b. length);
        } catch(IOException e){
            throw new ClassNotFoundException(name);
        }
    }
}
