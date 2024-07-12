package org.example.customer.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig{
    private int a;
    private int b;

}
