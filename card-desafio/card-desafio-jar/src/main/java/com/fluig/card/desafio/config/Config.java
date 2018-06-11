package com.fluig.card.desafio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Força o uso de um arquivo de configurações diferente, para nao conflitar com os demais artefatos.
 */
@Configuration
@PropertySource("classpath:META-INF/config.properties")
public class Config {
}
