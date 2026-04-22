package org.example.arkbackend.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MyBatis 映射语句检查器
 * 
 * 实现 CommandLineRunner 接口，在 Spring Boot 应用启动完成后自动执行
 * 用于验证 MyBatis 的 XML 映射文件是否正确加载，帮助排查映射相关问题
 * 
 * @author auto-generated
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MybatisCheckRunner implements CommandLineRunner {

    /**
     * MyBatis 的 SqlSessionFactory，用于获取配置信息
     */
    private final SqlSessionFactory sqlSessionFactory;

    /**
     * 应用启动后执行的检查逻辑
     * 
     * @param args 命令行参数（未使用）
     */
    @Override
    public void run(String... args) {
        // 获取所有已注册的 SQL 映射语句名称
        var names = sqlSessionFactory.getConfiguration().getMappedStatementNames();
        
        // 遍历并打印所有映射语句，便于检查是否正确加载
        for (String name : names) {
            log.warn("MappedStatement: {}", name);
        }

        // 检查特定的映射语句是否存在（示例：检查 UserMapper.selectByUsername）
        boolean has = sqlSessionFactory.getConfiguration()
                .hasStatement("org.example.arkbackend.mapper.UserMapper.selectByUsername");
        log.warn("Has selectByUsername: {}", has);
    }
}