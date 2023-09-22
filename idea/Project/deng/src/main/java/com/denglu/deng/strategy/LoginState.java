package com.denglu.deng.strategy;

import com.denglu.deng.model.UserState;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginState {
    UserState useState() default UserState.VALID;
}
