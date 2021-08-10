package com.ami.activity.config;

import com.ami.activity.log.LogStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wangchendong
 * @date 2021/08/10
 */
@Slf4j
@Component
public class LogPrint implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(LogStyle.BLACK.dye("test print colorful log ..."));
        log.info(LogStyle.RED.dye("test print colorful log ..."));
        log.info(LogStyle.GREEN.dye("test print colorful log ..."));
        log.info(LogStyle.YELLOW.dye("test print colorful log ..."));
        log.info(LogStyle.BLUE.dye("test print colorful log ..."));
        log.info(LogStyle.PURPLE.dye("test print colorful log ..."));
        log.info(LogStyle.SKY.dye("test print colorful log ..."));
        log.info(LogStyle.WHITE.dye("test print colorful log ..."));
    }
}
