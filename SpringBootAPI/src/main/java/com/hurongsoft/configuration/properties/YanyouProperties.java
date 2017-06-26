package com.hurongsoft.configuration.properties;

import com.hurongsoft.configuration.properties.config.SftpConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@ConfigurationProperties("api.yanyou")
@Data
@Validated
public class YanyouProperties {
    @Valid
    @NestedConfigurationProperty
    private SftpConfig sftp = new SftpConfig();
}
