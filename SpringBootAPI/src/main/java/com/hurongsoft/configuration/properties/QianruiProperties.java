package com.hurongsoft.configuration.properties;

import com.hurongsoft.configuration.properties.config.FtpConfig;
import com.hurongsoft.configuration.properties.config.SftpConfig;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@ConfigurationProperties("api.qianrui")
@Data
@Validated
public class QianruiProperties {
    @Valid
    @NestedConfigurationProperty
    private FtpConfig ftp = new FtpConfig();

    @Valid
    @NestedConfigurationProperty
    private SftpConfig sftp = new SftpConfig();

    @NotBlank
    private String fundUrl;
    @NotBlank
    private String orderUrl;
}
