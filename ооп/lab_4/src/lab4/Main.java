package lab4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Class<ThisIsClass> justClass = ThisIsClass.class;
        ThisIsClass thisIsClassInstance = new ThisIsClass();
        int val;

        for (Method m : justClass.getDeclaredMethods()) {
            System.out.println(m.getName() + " " + m.isAnnotationPresent(ThisIsAnnotation.class));
            if (m.isAnnotationPresent(ThisIsAnnotation.class)) {
                val = getValAnnotation(m);

                try {
                    if (m.trySetAccessible())
                        for (int i = 1; i <= val; i++) {
                            System.out.print(i + ". ");
                            m.invoke(thisIsClassInstance, "User");
                        }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("---");
        }
    }

    public static int getValAnnotation(Method m) {
        for (Annotation a : m.getAnnotations()) {
            if (Objects.equals(a.annotationType(), ThisIsAnnotation.class))
                return ((ThisIsAnnotation) a).value();
        }
        return 0;
    }
}
