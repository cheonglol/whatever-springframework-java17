package com.cheonglol.whatever.configurations.dataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("embedded-database")
public class EmbeddedDataSourceConfig {

}