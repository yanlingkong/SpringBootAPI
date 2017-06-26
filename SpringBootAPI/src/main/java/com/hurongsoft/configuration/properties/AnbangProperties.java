package com.hurongsoft.configuration.properties;

import com.hurongsoft.configuration.properties.config.FtpConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@ConfigurationProperties("api.anbang")
@Data
@Validated
public class AnbangProperties {
    @Valid
    @NestedConfigurationProperty
    private FtpConfig ftp = new FtpConfig();
}
