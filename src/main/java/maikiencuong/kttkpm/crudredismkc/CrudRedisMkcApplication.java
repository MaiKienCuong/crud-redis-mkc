package maikiencuong.kttkpm.crudredismkc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class CrudRedisMkcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudRedisMkcApplication.class, args);
    }

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate redisTemplate() {
        var redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        return redisTemplate;
    }

}
