import ch.qos.logback.core.util.FileSize
import grails.util.BuildSettings
import grails.util.Environment
import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

import java.nio.charset.Charset

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

// See http://logback.qos.ch/manual/groovy.html for details on configuration
def loggingDir = (System.getProperty('catalina.base') ? System.getProperty('catalina.base') + '/logs' : './logs')
def appName = 'userdetails'
def TOMCAT_LOG = 'TOMCAT_LOG'
switch (Environment.current) {
    case Environment.PRODUCTION:
        appender(TOMCAT_LOG, RollingFileAppender) {
            file = "$loggingDir/${appName}.log"
            encoder(PatternLayoutEncoder) {
                pattern =
                        '%d{yyyy-MM-dd HH:mm:ss.SSS} ' + // Date
                                '%5p ' + // Log level
                                '--- [%15.15t] ' + // Thread
                                '%-40.40logger{39} : ' + // Logger
                                '%m%n%wex' // Message
            }
            rollingPolicy(FixedWindowRollingPolicy) {
                fileNamePattern = "$loggingDir/$appName.%i.log.gz"
                minIndex=1
                maxIndex=4
            }
            triggeringPolicy(SizeBasedTriggeringPolicy) {
                maxFileSize = FileSize.valueOf('10MB')
            }
        }
        break
    default:
        appender(TOMCAT_LOG, ConsoleAppender) {
            encoder(PatternLayoutEncoder) {
                charset = Charset.forName('UTF-8')

                pattern =
                        '%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} ' + // Date
                                '%clr(%5p) ' + // Log level
                                '%clr(---){faint} %clr([%15.15t]){faint} ' + // Thread
                                '%clr(%-40.40logger{39}){cyan} %clr(:){faint} ' + // Logger
                                '%m%n%wex' // Message
            }
        }
        break
}

def targetDir = BuildSettings.TARGET_DIR
if (Environment.isDevelopmentMode() && targetDir != null) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}
jmxConfigurator()

root(INFO, [TOMCAT_LOG])
[
    (OFF): [],
    (ERROR): [
        'grails.spring.BeanBuilder',
        'grails.plugin.webxml',
        'grails.plugin.cache.web.filter',
    ],
    (WARN): [
        'au.org.ala.cas'
    ],
    (INFO): [
        'grails.plugin.externalconfig.ExternalConfig',
        'grails.app',
        'au.org.ala'
    ],
    (DEBUG): [
        'au.org.ala.userdetails',
        'grails.plugin.cache'
    ],
    (TRACE): [
    ]
].each { level, names -> names.each { name -> logger(name, level) } }
