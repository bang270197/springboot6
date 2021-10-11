package com.lecuong.validate;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Validator<T> {
    private T t;

    private Validator(T t) {
        this.t = t;
    }

    public static <T> Validator<T> of(T t, Supplier<RuntimeException> ex) {
        if (Objects.isNull(t)) {
            throw ex.get();
        }

        return new Validator<>(t);
    }


    public <R> Validator<T> validate(Function<T, R> transform, Predicate<R> filter, Supplier<RuntimeException> ex) {
        if (filter.test(transform.apply(t))) {
            throw ex.get();
        }

        return this;
    }

    public T get() {
        return t;
    }
}
