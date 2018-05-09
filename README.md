Innovation Common
=================
Innovation Common Library - JAVA语言开发的通用库，用于简化Web系统搭建。

innovation-common-all 通用库jar
innovation-common-all-test 通用库web测试工程

##新旧erp登录配置
* 新旧erp登录相关包有结构路径冲突，需二选一
* 在编译时，注意需对pom.xml进行调整（erpcas和sso-uim二选一，包结构有冲突）

### 新erp登录（SSO）
* sso单点登录，在spring-config.xml中引用测试工程中ssoauthen.properties、springmvc-ssoerplogin.xml配置
* 注意springmvc.xml中interceptor使用新版登录配置项，屏蔽旧版登录配置项

### 旧erp登录
* 在spring-config.xml中引用测试工程中authen.properties、springmvc-erplogin.xml配置
* 注意springmvc.xml中interceptor只用旧版登录配置项，屏蔽新版登录配置项
    