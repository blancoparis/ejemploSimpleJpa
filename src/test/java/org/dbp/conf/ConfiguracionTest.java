package org.dbp.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages ="org.dbp")
@EnableTransactionManagement
public class ConfiguracionTest {

}
