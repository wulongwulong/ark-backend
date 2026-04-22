package org.example.arkbackend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Component
public class DbCheckRunner implements CommandLineRunner {

    private final DataSource dataSource;

    public DbCheckRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            log.warn("---数据库连接成功:{} ",connection.getMetaData().getURL() );
        } catch (Exception e) {
            log.warn("---数据库连接失败---");
            throw e;
        }
    }
}
