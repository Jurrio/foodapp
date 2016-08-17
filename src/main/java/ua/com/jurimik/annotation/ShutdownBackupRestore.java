package ua.com.jurimik.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ua.com.jurimik.enums.SerializationType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShutdownBackupRestore {
	SerializationType type() default SerializationType.BYTE_STREAM;
}
