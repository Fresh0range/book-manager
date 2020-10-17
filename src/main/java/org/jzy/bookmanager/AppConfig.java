package org.jzy.bookmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /**
     * 对书籍数量进行并发操作使用的锁
     * @return 对书籍数量进行并发操作使用的锁
     */
    @Bean("bookLock")
    public Object createBookLock() {
        return new byte[0];
    }
}
